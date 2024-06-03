package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OfferRide1_pom extends Base{

	public OfferRide1_pom(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='Offer Ride']")
	WebElement offerride;
	
	@FindBy(id="from_location")
	WebElement fromlocation;
	
	@FindBy(id="to_location")
	WebElement tolocation;
	
	@FindBy(id="pickup_point_2")
	WebElement pickuppoint;
	
	@FindBy(id="onward_date")
	WebElement onwarddate;
	
	@FindBy(id="onward_time")
	WebElement onwardtime;
	
	@FindBy(id="return_date")
	WebElement returndate;
	
	@FindBy(id="return_time")
	WebElement returntime;
	
	@FindBy(id="next_btn")
	WebElement btnsave;
	
	
	public void setFromLocation(String from) {
		fromlocation.sendKeys(from);
	}
	
	public void setToLocation(String to) {
		tolocation.sendKeys(to);
	}
	
	public void setPickupPoint(String pick) {
		pickuppoint.sendKeys(pick);
	}
	
	public void setOnWardTime(String ontime) {
		onwardtime.sendKeys(ontime);
	}
	
	public void setOnWardDate(String ondate) {
		onwarddate.sendKeys(ondate);
	}
	
	public void setReturnDate(String rtndate) {
		returndate.sendKeys(rtndate);
	}
	
	public void setReturnTime(String rtntime) {
		returntime.sendKeys(rtntime);
	}
	
	public void clickSave() {
		btnsave.click();
	}
}
