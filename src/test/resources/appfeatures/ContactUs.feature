Feature: Contact Us Feature

Scenario Outline: Contact Us scenario with different set of data
Given user navigates to contact us page
When user fills the form from given sheetname "<SheetName>" and "<RowNumber>"
And user clicks on send button
Then it shows successful message "Your message has been successfully sent to our team."  

Examples:
|SheetName|RowNumber|
|ContactUs|1|
|ContactUs|2|

#8steps(6skipped,2 undefined) for without steps definitions
#https://cucumber.io/docs/cucumber/api/:
#When Cucumber can’t find a matching step definition, the step gets marked as undefined (yellow), and all subsequent steps in the scenario are skipped.
#this is because Steps that follow undefined, pending, or failed steps are never executed, even 
#if there is a matching step definition. These steps are marked as skipped (cyan).