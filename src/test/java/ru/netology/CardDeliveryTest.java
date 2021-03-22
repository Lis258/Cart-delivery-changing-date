package ru.netology;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {

    @BeforeEach
    void shouldSetUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldSendFormAndChangeDateValidData() {
        val clientDataInfo = DataGenerator.generateClientDataInfo("ru");
        $("[data-test-id=city] input").setValue(clientDataInfo.getValidCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(clientDataInfo.getFirstDate());
        $("[name='name']").setValue(clientDataInfo.getValidName());
        $("[name='phone']").setValue(clientDataInfo.getValidPhone());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(clientDataInfo.getNewDate());
        $("[class='button__text']").click();
        $(byText("Перепланировать")).click();
        $(".notification__title").shouldHave(text("Успешно!"));
        $(".notification__content").shouldHave(text("Встреча успешно запланирована на "+clientDataInfo.getNewDate()));
    }
}
