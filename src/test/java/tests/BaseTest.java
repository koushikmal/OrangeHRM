package tests;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObjects.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class BaseTest extends BaseClass {

	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@BeforeClass
	public void pgObjects() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
