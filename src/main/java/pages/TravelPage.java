package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelPage {

    @FindBy(xpath = "//P[@class='kit-button kit-button_color_green kit-button_size_m']")
    public WebElement goToInsuranceButton;

    public TravelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        WebElement titleIns = driver.findElement(By.xpath("//H3[text()='Страхование путешественников']"));
        wait.until(ExpectedConditions.visibilityOf(titleIns));
    }

}
