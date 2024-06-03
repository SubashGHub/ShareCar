package testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.OfferRide1_pom;
import pom.OfferRide2_pom;
import pom.Profile_pom;

public class OfferRideTC1 extends LoginTC{
	
	@Test(dependsOnMethods = "loginTest", dataProvider = "offerData")
	public void offerRide1Test(String from, String to, String pick, String ondate, String ontime, String rtndate, String rtntime) {
	OfferRide1_pom offer = new OfferRide1_pom(driver);
	
	Profile_pom pro = new Profile_pom(driver);
	
	
	
	pro.clickOfferride();
	
	offer.setFromLocation(from);
	offer.setToLocation(to);
	offer.setPickupPoint(pick);
	offer.setOnWardTime(ontime);
	offer.setOnWardDate(ondate);
	offer.setReturnDate(rtndate);
	offer.setReturnTime(rtntime);
	offer.clickSave();
	
	OfferRide2_pom offer2 = new OfferRide2_pom(driver);
	
	Assert.assertEquals(offer2.getColor(), "rgb(101, 52, 255)");
	
	}
	
	@DataProvider
	String[][] offerData() throws IOException {
	
		
		FileInputStream srm = new FileInputStream(System.getProperty("user.dir")+"/TestData/Sharecar data.xlsx");
		XSSFWorkbook bk = new XSSFWorkbook(srm);
		XSSFSheet sht = bk.getSheet("Sheet1");
		
		int row = sht.getLastRowNum();
		int clm = sht.getRow(0).getLastCellNum();
		
		String arr [][] = new String[row][clm];
		
		for(int i=1; i<=row;i++) {
			for(int j=0;j<clm;j++) {
				XSSFCell cell = sht.getRow(i).getCell(j);
				DataFormatter fmt = new DataFormatter();
				arr[i-1][j] = fmt.formatCellValue(cell);
			}
		}
		
		bk.close();
		srm.close();
		return arr;
		
	}
	
	
	
}
