package page1;

//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Cartpg {

	WebDriver driver;
	By cartbtn=By.xpath("//*[@id=\"aspnetForm\"]/nav/div/div/div[2]/ul/li[1]/a/span");
	By inpqty=By.id("BookCart_lvCart_ctrl0_txtQty");
	By upval=By.id("BookCart_lvCart_ctrl0_imgUpdate");
	By updmsg=By.id("BookCart_lvCart_lblMsg");
	By movtowl=By.id("BookCart_lvCart_ctrl0_btnMovetoWishlist");
	By remov=By.id("BookCart_lvCart_ctrl1_imgDelete");
	By plordr=By.id("BookCart_lvCart_imgPayment");
	


	public Cartpg(WebDriver driver) {
		this.driver=driver;
	}




	public void placeOrder() throws Exception {
		  Map<String, Object> vars;
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		    vars = new HashMap<String, Object>();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		    driver.findElement(cartbtn).click();
		    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cboxIframe")));
		    driver.switchTo().frame(driver.findElement(By.className("cboxIframe")));
		    driver.findElement(inpqty).sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.DELETE);;
		    Thread.sleep(2000);
		    driver.findElement(inpqty).sendKeys("4");
		    Thread.sleep(2000);
		    driver.findElement(upval).click();
		    Thread.sleep(2000);
		    WebElement txt=driver.findElement(updmsg);
			if(txt.getText().equalsIgnoreCase("Order quantity successfully updated"))
			{			System.out.println("pass");
				}
				else
				{
				System.out.println("fail");
				}
		    driver.findElement(remov).click();
		    Thread.sleep(2000);
		    driver.findElement(movtowl).click();
		    Thread.sleep(2000);
		    driver.findElement(plordr).click();
		  }
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(cartbtn).click();
//		driver.manage().window().maximize();
//		//JavascriptExecutor js=(JavascriptExecutor)driver;
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.className("cboxIframe")));
//		//js.executeScript("arguments[0].scrollIntoView(true);", inpqty);
//
//		
//		driver.findElement(inpqty).sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.DELETE);
//		driver.findElement(inpqty).sendKeys("4",Keys.ENTER);
//		driver.findElement(upval);
//		WebElement txt=driver.findElement(updmsg);
//		if(txt.getText().equalsIgnoreCase("Order quantity successfully updated"))
//		{			System.out.println("pass");
//			}
//			else
//			{
//			System.out.println("fail");
//			}
//		driver.findElement(movtowl).click();
//		driver.findElement(remov).click();
//		driver.findElement(plordr).click();
	}

