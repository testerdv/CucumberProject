Feature: Login Page Feature

Scenario: Login Page Title
Given user is on login page
When user gets title of the page
Then page title should be "Login - My Store"

Scenario: Forgot Pasword Link
Given user is on login page
Then forgot your password link should be displayed
# note no when


Scenario: Login With Correct Credentials
Given user is on login page
When user enters username "email2@email.com"
And user enters password "email"
And user clicks on login button
And user gets title of the page
And page title should be "My account - My Store"