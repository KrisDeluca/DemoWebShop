Feature: Add/Remove item to cart

Background: Login before shopping items
	Given User launchs Browser
	When User opens URL "https://demowebshop.tricentis.com/"
	And Click on Login link
	And Enter Login details "abc@abc.in" & "123456"
	And Click on Login button
	
@regression	
Scenario: Add a book to cart
	When Click on Books under categories
	And Add Item to cart
	Then Go to Shopping Cart
	And Fill required fields and checkout
	Then PageTitle should be "Demo Web Shop. Checkout"
	And Close the Browser
	
@sanity
Scenario: Add a CellPhones to cart
	When Click on Electronics under categories
	And Click on Cellphones tab
	And Add Item to cart
	Then Go to Shopping Cart
	And Fill required fields and checkout
	Then PageTitle should be "Demo Web Shop. Checkout"
	And Close the Browser
	
@regression
Scenario Outline: Add a Desktops to cart
	When Click on Computers under categories
	And Click on Desktops tab
	And Add Item to cart
	And Select specs "<Processor>", "<RAM>", "<HDD>" & "<Software>"
	And Add Item to cart
	Then Go to Shopping Cart
	And Fill required fields and checkout
	Then PageTitle should be "Demo Web Shop. Checkout"
	And Close the Browser
	
Examples:
|Processor|RAM|HDD|Software|
|Fast|4 GB|400 GB|Office Suite|
#|Slow|8 GB|320 GB|Image Viever|
#|Medium|2 GB|400 GB|Other Office|

@sanity @smoke
Scenario: Clear cart
	Then Go to Shopping Cart
	And Select all items in cart
	And Click on Update Cart
	Then Cart should be empty
	And Close the Browser