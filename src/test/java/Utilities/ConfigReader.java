package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    public  static Properties properties;

    static {
        try{
            FileInputStream input=new FileInputStream("src/test/resources/config.properties");
            properties=new Properties();
            properties.load(input);
            input.close();
        } catch (Exception e) {
            throw  new RuntimeException("Failed to load config.properties file");
        }
    }
    public  static String getProperty(String key){
        return properties.getProperty(key);
    }
}
