package com.homework.chassetresore;

import com.homework.chassetresore.domaine.*;
import com.homework.chassetresore.service.AventurierService;
import com.homework.chassetresore.service.FileService;
import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Application {

    public static void main(String[] args) {

        FileService fileService = new FileService(Constantes.INPUT_FILE_PATH);
        try {
            Carte carte = fileService.construireCarteDepuisFichier(fileService.getPathfichier());
            List<Aventurier> aventuriersFinal = new ArrayList<>();
            carte.getAventuriers().stream().forEach(aventurier -> {
                AventurierService aventurierService= new AventurierService(carte);
                aventuriersFinal.add(aventurierService.appliquerInstructions(aventurier));
            });
            carte.getAventuriers().clear();
            aventuriersFinal.stream().forEach(aventurier -> carte.getAventuriers().add(aventurier));
            fileService.writeOutputFile (carte.toString(), new File(Constantes.OUTPUT_FILE_PATH));
            System.out.println(carte.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }


        //Instructions instructions = new Instructions("AADADA");

        Aventurier aventurier = new Aventurier(new Point(1, 1), Direction.SUD, "Laura");

        Montagne montagne1 = new Montagne(new Point(1, 0));
        Montagne montagne2 = new Montagne(new Point(2, 1));
        Tresor tresor = new Tresor(new Point(0, 3), 2);
        Tresor tresor1 = new Tresor(new Point(1, 3), 3);
        Point bordure = new Point(3, 4);
        Carte carte = new Carte(bordure, Arrays.asList(tresor, tresor1), Arrays.asList(montagne1, montagne2), null);


//        AventurierService service = new AventurierService(carte, instructions);
//        Aventurier aventurierFinal = service.appliquerInstructions(aventurier);

//        Aventurier aventurierFinal = service.appliquerInstruction(aventurier, Instruction.AVANCER);
//        Aventurier aventurierFinal2 = service.appliquerInstruction(aventurierFinal, Instruction.AVANCER);
//        Aventurier aventurierFinalD = service.appliquerInstruction(aventurierFinal2, Instruction.DROITE);
//        Aventurier aventurierFinalA = service.appliquerInstruction(aventurierFinalD, Instruction.AVANCER);

//        System.out.println(aventurierFinal);
//        System.out.println(carte);

    }
}
