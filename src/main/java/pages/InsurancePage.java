package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class InsurancePage {

    public WebDriver driver;

    public InsurancePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        Wait<WebDriver> wait2 = new WebDriverWait(driver, 5, 1000);
        WebElement title = driver.findElement(By.xpath("//SPAN[@class='b-heading-tabset-title ng-binding'][text()='Выбор полиса']"));
        wait2.until(ExpectedConditions.visibilityOf(title));

    }

    @FindBy(xpath = "//DIV[@ng-click='setProdProg(prodProg)']")
    public WebElement minSumInsCoverage;

    @FindBy(xpath = "//SPAN[@ng-click='save()'][text()='Оформить']")
    public WebElement goToNextStageButton;

    @FindBy(name = "insured0_surname")
    public WebElement insSurname;

    @FindBy(name = "insured0_name")
    public WebElement insName;

    @FindBy(name = "insured0_birthDate")
    public WebElement insBirthDate;

    @FindBy(name = "surname")
    public WebElement surname;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name = "middlename")
    public WebElement middlename;

    @FindBy(name = "birthDate")
    public WebElement birthDate;

    @FindBy(xpath = "//INPUT[@ng-model='formdata.insurer.GENDER']")
    public WebElement gender;

    @FindBy(xpath = "//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']")
    public WebElement docSeries;

    @FindBy(xpath = "//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']")
    public WebElement docNumbers;

    @FindBy(name = "issueDate")
    public WebElement issueDate;

    @FindBy(name = "issuePlace")
    public WebElement issuePlace;

    @FindBy(xpath = "//SPAN[@ng-click='save()'][text()='Продолжить']")
    public WebElement contButton;

    public void inputFieldInsured(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия /Surname":
                inputFieldInsured(insSurname, value);
                break;
            case "Имя / Given names":
                inputFieldInsured(insName, value);
                break;
            case "Дата рождения":
                inputField(insBirthDate, value);
                break;
        }
    }

    public void inputField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия":
                inputField(surname, value);
                break;
            case "Имя":
                inputField(name, value);
                break;
            case "Отчество":
                inputField(middlename, value);
                break;
            case "Дата рождения":
                inputField(birthDate, value);
                break;
            case "Серия":
                inputField(docSeries, value);
                break;
            case "Номер":
                inputField(docNumbers, value);
                break;
            case "Дата выдачи":
                inputField(issueDate, value);
                break;
            case "Кем выдан":
                inputField(issuePlace, value);
                break;
        }
    }

    public void inputFieldInsured(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void inputField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public String getInputFieldInsured(String fieldName) {
        switch (fieldName) {
            case "Фамилия /Surname":
                return insSurname.getAttribute("value");
            case "Имя / Given names":
                return insName.getAttribute("value");
            case "Дата рождения":
                return insBirthDate.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public String getInputField(String fieldName) {
        switch (fieldName) {
            case "Фамилия":
                return surname.getAttribute("value");
            case "Имя":
                return name.getAttribute("value");
            case "Отчество":
                return middlename.getAttribute("value");
            case "Дата рождения":
                return birthDate.getAttribute("value");
            case "Серия":
                return docSeries.getAttribute("value");
            case "Номер":
                return docNumbers.getAttribute("value");
            case "Дата выдачи":
                return issueDate.getAttribute("value");
            case "Кем выдан":
                return issuePlace.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }
    

    public void checkFieldErrorMessage(String errorMessage){
        String actualValue = driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));

    } 
}