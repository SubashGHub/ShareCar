package testcases;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.FindARide_pom;
import pom.Profile_pom;

public class FindARideTC extends LoginTC{
	
	@Test(dependsOnMethods = "loginTest", dataProvider = "rideData")
	public void findRideTest(String from, String to, String date) {
		FindARide_pom fd = new FindARide_pom(driver);
		Profile_pom h = new Profile_pom(driver);
		
		h.clickFindride();
		fd.setFromLocation(from);
		fd.setToLocation(to);
		fd.selectExtendRadius();
		fd.setJourneyDate(date);
		fd.searchRide();
		
	}
	
	@DataProvider
	String[][] rideData() {
		String arr [][] = {{"Chennai","Bengaluru","08/06/2024"}};
		return arr;
	}
}
