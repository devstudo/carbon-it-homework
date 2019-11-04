package com.homework.chassetresore;

import com.homework.chassetresore.domaine.*;
import com.homework.chassetresore.exception.GenericException;
import com.homework.chassetresore.service.AventurierService;
import com.homework.chassetresore.service.FileService;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Data
public class Application {

    public static void main(String[] args) {
        try {
            /*Récupération de la valeur du path entrée par L'utilisateur*/
            Scanner input = new Scanner(System.in);
            System.out.print(Constantes.CONSOLE_MESSAGE);
            String filePath = input.next();

            /*création de la carte à partir du fichier*/
            FileService fileService = new FileService(filePath);
            Carte carte = fileService.construireCarteDepuisFichier(fileService.getPathfichier());
            AventurierService aventurierService = new AventurierService(carte);

            /*execution des instruction de chaque utilisateur et
            * mise à jour de la liste des aventuriers carte après instructions*/
            carte.setAventuriers(carte.getAventuriers().stream().
                    map(aventurier -> aventurierService.appliquerInstructions(aventurier)).collect(Collectors.toList()));

            /*écriture de la carte dans le fichier de sortie*/
            File out= new File(filePath.substring(0,filePath.lastIndexOf("/"))+ "/output-fichier");
            fileService.writeOutputFile(carte.toString(), out);
            out.createNewFile();
            System.out.println(carte.toString());
        } catch (IOException | GenericException e) {
            e.printStackTrace();
        }
    }
}
