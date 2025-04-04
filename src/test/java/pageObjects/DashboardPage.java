package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.BaseTest;

public class DashboardPage extends BaseTest {

	@FindBy(xpath="//span[text()='PIM']")
	WebElement pim;

	//Initialization
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Methods
	public String getPageTitle() {
		return driver.getTitle();
	}

	public void clickOnPimMenu() {
		pim.click();
	}
}
