package com.homework.chassetresore.domaine;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Carte {

    private final Point bordureTop;
    public static final Point bordureButtom = new Point(0, 0);
    private List<Tresor> tresors;
    private List<Montagne> montagnes;


    public Carte(Point bordureTop, List<Tresor> tresors, List<Montagne> montagnes) {
        this.bordureTop = bordureTop;
        this.tresors = tresors;
        this.montagnes = montagnes;
    }

    public Point getBordureTop() {
        return bordureTop;
    }

    public List<Tresor> getTresors() {
        return tresors;
    }

    public List<Montagne> getMontagnes() {
        return montagnes;
    }

    public void setTresors(List<Tresor> tresors) {
        this.tresors = tresors;
    }

    public void setMontagnes(List<Montagne> montagnes) {
        this.montagnes = montagnes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carte)) return false;
        Carte carte = (Carte) o;
        return bordureTop.equals(carte.bordureTop) &&
               tresors.equals(carte.tresors) &&
               montagnes.equals(carte.montagnes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bordureTop, tresors, montagnes);
    }

    @Override
    public String toString() {
        return "Carte{" +
               "bordureTop=" + bordureTop +
               ", \ntresors=" + tresors +
               ", \nmontagnes=" + montagnes +
               '}';
    }
}
