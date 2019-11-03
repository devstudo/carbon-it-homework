package com.homework.chassetresore.domaine;

import lombok.Data;

@Data
public class Montagne extends Plaine {

    public Montagne(Point point) {
        super(point, "M");
    }

    @Override
    public String toString() {
        return "\n" + this.getTag() + " - " + this.getPoint().getX() + " - " + this.getPoint().getY();
    }
}
