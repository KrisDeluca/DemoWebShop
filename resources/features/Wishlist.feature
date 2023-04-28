Feature: Add/Remove item to wishlist
	
@regression	
Scenario Outline: Add an item to wishlist
	Given User launchs Browser
	When User opens URL "https://demowebshop.tricentis.com/"
	And Enter "<Item>" in Search Box
	Then Click on Item Link
	And Add to Wishlist
	When Go to Wishlist
	Then "<Item>" should be available on Wishlist
	And Close the Browser

Examples:
|Item|
|Camera|
|Sneaker|