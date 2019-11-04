package com.homework.chassetresore.domaine;


import com.homework.chassetresore.Constantes;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Carte {

    private final Point bordureTop;
    public static final Point bordureButtom = new Point(0, 0);
    private List<Tresor> tresors;
    private List<Montagne> montagnes;
    private List<Aventurier> aventuriers;
    private final String tag= "C";


    public Carte(Point bordureTop, List<Tresor> tresors, List<Montagne> montagnes, List<Aventurier> aventuriers) {
        this.bordureTop = bordureTop;
        this.tresors = tresors;
        this.montagnes = montagnes;
        this.aventuriers= aventuriers;
    }

    @Override
    public String toString() {
        return this.getTag() + " - " + bordureTop.getX() + " - " + bordureTop.getY()
                + this.montagnes.stream().map(montagne -> montagne.toString()).collect(Collectors.joining())
                + this.writeTresorsComent(this, Constantes.TRESORS_COMMENTS )
                + this.tresors.stream().map(montagne -> montagne.toString()).collect(Collectors.joining())
                + this.writeAventuriersComent(this, Constantes.AVENTURIERS_COMMENT)
                + this.aventuriers.stream().map(montagne -> montagne.toString()).collect(Collectors.joining());


    }

    public String writeTresorsComent(Carte carte, String coment){
        return !carte.getTresors().isEmpty()? coment : "";
    }

    public String writeAventuriersComent(Carte carte, String coment){
        return !carte.getAventuriers().isEmpty()? coment : "";
    }

    /**
     * @param aventurier
     * @param top
     * @param bottom
     * @return
     */
    public boolean orBordure(Aventurier aventurier, Point top, Point bottom) {
        return aventurier.getPoint().getY() > top.getY()
                || aventurier.getPoint().getX() > top.getX()
                || aventurier.getPoint().getX() < bottom.getX()
                || aventurier.getPoint().getY() < bottom.getY();
    }
}
