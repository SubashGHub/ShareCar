package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.Loginpage_pom;

public class LoginTC extends BaseClass{

	@Test(dataProvider = "loginData")
	public void loginTest(String uname, String pwd) {
		Loginpage_pom lp = new Loginpage_pom(driver);
		
		lp.setEmail(uname);
		lp.setPassword(pwd);
		lp.clickLogin();
		Assert.assertEquals(driver.getTitle(), "Profile - Sharecaar", "Page Title Mismatch");
	}
	
	@DataProvider
	String[][] loginData() {
		String arr[][] = {{"niteesh@w3softech.com","w3softech"}};
		return arr;
	}
}
