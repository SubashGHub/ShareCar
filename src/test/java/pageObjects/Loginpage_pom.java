package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage_pom extends Base{
	
	
	public Loginpage_pom(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="sbtLogin")
	WebElement btnlogin;
	
	public Loginpage_pom setEmail(String uname) {
		txtEmail.sendKeys(uname);
		return this;
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		js.executeScript("arguments[0].click();",btnlogin);
	}
	
	

}
