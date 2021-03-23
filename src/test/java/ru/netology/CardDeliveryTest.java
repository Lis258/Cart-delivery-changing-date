package ru.netology;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {

    @BeforeEach
    void shouldSetUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldSendFormValidDataName1WithoutSpecialLetter() {
        val clientDataInfo = DataGenerator.generateClient1ValidData("ru");
        $("[data-test-id=city] input").setValue(clientDataInfo.getCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(clientDataInfo.getFirstDate());
        $("[name='name']").setValue(clientDataInfo.getName());
        $("[name='phone']").setValue(clientDataInfo.getPhone());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(clientDataInfo.getNewDate());
        $("[class='button__text']").click();
        $(byText("Перепланировать")).click();
        $(".notification__title").shouldHave(exactText("Успешно!"));
        $(".notification__content").shouldHave(exactText("Встреча успешно запланирована на " + clientDataInfo.getNewDate()));
    }

    @Test
    void shouldSendFormValidDataName2WithSpecialLetter() {
        val clientDataInfo = DataGenerator.generateClient2ValidData("ru");
        $("[data-test-id=city] input").setValue(clientDataInfo.getCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(clientDataInfo.getFirstDate());
        $("[name='name']").setValue(clientDataInfo.getName());
        $("[name='phone']").setValue(clientDataInfo.getPhone());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(clientDataInfo.getNewDate());
        $("[class='button__text']").click();
        $(byText("Перепланировать")).click();
        $(".notification__title").shouldHave(exactText("Успешно!"));
        $(".notification__content").shouldHave(exactText("Встреча успешно запланирована на " + clientDataInfo.getNewDate()));
    }

    @Test
    void shouldNotSendFormInvalidName() {
        val clientDataInfo = DataGenerator.generateClient3InvalidName("ru");
        $("[data-test-id=city] input").setValue(clientDataInfo.getCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(clientDataInfo.getFirstDate());
        $("[name='name']").setValue(clientDataInfo.getName());
        $("[name='phone']").setValue(clientDataInfo.getPhone());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $(".input_invalid[data-test-id=name] .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldNotSendFormInvalidPhone() {
        val clientDataInfo = DataGenerator.generateClient4InvalidPhone("ru");
        $("[data-test-id=city] input").setValue(clientDataInfo.getCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(clientDataInfo.getFirstDate());
        $("[name='name']").setValue(clientDataInfo.getName());
        $("[name='phone']").setValue(clientDataInfo.getPhone());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $(".input_invalid[data-test-id=phone] .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldNotSendFormInvalidCity() {
        val clientDataInfo = DataGenerator.generateClient5InvalidCity("ru");
        $("[data-test-id=city] input").setValue(clientDataInfo.getCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(clientDataInfo.getFirstDate());
        $("[name='name']").setValue(clientDataInfo.getName());
        $("[name='phone']").setValue(clientDataInfo.getPhone());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $(".input_invalid[data-test-id=city] .input__sub").shouldHave(exactText("Доставка в выбранный город недоступна"));
    }

    @Test
    void shouldNotSendFormNoName() {
        val clientDataInfo = DataGenerator.generateClient1ValidData("ru");
        $("[data-test-id=city] input").setValue(clientDataInfo.getCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(clientDataInfo.getFirstDate());
        $("[name='phone']").setValue(clientDataInfo.getPhone());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $(".input_invalid[data-test-id=name] .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldNotSendFormNoPhone() {
        val clientDataInfo = DataGenerator.generateClient1ValidData("ru");
        $("[data-test-id=city] input").setValue(clientDataInfo.getCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(clientDataInfo.getFirstDate());
        $("[name='name']").setValue(clientDataInfo.getName());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $(".input_invalid[data-test-id=phone] .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldNotSendFormNoCity() {
        val clientDataInfo = DataGenerator.generateClient1ValidData("ru");
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(clientDataInfo.getFirstDate());
        $("[name='name']").setValue(clientDataInfo.getName());
        $("[name='phone']").setValue(clientDataInfo.getPhone());
        $("[data-test-id=agreement]").click();
        $("[class='button__text']").click();
        $(".input_invalid[data-test-id=city] .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldNotSendFormNoAgreement() {
        val clientDataInfo = DataGenerator.generateClient1ValidData("ru");
        $("[data-test-id=city] input").setValue(clientDataInfo.getCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(clientDataInfo.getFirstDate());
        $("[name='name']").setValue(clientDataInfo.getName());
        $("[name='phone']").setValue(clientDataInfo.getPhone());
        $("[class='button__text']").click();
        $(".input_invalid[data-test-id=agreement] .checkbox__text").shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных"));
    }

}
