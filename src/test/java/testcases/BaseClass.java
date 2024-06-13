package testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public static WebDriver driver;
	ResourceBundle bundle;
	
	
	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		bundle = ResourceBundle.getBundle("config");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(bundle.getString("url"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
		
	public String captureScreen(String TCname) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		String timeStamp=new SimpleDateFormat("dd.MM.yyyy.hh.mm").format(new Date());
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String target=(System.getProperty("user.dir")+"/Screenshot/"+TCname+"_"+timeStamp+".png");
		
		try {
			FileUtils.copyFile(src, new File(target));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return target;
	}

}
