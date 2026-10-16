package com.epam.training.person.persistence;

import com.epam.training.person.domain.Phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PhoneParser {
    public static Phone parse(String value) throws IllegalArgumentException {
        String area = null;
        String region = null;
        String local = null;

        // 1234567890 , 123-456-7890 -> valid
        // 1234567, 123-3456-654, 123-456-76555 -> not valid
        // -, -----, 12fdg4 -> not valid

        boolean digitFormat = value.chars().allMatch(ch-> Character.isDigit(ch)) && value.length() == 10;

        if(digitFormat){
            area = value.substring(0,3);
            region = value.substring(3,6);
            local = value.substring(6,10);

            return new Phone(area,region,local);
        }

        boolean dashFormat =  value.length() == 12 && Arrays.stream(value.split("-")).allMatch(str-> str.chars().allMatch(ch-> Character.isDigit(ch))) && value.split("-").length == 3 && value.split("-")[0].length() ==3 && value.split("-")[1].length() == 3 && value.split("-")[2].length()==4;

        if(dashFormat){
            String[] phoneParts = value.split("-");
            area = phoneParts[0];
            region = phoneParts[1];
            local = phoneParts[2];

            return new Phone(area, region, local);
        }

        if(value.equals("-"))
            return null;

        throw new IllegalArgumentException();
    }
}
