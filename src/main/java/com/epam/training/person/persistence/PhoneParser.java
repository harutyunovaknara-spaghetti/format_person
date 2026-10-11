package com.epam.training.person.persistence;

import com.epam.training.person.domain.Phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneParser {
    public static Phone parse(String value) throws IllegalArgumentException {
        String area = "";
        String region = "";
        String local = "";

        boolean areDigits = false;

        if (value.length() == 12) {
            String[] parts = value.split("-");
            List<Integer> date = new ArrayList<>();
            if (parts.length == 3) {
                areDigits = Arrays.stream(parts).allMatch(str -> str.chars().allMatch(Character::isDigit));
                if (areDigits) {
                    date = Arrays.stream(parts).map(str -> Integer.parseInt(str)).toList();
                    area = date.get(0).toString();
                    region = date.get(1).toString();
                    local = date.get(2).toString();
                }
            }
        }

        if (value.length() == 10) {
            areDigits = value.chars().allMatch(Character::isDigit);
            if (areDigits) {
                area = value.substring(0, 2);
                region = value.substring(2, 5);
                local = value.substring(6, 10);
            }
        }

        if (!areDigits)
            throw new IllegalArgumentException();


        return new Phone(area, region, local);
    }
}
