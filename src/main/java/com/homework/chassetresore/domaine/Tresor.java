package com.homework.chassetresore.domaine;

import lombok.Data;

@Data
public class Tresor extends Plaine {
    private int nbrDeTresors;

    public Tresor(Point point, int nbrDeTresors) {
        super(point, "T");
        this.nbrDeTresors = nbrDeTresors;
    }

    public Tresor decrement() {
        this.nbrDeTresors--;
        return this;
    }

    @Override
    public String toString() {
        return "\n" + this.getTag() + " - " + this.getPoint().getX() + " - " + this.getPoint().getY() + " - " + this.getNbrDeTresors();
    }
}
