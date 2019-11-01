package com.homework.chassetresore.domaine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Instructions {

    private final List<Instruction> instructionList;

    public Instructions(List<Instruction> instructionList) {
        this.instructionList = instructionList;
    }

    public Instructions(String instructions) {
        this(instructions.chars()
                         .mapToObj(elem -> (char) elem)
                         .map(Instruction::valueOfChar)
                         .collect(Collectors.toList())
        );
    }

    public List<Instruction> getInstructionList() {
        return instructionList;
    }

    public enum Instruction {
        AVANCER('A'),
        DROITE('D'),
        GAUCH('G');

        private final char instruction;

        Instruction(char instruction) {
            this.instruction = instruction;
        }

        public char getInstruction() {
            return instruction;
        }

        public static Instruction valueOfChar(char instruction) {
            return Arrays.stream(values())
                         .filter(elem -> elem.getInstruction() == instruction)
                         .findFirst()
                         .orElseThrow(() -> new IllegalStateException("no instruction"));
        }
    }

}
