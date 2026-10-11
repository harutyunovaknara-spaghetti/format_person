package com.epam.training.person.persistence;

import com.epam.training.person.domain.Gender;
import com.epam.training.person.domain.Location;
import com.epam.training.person.domain.Person;
import com.epam.training.person.domain.Phone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;

public class CSVPersonReader implements DataReader<List<Person>> {
    private Scanner scanner;
    private final InputStream in;

    public CSVPersonReader(InputStream in) {
        this.in = in;
    }

    @Override
    public List<Person> read() {
        List<Person> personList = new ArrayList<>();
        BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(in));

        try {
            String line = bufferedInputStream.readLine();
            while (line != null) {
                List<String> csvData = List.of(line.split(","));
                line = bufferedInputStream.readLine();


                UUID id = UUID.fromString(csvData.get(0));
                String name = csvData.get(1);
                LocalDate dateOfBirth = readLocalDate(csvData.get(2));
                Location placeOfBirth = new Location(csvData.get(3), csvData.get(4), csvData.get(5), csvData.get(6));
                Gender gender = readGender(csvData.get(7));

                List<Phone> phones = readPhones(csvData.get(8) , csvData.get(9) ,csvData.get(10));


                Person person = new Person(
                        id,
                        name,
                        dateOfBirth,
                        placeOfBirth,
                        gender,
                        phones
                );
                personList.add(person);

            }
        } catch (IOException e) {
        }
        return personList;

    }

    @Override
    public void close() {

    }

    private Gender readGender(String value) {
        return switch (value) {
            case "Male" -> Gender.MALE;
            case "Female" -> Gender.FEMALE;
            default -> null;
        };
    }

    private LocalDate readLocalDate(String value) {


        List<Integer> stringIntoInteger = Arrays.stream(value.split("-"))
                .map(Integer::parseInt).toList();

        return LocalDate.of(stringIntoInteger.get(0), stringIntoInteger.get(1), stringIntoInteger.get(2));
    }

    private List<Phone> readPhones(String value1, String value2, String value3) {
        List<String> split = List.of(value1, value2, value3);

        return split.stream().map(PhoneParser::parse).toList();
    }


}
