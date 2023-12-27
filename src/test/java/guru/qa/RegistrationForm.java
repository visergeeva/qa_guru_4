package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        $("[id=firstName]").setValue("Peter");
        $("[id=lastName]").setValue("Ivanov");
        $("[id=userEmail]").setValue("ivanov_petya@test.com");
        $("[for=gender-radio-1]").click();
        $("[id=userNumber]").setValue("+712345677");
        $("[class=react-datepicker-wrapper]").click();
        $("[class=react-datepicker__month-select]").selectOption("February");
        $("[class=react-datepicker__year-select]").selectOption("1980");
        $(byText("24")).click();
//        $("[aria-label=Choose Tuesday, March 18th, 1980]").click();









//        $("[id=currentAddress]").setValue("Marra avenu, 1");

//        $("[id=dateOfBirthInput]").setValue("12 Oct 1980");
//        $("[class=subjects-auto-complete__value-container]").click();


//        $("[id=firstName]").shouldHave(text("Peter"));

//        $("[id=lastName]").shouldHave(text("Ivanov"));
//        $("[id=userEmail]").shouldHave(text("ivanov_petya@boxx.com"));
//        $("[for=gender-radio-1]").shouldHave(text("Another street 1"));






    }
}