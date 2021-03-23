package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    private DataGenerator() {
    }

    private static Random random = new Random();

    public static String generateValidName1WithoutSpecialLetter() {
        Faker faker = new Faker(new Locale("ru"));
        String name = faker.name().fullName();
        if (name.contains("ё")) {
            name = name.replace("ё", "е");
        }
        if (name.contains("Ё")) {
            name = name.replace("Ё", "Е");
        }
        return name;
    }

    public static String generateValidCity() {
        String[] cityArray = {"Москва", "Уфа", "Казань", "Якутск", "Пермь"};
        return cityArray[random.nextInt(cityArray.length)];
    }

    public static String generateFirstDate() {
        return LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateNewDate() {
        return LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static ClientDataInfo generateClient1ValidData(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        return new ru.netology.ClientDataInfo(
                generateValidName1WithoutSpecialLetter(),
                faker.phoneNumber().phoneNumber(),
                generateValidCity(),
                generateFirstDate(),
                generateNewDate()
        );
    }

    public static ClientDataInfo generateClient2ValidData(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        return new ru.netology.ClientDataInfo(
                "Иванов Иван Фёдорович",
                faker.phoneNumber().phoneNumber(),
                generateValidCity(),
                generateFirstDate(),
                generateNewDate()
        );
    }

    public static ClientDataInfo generateClient3InvalidName(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        return new ru.netology.ClientDataInfo(
                "Ivanov Ivan",
                faker.phoneNumber().phoneNumber(),
                generateValidCity(),
                generateFirstDate(),
                generateNewDate()
        );
    }

    public static ClientDataInfo generateClient4InvalidPhone(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        return new ru.netology.ClientDataInfo(
                generateValidName1WithoutSpecialLetter(),
                "790000",
                generateValidCity(),
                generateFirstDate(),
                generateNewDate()
        );
    }

    public static ClientDataInfo generateClient5InvalidCity(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        return new ru.netology.ClientDataInfo(
                generateValidName1WithoutSpecialLetter(),
                faker.phoneNumber().phoneNumber(),
                "Moscow",
                generateFirstDate(),
                generateNewDate()
        );
    }

}
