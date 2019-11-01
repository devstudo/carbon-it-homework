package com.homework.chassetresore.domaine;

public enum Direction {
    NORTH("N"),
    EST("E"),
    SUD("S"),
    OUEST("O");

    private final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

}
