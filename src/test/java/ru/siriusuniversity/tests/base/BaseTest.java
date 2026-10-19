package ru.siriusuniversity.tests.base;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.siriusuniversity.tests.config.WebDriverConfig;

/**
 * Base class for all UI tests.
 * Sets up Selenide and closes the browser cleanly.
 */
public abstract class BaseTest {

    @BeforeAll
    static void setUpAll() {
        WebDriverConfig.setUp();
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }
}
