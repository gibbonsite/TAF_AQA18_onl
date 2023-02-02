Feature: Usa a background

  Rule: правило 1
    Background:
      Given открыт браузер
        * страца логина открыта

    Scenario: Испольвание чего-то 1
      Given user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in

    Scenario: Испольвание чего-то 2
      Given user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in

  Rule: правило 2
    Background:
      Given открыт браузер
      * страца логина открыта

    Scenario: Испольвание чего-то 1
      Given user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in

    Scenario: Испольвание чего-то 2
      Given user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in