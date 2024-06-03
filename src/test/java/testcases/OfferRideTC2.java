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

import pom.OfferRide2_pom;

public class OfferRideTC2 extends OfferRideTC1{
	
	@Test(dependsOnMethods = "offerRide1Test", dataProvider = "offerData1")
	public void offerRide2Test(String startprice, String ipdate, String iptime, String ipprice, String endprice, 
							String rtnprice, String rtnipdate, String rtniptime, String rtnipprice, String rtnendprice) {
		
	OfferRide2_pom offer = new OfferRide2_pom(driver);
	
	offer.setStartpointPrice(startprice);
	offer.setInterpointDate(ipdate);
	offer.setInterpointTime(iptime);
	offer.setInterpointPrice(ipprice);
	offer.setEndpointPrice(endprice);
	offer.setReturnSrtpointPrice(rtnprice);
	offer.setReturnIntrpointDate(rtnipdate);
	offer.setReturnIntrpointTime(rtniptime);
	offer.setReturnIntrpointPrice(rtnipprice);
	offer.setReturnEndpointPrice(rtnendprice);
	offer.clickPublish();
	Assert.assertEquals(driver.getTitle(), "Ride Detail - Sharecaar", "Page Title Mismatch");
	
	}
	
	@DataProvider
	String[][] offerData1() throws IOException {
	
		
		FileInputStream srm = new FileInputStream(System.getProperty("user.dir")+"/TestData/Sharecar data.xlsx");
		XSSFWorkbook bk = new XSSFWorkbook(srm);
		XSSFSheet sht = bk.getSheet("Sheet2");
		
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
