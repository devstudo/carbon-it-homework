package com.homework.chassetresore.exception;

public enum ExceptionEnum {
    ERROR_FILE_01("ERROR_FILE_01","Format  ligne de CARTE non conforme !"),
    ERROR_FILE_02("ERROR_FILE_02","Le fichier doit contenir une et une seule CARTE !"),
    ERROR_FILE_03("ERROR_FILE_03","Format d'une ligne de MONTAGNE non conforme !"),
    ERROR_FILE_04("ERROR_FILE_04","Format d'une ligne de TRESORE non conforme !"),
    ERROR_FILE_05("ERROR_FILE_05","Format d'une ligne d'AVENTURIER est non conforme !"),
    ERROR_FILE_06("ERROR_FILE_06","Direction de la ligne d'AVENTURIER est non conforme => chousir dans {'N', 'E', 'S', 'O'}"),
    ERROR_FILE_07("ERROR_FILE_07","ISTRUCTION de la ligne d'AVENTURIER est non conforme => chousir dans {'A', 'G', 'D'}"),
    ERROR_FILE_08("ERROR_FILE_08","ITEM de CARTE non conforme => choisir dans {'A', 'T', 'M'}"),
    ERROR_FILE_09("ERROR_FILE_08","Aventurier {%s} est or bordures de la CARTE");


    private String code;
    private String message;



    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.join(" : ",code,message);
    }
}
