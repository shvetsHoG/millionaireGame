package database;

import config.DatabaseProperties;
import config.PropertiesFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatabaseMillionaireGame {

    private static DatabaseMillionaireGame instance;

    private final DatabaseProperties properties = PropertiesFactory.getProperties();

    private DatabaseMillionaireGame() {
        init();
    }

    public synchronized static DatabaseMillionaireGame getInstance() {
        if (instance == null) {
            instance = new DatabaseMillionaireGame();
        }

        return instance;
    }

    private void init() {
        createScheme();
        createTableQuestions();
        createTableAnswers();
    }

    private void createScheme() {
        String sql = """
                create schema if not exists millionaire;
                """;
        execute(sql);
    }

    private void createTableQuestions() {
        String sql = """
                create table if not exists millionaire.questions(
                    id serial primary key,
                    question varchar(255)
                )
                """;

        execute(sql);
    }

    private void createTableAnswers() {
        String sql = """
                create table if not exists millionaire.answers(
                    id serial primary key,
                    idQuestion int,
                    answer varchar(255),
                    isRightAnswer boolean
                )
                """;

        execute(sql);
    }

    public String selectQuestionId(String question) {
        String result = null;
        String sql = """
                select id
                from millionaire.questions
                where question = '%s'
                """;

        String select = String.format(sql, question);

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(select);
            if (set.next()) {
                result = set.getString("id");
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }


    public Map<String, String> selectById(int id, String table, String... columnNames) {
        Map<String, String> result = new HashMap<>();
        String sql = """
                select id, %s
                from millionaire.%s
                where id = %d
                """;
        String names = Stream.of(columnNames)
                .collect(Collectors.joining(", "));

        String select = String.format(sql, names, table, id);

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(select);

            while (set.next()) {
                for (String columnName : columnNames) {
                    result.put(columnName, set.getString(columnName));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    public List<Map<String, String>> selectAll(String table, String... columnNames) {
        List<Map<String, String>> result = new ArrayList<>();

        String sql = """
                select %s
                from millionaire.%s
                """;

        String names = String.join(", ", columnNames);

        String select = String.format(sql, names, table);

        try (Connection connection = connect();
             Statement statement = connection.createStatement();
        ) {
            ResultSet set = statement.executeQuery(select);

            while (set.next()) {
                Map<String, String> fields = new HashMap<>();

                for (String columnName : columnNames) {
                    fields.put(columnName, set.getString(columnName));
                }

                result.add(fields);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public void execute(String sql) {
        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(
                properties.getUrl(),
                properties.getLogin(),
                properties.getPassword()
        );
    }
}
