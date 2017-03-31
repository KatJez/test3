package pl.lait.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//tu beda el ktore bedziemy zarzadzac

public class MainPage {

	static String signOnLinkText = "SIGN-ON";  //przerobiliśmy to na linki, żeby sta zaciągać do testów, nie trzeba potem wszędzie pisać SIGN-ON tylko tutaj
	static String registerLinkText = "REGISTER";
	static String supportLinkText = "SUPPORT";
	static String contactLinkText = "CONTACT";
	
	public  WebElement link_click(WebDriver driver, String txt) {		
		return driver.findElement(By.linkText(txt));
	}
	
	public  WebElement link_signOn(WebDriver driver) {		//metoda ktora zwroci nasz link do sign on i tu musimy mu przekazac firefoxa przez parametr zeby dalo sie go kliknac
		return driver.findElement(By.linkText(signOnLinkText));
	}
	
	public  WebElement link_register(WebDriver driver) {		
		return driver.findElement(By.linkText(registerLinkText));
	}
	
	public WebElement link_support(WebDriver driver) {		
		return driver.findElement(By.linkText(supportLinkText));
	}
	
	public WebElement link_contact(WebDriver driver) {		
		return driver.findElement(By.linkText(contactLinkText));
	}

}
