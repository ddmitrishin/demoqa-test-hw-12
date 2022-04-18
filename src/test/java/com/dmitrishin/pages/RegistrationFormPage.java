package com.dmitrishin.pages;

import com.codeborne.selenide.SelenideElement;
import com.dmitrishin.data.GenerateData;
import com.dmitrishin.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    CalendarComponent calendar = new CalendarComponent();
    GenerateData generateData = new GenerateData();

    //locators
    public String headerText = "Student Registration Form";
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement genderInput = $("#genterWrapper");
    SelenideElement userPhoneNumberInput = $("#userNumber");
    SelenideElement subjectInput = $("#subjectsInput");
    SelenideElement hobbiesCheckBox = $("#hobbiesWrapper");
    //actions

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(headerText));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationFormPage setGender(String gender) {
        genderInput.setValue(gender);
        return this;
    }

    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        userPhoneNumberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationFormPage setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(){
        subjectInput.$(byText(generateData.getRandomSubject())).pressEnter();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}
