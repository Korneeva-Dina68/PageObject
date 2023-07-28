package pro.learnup.pageobject.pages.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pro.learnup.pageobject.pages.AccountPage;
import pro.learnup.pageobject.pages.BaseView;
import pro.learnup.pageobject.pages.CartPage;
import pro.learnup.pageobject.pages.PhonesPage;

public class HeaderBlock extends BaseView {
    public HeaderBlock(WebDriver webDriver) {
        super(webDriver);
    }
    public PhonesPage login(String login, String password) {
        webDriver.findElement(By.xpath("//button[.='LOGIN']")).click();
        webDriver.findElement(By.xpath("//input[contains(@id, 'Username')]")).sendKeys(login);
        webDriver.findElement(By.xpath("//input[contains(@id, 'Password')]")).sendKeys(password);
        webDriver.findElement(By.xpath("//button[.='Submit']")).click();
        new WebDriverWait(webDriver, 1).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='LOGOUT']")));
        return new PhonesPage(webDriver);
    }
    public AccountPage clickAccount() {
        webDriver.findElement(By.xpath("//span[text()='ACCOUNT']")).click();
        return new AccountPage(webDriver);
    }
    public CartPage goToCart() {
        webDriver.findElement(By.xpath(".//a[.='CART']")).click();
        return new CartPage(webDriver);
    }

}
