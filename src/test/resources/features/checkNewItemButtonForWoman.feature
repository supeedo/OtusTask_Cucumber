Feature: Убедиться в правильной фильтрации по гендеру с отработкой одной из кнопок главного меню.


  Scenario: Проверка кнопки "Новинки" для женщин
    Given Открыть браузер
    Then Перейти на 'https://www.tsum.ru/'
    Then Проверить что нажата ктопка 'Женское' в gender меню
    Then Нажать на кнопку 'Новинки' в Главном меню
    Then Убедиться что в центре страницы отобразилось 'Новинки для женщин'
    Then Закрыть браузер