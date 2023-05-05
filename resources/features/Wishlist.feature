Feature: Add/Remove item to wishlist
	
Background: Login before shopping items
	Given User launchs Browser
	When User opens URL "https://demowebshop.tricentis.com/"
	And Click on Login link
	And Enter Login details "abc@abc.in" & "123456"
	And Click on Login button
	

@regression	@sanity
Scenario Outline: Add an item to wishlist
	When Enter "<Item>" in Search Box
	And Click on Item Link
	And Add to Wishlist
	Then Go to Wishlist Cart
	And "<Item>" should be available on Wishlist
	And Close the Browser

Examples:
|Item|
|Camera|
|Sneaker|

@sanity @smoke
Scenario: Clear wishlist
	Then Go to Wishlist Cart
	And Select all items in cart
	And Click on Update Cart
	Then Wishlist should be empty
	And Close the Browser