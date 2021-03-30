package org.example;

import static org.junit.Assert.assertTrue;

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
    public void close() { closeBrowser(); }

    @Test
    public void UserLogInWithoutPasswordAndUsername()
    {
        driver.findElement(By.id("btnLogin")).click();
        WebElement log = driver.findElement(By.id("spanMessage"));
        Assert.assertEquals("this is fine","Username cannot be empty",log.getText());
    }
    @Test
    public void userShouldNotLogInWithoutPassword()
    {
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.click();
        username.sendKeys("admin");
        driver.findElement(By.id("btnLogin")).click();
        WebElement passwordEmpty = driver.findElement(By.id("spanMessage"));
        Assert.assertEquals("it is fine","Password cannot be empty",passwordEmpty.getText());
    }
    @Test
    public void UserShouldNotLogInWithoutUsername()
    {
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.click();
        password.sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        WebElement userNameempty = driver.findElement(By.id("spanMessage"));
        Assert.assertEquals("this is right","Username cannot be empty", userNameempty.getText());
    }
    @Test
    public void UserShouldBeAbleToLogin()
    {
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.click();
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.click();
        password.sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        WebElement dashBoard = driver.findElement(By.id("menu_dashboard_index"));
        Assert.assertEquals("we are on dashboard", "Dashboard",dashBoard.getText() );
    }
    @Test
    public void ToFindIfUserExists()
    {
        WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        admin.click();
        WebElement findtext = driver.findElement(By.id("searchSystemUser_userName"));
        findtext.sendKeys("vikas");
        WebElement search = driver.findElement(By.id("searchBtn"));
        search.click();
        WebElement noRecord = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td"));
        Assert.assertEquals("search button is there", "No Records Found",noRecord.getText());
    }

}
