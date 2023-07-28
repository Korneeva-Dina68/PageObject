package pro.learnup.pageobject.pagesWB;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageWB extends BasePageWB {
    public MainPageWB(WebDriver webDriver) {
        super(webDriver);
    }
    public MainPageWB clickCatalogBurgerMenu() throws InterruptedException {
        webDriver.findElement(By.xpath("//a[@href='https://www.wildberries.ru/catalog/elektronika']")).click();
        Thread.sleep(3000);
        return new MainPageWB(webDriver);
    }
    public ProductGroupPageWB clickSectionCatalogBurgerMenu() throws InterruptedException {
        webDriver.findElement(By.xpath("//div[@class='menu-catalog']//a[text()='Смарт-часы и браслеты']")).click();
        Thread.sleep(3000);
        return new ProductGroupPageWB(webDriver);
    }

    public MainPageWB checkProfileRegistration() {
        assertThat(webDriver.findElement(By.className("sign-in-page__wrap")).getText()).contains("Войти или создать профиль");
        return MainPageWB.this;
    }

}
