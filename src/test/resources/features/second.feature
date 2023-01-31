Feature: Параметризированные тесты

  Scenario: Параметризация степов
    Given открыт браузер
    * страца логина открыта
    When user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in
    Then title is "All Projects"
    And project id is 123

  Scenario Outline: Параметризация при помощи таблицы значений
    Given открыт браузер
    * страца логина открыта
    When user "<username>" with password "<password>" logged in
    Then title is "All Projects"
    And project id is <age>
    Examples:
      | username              | password  | age |
      | atrostyanko@gmail.com | Qwertyu_1 | 123 |
      | atrostyanko@gmailcom  | Qwertyu_1 | 123 |

