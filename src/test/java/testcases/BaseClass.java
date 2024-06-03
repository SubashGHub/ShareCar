package testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void openApp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://products.ncryptedprojects.com/sharecaar/login");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void close() {
		driver.close();
	}
	
	
	public String captureScreen(String TCname) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		String timeStamp=new SimpleDateFormat("dd.MM.yyyy.hh.mm").format(new Date());
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String target=(System.getProperty("user.dir")+"\\Screenshot\\"+TCname+"_"+timeStamp+".png");
		try {
			FileUtils.copyFile(src, new File(target));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return target;
	}

}
