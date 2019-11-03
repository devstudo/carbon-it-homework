package com.homework.chassetresore.domaine;

import com.homework.chassetresore.exception.InstructionNonConformeException;

import java.util.Arrays;

public enum Instruction {
    AVANCER("A"),
    DROITE("D"),
    GAUCH("G");

    private final String instruction;

    Instruction(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }

    public static Instruction valueOfString(String instruction) {
        return Arrays.stream(values())
                .filter(elem -> elem.getInstruction().equals(instruction))
                .findFirst()
                .orElseThrow(() -> new InstructionNonConformeException());
    }
}
