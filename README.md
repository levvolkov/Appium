# Домашнее задание к занятию «2.4. Appium. Кроссплатформенная мобильная автоматизация тестирования»

## Сделано:

<br>

### Задача 1. Настройка окружения для работы с Appium

1. Установлен [Node.js.](https://nodejs.org/en/download/package-manager)
2. Через терминал mac OS установлен [Appium](https://appium.io/docs/en/latest/quickstart/install/), используя менеджер пакетов npm c командой от имени администратора.
```
   sudo npm install -g appium
```
3. Установлен [драйвер UiAutomator2](https://appium.io/docs/en/latest/quickstart/uiauto2-driver/), необходимый во второй версии Appium, под написание тестов на Andriod.
```
   sudo appium driver install uiautomator2
```
4. Установлен [драйвер XCUITest](https://appium.io/docs/en/latest/guides/managing-exts/#using-appiums-extension-cli), необходимый во второй версии Appium, под написание тестов на iOS.
```
   sudo appium driver install xcuitest
```
5. Установлен [Appium Doctor](https://github.com/appium/appium-doctor) для проведения анализа, диагностики.
```
   sudo npm install -g appium-doctor
```
* Запущена утилита для проверки насколько система готова к работе с Appium и каких компонентов не хватает для автоматизации.
```
   appium-doctor
```
*  При появлении предупреждения о том, что компонент Carthage не найден, установлен Carthage. Если использовать Appium для автоматизации тестирования приложений только на Android или для веб-тестирования, то предупреждение о Carthage может быть не критичным. Для работы с iOS игнорирование отсутствия Carthage может привести к проблемам с установкой или запуском тестов. Чтобы минимизировать риски, установлены все необходимые зависимости.
```
   brew install carthage
```
6. Установалена последняя версия [Appium Inspector](https://github.com/appium/appium-inspector/releases), оболочка которая будет запускать рекордер в Appium.
7. При попытке запустить в терминале appium-сервер возникла ошибка связанная с тем, что Appium не может записать данные в свою рабочую директорию.
```
   appium
```
* Для проверки прав доступа введена команда.
```
   ls -la /Users/имя_пользователя/.appium
```
* Tак как права доступа к ней принадлежат пользователю root, а не моему аккаунту которая находится по пути `/Users/имя_пользователя/.appium` введена команда для изменения владельца папки и её содержимого.
```
   sudo chown -R имя_пользователя:staff /Users/имя_пользователя/.appium
```
8. Запущен эмулятор.
9. Собрано [приложение из лекции 2.2](https://github.com/netology-code/mqa-homeworks/tree/main/2.2%20UI%20Automator/sample).
10. Подключился к устройству через Appium Inspector. Заданы параметры в поле **возможности**. Вместо значении параметра *app* путь к apk-файлу, указал *appActivity* , так как приложение уже установлено на девайсе.
```json
{
  "platformName": "android",
  "deviceName": "Some name",
  "appPackage": "ru.netology.testing.uiautomator",
  "appActivity": "ru.netology.testing.uiautomator.MainActivity",
  "automationName": "uiautomator2"
}
```

---

<br>

### Задача 2. Автоматизация тестирования Appium

1. Создан новый проект в IDEA на базе gradle с использованием Java JDK 11 для стабильной работы.
2. В нем созданы тестовые классы в которых написаны UI-тесты с помощью фреймворка Appium на [приложение из лекции 2.2](https://github.com/netology-code/mqa-homeworks/blob/main/2.2%20UI%20Automator/2.2.md).
* тест на попытку установки пустой строки
* тест на открытие текста в новой Activity