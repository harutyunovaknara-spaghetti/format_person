package com.epam.training.person.persistence;

import com.epam.training.person.domain.Subscriber;

import java.io.OutputStream;
import java.util.List;

public class XMLSubscriberWriter implements DataWriter<List<Subscriber>> {
    private final OutputStream out;

    public XMLSubscriberWriter(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(List<Subscriber> value) {

    }

    @Override
    public void close() {

    }
}
