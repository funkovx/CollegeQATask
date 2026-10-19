package ru.siriusuniversity.tests.config;

import com.codeborne.selenide.Configuration;

/**
 * Selenide / WebDriver configuration.
 * Kept in its own class so all settings live in one place and are easy to extend.
 */
public final class WebDriverConfig {

    public static final String BASE_URL = "https://lks.siriusuniversity.ru";
    public static final String LOGIN_PATH = "/login";

    private WebDriverConfig() {
    }

    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = BASE_URL;
        Configuration.timeout = 10_000;
        Configuration.pageLoadTimeout = 30_000;
        Configuration.headless = Boolean.parseBoolean(
                System.getProperty("selenide.headless", "false")
        );
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
        Configuration.reportsFolder = "target/selenide-reports";
    }
}
