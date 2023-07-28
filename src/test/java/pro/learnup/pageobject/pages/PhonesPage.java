package pro.learnup.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PhonesPage extends BasePage {
    public PhonesPage(WebDriver webDriver) {
        super(webDriver);
    }
    public PhonePage selectPhone(String phoneName) {
        List<WebElement> phones = webDriver.findElements(By.className("product"));
        phones.stream()
                .filter(el -> el.getText().contains(phoneName))
                .findFirst()
                .orElseThrow()
                .findElement(By.xpath(".//a[.='See more']"))
                .click();
        return new PhonePage(webDriver);
    }

    public PhonesPage clickSearchByPrice() {
        webDriver.findElement(By.xpath(" //*[contains(text(),'Price')]")).click();
        return new PhonesPage(webDriver);
    }
    public PhonesPage clickSearchByPriceMore750(){
        webDriver.findElement(By.xpath(" //input[contains(@value,'750>')]")).click();
        return new PhonesPage(webDriver);
    }
    public void clickSearchByBrand() {
        webDriver.findElement(By.xpath("//div[contains(text(),'Brand')]")).click();
    }
    public void clickSearchByBrandHuawei() {
        webDriver.findElement(By.xpath("//input[@value='huawei']")).click();
    }
    public void clickSearchByInternalMemory() {
        webDriver.findElement(By.xpath("//div[contains(text(),'Internal memory')]")).click();
    }
    public void clickSearchByInternalMemory256GB() {
        webDriver.findElement(By.xpath("//input[@value='256']")).click();
    }
    public PhonesPage clickSearchByCPU() {
        webDriver.findElement(By.xpath("//div[contains(text(),'CPU')]")).click();
        return new PhonesPage(webDriver);
    }
    public PhonesPage clickSearchByCPUHexaCore() {
        webDriver.findElement(By.xpath("//input[@value='hexa_core']")).click();
        return new PhonesPage(webDriver);
    }
    public PhonesPage checkFilterPhone(String filter) {
        List<WebElement> brandPhones = webDriver.findElements(By.xpath("//div[@class='content-left']"));
        brandPhones.forEach(p-> {
            if (p.getText().contains(filter)) System.out.println("Телефон соответствует заявленным требованиям");
            else System.out.println("Ошибка!!! Телефон с другими параметрами.");
        });
        return PhonesPage.this;
    }
    public PhonesPage clickButtonClearFilter() {
        webDriver.findElement(By.xpath("//span[text()='Clear Filters']")).click();
        return new PhonesPage(webDriver);
    }
}
