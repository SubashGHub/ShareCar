package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.OfferRide2_pom;
import utility.ExcelUtil;
import utility.ExtentReport;

public class OfferRideTC2 extends OfferRideTC1{

	@Test(dependsOnMethods = "offerRide1Test", dataProvider = "offerData1")
	public void offerRide2Test(String arr[]) {

		OfferRide2_pom offer = new OfferRide2_pom(driver);

		offer.setStartpointPrice(arr[0]);
		offer.setInterpointDate(arr[1]);
		offer.setInterpointTime(arr[2]);
		offer.setInterpointPrice(arr[3]);
		offer.setEndpointPrice(arr[4]);
		offer.setReturnSrtpointPrice(arr[5]);
		offer.setReturnIntrpointDate(arr[6]);
		offer.setReturnIntrpointTime(arr[7]);
		offer.setReturnIntrpointPrice(arr[8]);
		offer.setReturnEndpointPrice(arr[9]);
		offer.clickPublish();
		ExtentReport.test.pass("In step-2 page publish button clicked");
		
		Assert.assertEquals(driver.getTitle(), "Ride Detail - Sharecaar", "Page Title Mismatch");

	}

	@DataProvider
	String[][] offerData1() throws IOException {

		return ExcelUtil.excelRead("Sheet2");

	}



}
