package com.dmitrishin.data;

import com.github.javafaker.Faker;

import java.util.Random;

public class GenerateData {
    Faker faker = new Faker();

    public String firstname = faker.name().firstName();
    public String lastname = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    String[] genders = {"Male", "Female", "Other"};
    String[] subjects = {"English", "Maths", "Hindi"};
    String[] hobbies = {"Sports", "Reading", "Music"};

    public String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return String.valueOf(array[rnd]);
    }

    public String getRandomGender() {
        return getRandom(genders);
    }

    public String getRandomSubject() {
        return getRandom(subjects);
    }

    public String getRandomHobbies() {
        return getRandom(hobbies);
    }

    public String getFirstName(){
        return faker.name().firstName();
    }

}
