package com.homework.chassetresore.domaine;

import com.homework.chassetresore.exception.DirectionNonConformeException;

import java.util.Arrays;

public enum Direction {
    NORTH("N"),
    EST("E"),
    SUD("S"),
    OUEST("O");

    private final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public String getItem() {
        return direction;
    }

    public static Direction valueOfString(String instruction) {
        return Arrays.stream(values())
                .filter(elem -> elem.getItem().equals(instruction))
                .findFirst()
                .orElseThrow(() -> new DirectionNonConformeException());
    }

}
