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

    public static ClientDataInfo generateClientDataInfo(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        return new ru.netology.ClientDataInfo(
                faker.name().fullName(),
                faker.phoneNumber().phoneNumber(),
                generateValidCity(),
                generateFirstDate(),
                generateNewDate()
        );
    }

}
