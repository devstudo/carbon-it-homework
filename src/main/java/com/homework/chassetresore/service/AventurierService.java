package com.homework.chassetresore.service;

import com.homework.chassetresore.domaine.Carte;
import com.homework.chassetresore.domaine.Aventurier;
import com.homework.chassetresore.domaine.Instructions;
import com.homework.chassetresore.domaine.Instructions.Instruction;
import com.homework.chassetresore.domaine.Montagne;
import com.homework.chassetresore.domaine.Point;
import com.homework.chassetresore.domaine.Tresor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AventurierService {

    private final Instructions instructions;
    private final Carte carte;
    private Aventurier aventurierFinal;

    public AventurierService(Carte carte, Instructions instructions) {
        this.instructions = instructions;
        this.carte = carte;
    }

    public Aventurier appliquerInstructions(Aventurier aventurier) {
        return instructions.getInstructionList().stream()
                    .reduce(aventurier,
                            this::appliquerInstruction, // (a, instruction) -> avancerDansLaCarte(a, instruction)
                            (first, second) -> second);
    }

//    public Aventurier appliquerInstructions(Aventurier aventurier) {
//        this.aventurierFinal= aventurier;
//        List<Instruction> instructionsList = instructions.getInstructionList();
//        for (Instruction instruction : instructionsList) {
//            aventurierFinal = appliquerInstruction(aventurierFinal, instruction);
//        }
//        return aventurierFinal;
//    }

    public Aventurier appliquerInstruction(Aventurier aventurier, Instruction instruction) {
        switch (instruction) {
            case AVANCER:
                return avancerAvecObstacles(aventurier, carte)
                        .map(aventurierAvancer ->
                                rammaserTresor(carte.getTresors(), aventurierAvancer.getPoint())
                                        .map(tresor -> {
                                            tresor.decrement();
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

    private Optional<Tresor> rammaserTresor(List<Tresor> tresors, Point point) {
        return tresors.stream()
                .filter(tresor -> tresor.getPoint().equals(point))
                .findFirst();
    }

    private Optional<Aventurier> avancerAvecObstacles(Aventurier aventurier, Carte carte) {
        Aventurier aventurierAvancee = aventurier.avance();
        List<Point> points = carte.getMontagnes().stream().map(Montagne::getPoint).collect(Collectors.toList());

        if (points.contains(aventurierAvancee.getPoint())) {
            return Optional.empty();
        } else if (orBordure(aventurierAvancee, carte.getBordureTop(), Carte.bordureButtom)) {
            return Optional.empty();
        } else {
            return Optional.of(aventurierAvancee);
        }
    }

    private boolean orBordure(Aventurier aventurier, Point top, Point bottom) {
        return aventurier.getPoint().getY() > top.getY()
                || aventurier.getPoint().getX() > top.getX()
                || aventurier.getPoint().getX() < bottom.getX()
                || aventurier.getPoint().getY() < bottom.getY();
    }

}
