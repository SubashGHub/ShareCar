package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class OfferRide2_pom extends Base {

	public OfferRide2_pom(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='d-md-flex justify-content-md-between travel-price '][1]/div[4]//input")
	WebElement startpointprice;
	
	@FindBy(xpath = "//input[@name='mainRoute_price']")
	WebElement endpointprice;
	
	@FindBy(xpath  = "//div[@class='d-md-flex justify-content-md-between travel-price '][2]/div[2]//input")
	WebElement interpointdate;
	
	@FindBy(xpath = "//div[@class='d-md-flex justify-content-md-between travel-price '][2]/div[3]//input")
	WebElement interpointtime;

	@FindBy(xpath = "//div[@class='d-md-flex justify-content-md-between travel-price '][2]/div[4]//input")
	WebElement interpointprice;
	
//	Return trip
	
	@FindBy(xpath = "//div[@class='d-md-flex justify-content-md-between travel-price-round '][1]/div[4]//input")
	WebElement return_startpointprice;
	
	@FindBy(xpath = "//input[@name='mainRoute_price_round']")
	WebElement return_endpointprice;
	
	@FindBy(xpath =  "//div[@class='d-md-flex justify-content-md-between travel-price-round '][2]/div[2]//input")
	WebElement return_interpointdate;

	@FindBy(xpath = "//div[@class='d-md-flex justify-content-md-between travel-price-round '][2]/div[3]//input")
	WebElement return_interpointtime;
	
	@FindBy(xpath = "//div[@class='d-md-flex justify-content-md-between travel-price-round '][2]/div[4]//input")
	WebElement return_interpointprice;
	
	@FindBy(id = "publish")
	WebElement btnpublish;
	
	@FindBy(id = "tab_2")
	WebElement step2;
	
	
	public String getColor() {
		String initialColor = step2.getCssValue("border-color");
		
		 // Wait for the element's color to change
        wt.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                // Get the current color of the element
               String currentColor = step2.getCssValue("border-color");
                // Check if the color has changed
                return !currentColor.equals(initialColor);
            }
        });
       return step2.getCssValue("border-color");
	}
	
	public void setStartpointPrice(String ondate) {
		startpointprice.clear();
		startpointprice.sendKeys(ondate);
	}

	public void setEndpointPrice(String ondate) {
		endpointprice.clear();
		endpointprice.sendKeys(ondate);
	}
	
	public void setInterpointDate(String rtndate) {
		interpointdate.sendKeys(rtndate);
	}

	public void setInterpointTime(String rtndate) {
		interpointtime.sendKeys(rtndate);
	}

	public void setInterpointPrice(String rtndate) {
		interpointprice.clear();
		interpointprice.sendKeys(rtndate);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
//	Return trip

	public void setReturnSrtpointPrice(String ondate) {
		return_startpointprice.clear();
		return_startpointprice.sendKeys(ondate);
	}
	
	public void setReturnEndpointPrice(String ondate) {
		return_endpointprice.clear();
		return_endpointprice.sendKeys(ondate);
	}

	public void setReturnIntrpointPrice(String ondate) {
		return_interpointprice.clear();
		return_interpointprice.sendKeys(ondate);
	}

	public void setReturnIntrpointDate(String ondate) {
		return_interpointdate.sendKeys(ondate);
	}

	public void setReturnIntrpointTime(String ondate) {
		return_interpointtime.sendKeys(ondate);
	}
	
	public void clickPublish() {
		js.executeScript("arguments[0].click();",btnpublish);
	}

}
