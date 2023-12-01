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


    public String selectById(int id, String table, String row, String column) {
        String result = "";
        String sql = """
                select %s
                from millionaire.%s
                where %s = %d
                """;

        String select = String.format(sql, column, table, row, id);

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(select);

            while (set.next()) {
                result = set.getString(column);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }


    public Map<String, String> selectById(int id, String table, String row, String... columnNames) {
        Map<String, String> result = new HashMap<>();
        String sql = """
                select %s
                from millionaire.%s
                where %s = %d
                """;
        String names = Stream.of(columnNames)
                .collect(Collectors.joining(", "));

        String select = String.format(sql, names, table, row, id);

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(select);

            while (set.next()) {
                result.put(set.getString(columnNames[0]), set.getString(columnNames[1]));
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
