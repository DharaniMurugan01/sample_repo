package com.DP;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class DPDemo{
    private static final ThreadLocal<WebDriver> threadLocal=new ThreadLocal<>();
    public WebDriver getDriver() {
        return threadLocal.get();
    }
    @BeforeMethod
    public void setUp(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        WebDriver driver=new ChromeDriver(options);
        threadLocal.set(driver);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get("https://www.google.co.in/");
    }
    @Test(dataProvider="TestData",
    		dataProviderClass=Dataproviderr.class)
    public void searchTest(String data) {
        WebDriver driver=getDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));        WebElement search=driver.findElement(By.name("q"));
        search.sendKeys(data);
        search.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
        WebElement txt=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        String actualSearchText=txt.getAttribute("value");
        System.out.println("Search Term Entered: " + actualSearchText);
        Assert.assertEquals(actualSearchText, data);
    }
    @AfterMethod
    public void tearDown(){
        WebDriver driver=getDriver();
        if (driver!=null) {
            driver.quit();
            threadLocal.remove();
        }
    }
}