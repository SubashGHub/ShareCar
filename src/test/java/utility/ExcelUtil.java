package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static String[][] excelRead(String Sheetname) throws IOException {
	
		
		FileInputStream srm = new FileInputStream(System.getProperty("user.dir")+"/TestData/Sharecar data.xlsx");
		XSSFWorkbook bk = new XSSFWorkbook(srm);
		XSSFSheet sht = bk.getSheet(Sheetname);
		
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
