package pro.learnup.pageobject.pagesWB.blocksWB;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pro.learnup.pageobject.pagesWB.*;

public class HeaderBlockWB extends BaseViewWB {
    public HeaderBlockWB(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductGroupPageWB clickAndInputSearchBar(String product) {
        webDriver.findElement(By.xpath("//input[@class='search-catalog__input j-wba-header-item']")).sendKeys(product, Keys.ENTER);
        return new ProductGroupPageWB(webDriver);
    }
    public MainPageWB clickBurgerMenu() throws InterruptedException {
        webDriver.findElement(By.xpath("//button[@aria-label='Навигация по сайту']")).click();
        Thread.sleep(3000);
        return new MainPageWB(webDriver);
    }
    public BasketPageWB goToBasket() {
        webDriver.findElement(By.xpath("//a[@data-wba-header-name='Cart']")).click();
        return new BasketPageWB(webDriver);
    }
    public void clickButtonAddresses() {
        webDriver.findElement(By.xpath("//div[@class='navbar-pc__item j-item-addresses']")).click();
    }
}
