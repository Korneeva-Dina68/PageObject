package pro.learnup.pageobject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pro.learnup.pageobject.pages.PhonesPage;
import pro.learnup.pageobject.pages.blocks.HeaderBlock;
import pro.learnup.selenium.BaseTest;


public class ShopTest extends BaseTest {
    String login = "admin10";
    String password = "admin";
    String phoneName = "HTC U11";
    String phoneName2 = "Apple iPhone 8 Plus";
    String phoneName3 = "Apple iPhone X";
    String newAddress = "NewAddress";
    String newEmail = "NewEmail";
    String phoneNumber = "9999999999";
    String brand = "Huawei";
    String internalMemory = "256 GB";
    String cpu = "Hexa-core";

    @ParameterizedTest
    @ValueSource(strings={"HTC U11"})
    public void buyPhoneTest(String phoneName) throws InterruptedException {
        webDriver.get("http://localhost:3000/");

        new PhonesPage(webDriver)
                .getHeaderBlock()
                .login(login, password)
                .selectPhone(phoneName)
                .checkPhoneName(phoneName)
                .clickAddToCart()
                .getHeaderBlock()
                .goToCart()
                .checkCartContainExactly(phoneName)
                .clickCheckOut()
                .clickConfirm()
                .checkThatCheckOutSuccessful();
    }

    @Test
    public void filterCPU() throws InterruptedException { //сортировка телефонов по цене и очистка после сортировки
        webDriver.get("http://localhost:3000/");

        new PhonesPage(webDriver)
                .getHeaderBlock()
                .login(login, password)
                .clickSearchByCPU()
                .clickSearchByCPUHexaCore()
                .checkFilterPhone(cpu)
                .clickButtonClearFilter();
    }

    @Test
    public void personalData() throws InterruptedException {  //изменение личных данных в личном кабинете
        webDriver.get("http://localhost:3000/");

        new PhonesPage(webDriver)
                .getHeaderBlock()
                .login(login, password)
                .getHeaderBlock()
                .clickAccount()
                .clickEditAccount()
                .checkEditAccount()
                .clickAndClearAndSendKeysEmailAccount(newEmail)
                .clickAndClearAndSendKeysAddressAccount(newAddress)
                .clickAndClearAndSendKeysPhoneAccount(phoneNumber)
                .clickSaveAccount();
    }
    @Test
    public void deletePhoneTest() throws InterruptedException {   // добавляем телефоны в корзину и удаляем их разными способами
        webDriver.get("http://localhost:3000/");

        new PhonesPage(webDriver)
                .getHeaderBlock()
                .login(login, password)
                .selectPhone(phoneName)
                .checkPhoneName(phoneName)
                .clickAddToCart()
                .backToCatalog()
                .selectPhone(phoneName2)
                .checkPhoneName(phoneName2)
                .clickAddToCart()
                .backToCatalog()
                .selectPhone(phoneName3)
                .checkPhoneName(phoneName3)
                .clickAddToCart()
                .getHeaderBlock()
                .goToCart()
                .checkCartContainExactly(phoneName, phoneName2, phoneName3)
                .deletePhone(phoneName)
                .deleteAllPhoneCancel()
                .deleteAllPhoneYes()
                .checkNoItemsCart();
    }

    @Test
    public void filterBrandTest() {
        webDriver.get("http://localhost:3000/");
        new HeaderBlock(webDriver).login(login, password);
        new PhonesPage(webDriver).clickSearchByBrand();
        new PhonesPage(webDriver).clickSearchByBrandHuawei();
        new PhonesPage(webDriver).checkFilterPhone(brand);
        new PhonesPage(webDriver).clickButtonClearFilter();
    }
    @Test
    public void filterInternalMemoryTest() {
        webDriver.get("http://localhost:3000/");
        new HeaderBlock(webDriver).login(login, password);
        new PhonesPage(webDriver).clickSearchByInternalMemory();
        new PhonesPage(webDriver).clickSearchByInternalMemory256GB();
        new PhonesPage(webDriver).checkFilterPhone(internalMemory);
        new PhonesPage(webDriver).clickButtonClearFilter();
    }
}