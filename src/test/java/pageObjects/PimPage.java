package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.BaseTest;

public class PimPage extends BaseTest {

	//Locators
	@FindBy(xpath="//h6[text()='PIM']")
	WebElement titlePim;

	@FindBy(xpath="//i[contains(@class,'oxd-icon bi-check oxd-checkbox-input-icon')]")
	List<WebElement> checkAll;

	@FindBy(xpath="//input[@type='checkbox']")
	List<WebElement> checkInput;

	@FindBy(xpath="//a[text()='Add Employee']")
	WebElement addEmployeeBtn;

	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement empFirstName;

	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement empLastName;

	@FindBy(xpath="//button[@type='submit']")
	WebElement saveBtn;

	@FindBy(xpath="//h6[normalize-space()='Personal Details']")
	WebElement personalDetailstitle;

	//Initialization of locators/variables
	public PimPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//methods required to perform test steps
	public String titleOfPimPage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return titlePim.getText();
	}

	public boolean verifyIdCheckBoxSelected() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return checkInput.get(0).isSelected();
	}

	public void selectIdcheckBox() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		checkAll.get(0).click();
	}

	public void addEmp() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		addEmployeeBtn.click();
		empFirstName.sendKeys("Koushik");
		empLastName.sendKeys("Mal");
		saveBtn.submit();
	}

	public String validateAddEmp() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return personalDetailstitle.getText();
	}
}
