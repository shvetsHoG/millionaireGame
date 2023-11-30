package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFactory {

    private static DatabaseProperties properties;

    private PropertiesFactory() {

    }

    public static synchronized DatabaseProperties getProperties() {
        if (properties == null) {
            init();
        }

        return properties;
    }

    public static void init() {
        String filePropertiesName = "application.properties";

        ClassLoader classLoader= Thread.currentThread().getContextClassLoader();
        properties = new DatabaseProperties();

        try (InputStream stream = classLoader.getResourceAsStream(filePropertiesName)) {
            properties.load(stream);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
    }
}
