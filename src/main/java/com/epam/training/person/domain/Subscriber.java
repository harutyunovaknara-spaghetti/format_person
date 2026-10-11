package com.epam.training.person.domain;

import java.util.Objects;

public class Subscriber {
    private final String phone;
    private final String clientName;

    public Subscriber(String phone, String clientName){
        this.phone = phone;
        this.clientName = clientName;
    }

    public String getPhone() {
        return phone;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        return (obj instanceof Subscriber) &&
                Objects.equals(((Subscriber) obj).clientName, this.clientName)
                && Objects.equals(((Subscriber) obj).phone, this.phone);
    }
}
