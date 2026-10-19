package ru.siriusuniversity.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.siriusuniversity.tests.base.BaseTest;
import ru.siriusuniversity.tests.config.Credentials;
import ru.siriusuniversity.tests.pages.LoginPage;

@DisplayName("Sirius University login page")
public class LoginPageTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Login scenario depends on whether .env with credentials exists")
    void loginScenario() {
        loginPage.openPage().verifyLoginButtonIsDisplayed();

        if (Credentials.isAvailable()) {
            loginPage.login().verifyPageLoaded();
        } else {
            loginPage.clickLoginButtonAndVerifyValidationError();
        }
    }
}
