package com.homework.chassetresore.service;


import com.homework.chassetresore.domaine.*;
import com.homework.chassetresore.exception.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FileServiceTest {

    private List<String> lignes;
    private FileService fileService;
    private Carte resultCarte;
    private Point bordure;
    private Aventurier aventurier;
    private Montagne montagne1, montagne2;
    private Tresor tresor, tresor1;

    @Before
    public void before() {
        lignes= Arrays.asList("C - 3 - 4",
                "M - 1 - 0",
                "M - 2 - 1",
                "T - 0 - 3 - 2",
                "T - 1 - 3 - 3",
                "A - Laura - 1 - 1 - S - AADADA");
        fileService= new FileService();

        aventurier = new Aventurier(new Point(1, 1), Direction.SUD, "Laura");
        aventurier.aventurierInstructions("AADADA");
        montagne1 = new Montagne(new Point(1, 0));
        montagne2 = new Montagne(new Point(2, 1));
        tresor = new Tresor(new Point(0, 3), 2);
        tresor1 = new Tresor(new Point(1, 3), 3);
        bordure = new Point(3, 4);
        resultCarte = new Carte(bordure, Arrays.asList(tresor, tresor1), Arrays.asList(montagne1, montagne2), Arrays.asList(aventurier));



    }

    @Test
    public void test_lireLigneFichier_OK() throws Exception {

        Carte carte = fileService.lireLigneFichier(lignes);
        assertTrue(carte.equals(resultCarte));
    }

    @Test(expected = CarteNonConformeException.class)
    public void test_instantiateCarte_KO_CarteNonConforme() throws CarteNonConformeException {

        fileService.instantierCarte("C - 2 - 3");
    }

    @Test(expected = TresorNonConformeException.class)
    public void test_instantiateTresor_KO_TresorNonConforme() throws TresorNonConformeException {

        fileService.instantierTresor("T - 2");
    }

    @Test(expected = MontagneNonConformeException.class)
    public void test_instantiateMontagne_KO_MontagneNonConforme() throws MontagneNonConformeException {
        fileService.instantierMontagne("M-2");
    }

    @Test(expected = AventurierNonConformeException.class)
    public void test_instantiateAventurier_KO_AventurierNonConforme() throws Exception {
        Point bordure = new Point(3, 4);
        Carte carte = new Carte(bordure, null, null, null);
        fileService.instantierAventurier("A - 2", carte);
    }

    @Test(expected = AventurierHorsBordureException.class)
    public void test_instantiateAventurier_KO_AventurierHorsBordure() throws Exception {
        Point bordure = new Point(3, 4);
        Carte carte = new Carte(bordure, null, null, null);
        fileService.instantierAventurier("A-Simo-0-5-E-GAGAGAGADDA", carte);
    }

    @Test(expected = MultiplesCartesException.class)
    public void test_MultipleCarte_KO_MultiplesCartes() throws Exception {
        lignes= Arrays.asList("C - 3 - 4",
                "C - 1 - 0",
                "M - 2 - 1",
                "T - 0 - 3 - 2",
                "T - 1 - 3 - 3",
                "A - Laura - 1 - 1 - S - AADADA");
        fileService.lireLigneFichier(lignes);

    }


}
