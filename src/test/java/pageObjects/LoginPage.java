package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.BaseTest;

public class LoginPage extends BaseTest {

	//All the locators of page

	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement invalidMsg;

	@FindBy(xpath="//h5[text()='Login']")
	WebElement txtLoginPage;

	//Initialization of locators/variables
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	//methods required to perform test steps

	public void setUserName(String uname) {
		username.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLoginButton() {
		loginBtn.click();
	}

	public String getInvalidText() {
		return (invalidMsg.getText());
	}

	public void loginMethod() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginBtn.click();
	}

	public String titleLoginPage() {
		return txtLoginPage.getText();
	}

	public String currentUrl() {
		return driver.getCurrentUrl();
	}
}
