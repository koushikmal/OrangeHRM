package orangeHRMDemo;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

	@Test(priority=0, enabled=true)
	public void loginWithInvalidCredential() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin12389657");
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();

		String message_actual = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
		String message_expected = "Invalid credentials";
		Assert.assertTrue(message_actual.contains(message_expected));

	}

	@Test(priority=1, enabled=true)
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

	@Test(priority=3, enabled=true)
	public void searchEmployeeNyName() {

		login();

		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();

		//enter employee name
		driver.findElement(By.xpath("//div[label[text()='Employee Name']]/following-sibling::div/div/div/input[@placeholder='Type for hints...']")).sendKeys("Koushik");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String expectedStr = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']")).getText();
		System.out.println(expectedStr);
		Assert.assertTrue(expectedStr.contains("Found"));

		logout();
	}

	@Test(priority=4, enabled=true)
	public void searchEmployeeById() {

		String empId="0377";
		String expectedEmpId = "";

		login();

		//find PIM Menu and click on PIM Menu
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();

		//enter employee id
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(empId);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//Explicit Wait to wait for the search results
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='row']")));


		//Find list of Rows in search result table
		List<WebElement> row = driver.findElements(By.xpath("//div[@role='row']"));

		//Validate empId from search result
		if(row.size()>1) {		
			expectedEmpId = driver.findElement(By.xpath("(//div[@role='row'])[2]/div[2]")).getText();		
			Assert.assertEquals(empId, expectedEmpId);			
		}else System.out.println("Employee Id does not exist");

		logout();
	}

	@Test(priority=5, enabled=true)
	public void fileUpload() throws IOException, InterruptedException {

		login();

		//find PIM Menu and click on PIM Menu
		driver.findElement(By.xpath("//span[text()='PIM']")).click();

		//Click on Configuration button
		driver.findElement(By.xpath("//span[text()='Configuration ']")).click();
		driver.findElement(By.partialLinkText("Data Import")).click();

		//click on browse button
		driver.findElement(By.xpath("//div[text()='Browse']")).click();

		Thread.sleep(5000);

		Runtime.getRuntime().exec("C://FileUploadOrangeHRM.exe");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

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
