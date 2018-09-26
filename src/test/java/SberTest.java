import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class SberTest extends BaseTest {

 
    @Test
    @Ignore
    public void testSber(){
        driver.get(baseUrl);
        driver.findElement(By.xpath("//SPAN[@class='lg-menu__text'][text()='Страхование']")).click();
        driver.findElement(By.xpath("//A[@href='/ru/person/bank_inshure/insuranceprogram/travel_and_shopping'][text()='Путешествия и покупки'][text()='Путешествия и покупки']")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        WebElement titleIns = driver.findElement(By.xpath("//H3[text()='Страхование путешественников']"));
        wait.until(ExpectedConditions.visibilityOf(titleIns));
        assertEquals("Страхование путешественников", titleIns.getText());

        driver.findElement(By.xpath("//P[@class='kit-button kit-button_color_green kit-button_size_m']")).click();

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        Wait<WebDriver> wait2 = new WebDriverWait(driver, 5, 1000);
        WebElement titleSum = driver.findElement(By.xpath("//H3[@class='b-form-section-title'][text()='Выберите сумму страховой защиты']"));
        wait2.until(ExpectedConditions.visibilityOf(titleSum));

        assertEquals("Выберите сумму страховой защиты", titleSum.getText());
        driver.findElement(By.xpath("//DIV[@ng-click='setProdProg(prodProg)']")).click();
        driver.findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Оформить']")).click();
        inputField(By.name("insured0_surname"), "Testing");
        inputField(By.name("insured0_name"), "Test");
        inputField(By.name("insured0_birthDate"), "12122012");
        inputField(By.name("surname"), "Тестовый");
        inputField(By.name("name"), "Тест");
        inputField(By.name("middlename"), "Тестович");
        inputField(By.name("birthDate"), "11111994");
        driver.findElement(By.xpath("//INPUT[@ng-model='formdata.insurer.GENDER']")).click();
        inputField(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']"), "1234");
        inputField(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']"), "123456");
        inputField(By.name("issueDate"), "10101990");
        inputField(By.name("issuePlace"), "Тестовым отделением");

        assertEquals("Testing",
                driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("Test",
                driver.findElement(By.name("insured0_name")).getAttribute("value"));
        assertEquals("12.12.2012",
                driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        assertEquals("Тестовый",
                driver.findElement(By.name("surname")).getAttribute("value"));
        assertEquals("Тест",
                driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals("Тестович",
                driver.findElement(By.name("middlename")).getAttribute("value"));
        assertEquals("11.11.1994",
                driver.findElement(By.name("birthDate")).getAttribute("value"));
        assertEquals("1234",
                driver.findElement(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']")).getAttribute("value"));
        assertEquals("123456",
                driver.findElement(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']")).getAttribute("value"));
        assertEquals("10.10.1990",
                driver.findElement(By.name("issueDate")).getAttribute("value"));
        assertEquals("Тестовым отделением",
                driver.findElement(By.name("issuePlace")).getAttribute("value"));

        driver.findElement(By.xpath("//SPAN[@ng-click='save()'][text()='Продолжить']")).click();

        String expected = "Заполнены не все обязательные поля";
        String actual = driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")).getText();
        assertTrue("Некорректное сообщение", expected.equals(actual));

        assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")).getText());
    }

}
