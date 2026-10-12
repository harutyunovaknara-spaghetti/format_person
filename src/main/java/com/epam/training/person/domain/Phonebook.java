package com.epam.training.person.domain;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;
@XmlRootElement
public class Phonebook {
    private final List<Subscriber> subscribers;

    public Phonebook(List<Subscriber> subscribers){
        this.subscribers = subscribers;
    }

    public Phonebook(){
        this.subscribers = null;
    }
    @XmlElement(name = "subscriber")
    public List<Subscriber> getSubscribers(){
        return this.subscribers;
    }
}
