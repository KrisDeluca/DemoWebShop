Feature: Registration

@sanity
Scenario Outline: Successful registration complete
	Given User launchs Browser
	When User opens URL "https://demowebshop.tricentis.com/"
	And Click on Register button to initiate
	And Enter Details "<Gender>", "<Name>" & "<Email>"
	And Enter Password "<Password>"
	And Click on Register button to complete
	Then Success Message displays
	When Click on Continue
	Then PageTitle should be "Demo Web Shop"
	And Close the Browser
	
Examples:
|Gender|Name|Email|Password|
|Male|Rohan Singh|abcd@123.efg|12345678|
#|Male|Raj Singh|efgh@456.abc|12345678|
#|Female|Preeti Gupta|ijhk@789.xyz|12345678|