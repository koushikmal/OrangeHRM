package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PimTest extends BaseTest {

	@BeforeClass
	public void login() {
		loginpage.loginMethod();
	}

	@Test(priority=4)
	public void verifyPimPageTitle(){
		dashboardpage.clickOnPimMenu();
		Assert.assertEquals("PIM", pimpage.titleOfPimPage());
	}

	@Test(priority=5)
	public void verifyIdCheckBoxIsSelected() {
		pimpage.selectIdcheckBox();
		Assert.assertEquals(pimpage.verifyIdCheckBoxSelected(), true);
	}

	@Test(priority=6)
	public void verifyAddEmployee() {
		pimpage.addEmp();
		Assert.assertEquals("Personal Details", pimpage.validateAddEmp());
	}
}
