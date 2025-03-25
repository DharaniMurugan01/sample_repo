package Muldp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Multilple {
	WebDriver driver;
	  @BeforeMethod
	  public void setup() {
		  driver=new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.manage().window().maximize();
	  }
	  @Test(dataProvider="testdata1",dataProviderClass=Muldp.Mulldp.class)
	  public void search(String un,String pass) {
		  WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		  username.sendKeys(un);
		  WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		  password.sendKeys(pass);
		  WebElement submit=driver.findElement(By.xpath("//button[text()=' Login ']"));
		  submit.click();
	  }
	  @AfterMethod
	  public void teardown() {
		  driver.quit();
	  }
}
