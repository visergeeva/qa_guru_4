package guru.qa;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()

                //Заполнение формы

                .setFirstName("Peter")
                .setLastName("Ivanov")
                .setUserEmail("ivanov_petya@test.com")
                .setUserNumber("7123456770")
                .setGender("Male")
                .setHobby("Sports")
                .setHobby("Music")
                .setCurrentAddress("Marra avenu, 1")
                .setDateOfBirth("20", "April", "1978")
                .setSubjects("Computer Science")
                .setSubjects("Economics")
                .setState("Haryana")
                .setCity("Karnal")
                .setPicture("test.jpg")
                .submit();

                 //Проверки

        registrationPage.checkResult("Student Name", "Peter Ivanov")
                .checkResult("Student Email", "ivanov_petya@test.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7123456770")
                .checkResult("Date of Birth", "20 April,1978")
                .checkResult("Subjects", "Computer Science, Economics")
                .checkResult("Hobbies", "Sports, Music")
                .checkResult("Picture", "test.jpg")
                .checkResult("Address", "Marra avenu, 1")
                .checkResult("State and City", "Haryana Karnal");

    }

    @Test
    void minimalInputDataTest() {
        registrationPage.openPage()

                //Заполнение формы

                .setFirstName("Test")
                .setLastName("Testoviy")
                .setUserNumber("1234567890")
                .setGender("Other")
                .submit();

                //Проверки

        registrationPage.checkResult("Student Name", "Test Testoviy")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
        ;


    }

    @Test
    void negativeCheckTest() {
        registrationPage.openPage()

                //Заполнение формы

                .setFirstName("Test")
                .setLastName("Testoviy")
                .setUserNumber("checking")
                .submit();

                //Проверки

        registrationPage.noResult();


    }
}