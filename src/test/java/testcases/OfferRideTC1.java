package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.OfferRide1_pom;
import pageObjects.OfferRide2_pom;
import pageObjects.Profile_pom;
import utility.ExcelUtil;
import utility.ExtentReport;

public class OfferRideTC1 extends LoginTC{
	
	@Test(dependsOnMethods = "loginTest", dataProvider = "offerData")
	public void offerRide1Test(String arr []) {
	OfferRide1_pom offer = new OfferRide1_pom(driver);
	
	new Profile_pom(driver).clickOfferride();;
	
	offer.setFromLocation(arr[0]);
	offer.setToLocation(arr[1]);
	offer.setPickupPoint(arr[2]);
	offer.setOnWardTime(arr[3]);
	offer.setOnWardDate(arr[4]);
	offer.setReturnDate(arr[5]);
	offer.setReturnTime(arr[6]);
	offer.clickSave();
	ExtentReport.test.pass("In step-1 page Save button clicked");
	
	OfferRide2_pom offer2 = new OfferRide2_pom(driver);
	
	Assert.assertEquals(offer2.getColor(), "rgb(101, 52, 255)");
	
	}
	
	@DataProvider()
	String[][] offerData() throws IOException {
	
		return ExcelUtil.excelRead("Sheet1");
		
	}
	
	
	
}
