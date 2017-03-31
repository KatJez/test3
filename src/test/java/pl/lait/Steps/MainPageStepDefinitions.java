package pl.lait.Steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.*;
import cucumber.api.java.en.*;
import junit.framework.Assert;
import pl.lait.PageObjects.MainPage;
import pl.lait.PageObjects.Reservation2Page;
import pl.lait.PageObjects.ReservationPage;
import pl.lait.PageObjects.SignOnPage;
import pl.lait.Setup.Init;

public class MainPageStepDefinitions extends Init{
        protected WebDriver driver;
        
        @Before
        public void init(){
        	driver = getDriver();    	
        }
        
        @Given("^I open main page$")                  //otwarcie wyr regularnego, poszukiwany tekst się tu zaczyna
         public void i_open_main_page(){
        	System.out.println("krok pierwszy w teście");
        }
        
        @When("^I click link \"([^\"]*)\"$")
        public void i_click_link(String arg1) throws Throwable {
            // Write code here that turns the phrase above into concrete actions
           MainPage main = new MainPage();       //tworzymy obiekt strony zeby się do niej odwołać
           main.link_click(driver, arg1).click();
        }

        @When("^I click login button$")
        public void i_click_login_button() throws Throwable {
            // Write code here that turns the phrase above into concrete actions
            
        }

        @Then("^I should see contact page$")
        public void i_should_see_contact_page() throws Throwable {
            // Write code here that turns the phrase above into concrete actions
                                                    
        	System.out.println("Page title: " + driver.getTitle());
        	Assert.assertEquals("Wrong page title", "Under Construction: Mercury Tours", driver.getTitle());
        }
           
        //--logowanie na konkretną osobę
        
        @When("^I fill in login fields with \"([^\"]*)\" \"([^\"]*)\"$")           // wyrażenie \" to escape character żeby nie traktował tego jako cudzysłów 
        public void i_fill_in_login_fields_with(String arg1, String arg2) throws Throwable {
            // Write code here that turns the phrase above into concrete actions
        	SignOnPage login = new SignOnPage();
        	login.loginAs(arg1, arg2, driver);
         }

        @Then("^I should see flights reservation page$")
        public void i_should_see_flights_reservation_page() throws Throwable {
            // Write code here that turns the phrase above into concrete actions
        	Assert.assertEquals("Wrong page title", "Find a Flight: Mercury Tours:", driver.getTitle());
        }
        
        
        @When("^I fill first reservation page$")
        public void i_fill_first_reservation_page() throws Throwable {
            // Write code here that turns the phrase above into concrete actions
        	MainPage mainPage = new MainPage();
    		SignOnPage signOnPage = new SignOnPage();
    		ReservationPage reservPage = new ReservationPage();
    		    		    		
    		reservPage.radio_oneWay(driver);
    		reservPage.selectPassengersCount(driver,"1");             
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
    		reservPage.buttonSubmit(driver).click();
        }
        
        @When("^I fill second reservation page$")
        public void i_fill_second_reservation_page() throws Throwable {
          
        	Reservation2Page reserv2page = new Reservation2Page();
        	
        	reserv2page.radio_depart(driver).click();
    		reserv2page.radio_return(driver).click();
    		reserv2page.buttonContinue(driver).click();
        }
        
        @When("^I fill third reservation page$")
        public void i_fill_third_reservation_page() throws Throwable {
        	
        	Reservation2Page reserv2page = new Reservation2Page();
        	
        	reserv2page.fillPassName("Katarzyna", "Pierwsza", driver);
    		reserv2page.selectPassMeal(driver).selectByVisibleText("Vegetarian");
    		reserv2page.selectCreditCard(driver).selectByVisibleText("Visa");
    		reserv2page.input_creditCardNumber(driver).sendKeys("123456789");
    		reserv2page.selectExpirationMonth(driver).selectByVisibleText("02");
    		reserv2page.selectExpirationYear(driver).selectByVisibleText("2000");
    		reserv2page.input_namePass1(driver).sendKeys("Katarzyna");
    		reserv2page.input_lastPass1(driver).sendKeys("Pierwsza1"); 					
    		reserv2page.checkboxTicketlessTravel(driver).click();
    		reserv2page.input_billingAdress(driver).clear();
    		reserv2page.input_billingAdress(driver).sendKeys("nowy adres wpisuje");
    		reserv2page.input_billingCity(driver).clear();
    		reserv2page.input_billingCity(driver).sendKeys("Lublin");
    		reserv2page.button_securePurchase(driver).click();
    		//reserv2page.button_logOut(driver).click();
        	
        }
        
        @Then("^I should see flights confirmation page$")
        public void i_should_see_flights_confirmation_page() throws Throwable {
            // Write code here that turns the phrase above into concrete actions
        	Assert.assertEquals("Wrong page title", "Flight Confirmation: Mercury Tours", driver.getTitle());
        }
        @After
        public void end(){
        	cleanUp();                    //zamknie się przeglądarka po teście cucumberowym
        }
}
