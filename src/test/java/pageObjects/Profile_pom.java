package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile_pom extends Base{

	public Profile_pom(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@id='navbarSupportedContent']/descendant::li[1]/a")
	WebElement findride;
	
	public void clickFindride() {
		findride.click();
	}
	
	@FindBy(xpath="//ul[@class='navbar-nav ml-auto']/li[2]/a")
	WebElement offerride;
	
	public void clickOfferride() {
		offerride.click();
	}

}
