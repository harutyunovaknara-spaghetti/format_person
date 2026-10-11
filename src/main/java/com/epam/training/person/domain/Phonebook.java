package com.epam.training.person.domain;

import java.util.List;

public class Phonebook {
    private final List<Subscriber> subscribers;

    public Phonebook(List<Subscriber> subscribers){
        this.subscribers = subscribers;
    }
}
