package pro.learnup.pageobject.pagesWB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductPageWB extends BasePageWB {
    public ProductPageWB(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductPageWB checkSpecificProduct(String product) {
        assertThat(webDriver.findElement(By.className("product-page__header-wrap")).getText())
                .containsIgnoringCase(product);
        return ProductPageWB.this;
    }
    public ProductPageWB addInCart() {
        webDriver.findElement(By.xpath("//div[@class='product-page__aside-sticky']//span[text()='Добавить в корзину']")).click();
        return new ProductPageWB(webDriver);
    }
    public MainPageWB addToFavoritesProduct() {
        webDriver.findElement(By.xpath("//div[@class='product-page__aside-container j-price-block']//button[@aria-label='Добавить в избранное']")).click();
        return new MainPageWB(webDriver);
    }
}
