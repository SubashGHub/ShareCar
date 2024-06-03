package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage_pom extends Base{
	
	
	public Loginpage_pom(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="sbtLogin")
	WebElement btnlogin;
	
	public void setEmail(String uname) {
		email.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		js.executeScript("arguments[0].click();",btnlogin);
	}
	
	

}
