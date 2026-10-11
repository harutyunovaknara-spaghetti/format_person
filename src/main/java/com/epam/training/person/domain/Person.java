package com.epam.training.person.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public record Person(UUID id, String name, LocalDate dateOfBirth, Location placeOfBirth, Gender gender, List<Phone> phones) {
    public Person(UUID id, String name, LocalDate dateOfBirth){
        this(id,name,dateOfBirth, null, null,null);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        return (obj instanceof Person) && Objects.equals(((Person) obj).id, this.id)
                && Objects.equals(((Person) obj).name, this.name)
                && Objects.equals(((Person) obj).dateOfBirth, this.dateOfBirth);
    }
}
