package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserSelector
{
    protected static WebDriver driver;
    public static void openBrowser()
    {

        String browser = LoadProps.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else
            {
                driver = new SafariDriver();
            }
        driver.get(LoadProps.getProperty("url"));
    }
    public void closeBrowser()
    {
        driver.quit();
    }

}
