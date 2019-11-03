package com.homework.chassetresore.domaine;

import lombok.Data;

@Data
public class Plaine {
    private Point point;
    private String tag;

    public Plaine(Point point, String tag) {
        this.point = point;
        this.tag = tag;
    }
}

