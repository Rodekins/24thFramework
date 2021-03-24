package org.example;


import org.junit.Assert;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSuite extends BrowserSelector
{
    @BeforeMethod
    public void open()
    {
        openBrowser();
    }
    @AfterMethod
    public void close()
    {
        closeBrowser();
    }
    @Test(priority = 1 )
    public void userCanNavigateToTheGivenSite()
    {
        String pageTitle = driver.findElement(By.id("page-title")).getText();
        Assert.assertEquals("ItIsNotRight","Log in",pageTitle);
        Assert.assertEquals("urlNotMatch",LoadProps.getProperty("url"),driver.getCurrentUrl());
    }
    @Test(priority = 2)
    public void userCanNavigateToOurServicesPage() throws InterruptedException {
        driver.findElement(By.linkText("Our services")).click();
        WebElement awards = driver.findElement(By.xpath("//*[@id='block-system-main']/main/div[1]/div/div/div/div/div/div[3]/div[1]/div/h2"));
        Assert.assertEquals("awards","Our award-winning accounts",awards.getText());
    }

}
//