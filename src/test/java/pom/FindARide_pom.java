package pom;

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
	WebElement fromlocation;
	
	@FindBy(id="to_location")
	WebElement tolocation;
	
	@FindBy(id="searchBtn")
	WebElement btnsearch;
	
	@FindBy(id="journey_date")
	WebElement journeydate;
	
	@FindBy(id="extend_radius")
	WebElement extendredius;
	
	public void setFromLocation(String from) {
		fromlocation.sendKeys(from);
	}
	
	public void setToLocation(String to) {
		tolocation.sendKeys(to);
	}
	
	public void searchRide() {

		wt.until(ExpectedConditions.elementToBeClickable(btnsearch));
		btnsearch.click();
	}
	
	public void setJourneyDate(String date) {
		journeydate.sendKeys(date);
	}
	
	public void selectExtendRadius() {
		js.executeScript("arguments[0].click();",extendredius);
		Select sc = new Select(extendredius);
		sc.selectByVisibleText("Radius 20");
	}

}
