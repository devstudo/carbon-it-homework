package com.homework.chassetresore.service;

import com.homework.chassetresore.domaine.*;
import jdk.nashorn.internal.runtime.options.Option;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {

    private Path filePath;
    private Carte carte;

    public FileService(String filePath) {
        this.filePath = Paths.get(filePath);
        ;
    }

    public Path getFilePath() {
        return filePath;
    }

    public void processFile(Path path) throws IOException{
        List<String> inputFileLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        //Carte carte = getCardFromFile(inputFileLines).get();

        inputFileLines.stream().filter(line -> !line.startsWith("#") && !line.equals("") && !line.startsWith("C"))
                .map(line -> line.replaceAll(" ", ""))
                .forEach(line -> processLine(line, carte));
    }

    public Optional<Carte> getCardFromFile(List<String> lines){

        long count= lines.stream().filter(line -> !line.startsWith("#") && !line.equals("") && line.startsWith("C")).count();
        if (count == 0 && count > 1) {
            //throw new Exception("fichier doit contenir une et une seule carte");
            return null;
        }

        return  lines.stream().filter(line -> !line.startsWith("#") && !line.equals("") && line.startsWith("C"))
                .map(line -> instantierCarte(line)).findFirst();

    }

    public void processLine(String line, Carte carte)  {
        CarteItem item = CarteItem.valueOf(line.substring(0,1));
        switch (item) {
            case MONTAGNE:
                carte.getMontagnes().add(instantierMontagne(line));
            case TRESORE:
                carte.getTresors().add(intantierTresor(line));

            case AVENTURIER:

            default:

        }
    }

    public Carte instantierCarte(String line) {
        if (!line.matches("C-[0-9]+-[0-9]+$")){
            return null;
        }
        char[] array = line.replaceAll("-", "").toCharArray();
        int hauteur = array[1];
        int largeur = array[2];
        return new Carte(new Point(hauteur, largeur), new ArrayList<>(), new ArrayList<>());
    }

    public Montagne instantierMontagne(String line){
        if (!line.matches("M-[0-9]+-[0-9]+$")){
            //throw new Exception("ligne de montagne non conforme");
            return null;
        }
        char[] array = line.replaceAll("-", "").toCharArray();
        int x = array[1];
        int y = array[2];
        return new Montagne(new Point(x,y));
    }


    public Tresor intantierTresor(String line) {
        if (!line.matches("T-[0-9]+-[0-9]+-[0-9]+$")){
            //throw new Exception("ligne de Trésor non conforme");
            return null;
        }
        char[] array = line.replaceAll("-", "").toCharArray();
        int x = array[1];
        int y = array[2];
        int nbrDeTresor = array[3];
        return new Tresor(new Point(x,y), 0);
    }

    public Aventurier intantierAventurier(String line) throws Exception {
        if (!line.matches("A-[a-zA-Z]+-[0-9]+-[0-9]+-[A-Z]-[A-Z]+$")){
            throw new Exception("ligne de Aventurier non conforme");
        }
        String[] array = line.split("-");
        String name= array[1];
        int x = Integer.parseInt(array[2]);
        int y = Integer.parseInt(array[3]);
        Direction direction= Direction.valueOf(array[4]);
        return new Aventurier(new Point(x,y), direction, name);
    }



}
