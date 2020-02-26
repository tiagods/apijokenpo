package com.tiagods.jokenpo.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Escolha {
    PEDRA,PAPEL,TESOURA;

    public static Escolha getRandom()  {
        final List<Escolha> list = Arrays.asList(values());
        return Arrays.asList(values()).get(new Random().nextInt(list.size()));
    }
}
