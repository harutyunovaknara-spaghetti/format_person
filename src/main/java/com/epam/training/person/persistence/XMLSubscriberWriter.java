package com.epam.training.person.persistence;

import com.epam.training.person.domain.Phonebook;
import com.epam.training.person.domain.Subscriber;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.OutputStream;
import java.util.List;

public class XMLSubscriberWriter implements DataWriter<List<Subscriber>> {
    private final OutputStream out;
    private final JAXBContext jaxbContext;

    public XMLSubscriberWriter(OutputStream out) {
        this.out = out;
        try {
            this.jaxbContext = JAXBContext.newInstance(Phonebook.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(List<Subscriber> value) {
        try {
            Marshaller marshaller = this.jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Phonebook phonebook = new Phonebook(value);
            marshaller.marshal(phonebook, out);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {

    }
}
