package com.homework.chassetresore;

import com.homework.chassetresore.domaine.Aventurier;
import com.homework.chassetresore.domaine.Carte;
import com.homework.chassetresore.domaine.Direction;
import com.homework.chassetresore.domaine.Instructions;
import com.homework.chassetresore.domaine.Instructions.Instruction;
import com.homework.chassetresore.domaine.Montagne;
import com.homework.chassetresore.domaine.Point;
import com.homework.chassetresore.domaine.Tresor;
import com.homework.chassetresore.service.AventurierService;
import com.homework.chassetresore.service.FileService;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Application {

    public static void main(String[] args) {

        FileService fileService = new FileService("/Users/simob/Documents/carbon-it-homwork/src/main/resources/source.txt");
        try {
            fileService.processFile(fileService.getFilePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String fileName = "recources/source.txt";
//        Path path = Paths.get(fileName);
//        getLinesFromFile(Path path);
        Instructions instructions= new Instructions("AADADA");

        Aventurier aventurier = new Aventurier(new Point(1, 1), Direction.SUD, "Laura");

        Montagne montagne1 = new Montagne(new Point(1, 0));
        Montagne montagne2 = new Montagne(new Point(2, 1));
        Tresor tresor = new Tresor(new Point(0, 3), 2);
        Tresor tresor1 = new Tresor(new Point(1, 3), 3);
        Point bordure = new Point(3, 4);
        Carte carte = new Carte(bordure, Arrays.asList(tresor, tresor1), Arrays.asList(montagne1, montagne2));


        AventurierService service = new AventurierService(carte, instructions);
        Aventurier aventurierFinal = service.appliquerInstructions(aventurier);

//        Aventurier aventurierFinal = service.appliquerInstruction(aventurier, Instruction.AVANCER);
//        Aventurier aventurierFinal2 = service.appliquerInstruction(aventurierFinal, Instruction.AVANCER);
//        Aventurier aventurierFinalD = service.appliquerInstruction(aventurierFinal2, Instruction.DROITE);
//        Aventurier aventurierFinalA = service.appliquerInstruction(aventurierFinalD, Instruction.AVANCER);

        System.out.println(aventurierFinal);
        System.out.println(carte);
    }


    public List<String> getLinesFromFile(Path path) throws IOException {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}
