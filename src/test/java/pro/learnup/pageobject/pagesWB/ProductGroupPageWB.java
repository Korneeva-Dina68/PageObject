package pro.learnup.pageobject.pagesWB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductGroupPageWB extends BasePageWB {
    public ProductGroupPageWB(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductGroupPageWB checkingResultSearch(String product) {
        assertThat(webDriver.findElement(By.xpath("//h1[@class='searching-results__title']")).getText())
                .containsIgnoringCase(product);
        return ProductGroupPageWB.this;
    }
    public ProductPageWB selectProduct() {
        webDriver.findElement(By.xpath("//div[@class='product-card-list']//article[1]")).click();
        return new ProductPageWB(webDriver);
    }
    public ProductGroupPageWB checkSectionCatalogBurgerMenu() {
        assertThat(webDriver.findElement(By.className("catalog-title-wrap")).getText())
                .containsIgnoringCase("Смарт часы и аксессуары");
        return ProductGroupPageWB.this;
    }
}
