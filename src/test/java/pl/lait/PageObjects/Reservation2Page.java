package pl.lait.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Reservation2Page {

	
//do 2giej strony
	
	//to radiobuttony 	kolejna strona w rezerwacji - http://newtours.demoaut.com/mercuryreservation2.php
		static String radioDepart_xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[7]/td[1]/input";
		static String radioReturn_xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input";
	
		//i teraz mamy obiekt continue	
		static String inputContinue_xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input";
		
//do 3 strony rejestracji
		static String input_passFirst0_name = "passFirst0";
		static String input_passLast0_name = "passLast0";
		static String select_passMeal_name = "pass.0.meal"; 
		static String select_creditCard_name = "creditCard";
		static String input_creditCardNumber_name = "creditnumber";
		static String select_expirationMonth_name = "cc_exp_dt_mn";
		static String select_expirationYear_name = "cc_exp_dt_yr";
		static String input_cc_frst_name = "cc_frst_name";
		static String input_cc_last_name = "cc_last_name";
		                     /* alternatywny zapis dla wypełnienia imienia, nazwiska i drugiego imienia
		                      * static String input_cc_frst_name = "cc_frst_name";
		                        static String input_cc_last_name = "cc_last_name";
		                        static String input_cc_mid_name = "cc_mid_name";
		                      */
		static String inputTicketlessTravel_xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input";
		static String input_billAddress1_name = "billAddress1";
		static String input_billCity_name = "billCity";
		
		static String button_securePurchase_name = "buyFlights";
		
		static String button_logOut_xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[3]/a";
		
		
//met do strony 2 rezerwacji
		public WebElement radio_depart(WebDriver driver){                          
			return driver.findElement(By.xpath(radioDepart_xpath));
		}
		public WebElement radio_return(WebDriver driver){                          
			return driver.findElement(By.xpath(radioReturn_xpath));
		}
		public WebElement buttonContinue(WebDriver driver){                          
			return driver.findElement(By.xpath(inputContinue_xpath));
		}
	
//teraz robimy metody ze strony 3 rezerwację (połącyzliśmy 2 i 3 w jedno	
		
		public WebElement input_passFirst(WebDriver driver){
			return driver.findElement(By.name(input_passFirst0_name));
		}
		public WebElement input_passLast(WebDriver driver){
			return driver.findElement(By.name(input_passLast0_name));
		}
		                              //alternatywny zapis do tych dwóch powyżej
		                                public void fillPassName(String first, String last, WebDriver driver){
		                                	driver.findElement(By.name(input_passFirst0_name)).sendKeys(first);
		                                	driver.findElement(By.name(input_passLast0_name)).sendKeys(last);
		                                }
	                
		                                		
		public Select selectPassMeal(WebDriver driver){
			return new Select(driver.findElement(By.name(select_passMeal_name)));
		}
		public Select selectCreditCard(WebDriver driver){
			return new Select(driver.findElement(By.name(select_creditCard_name)));	
		}
		public WebElement input_creditCardNumber(WebDriver driver){
			return driver.findElement(By.name(input_creditCardNumber_name));
		}
		public Select selectExpirationMonth(WebDriver driver){
			return new Select(driver.findElement(By.name(select_expirationMonth_name)));
		}
		public Select selectExpirationYear(WebDriver driver){
			return new Select(driver.findElement(By.name(select_expirationYear_name)));
		}
		
		public WebElement input_namePass1(WebDriver driver){
			return driver.findElement(By.name(input_cc_frst_name));
		}
		public WebElement input_lastPass1(WebDriver driver){
			return driver.findElement(By.name(input_cc_last_name));
		}
		
						/*alternatywnie, aby wypełnić pola jednym poleceniem
						 * public void fillCreditOwner(String first, String mid, String last, WebDriver){
						 * driver.findElement(By.name(input_cc_frst_name)).sendKeys(first);
						 * driver.findElement(By.name(input_cc_mid_name)).sendKeys(mid);
						 * driver.findElement(By.name(input_cc_last_name)).sendKeys(last);
						 */
		
		public WebElement checkboxTicketlessTravel(WebDriver driver){                          
			return driver.findElement(By.xpath(inputTicketlessTravel_xpath));
		}
		public WebElement input_billingAdress(WebDriver driver){
			return driver.findElement(By.name(input_billAddress1_name));	
		}
		public WebElement input_billingCity(WebDriver driver){
			return driver.findElement(By.name(input_billCity_name));	
		}
				
		public WebElement button_securePurchase(WebDriver driver){
			return driver.findElement(By.name(button_securePurchase_name));	
		}	
			
		
		public WebElement button_logOut(WebDriver driver){
			return driver.findElement(By.xpath(button_logOut_xpath));	
		}
		
		
		
		
		

}
