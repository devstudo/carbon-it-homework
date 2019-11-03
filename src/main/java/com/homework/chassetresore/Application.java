package com.homework.chassetresore;

import com.homework.chassetresore.domaine.*;
import com.homework.chassetresore.service.AventurierService;
import com.homework.chassetresore.service.FileService;
import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Application {

    public static void main(String[] args) {

        FileService fileService = new FileService(Constantes.INPUT_FILE_PATH);
        try {
            /*création de la carte à partir du fichier*/
            Carte carte = fileService.construireCarteDepuisFichier(fileService.getPathfichier());
            AventurierService aventurierService = new AventurierService(carte);

            /*execution des instruction de chaque utilisateur et
            * mise à jour de la liste des aventuriers carte après instructions*/
            carte.setAventuriers(carte.getAventuriers().stream().
                    map(aventurier -> aventurierService.appliquerInstructions(aventurier)).collect(Collectors.toList()));

            /*écriture de la carte dans le fichier de sortie*/
            fileService.writeOutputFile(carte.toString(), new File(Constantes.OUTPUT_FILE_PATH));
            System.out.println(carte.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
