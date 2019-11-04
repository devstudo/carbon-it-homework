package com.homework.chassetresore.service;


import com.homework.chassetresore.Constantes;
import com.homework.chassetresore.domaine.Carte;
import com.homework.chassetresore.domaine.Point;
import com.homework.chassetresore.exception.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertTrue;

public class FileServiceTest {
    private FileService fileService;
    @Mock
    private BufferedWriter bufferedWriterMock;

    @Before
    public void before() {
        fileService = new FileService(Constantes.INPUT_FILE_PATH);

    }


    @Test
    public void test_construireCarteDepuisFichier_OK() throws Exception {

        String carteResult= "C - 3 - 4\n" +
                "M - 1 - 0\n" +
                "M - 2 - 1\n" +
                "# {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Nb. de trésors restants}\n" +
                "T - 0 - 3 - 2\n" +
                "T - 1 - 3 - 3\n" +
                "# {A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. trésors ramassés}\n" +
                "A - Lara - 1 - 1 - S - 0\n" +
                "A - Simo - 0 - 3 - E - 0";

        Carte carte = fileService.construireCarteDepuisFichier(fileService.getPathfichier());
        assertTrue(carte.toString().equals(carteResult));

    }

    @Test(expected = CarteNonConformeException.class)
    public void test_instantiateCarte_KO() throws CarteNonConformeException {

        fileService.instantierCarte("C - 2 - 3");
    }

    @Test(expected = TresorNonConformeException.class)
    public void test_instantiateTresor_KO() throws TresorNonConformeException {

        fileService.intantierTresor("T - 2");
    }

    @Test(expected = MontagneNonConformeException.class)
    public void test_instantiateMontagne_KO() throws MontagneNonConformeException {
        fileService.instantierMontagne("M-2");
    }

    @Test(expected = AventurierNonConformeException.class)
    public void test_instantiateAventurier_KO() throws AventurierNonConformeException, AventurierOrBordureException {
        Point bordure = new Point(3, 4);
        Carte carte = new Carte(bordure, null, null, null);
        fileService.intantierAventurier("A - 2", carte);
    }

    @Test(expected = AventurierOrBordureException.class)
    public void test_instantiateAventurier_KO1() throws AventurierNonConformeException, AventurierOrBordureException {
        Point bordure = new Point(3, 4);
        Carte carte = new Carte(bordure, null, null, null);
        fileService.intantierAventurier("A-Simo-0-5-E-GAGAGAGADDA", carte);
    }


}
