package com.dmitrishin.tests;

import com.codeborne.selenide.Configuration;
import com.dmitrishin.data.GenerateData;
import com.dmitrishin.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    GenerateData generate = new GenerateData();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillPracticeFormTest() {

        //Input parameters
        String firstName = generate.getFirstName();
        String lastName = "Dmitrishin";
        String email = "test@example.com";
        String gender = "Male";
        String phone = "9199960164";
        String subject = "Physics";
        String hobbies = "Sports";
        String imagePath = "img/Avatar.jpg";
        String address = "Komsa street 11, 15 apt.";
        String state = "Haryana";
        String city = "Karnal";

        //registrationFormPage.openPage().setFirstName("LALA");
        registrationFormPage.openPage();
        $("#firstName").setValue("fasa");
        $("#uploadPicture").uploadFromClasspath(imagePath);
        $("#currentAddress").setValue(address);
        $("#state").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        //Form validation
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Label Value"),
                text("Student Name " + firstName + " " + lastName),
                text("Student Email " + email),
                text("Gender " + gender),
                text("Mobile " + phone),
                text("Date of Birth 16 June,1992"),
                text("Subjects " + subject),
                text("Hobbies " + hobbies),
                text("Picture Avatar.jpg"),
                text("Address " + address),
                text("State and City " + state + " " + city));

        //($(".table-responsive").$(byText(key))).parent().shouldHave(text(value));

        $("#closeLargeModal").click();
    }
}
