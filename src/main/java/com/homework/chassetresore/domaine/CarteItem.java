package com.homework.chassetresore.domaine;

public enum  CarteItem {
    CARTE("C"),
    MONTAGNE("M"),
    TRESORE("T"),
    AVENTURIER("A");

    private final String item;

    CarteItem(String item) {
        this.item = item;
    }
}
