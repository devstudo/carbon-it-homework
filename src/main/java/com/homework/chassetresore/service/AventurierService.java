package com.homework.chassetresore.service;

import com.homework.chassetresore.domaine.Aventurier;
import com.homework.chassetresore.domaine.Carte;
import com.homework.chassetresore.domaine.Instruction;
import com.homework.chassetresore.domaine.Montagne;
import com.homework.chassetresore.domaine.Point;
import com.homework.chassetresore.domaine.Tresor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AventurierService {

    private final Carte carte;

    public AventurierService(Carte carte) {
        this.carte = carte;
    }

    public Aventurier appliquerInstructions(Aventurier aventurier) {
        return aventurier.getInstructionList().stream()
                .reduce(aventurier,
                        this::appliquerInstruction,
                        (first, second) -> second);
    }

    /**
     * @param aventurier
     * @param instruction
     * @return
     */
    private Aventurier appliquerInstruction(Aventurier aventurier, Instruction instruction) {
        switch (instruction) {
            case AVANCER:
                return avancerAvecObstacles(aventurier, carte)
                        .map(aventurierAvancer ->
                                rammaserTresor(carte.getTresors(), aventurierAvancer.getPoint())
                                        .map(tresor -> {
                                            tresor.decrement();
                                            if (tresor.getNbrDeTresors() == 0) {
                                                carte.getTresors().remove(tresor);
                                            }
                                            return aventurierAvancer.incrementTresor();
                                        }).orElse(aventurierAvancer)
                        ).orElse(aventurier);
            case GAUCH:
                return aventurier.tourneGauche();
            case DROITE:
                return aventurier.tourneDroite();
            default:
                return aventurier;

        }
    }

    /**
     * @param tresors
     * @param point
     * @return
     */
    private Optional<Tresor> rammaserTresor(List<Tresor> tresors, Point point) {
        return tresors.stream()
                .filter(tresor -> tresor.getPoint().equals(point))
                .findFirst();
    }

    /**
     * @param aventurier
     * @param carte
     * @return
     */
    private Optional<Aventurier> avancerAvecObstacles(Aventurier aventurier, Carte carte) {
        Aventurier aventurierAvancee = aventurier.avance();
        List<Point> points = carte.getMontagnes().stream().map(Montagne::getPoint).collect(Collectors.toList());

        if (points.contains(aventurierAvancee.getPoint())) {
            return Optional.empty();
        } else if (carte.orBordure(aventurierAvancee, carte.getBordureTop(), Carte.bordureButtom)) {
            return Optional.empty();
        } else {
            return Optional.of(aventurierAvancee);
        }
    }
}
