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

        boolean containsOnlySymbols = value.chars().mapToObj(ch->(char) ch).toList().stream().anyMatch(c-> !Character.isDigit(c));
        if(value.length() < 10 || value.length() > 12)
            throw new IllegalArgumentException();
        if(containsOnlySymbols)
            throw new IllegalArgumentException();

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
                area = value.substring(0, 3);
                region = value.substring(3, 6);
                local = value.substring(6, 10);
            }
        }

        return new Phone(area, region, local);
    }
}
