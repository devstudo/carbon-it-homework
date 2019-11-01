package com.homework.chassetresore.domaine;

import java.util.Objects;

public class Plaine {
    private Point point;
    private String tag;

    public Plaine(Point point, String tag) {
        this.point = point;
        this.tag = tag;
    }

    public Point getPoint() {
        return point;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plaine)) return false;
        Plaine plaine = (Plaine) o;
        return point.equals(plaine.point) &&
               tag.equals(plaine.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, tag);
    }

    @Override
    public String toString() {
        return "Plaine{" +
               "point=" + point +
               ", tag='" + tag + '\'' +
               '}';
    }
}

