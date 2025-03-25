package Dataproviderpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Datapro {
   private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

   @BeforeMethod
   public void setup() {
       driver.set(new ChromeDriver());
       getDriver().get("https://www.bing.com/");
       getDriver().manage().window().maximize();
   }

   public WebDriver getDriver() {
       return driver.get();
   }

   @Test(dataProvider="testdata", dataProviderClass=DP.class)
   public void search(String key) {
       WebElement txt = getDriver().findElement(By.xpath("//textarea[@id='sb_form_q']"));
       txt.sendKeys(key);
       getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       String k = txt.getAttribute("value");
       txt.sendKeys(Keys.ENTER);
       Assert.assertEquals(key, k);
       System.out.println("Assertion success "+key);
   }

   @AfterMethod
   public void teardown() {
       getDriver().quit();
       driver.remove();
   }
}
