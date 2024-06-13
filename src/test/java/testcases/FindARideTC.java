package testcases;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Base;
import pageObjects.FindARide_pom;
import pageObjects.Profile_pom;
import utility.ExtentReport;

public class FindARideTC extends LoginTC{
	
	@Test(dependsOnMethods = "loginTest", dataProvider = "rideData")
	public void findRideTest(String from, String to, String date, String radius) {
		FindARide_pom fd = new FindARide_pom(Base.driver);
		
		new Profile_pom(driver).clickFindride();
		
		fd.setFromLocation(from);
		fd.setToLocation(to);
		fd.selectExtendRadius(radius);
		fd.setJourneyDate(date);
		fd.clickSearchRide();
		ExtentReport.test.pass("Search ride button clicked");
	}
	
	@DataProvider
	String[][] rideData() {
		String arr [][] = {{"Chennai","Bengaluru","23-08-2024","20"}};
		return arr;
	}
}
