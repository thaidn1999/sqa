package com.nhom18.server.selenium;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class LoginTest {
    //    Test Đăng nhập
    @Test
    public void LoginSuccess() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver" , "C:\\Selenium\\Selenim_ChromeDr\\ChromeDr\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/login");
        WebElement txtUserName = driver.findElement(By.name("username"));
        WebElement txtPassWord = driver.findElement(By.name("password"));
        txtUserName.sendKeys("Admin");
        txtPassWord.sendKeys("User_1234");
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/form/button/span[1]"));
        btn.click();
        Thread.sleep(10000);
        String expectedUrl="http://localhost:3000/admin";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        driver.quit();
    }
    @Test
    public void UsernameEmptyTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver" , "C:\\Selenium\\Selenim_ChromeDr\\ChromeDr\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        Thread.sleep(2000);
        WebElement txtUserName = driver.findElement(By.name("username"));
        WebElement txtPassWord = driver.findElement(By.name("password"));
        txtUserName.sendKeys("");
        txtPassWord.sendKeys("User_1234");
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/form/button/span[1]"));
        btn.click();
        WebElement txtNotify = driver.findElement(By.xpath("//*[@id=\"username-helper-text\"]"));
        Assert.assertEquals("Tên đăng nhập chỉ được bao gồm chữ,số hoặc các kí tự như @.-/_ và không được để trống",
                txtNotify.getText());
        driver.quit();
    }
    @Test
    public void PasswordEmptyTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver" , "C:\\Selenium\\Selenim_ChromeDr\\ChromeDr\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        Thread.sleep(2000);
        WebElement txtUserName = driver.findElement(By.name("username"));
        WebElement txtPassWord = driver.findElement(By.name("password"));
        txtUserName.sendKeys("Admin");
        txtPassWord.sendKeys("");
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/form/button/span[1]"));
        btn.click();
        WebElement txtNotify = driver.findElement(By.xpath("//*[@id=\"password-helper-text\"]"));
        Assert.assertEquals("Mật khẩu phải gồm ít nhất 8 kí tự bao gồm ít nhất 1 chữ cái in thường, 1 chữ cái in hoa, 1 số và 1 kí tự đặc biệt !@#$%^&*_",
                txtNotify.getText());
    }
    @Test
    public void UserPassEmptyTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver" , "C:\\Selenium\\Selenim_ChromeDr\\ChromeDr\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        Thread.sleep(2000);
        WebElement txtUserName = driver.findElement(By.name("username"));
        WebElement txtPassWord = driver.findElement(By.name("password"));
        txtUserName.sendKeys("");
        txtPassWord.sendKeys("");
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/form/button/span[1]"));
        btn.click();
        WebElement txtNotifyUserName = driver.findElement(By.xpath("//*[@id=\"username-helper-text\"]"));
        WebElement txtNotifyPassWord = driver.findElement(By.xpath("//*[@id=\"password-helper-text\"]"));
        Assert.assertEquals("Tên đăng nhập chỉ được bao gồm chữ,số hoặc các kí tự như @.-/_ và không được để trống",
                txtNotifyUserName.getText());
        Assert.assertEquals("Mật khẩu phải gồm ít nhất 8 kí tự bao gồm ít nhất 1 chữ cái in thường, 1 chữ cái in hoa, 1 số và 1 kí tự đặc biệt !@#$%^&*_",
                txtNotifyPassWord.getText());
    }
    // Test username phần quên tài khoản
    @Test
    public void AccountForgotTest1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver" , "C:\\Selenium\\Selenim_ChromeDr\\ChromeDr\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        Thread.sleep(2000);
        WebElement fg = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/form/div[4]/div/a/p"));
        fg.click();
        WebElement txtUserName = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        txtUserName.sendKeys("");
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/form/button/span[1]"));
        btn.click();
        WebElement txtNotify = driver.findElement(By.xpath("//*[@id=\"username-helper-text\"]"));
        Assert.assertEquals("Tên đăng nhập chỉ được bao gồm chữ,số hoặc các kí tự như @.-/_ và không được để trống",
                txtNotify.getText());
    }

    @Test
    public void TermTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver" , "C:\\Selenium\\Selenim_ChromeDr\\ChromeDr\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        WebElement txtUserName = driver.findElement(By.name("username"));
        WebElement txtPassWord = driver.findElement(By.name("password"));
        txtUserName.sendKeys("Admin");
        txtPassWord.sendKeys("User_1234");
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"root\"]/main/div[1]/form/button/span[1]"));
        btn.click();
        Thread.sleep(1000);
        WebElement bt = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/ul/a[2]/div/div[1]/button"));
        bt.click();
//        WebElement txtStart = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/main/div[1]/form/div[3]/div/input"));
//        txtStart.sendKeys("01:00:00 25/05/202_");
//        WebElement txtNotify = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/main/div[1]/form/div[3]/p"));
//        txtNotify.sendKeys("Invalid Date Format");
//        Assert.assertEquals("Invalid Date Format", txtNotify.getText());
//        driver.quit();
    }

}
