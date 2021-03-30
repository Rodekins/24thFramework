package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;


public class BrowserSelector
{
    protected static WebDriver driver;
    public static void openBrowser()
    {
        String browser = LoadProp.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else
        {
            driver = new SafariDriver();
        }
        driver.get(LoadProp.getProperty("url"));
    }
    public void closeBrowser()
    {
        driver.quit();
    }


}
