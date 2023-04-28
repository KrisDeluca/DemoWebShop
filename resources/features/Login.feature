Feature: Login

@sanity @regression
Scenario Outline: Successful login complete
	Given User launchs Browser
	When User opens URL "https://demowebshop.tricentis.com/"
	And Click on Login link
	And Enter Login details "<Email>" & "<Password>"
	And Click on Login button
	Then Profile Name should be "<Email>"
	And Close the Browser
	
Examples:
|Email|Password|
|abc@abc.in|123456|
|abcd@123.xyz|12345678|