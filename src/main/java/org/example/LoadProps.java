package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProps
{
    public static String getProperty(String key)
    {
        Properties prop = new Properties();
        FileInputStream input;
        try
        {
            input = new FileInputStream("src/test/resources/TestData/Config.properties");
            prop.load(input);
            input.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
