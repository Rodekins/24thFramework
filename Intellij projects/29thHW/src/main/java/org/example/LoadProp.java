package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProp
{
    public static String getProperty(String key)
    {
        Properties prop = new Properties();
        FileInputStream input;
        try
        {
            input = new FileInputStream("src/test/resources/TestData/config.properties");
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
