package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//UL[@class='lg-menu__list']")
    WebElement mainMenu;

    @FindBy(xpath = "(//UL[@class='lg-menu__sub-list'])[6]")
    WebElement subMenu;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void selectMainMenu (String menuItem){
        mainMenu.findElement(By.xpath(".//SPAN[@class='lg-menu__text'][text()='"+menuItem+"']")).click();

    }

    public void selectSubMenu (String sMenuItem){
        subMenu.findElement(By.xpath(".//li[@class='lg-menu__sub-item']//a[contains(text(),'"+sMenuItem+"')]")).click();

    }

}
