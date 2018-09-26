import org.junit.Test;
import pages.InsurancePage;
import pages.MainPage;
import pages.TravelPage;

public class MyRefTest extends BaseTest {


    @Test
    public void newSberTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Путешествия и покупки");

        new TravelPage(driver).goToInsuranceButton.click();
        new InsurancePage(driver).minSumInsCoverage.click();
        new InsurancePage(driver).goToNextStageButton.click();

        InsurancePage insurancePage = new InsurancePage(driver);
        insurancePage.inputFieldInsured("Фамилия /Surname", "Testing");
        insurancePage.inputFieldInsured("Имя / Given names", "Test");
        insurancePage.inputFieldInsured("Дата рождения", "12122012");
        insurancePage.inputField("Фамилия", "Тестовый");
        insurancePage.inputField("Имя", "Тест");
        insurancePage.inputField("Отчество", "Тестович");
        insurancePage.inputField("Дата рождения", "11111994");
        new InsurancePage(driver).gender.click();
        insurancePage.inputField("Серия", "1234");
        insurancePage.inputField("Номер", "123456");
        insurancePage.inputField("Дата выдачи", "10101990");
        insurancePage.inputField("Кем выдан", "Тестовым отделением");
        new InsurancePage(driver).contButton.click();

        insurancePage.checkFieldErrorMessage("Заполнены не все обязательные поля");

    }

}
