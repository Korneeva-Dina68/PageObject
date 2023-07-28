package pro.learnup.pageobject.pagesWB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;


public class AddressesPageWB extends BasePageWB{
    public AddressesPageWB(WebDriver webDriver) {
        super(webDriver);
    }
    public void clickQuestionsAndAnswers() {
        webDriver.findElement(By.xpath("//li[@class='service-menu__item']//a[text()='Вопросы и ответы']")).click();
    }
    public void switchToFrame() {
        webDriver.switchTo().frame("pageInfoIfr");
    }
    public void checkToBeQuestionsAndAnswers() {
        assertThat(webDriver.findElement(By.xpath("//div[@id='questions-answers']/h1")).getText())
                .containsIgnoringCase("Вопросы и ответы");
    }
    public void clickInputYourQuestionAndSendKeys(String request) {
        webDriver.findElement(By.xpath("//div[@class='faq-search-block']//input[@class='faq-search-input']")).sendKeys(request);
    }
    public void clickSelectingSubqueryQuestion() {
        webDriver.findElement(By.xpath("//ul[@class='faq-result-list j-ul-faq-search-results']//span[text()='Оформление заказа']")).click();
    }
    public void checkSelectingSubqueryQuestion(String request) {
        assertThat(webDriver.findElement(By.xpath("//div[@class='faq-contain-item j-faq-contain-item selected']//h1")).getText())
                .containsIgnoringCase(request);
    }
    public void clickSideMenu() {
        webDriver.findElement(By.xpath("//div[@class='faq-menu j-faq-menu']//span[text()='Управление личным кабинетом']")).click();
    }
    public void clickHowToChangeEmail() {
        webDriver.findElement(By.xpath("//div[@class='faq-contain-item j-faq-contain-item selected']//h2[text()='Как изменить e-mail?']")).click();
    }
}
