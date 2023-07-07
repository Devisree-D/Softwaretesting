package test1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import page1.Homepg;

public class Hometst extends Baseclstst{

	 public Hometst(WebDriver driver) {
		this.driver=driver;
	}
	@Test
	public void testhome() throws InterruptedException {
		Homepg ob=new Homepg(driver);
		ob.searchbook();
	}

}
