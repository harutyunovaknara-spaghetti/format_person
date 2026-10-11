package com.epam.training.person;

public interface Transformer<F,T> {
    T transform(F value);
}
