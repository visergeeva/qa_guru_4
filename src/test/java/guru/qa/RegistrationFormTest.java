package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //Заполнение формы

        $("#firstName").setValue("Peter");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov_petya@test.com");
        $("#genterWrapper").find(byText("Male")).click();
        $("#userNumber").setValue("7123456770");
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1980");
        $(".react-datepicker__day--015").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $("#hobbiesWrapper").find(byText("Sports")).click();
        $("#hobbiesWrapper").find(byText("Music")).click();
        $("#state").click();
        $("#stateCity-wrapper").find(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").find(byText("Karnal")).click();
        $("#currentAddress").setValue("Marra avenu, 1");
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#submit").click();

        //Проверки

        $(".modal-content").shouldHave(text("Peter Ivanov"));
        $(".modal-content").shouldHave(text("ivanov_petya@test.com"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("7123456770"));
        $(".modal-content").shouldHave(text("15 February,1980"));
        $(".modal-content").shouldHave(text("Computer Science, Economics"));
        $(".modal-content").shouldHave(text("Sports, Music"));
        $(".modal-content").shouldHave(text("test.jpg"));
        $(".modal-content").shouldHave(text("Marra avenu, 1"));
        $(".modal-content").shouldHave(text("Haryana Karnal"));

    }
}