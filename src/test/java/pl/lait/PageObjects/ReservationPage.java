package pl.lait.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReservationPage {

//radiobutton
	static String roundTrip_xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]";
	static String oneWay_xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]";
//selecty	
	static String passCount_name = "passCount";
	static String fromPort_name = "fromPort";
	static String fromMonth_name = "fromMonth";
	static String fromDay_name = "fromDay";
	static String toPort_name = "toPort";
	static String toMonth_name = "toMonth";
	static String toDay_name = "toDay";
//radiobutton
	static String serviceEco_xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/input";
	static String serviceBiz_xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]";
	static String serviceFirst_xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[2]";
//select	
	static String whichAirline_name = "airline";
//podsumowanie zakup
	static String submit_xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input";

	
	public WebElement radio_roundTrip(WebDriver driver) {     //zwracamy web element ale na razie nie klikamy w niego - najpier tego roundTrip
															// całą sciezke xpath wyciągniemy sobe na górę, żeby w razie czego poprawiać w 1 miejscu
		return driver.findElement(By.xpath(roundTrip_xpath));  //a tutaj wsadzamy zmienną zamiast xpath
	}
	
	public WebElement radio_oneWay(WebDriver driver) {     //zwracamy web element ale na razie nie klikamy w niego - one way teraz
		
		return driver.findElement(By.xpath(oneWay_xpath));	//i tutaj też wsadzamy zmienną zamiast xpath
	}
	
	//1 metoda - przyjmuje webdrivera i ile pasaz chcemy i nam znajduje go przekazujemu mu tekst - prostsza metoda!!!
	public void selectPassengersCount(WebDriver driver, String visibleText_passCount){
																						//ale tutaj zmieniamy 2 na visibleText
		Select passengers = new Select(driver.findElement(By.name(passCount_name)));    //i tutaj zmieniliśmy na passCount_name a było passCount
		passengers.selectByVisibleText(visibleText_passCount);									//tu była 2
	}
	//2 metoda - tu zwracamy selecta, podajemy tylko webdrivera, to to samo co na górze, ale ta trudniejsza
	public Select selectPassengersCount(WebDriver driver){
		Select passengers = new Select(driver.findElement(By.name(passCount_name)));    
		//passengers.selectByVisibleText(visibleText_passCount);
		return passengers;
	}               
	
	
	                                                                      //wszystkie selecty robimy voidem
	//teraz robimy metody które potem użyjemy w testach
	public void selectDepartingFrom(WebDriver driver, String visibleText_depFrom){        //te visibleText_depFrom to zmienna lokalna, można ją nazwać inaczej albo nawet wszędzie tak samo, tutaj napisaliśmy dla każdej metody inaczej, zeby było ładnie widać
		Select departingfrom = new Select(driver.findElement(By.name(fromPort_name)));
		departingfrom.selectByVisibleText(visibleText_depFrom);
	}
	public void selectFromMonth(WebDriver driver, String visibleText_fromMonth){
		Select on = new Select(driver.findElement(By.name(fromMonth_name)));
		on.selectByVisibleText(visibleText_fromMonth);
	}
	public void selectFromDay(WebDriver driver, String visibleText_fromDay){
		Select day = new Select(driver.findElement(By.name(fromDay_name)));
		day.selectByVisibleText(visibleText_fromDay);
	}
	public void selectToPort(WebDriver driver, String visibleText_toPort){
		Select arriving = new Select(driver.findElement(By.name(toPort_name)));
		arriving.selectByVisibleText(visibleText_toPort);
	}
	public void selectToMonth(WebDriver driver, String visibleText_toMonth){
		Select returning = new Select(driver.findElement(By.name(toMonth_name)));
		returning.selectByVisibleText(visibleText_toMonth);
	}
	public void selectToDay(WebDriver driver, String visibleText_toDay){                //void robi to za nas
		Select returningday = new Select(driver.findElement(By.name(toDay_name)));
		returningday.selectByVisibleText(visibleText_toDay);
	}
	public WebElement radioChooseClass_economy(WebDriver driver){                          //wybierz klasę w samolocie, void nie zwraca nic, wiec zamiast clicka mamy returning
		return driver.findElement(By.xpath(serviceEco_xpath));                        //zwróc ten web element, ale jeśli mamy el klikalne to klikamy je w teście, znajywanie el robimy na page object i klikamy w tekście, wiec musimy znalezc ten element i go wypluć i potem w teście klikamy
	}
	public WebElement radioChooseClass_first(WebDriver driver){                         
		return driver.findElement(By.xpath(serviceFirst_xpath));                        
	}
	public WebElement radioChooseClass_business(WebDriver driver){                          //wybierz klasę w samolocie, void nie zwraca nic, wiec zamiast clicka mamy returning
		return driver.findElement(By.xpath(serviceBiz_xpath));                        //zwróc ten web element, ale jeśli mamy el klikalne to klikamy je w teście, znajywanie el robimy na page object i klikamy w tekście, wiec musimy znalezc ten element i go wypluć i potem w teście klikamy
	}
	public void selectAirline(WebDriver driver, String visibleText_whichAirline){
		Select airline = new Select(driver.findElement(By.name(whichAirline_name)));
		airline.selectByVisibleText(visibleText_whichAirline);
	}
	public WebElement buttonSubmit(WebDriver driver){                          //void nie zwraca nic, wiec zamiast clicka mamy returning
		return driver.findElement(By.xpath(submit_xpath));
	}
}
