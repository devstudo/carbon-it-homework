package com.homework.chassetresore;

public class Constantes {

    /*Exceptions regulières*/
    public static final String CARTE_REGEX = "C-[0-9]+-[0-9]+$";
    public static final String MONTAGNE_REGEX = "M-[0-9]+-[0-9]+$";
    public static final String TRESORE_REGEX = "T-[0-9]+-[0-9]+-[0-9]+$";
    public static final String AVENTURIER_REGEX = "A-[a-zA-Z]+-[0-9]+-[0-9]+-[A-Z]-[A-Z]+$";

    /*paths fichiers*/
    public static final String CONSOLE_MESSAGE = "Entrez le path du fichier: ";
    public static final String INPUT_FILE_PATH = "/Users/simob/Documents/carbon-it-homework/src/main/resources/input-file.txt";
    public static final String OUTPUT_FILE_NAME = "resultat-chasse-aux-tresores";

    /*Tags*/
    public static final String CARTE_TAG = "C";

    /*file comments*/
    public static final String AVENTURIERS_COMMENT = "\n# {A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. trésors ramassés}";
    public static final String TRESORS_COMMENTS = "\n# {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Nb. de trésors restants}";


    private Constantes() {}
}
