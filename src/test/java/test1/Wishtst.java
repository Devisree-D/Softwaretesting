package test1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import page1.Wishlstpg;


public class Wishtst extends Baseclstst{
	public Wishtst(WebDriver driver) {
		this.driver=driver;
	}

	@Test
	public void testwish() throws InterruptedException {
		BaseLogintst ob=new BaseLogintst(driver);
		ob.testlogin();
		Wishlstpg obj=new Wishlstpg(driver);
		obj.Activity();
	}
}
