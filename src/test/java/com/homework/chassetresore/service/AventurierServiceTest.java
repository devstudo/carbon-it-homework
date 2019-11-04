package com.homework.chassetresore.service;

import com.homework.chassetresore.domaine.*;
import com.homework.chassetresore.exception.InstructionNonConformeException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class AventurierServiceTest {
    private  AventurierService aventurierService;
    private    Carte carte;
    private  Point bordure;
    private  Aventurier aventurier;
    private  Montagne montagne1, montagne2;
    private  Tresor tresor, tresor1, tresor2;

    @Before
    public void before() {
        aventurier = new Aventurier(new Point(1, 1), Direction.SUD, "Laura");
        montagne1 = new Montagne(new Point(1, 0));
        montagne2 = new Montagne(new Point(2, 1));
        tresor = new Tresor(new Point(0, 3), 2);
        tresor1 = new Tresor(new Point(1, 3), 2);
        tresor2 = new Tresor(new Point(3, 3), 1);
        bordure = new Point(3, 4);
        carte = new Carte(bordure, Arrays.asList(tresor, tresor1, tresor2), Arrays.asList(montagne1, montagne2), Arrays.asList(aventurier));
        aventurierService = new AventurierService(carte);

    }

    @Test
    public void test_appliquerInstructionOK() {
        aventurier.aventurierInstructions("AADADAG");
        Aventurier aventurierFinal= aventurierService.appliquerInstructions(aventurier);
        assertTrue(aventurierFinal.toString().equals("\nA - Laura - 0 - 2 - O - 2"));

    }

    @Test(expected = InstructionNonConformeException.class)
    public void test_appliquerInstructionKO1() {
        aventurier.aventurierInstructions("ZZ");
        aventurierService.appliquerInstructions(aventurier);

    }

    @Test()
    public void test_appliquerInstructionKO3() {
        aventurier= new Aventurier(new Point(2, 0), Direction.NORTH, "Laura");
        aventurier.aventurierInstructions("A");
        aventurierService.appliquerInstructions(aventurier);
        assertTrue(aventurier.equals(aventurierService.appliquerInstructions(aventurier)));

    }

    @Test()
    public void test_appliquerInstructionKO4() {
        aventurier= new Aventurier(new Point(2, 2), Direction.NORTH, "Laura");
        aventurier.aventurierInstructions("A");
        aventurierService.appliquerInstructions(aventurier);
        assertTrue(aventurier.equals(aventurierService.appliquerInstructions(aventurier)));

    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_appliquerInstructionKO5() {
        aventurier= new Aventurier(new Point(3, 2), Direction.SUD, "simo");
        aventurier.aventurierInstructions("A");
        aventurierService.appliquerInstructions(aventurier);
        //assertTrue(aventurier.equals(aventurierService.appliquerInstructions(aventurier)));

    }



}
