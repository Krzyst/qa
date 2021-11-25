@BDD
Feature: User Login

  @Login @worspress @userpanel
  Scenario: Login
    Given User starts on main page
    When User logs to user panel
    Then User can modify user profile
