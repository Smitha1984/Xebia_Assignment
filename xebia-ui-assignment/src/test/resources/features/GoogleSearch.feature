Feature: Verify google searach

Scenario: User search for ducks in google home page

Given user launches browser
And navigates to website google.com
When user enters ducks as input box
And clicks seach button
Then search result page should display result related to ducks
