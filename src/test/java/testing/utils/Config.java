package testing.utils;

import java.io.*;
import java.util.Properties;

public class Config {
    public Properties properties;

    public void loadConfig() {
        String propertyPath = "src/test/resources/properties/property.properties";
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(propertyPath));
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Property File Not Found");
        }
    }
}
