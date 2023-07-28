package pro.learnup.pageobject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pro.learnup.pageobject.pagesWB.AddressesPageWB;
import pro.learnup.pageobject.pagesWB.MainPageWB;
import pro.learnup.pageobject.pagesWB.blocksWB.HeaderBlockWB;
import pro.learnup.selenium.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class WildberriesTest extends BaseTest {
    String product = "самокат";
    String product2 = "швабра";
    String product3 = "смарт часы";
    String request = "оформление заказа";
    String request2 = "Управление личным кабинетом";


    @Test
    void searchBarTest() throws InterruptedException { // Ищем "самокат детский" через поисковую строку и добавляем в корзину
        webDriver.get("https://www.wildberries.ru/");
        Thread.sleep(3000);

        new MainPageWB(webDriver)
                .getHeaderBlockWB()
                .clickAndInputSearchBar(product)
                .checkingResultSearch(product)
                .selectProduct()
                .checkSpecificProduct(product)
                .addInCart()
                .getHeaderBlockWB()
                .goToBasket()
                .checkingLocationBasket()
                .checkProductInBasket(product);
    }

    @Test
    void burgerMenuTest() throws InterruptedException { //Ищем смарт часы через меню "бургер" и добавляем в корзину
        webDriver.get("https://www.wildberries.ru/");
        Thread.sleep(3000);

        new MainPageWB(webDriver)
                .getHeaderBlockWB()
                .clickBurgerMenu()
                .clickCatalogBurgerMenu()
                .clickSectionCatalogBurgerMenu()
                .checkSectionCatalogBurgerMenu()
                .selectProduct()
                .checkSpecificProduct(product3)
                .addInCart()
                .getHeaderBlockWB()
                .goToBasket()
                .checkingLocationBasket()
                .checkProductInBasket(product3);
    }

    @Test
    void addFavouritesTest() throws InterruptedException { // Ищем товар через поисковую строку и добавляем в "избранное"
        webDriver.get("https://www.wildberries.ru/");
        Thread.sleep(3000);

        new MainPageWB(webDriver)
                .getHeaderBlockWB()
                .clickAndInputSearchBar(product2)
                .checkingResultSearch(product2)
                .selectProduct()
                .checkSpecificProduct(product2)
                .addToFavoritesProduct()
                .checkProfileRegistration();
    }

    @Test
    void cleaningBasketTest() throws InterruptedException { //Добавляем товар в корзину и удаляем его оттуда
        webDriver.get("https://www.wildberries.ru/");
        Thread.sleep(3000);

        new MainPageWB(webDriver)
                .getHeaderBlockWB()
                .clickAndInputSearchBar(product)
                .checkingResultSearch(product)
                .selectProduct()
                .checkSpecificProduct(product)
                .addInCart()
                .getHeaderBlockWB()
                .goToBasket()
                .checkingLocationBasket()
                .checkProductInBasket(product)
                .deleteProductBasket()
                .checkBasketIsEmpty();
    }
    @Test
    void questionsAndAnswersMakingAnOrder() throws InterruptedException {  //Создаем запрос через поисковую строку "оформление заказа" в "Вопросы и ответы"
        webDriver.get("https://www.wildberries.ru/");
        Thread.sleep(3000);

        new HeaderBlockWB(webDriver).clickButtonAddresses();
        new AddressesPageWB(webDriver).clickQuestionsAndAnswers();
        new AddressesPageWB(webDriver).switchToFrame();
        new AddressesPageWB(webDriver).checkToBeQuestionsAndAnswers();
        new AddressesPageWB(webDriver).clickInputYourQuestionAndSendKeys(request);
        new AddressesPageWB(webDriver).clickSelectingSubqueryQuestion();
        new AddressesPageWB(webDriver).checkSelectingSubqueryQuestion(request);

    }

    @Test
    void questionsAndAnswersСhangeEmail() throws InterruptedException { //Создаем запрос через боковое меню в "Вопросы и ответы"
        webDriver.get("https://www.wildberries.ru/");
        Thread.sleep(3000);

        new HeaderBlockWB(webDriver).clickButtonAddresses();
        new AddressesPageWB(webDriver).clickQuestionsAndAnswers();
        new AddressesPageWB(webDriver).switchToFrame();
        new AddressesPageWB(webDriver).checkToBeQuestionsAndAnswers();
        new AddressesPageWB(webDriver).clickSideMenu();
        new AddressesPageWB(webDriver).checkSelectingSubqueryQuestion(request2);
        new AddressesPageWB(webDriver).clickHowToChangeEmail();
    }
}
