import Pages.CRMPage;
import Pages.LoginPage;
import Pages.TableViewPage;
import Utils.MyListener;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static Utils.RandomData.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MyListener.class)
public class DealTestCRM {

    @Test
    @Feature("Deals")
    @Tag("positiveTest")
    public void createQuickDeal() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        String name = getRandomName();
        new LoginPage()
                .login();

        CRMPage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickQuickDealBtn()
                .setDealName(name)
                .setDealPrice(String.valueOf(getRandomInt(1, 100)))
                .setDealProspect(getRandomName())
                .setDealEmail(getRandomEmail())
                .clickProspectDropDown()
                .chooseProspectList(getRandomInt(0, 5))
                .clickSaveQuickDealBtn();
        assertThat(name, is(containsString(crm.getDealFromStage(name))));


    }


    @Feature("Deals")
    @Tag("positiveTest")
    public void removeDealFromTable() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new LoginPage()
                .login();

        TableViewPage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickTableViewBtn()
                .clickCheckBoxTable(3)
                .clickDeleteButton()
                .clickConfirmModalButton();

        // добавить проверку на удалённую таблицу
    }



    @Feature("Deal")
    @Tag("positiveTest")
    public void bulkRemoveDealsFromTable() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        new LoginPage()
                .login();

        TableViewPage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickTableViewBtn()
                .clickCheckBoxTable(3)
                .clickCheckBoxTable(4)
                .clickCheckBoxTable(5)
                .clickDeleteButton()
                .clickConfirmModalButton();

// Добавить проверку на удалённые таблицы
    }


    @Feature("Deal")
    @Tag("positiveTest")
    public void changePipelineFromTableView() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new LoginPage()
                .login();

        TableViewPage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickTableViewBtn()
                .clickCheckBoxTable(3)
                .clickMoveBtn()
                .clickModalPipelineDrop()
                .getPipelineFromModalDrop(3)
                .clickSaveBtn();
        Selenide.sleep(5000);
// Добавить проверку , переименовать метод с гет на чуз
    }


    @Feature("Deal")
    @Tag("positiveTest")
    public void changeStageFromTableView() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new LoginPage()
                .login();

        TableViewPage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickTableViewBtn()
                .clickCheckBoxTable(3)
                .clickMoveBtn()
                .clickModalStageDropDown()
                .getStageFromModalDrop(2)
                .clickSaveBtn();
        Selenide.sleep(5000);
// Добавить проверку , переименовать метод с гет на чуз
    }



    @Feature("Deal")
    @Tag("positiveTest")
    public void changePipelineAndStageFromTableView() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new LoginPage()
                .login();

        TableViewPage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickTableViewBtn()
                .clickCheckBoxTable(3)
                .clickMoveBtn()
                .clickModalPipelineDrop()
                .getPipelineFromModalDrop(3)
                .clickModalStageDropDown()
                .getStageFromModalDrop(2)
                .clickSaveBtn();
        Selenide.sleep(5000);
// Добавить проверку , переименовать метод с гет на чуз
    }

}
