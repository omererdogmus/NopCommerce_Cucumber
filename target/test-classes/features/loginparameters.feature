@web
  Feature: Login Admin Feature

    Background:
      Given I am on admin panel page

      @parameters
      Scenario Outline: Verify invalid login for multiple users
        When I enter <username> into username text fields on admin login page
        And I enter <password> into password text fields on admin login page
        And I click on login button on admin login page
        Then I verify that I used invalid credentials

        Examples:

        | username       | password |
        | omer@gmail.com | test1234 |
        | john@gmail.com | 1234test |
        | lisa@gmail.com | test456  |