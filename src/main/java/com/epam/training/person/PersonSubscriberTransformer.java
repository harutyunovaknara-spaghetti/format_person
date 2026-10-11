package com.epam.training.person;

import com.epam.training.person.domain.Person;
import com.epam.training.person.domain.Subscriber;

import java.util.List;
import java.util.function.Predicate;

public class PersonSubscriberTransformer implements Transformer<List<Person>, List<Subscriber>> {
    private final Predicate<Person> predicate;

    public PersonSubscriberTransformer(Predicate<Person> predicate) {
        this.predicate = predicate;

    }


    @Override
    public List<Subscriber> transform(List<Person> value) {
        return value.stream()
                .filter(predicate)
                .flatMap(person -> person.phones().stream().map(phone -> new Subscriber(phone.toString(), person.name()))
                ).toList();

    }


}
