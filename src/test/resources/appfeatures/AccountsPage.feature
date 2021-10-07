Feature: Accounts Page Feature

Background: 
Given user has already logged in to application
|username|password|
|email2@email.com|email| 



Scenario: Accounts Page Title
Given user is on the accounts page
When user gets title of the page
Then page title should be "My account - My Store"

Scenario: Accounts Section Count
Given user is on the accounts page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
And accounts section count should be 5
