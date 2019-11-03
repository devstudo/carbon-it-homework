package com.homework.chassetresore.domaine;

import com.homework.chassetresore.exception.ItemdeCarteNonConformeException;

import java.util.Arrays;

public enum  CarteItem {
    MONTAGNE("M"),
    TRESORE("T"),
    AVENTURIER("A");

    private final String item;

    CarteItem(String item) {
      this.item = item;
    }

    public String getItem() {
        return item;
    }

    public static CarteItem valueOfString(String instruction) {
        return Arrays.stream(values())
                .filter(elem -> elem.getItem().equals(instruction))
                .findFirst()
                .orElseThrow(() -> new ItemdeCarteNonConformeException());
    }

}
