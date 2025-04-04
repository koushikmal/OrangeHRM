package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test(priority=0)
	public void verifyUrlPage() {
		Assert.assertEquals(loginpage.currentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority=1)
	public void verifyLoginPageIsDisplayed() {
		Assert.assertEquals(loginpage.titleLoginPage(), "Login");
	}

	@Test(priority=2)
	public void loginWithInvalidCredential() {
		loginpage.setUserName("Admin");
		loginpage.setPassword("admin123768");
		loginpage.clickLoginButton();

		String message_expected = "Invalid credentials";
		Assert.assertTrue(loginpage.getInvalidText().contains(message_expected));
	}

	@Test(priority=3)
	public void loginTestWithValidCredential() {
		loginpage.setUserName("Admin");
		loginpage.setPassword("admin123");
		loginpage.clickLoginButton();

		Assert.assertEquals("OrangeHRM", dashboardpage.getPageTitle());		
	}
}
