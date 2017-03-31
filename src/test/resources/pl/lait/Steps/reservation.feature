Feature: Reservation process

Scenario: Successfull reservation for one person
	Given I open main page
	When I click link "SIGN-ON"
	When I fill in login fields with "kasia123" "qwe123"
	When I fill first reservation page
	When I fill second reservation page
	When I fill third reservation page
	
	Then I should see flights confirmation page 