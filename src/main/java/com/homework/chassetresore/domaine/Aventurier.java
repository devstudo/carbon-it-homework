package com.homework.chassetresore.domaine;

import java.util.Objects;

public class Aventurier extends Plaine {
    private Direction direction;
    private String name;
    private int tresorsRamases;

    public Aventurier(Point point, Direction direction, String name) {
        super(point, "A");
        this.direction = direction;
        this.name = name;
        this.tresorsRamases= 0;
    }

    private Aventurier(Point point, Direction direction, String name, int tresorsRamases) {
        super(point, "A");
        this.direction = direction;
        this.name = name;
        this.tresorsRamases= tresorsRamases;
    }

    public Aventurier avance() {
        return new Aventurier(calculeNvPoint(), this.direction, name, tresorsRamases);
    }

    public Aventurier tourneDroite() {
        return new Aventurier(this.getPoint(), calculeNvDirectionDroite(), name, tresorsRamases);
    }

    public Aventurier tourneGauche() {
        return new Aventurier(this.getPoint(), calculeNvDirectionGauche(), name, tresorsRamases);
    }

    private Point calculeNvPoint() {
        switch (this.direction) {
            case NORTH:
                return new Point(getPoint().getX(), getPoint().getY() - 1);
            case EST:
                return new Point(getPoint().getX() + 1, getPoint().getY());
            case SUD:
                return new Point(getPoint().getX(), getPoint().getY() + 1);
            case OUEST:
                return new Point(getPoint().getX() - 1, getPoint().getY());
            default:
                return getPoint();
        }
    }

    private Direction calculeNvDirectionGauche() {
        switch (this.direction) {
            case NORTH:
                return Direction.OUEST;
            case EST:
                return Direction.NORTH;
            case SUD:
                return Direction.EST;
            case OUEST:
                return Direction.SUD;
            default:
                return this.direction;
        }
    }

    private Direction calculeNvDirectionDroite() {
        switch (this.direction) {
            case NORTH:
                return Direction.EST;
            case EST:
                return Direction.SUD;
            case SUD:
                return Direction.OUEST;
            case OUEST:
                return Direction.NORTH;
            default:
                return this.direction;
        }
    }

    private void setDirection(Direction direction) {
        this.direction = direction;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Aventurier incrementTresor() {
        return new Aventurier(this.getPoint(), direction, name, tresorsRamases + 1);
    }

    public Direction getDirection() {
        return direction;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aventurier)) return false;
        if (!super.equals(o)) return false;
        Aventurier that = (Aventurier) o;
        return tresorsRamases == that.tresorsRamases &&
               direction == that.direction &&
               name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), direction, name, tresorsRamases);
    }

    @Override
    public String toString() {
        return "Aventurier{" +
               "direction=" + direction +
               ", name='" + name + '\'' +
               ", tresorsRamases=" + tresorsRamases +
               "} " + super.toString();
    }
}
