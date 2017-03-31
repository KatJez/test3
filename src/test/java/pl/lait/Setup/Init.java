package pl.lait.Setup;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import javax.management.Descriptor;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Init {

	//static FirefoxDriver driver;
	static WebDriver driver;              //wpisaliśmy to zamiast tego powyżej
	String folder = "allScreens";
	
	
	
	public static WebDriver getDriver(){
		
		if(driver == null){
			System.out.println("obiekt Drivera = = NULL - wykonuję new FirefoxDriver()");
		
		URL hubUrl = null;
		
		try {
			hubUrl = new URL("http://localhost:4444/wd/hub/");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//URL url = new
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		//driver
		driver = new RemoteWebDriver(hubUrl, cap);
		//driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
		
	}else{
		
		System.out.println("obiekt Drivera != NULL - zwracam obiekt");
		return driver;
	}
	}
	
	public static void close(){
		driver.close();
		driver.quit();
		driver = null;
	}
	
	@After
	public void cleanUp(){
		
		close();
	}
	
	public void printScr(String folder){
		
		/*
		 * Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Long milis = timestamp.getTime();
		
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		System.out.println("Generating screenshot "+milis);
		try {
			FileUtils.copyFile(srcFile, new File("target\\"+folder+"\\screen-"+milis+".png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}
}
