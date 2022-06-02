package com.nhnacademy.resimanage.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Output<T> {
    private T data;

    private Output() {}

    @JsonCreator
    private Output(T t) {
        this.data = t;
    }

    public static Output success(Object object) {
        return new Output(object);
    }
}
