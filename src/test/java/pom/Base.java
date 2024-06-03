package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait wt;
	
	public Base(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
		PageFactory.initElements( driver, this);
		wt = new WebDriverWait(this.driver, Duration.ofSeconds(5));
	}
	
}
