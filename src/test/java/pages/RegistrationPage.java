package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            hobbyWrapper = $("#hobbiesWrapper"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            pictureInput = $("#uploadPicture"),
            submitButton = $("#submit"),
            resultTable = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();

    CheckResultComponent checkResultComponent = new CheckResultComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    ;

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    ;

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    ;

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    ;

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    ;

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    ;

    public RegistrationPage setHobby(String value) {
        hobbyWrapper.$(byText(value)).click();

        return this;
    }

    ;

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    ;

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    ;

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();

        return this;
    }

    ;

    public RegistrationPage setCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();

        return this;
    }

    ;


    public RegistrationPage setPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    ;

    public void submit() {
        submitButton.click();
    }


    public RegistrationPage checkResult(String key, String value) {
        checkResultComponent.checkResult(key, value);

        return this;
    }

    public void noResult() {
        resultTable.shouldNotBe(visible);
    }

    ;

}


