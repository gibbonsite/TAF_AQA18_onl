Feature: Начальный тест для изучения Cucumber

  Scenario: Простой тест без тела

  Scenario: Простой тест с Given
    Given открыт браузер

  Scenario: Простой тест с Given и When
    Given открыт браузер
    When страца логина открыта

  Scenario: Простой тест со всеми ключевыми словами
    Given открыт браузер
    When страца логина открыта
    Then поле username отображается

  Scenario: Использование AND
    Given открыт браузер
    And страца логина открыта
    Then поле username отображается
    * поле password отображается

  Scenario: Использование But
    Given открыт браузер
    And страца логина открыта
    Then поле username отображается
    But ошибка не оботражается


