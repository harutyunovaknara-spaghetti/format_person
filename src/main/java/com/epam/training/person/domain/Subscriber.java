package com.epam.training.person.domain;

import jakarta.xml.bind.annotation.*;

import java.util.Objects;
@XmlRootElement(name = "subscriber")
@XmlType(propOrder = {"phone","clientName"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Subscriber {
    @XmlElement(name = "client-name")
    private String clientName;
    @XmlElement(name = "phone-number")
    private String phone;
    public Subscriber(){
        this.phone = null;
        this.clientName = null;
    }
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
