package com.homework.chassetresore.service;

import com.homework.chassetresore.Constantes;
import com.homework.chassetresore.domaine.*;
import com.homework.chassetresore.exception.*;
import lombok.Data;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class FileService {

    private Path Pathfichier;

    public FileService(String filePath) {
        this.Pathfichier = Paths.get(filePath);
    }

    public Carte construireCarteDepuisFichier(Path pathFichier) throws Exception {
        List<String> lignesFichier = Files.readAllLines(pathFichier, StandardCharsets.UTF_8);
        Carte carte = getCardFromFile(lignesFichier);
        positionnerElementsSurCarte(lignesFichier, carte);
        return carte;
    }

    /**
     * @param lines
     * @return
     * @throws Exception
     */
    public Carte getCardFromFile(List<String> lines) throws Exception {

        long count = lines.stream().filter(line -> line.startsWith("C")).count();
        if (count == 0 || count > 1) {
            throw new MultiplesCartesException();
        }
        String carteLine = lines.stream().filter(line -> line.startsWith("C"))
                .map(line -> line.replaceAll(" ", "")).collect(Collectors.joining());
        return instantierCarte(carteLine);
    }

    /**
     * @param lines
     * @param carte
     */
    public void positionnerElementsSurCarte(List<String> lines, Carte carte) {

        lines.stream().filter(line -> !line.startsWith("#") && !line.equals("") && !line.startsWith("C"))
                .map(line -> line.replaceAll(" ", ""))
                .forEach(line -> {
                    try {
                        CarteItem item = CarteItem.valueOfString(line.substring(0, 1));
                        switch (item) {
                            case MONTAGNE:
                                carte.getMontagnes().add(instantierMontagne(line));
                                break;
                            case TRESORE:
                                carte.getTresors().add(intantierTresor(line));
                                break;
                            case AVENTURIER:
                                carte.getAventuriers().add(intantierAventurier(line, carte));
                                break;
                            default:
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    /**
     * @param result
     * @param myfile
     * @throws IOException
     */
    public static  void  writeOutputFile (String result, File myfile) throws IOException {
        final Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(myfile), StandardCharsets.UTF_8));
        out.append(result);
        out.flush();
        out.close();
    }

    public Carte instantierCarte(String line) throws Exception {
        if (!line.matches(Constantes.CARTE_REGEX)) {
            throw new CarteNonConformeException();
        }
        String[] array = line.split("-");
        int hauteur = Integer.parseInt(array[1]);
        int largeur = Integer.parseInt(array[2]);
        return new Carte(new Point(hauteur, largeur), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public Montagne instantierMontagne(String line) throws Exception {
        if (!line.matches(Constantes.MONTAGNE_REGEX)) {
            throw new MotagneNonConformeException();
        }
        String[] array = line.split("-");
        int x = Integer.parseInt(array[1]);
        int y = Integer.parseInt(array[2]);
        return new Montagne(new Point(x, y));
    }


    public Tresor intantierTresor(String line) throws Exception {
        if (!line.matches(Constantes.TRESORE_REGEX)) {
            throw new TresorNonConformeException();
        }
        String[] array = line.split("-");
        int x = Integer.parseInt(array[1]);
        int y = Integer.parseInt(array[2]);
        int nbrDeTresor = Integer.parseInt(array[3]);
        return new Tresor(new Point(x, y), nbrDeTresor);
    }

    public Aventurier intantierAventurier(String line, Carte carte) throws Exception {
        if (!line.matches(Constantes.AVENTURIER_REGEX)) {
            throw new AventurierNonConformeException();
        }
        String[] array = line.split("-");
        String name = array[1];
        int x = Integer.parseInt(array[2]);
        int y = Integer.parseInt(array[3]);

        Direction direction = Direction.valueOfString(array[4]);
        Aventurier aventurier= new Aventurier(new Point(x, y), direction, name);
        aventurier.aventurierInstructions(array[5]);
        if (carte.orBordure(aventurier, carte.getBordureTop(), carte.bordureButtom)){
            throw new AventurierOrBordureException(String.format(ExceptionEnum.ERROR_FILE_09.getMessage(), name));
        }
        return aventurier;
    }


}
