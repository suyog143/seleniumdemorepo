Feature: Application Login

Scenario: Login with valid credentials
Given Open any Browser
And Navigate to login page
When User enters username as "mycity143@gmail.com" and password as "Mycity@143" into the fields
And User clicks on the Login button
Then Verify user is able to successfully login
