package test1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reportgenerationbookswagon{
	WebDriver driver2;
	String baseurl="https://www.bookswagon.com/";

	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest test;
	
	public Reportgenerationbookswagon(WebDriver driver2)
	{
		this.driver2=driver2;
	}
	
	@BeforeClass
	public void setUp() {
		driver2=new ChromeDriver();
	}

	@BeforeTest
	public void generateReport() {
		reporter=new ExtentHtmlReporter("./Reports/bookswagonreport.html");
		reporter.config().setDocumentTitle("Automationreport");
		reporter.config().setReportName("functionaltest");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("os", "windows11");
		extent.setSystemInfo("testername", "Devisree");
		extent.setSystemInfo("Browser Name", "chrome");
		
		driver2.get(baseurl);

	}
	@Test
	public void homeReport() throws InterruptedException
	{
		test=extent.createTest("Homepage report");
		Hometst obj=new Hometst();
		obj.testhome();
	
		
	}
	@Test
	public void loginReport() throws InterruptedException
	{
		test=extent.createTest("Loginpage report");
		Logintst obj=new Logintst();
		obj.testlogin();
	}
	@Test
	public void searchReport() throws Exception 
	{
		test=extent.createTest("Searchpage report");
		Bookdetailtst obj=new Bookdetailtst();
		obj.testbkdetail();
	}
	@Test
	public void wishlistReport() throws InterruptedException
	{
		test=extent.createTest("Wishpage report");
		Wishtst obj=new Wishtst();
		obj.testwish();
		
	}
	@Test
	public void cartReport() throws Exception
	{
		test=extent.createTest("Cartpage report");
		Carttst obj=new Carttst();
		obj.testcart();
		
	}
	@AfterMethod
	public void browserclose(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "test case failed is "+result.getName());
			test.log(Status.FAIL, "test case failed is "+result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "test case skipped is "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "test case passed is "+result.getName());
		}
	}
	@AfterTest
	public void tearDown() {
		extent.flush();
	}
		

}
