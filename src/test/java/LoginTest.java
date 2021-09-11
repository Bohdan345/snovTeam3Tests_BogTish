import Pages.LoginPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static Pages.BasePage.destroy;

public class LoginTest {



    public void login() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        new LoginPage()

                .login();
        destroy();

    }
}
