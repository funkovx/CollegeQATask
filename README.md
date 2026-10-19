# CollegeQATask

UI test for the Sirius University student portal login page, written in Java with JUnit 5 and Selenide using the Page Object pattern.

## Stack

- Java 21, Maven
- JUnit 5
- Selenide 7.x (Chrome driver is managed automatically by Selenium Manager)
- dotenv-java for reading credentials from `.env`

## Project structure

```
CollegeQATask/
├── .env                  ← create it yourself, it is git-ignored
├── pom.xml
└── src/test/java/ru/siriusuniversity/tests/
    ├── base/
    │   └── BaseTest.java              // starts Chrome, closes it after each test
    ├── config/
    │   ├── Credentials.java           // reads LKS_LOGIN and LKS_PASSWORD from .env
    │   └── WebDriverConfig.java       // Selenide settings (browser, window size, timeouts)
    ├── pages/
    │   ├── DashboardPage.java         // checks a successful login (URL left /login)
    │   └── LoginPage.java             // Page Object for the login page
    └── LoginPageTest.java             // the test itself
```

## Credentials

Create `.env` in the project root:

```
LKS_LOGIN=your_email@example.com
LKS_PASSWORD=your_password
```

`.env` is listed in `.gitignore` and never committed.

## Running

```bash
mvn test
```

Headless mode:

```bash
mvn test -Dselenide.headless=true
```

## What the test does

`LoginPageTest` opens `https://lks.siriusuniversity.ru/login` and picks a scenario:

| Condition | Scenario |
| --- | --- |
| `.env` exists with credentials | Login button is visible → fills in login and password → submits → checks that the URL has left `/login` |
| `.env` is missing or empty | Login button is visible → submits an empty form → checks that the page stays on `/login` |

Screenshots of failed steps are saved to `target/selenide-reports/`.
