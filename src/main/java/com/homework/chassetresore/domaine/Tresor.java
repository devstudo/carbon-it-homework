package com.homework.chassetresore.domaine;

import java.util.Objects;

public class Tresor extends Plaine {
    private int nbrDeTresors;

    public Tresor(Point point, int nbrDeTresors) {
        super(point, "T");
        this.nbrDeTresors= nbrDeTresors;
    }

    public Tresor decrement() {
        this.nbrDeTresors--;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tresor)) return false;
        if (!super.equals(o)) return false;
        Tresor tresor = (Tresor) o;
        return nbrDeTresors == tresor.nbrDeTresors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nbrDeTresors);
    }

    @Override
    public String toString() {
        return "Tresor{" +
               "nbrDeTresors=" + nbrDeTresors +
               "} " + super.toString();
    }
}
