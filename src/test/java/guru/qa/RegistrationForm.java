package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Peter");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov_petya@test.com");
        $("label[for=gender-radio-1]").click();
        $("#userNumber").setValue("7123456770");
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1980");
        $(".react-datepicker__day--015").click();
        $("label[for=hobbies-checkbox-1]").click();
        $("label[for=hobbies-checkbox-3]").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $("#state").click(); $("#stateCity-wrapper").find(byText("Haryana")).click();
        $("#city").click(); $("#stateCity-wrapper").find(byText("Karnal")).click();

//        $("#uploadPicture").uploadFile(new File("src/test/java/resources/test.jpg"));
        $("#uploadPicture").uploadFromClasspath("test.jpg");
//        Selenide.executeJavaScript("document.body.style.zoom='80%'");
        $("#submit").click();












//        $("[id=currentAddress]").setValue("Marra avenu, 1");

//        $("[id=dateOfBirthInput]").setValue("12 Oct 1980");
//        $("[class=subjects-auto-complete__value-container]").click();


//        $("[id=firstName]").shouldHave(text("Peter"));

//        $("[id=lastName]").shouldHave(text("Ivanov"));
//        $("[id=userEmail]").shouldHave(text("ivanov_petya@boxx.com"));
//        $("[for=gender-radio-1]").shouldHave(text("Another street 1"));






    }
}