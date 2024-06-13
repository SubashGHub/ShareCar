package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FindARide_pom extends Base{

	public FindARide_pom(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="from_location")
	WebElement txtFromlocation;
	
	@FindBy(id="to_location")
	WebElement txtTolocation;
	
	@FindBy(id="searchBtn")
	WebElement btnsearch;
	
	@FindBy(id="journey_date")
	WebElement journeydate;
	
	@FindBy(id="extend_radius")
	WebElement extendredius;
	
	public void setFromLocation(String from) {
		txtFromlocation.sendKeys(from);
	}
	
	public void setToLocation(String to) {
		txtTolocation.sendKeys(to);
	}
	
	public void clickSearchRide() {

		wt.until(ExpectedConditions.elementToBeClickable(btnsearch));
		btnsearch.click();
	}
	
	public void setJourneyDate(String date) {
		journeydate.sendKeys(date);
	}
	
	public void selectExtendRadius(String radius) {
		js.executeScript("arguments[0].click();",extendredius);
		Select sc = new Select(extendredius);
		if(radius.equals("10")) {
		sc.selectByVisibleText("Radius 10");
		}if(radius.equals("20")) {
			sc.selectByVisibleText("Radius 20");
		}if(radius.equals("30")) {
			sc.selectByVisibleText("Radius 30");
		}
	}

}
