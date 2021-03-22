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
        String validName1 = faker.name().fullName();
        if (validName1.contains("ё")) {
            validName1 = validName1.replace("ё", "е");
        }
        if (validName1.contains("Ё")) {
            validName1 = validName1.replace("Ё", "Е");
        }
        return validName1;

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

    public static String generateInvalidName() {
        return "Ivanov Ivan";
    }

    public static String generateValidName2WithSpecialLetter() {
        return "Иванов Иван Фёдорович";
    }

    public static String generateInvalidPhone() {
        return "790000";
    }

    public static String generateInvalidCity() {
        return "Moscow";
    }

    public static ClientDataInfo generateClientDataInfo(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        return new ru.netology.ClientDataInfo(
                generateValidName1WithoutSpecialLetter(),
                faker.phoneNumber().phoneNumber(),
                generateValidCity(),
                generateFirstDate(),
                generateNewDate(),
                generateInvalidName(),
                generateValidName2WithSpecialLetter(),
                generateInvalidPhone(),
                generateInvalidCity()
        );
    }

}
