package com.homework.chassetresore.domaine;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Aventurier extends Plaine {
    private Direction direction;
    private final List<Instruction> instructionList;
    private String name;
    private int tresorsRamases;


    public Aventurier(Point point, Direction direction, String name) {
        super(point, "A");
        this.direction = direction;
        this.instructionList = new ArrayList<>();
        this.name = name;
        this.tresorsRamases = 0;
    }

    private Aventurier(Point point, Direction direction, String name, int tresorsRamases) {
        super(point, "A");
        this.direction = direction;
        this.name = name;
        this.tresorsRamases = tresorsRamases;
        this.instructionList = new ArrayList<>();
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

    public void aventurierInstructions(String instructions) {
        this.instructionList.addAll(Arrays.asList(instructions.split("")).stream()
                .map(instruction -> Instruction.valueOfString(instruction))
                .collect(Collectors.toList()));
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

    public Aventurier incrementTresor() {
        return new Aventurier(this.getPoint(), direction, name, tresorsRamases + 1);
    }

    @Override
    public String toString() {
        return "\n" + this.getTag() + " - " + this.name + " - " + this.getPoint().getX() + " - " + this.getPoint().getY() + " - "
                + this.direction.getItem() + " - " + this.tresorsRamases;
    }
}
