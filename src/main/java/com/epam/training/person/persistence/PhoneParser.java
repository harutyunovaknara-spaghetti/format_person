package com.epam.training.person.persistence;

import com.epam.training.person.domain.Phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneParser {
    public static Phone parse(String value) throws IllegalArgumentException {
        String area = null;
        String region = null;
        String local = null;

        boolean containsSymbolOrLetter = value.chars().anyMatch(ch-> !Character.isDigit(ch));
        boolean containsOnlyDash = value.chars().anyMatch(ch-> Character.isLetterOrDigit(ch));
        if(value.contains("-")) {
            return null;
        }


        String[] splitByDash = value.split("-");
        boolean isDashFormat = Arrays.stream(splitByDash).allMatch(ch-> ch.chars().allMatch(Character::isDigit));

        if(value.contains("-") && value.length() == 12 && isDashFormat && splitByDash.length==3){
            //format 123-456-7890
            //split 123 456 7890
            area = splitByDash[0];
            region = splitByDash[1];
            local = splitByDash[2];
            return new Phone(area, region,local);


        }else if(!containsSymbolOrLetter && value.length() == 10){
            area = value.substring(0,3);
            region = value.substring(3,6);
            local = value.substring(6, 10);
            return new Phone(area, region,local);

        }
        throw new IllegalArgumentException();
    }
}
