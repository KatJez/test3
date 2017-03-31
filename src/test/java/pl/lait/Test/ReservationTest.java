package pl.lait.Test;

import org.junit.*;
import org.openqa.selenium.WebDriver;

import pl.lait.PageObjects.MainPage;
import pl.lait.PageObjects.Reservation2Page;
import pl.lait.PageObjects.ReservationPage;
import pl.lait.PageObjects.SignOnPage;
import pl.lait.Setup.Init;

public class ReservationTest extends Init {

	protected static WebDriver driver;
	
	
	//@Before 
	
	public  void run(){
		driver = getDriver();
	}

	//@Test
	public void reservation(){
		MainPage mainPage = new MainPage();
		SignOnPage signOnPage = new SignOnPage();
		ReservationPage reservPage = new ReservationPage();
		Reservation2Page reserv2Page = new Reservation2Page();
		
		
		mainPage.link_signOn(driver).click();			         //gł str aplikacji
		signOnPage.loginAs("kasia123", "qwe123", driver);		//na tej stronie loguj sie
		reservPage.radio_oneWay(driver);
		reservPage.selectPassengersCount(driver,"1");             //a to dla void	- te dwa przykłądy, on chce tylko dostać parametry, to prostsza metoda, ta 1ze str ReservationPage
		reservPage.selectDepartingFrom(driver, "New York");
		reservPage.selectFromMonth(driver, "March");
		reservPage.selectFromDay(driver, "2");
		reservPage.selectToPort(driver, "London");
		reservPage.selectToMonth(driver, "March");
		reservPage.selectToDay(driver, "4");
		reservPage.radioChooseClass_business(driver);
		reservPage.radioChooseClass_economy(driver);
		reservPage.radioChooseClass_first(driver);
		reservPage.selectAirline(driver, "Unified Airlines");
		
		printScr("reservation");
		
		reservPage.buttonSubmit(driver).click();
		 
	//2 strona rezerwacji
		reserv2Page.radio_depart(driver).click();
		reserv2Page.radio_return(driver).click();
		
		printScr("reservation2");
		
		reserv2Page.buttonContinue(driver).click();
		
	//3 strona rezerwacji
		
		reserv2Page.fillPassName("Katarzyna", "Pierwsza", driver);
		reserv2Page.selectPassMeal(driver).selectByVisibleText("Vegetarian");
		reserv2Page.selectCreditCard(driver).selectByVisibleText("Visa");
		reserv2Page.input_creditCardNumber(driver).sendKeys("123456789");
		reserv2Page.selectExpirationMonth(driver).selectByVisibleText("02");
		reserv2Page.selectExpirationYear(driver).selectByVisibleText("2000");
		reserv2Page.input_namePass1(driver).sendKeys("Katarzyna");
		reserv2Page.input_lastPass1(driver).sendKeys("Pierwsza1");
		
					/*alternatywny zapis dla wypełniania pól z imionami i nazwiskiem
					 * reserv2Page.fillCreditOwner("Adam", "Wlasciciel", "karty", driver);
					 */
		reserv2Page.checkboxTicketlessTravel(driver).click();
		reserv2Page.input_billingAdress(driver).clear();
		reserv2Page.input_billingAdress(driver).sendKeys("nowy adres wpisuje");
		reserv2Page.input_billingCity(driver).clear();
		reserv2Page.input_billingCity(driver).sendKeys("Lublin");
		
		printScr("reservation3");
		reserv2Page.button_securePurchase(driver).click();
		
		reserv2Page.button_logOut(driver).click();
		printScr("reservation3");
	}
	
}
