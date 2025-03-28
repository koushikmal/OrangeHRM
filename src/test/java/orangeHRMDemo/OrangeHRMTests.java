package orangeHRMDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class OrangeHRMTests {

	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;

	@BeforeTest
	public void setup() {

		System.out.println("Before Test executed");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
	}

	@Test(priority=0)
	public void loginWithInvalidCredential() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin12389657");
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();

		String message_actual = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
		String message_expected = "Invalid credentials";
		Assert.assertTrue(message_actual.contains(message_expected));

	}

	@Test(priority=1)
	public void loginTestWithValidCredential() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();

		String pageTitle = driver.getTitle();
		Assert.assertEquals("OrangeHRM", pageTitle);
		
		logout();
	}

	@Test(priority=2, enabled=true)
	public void addEmployee(){
		
		login();
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Koushik");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Mal");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String expected = driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']")).getText();
		Assert.assertEquals("Personal Details", expected);
		
		logout();
	}

	public void login() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
	}

	public void logout() {
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		driver.findElements(By.xpath("//a[@class='oxd-userdropdown-link']")).get(3).click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}



}
