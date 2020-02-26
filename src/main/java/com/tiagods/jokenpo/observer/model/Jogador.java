package com.tiagods.jokenpo.observer.model;

import com.tiagods.jokenpo.enums.Escolha;

public interface Jogador {
    Escolha joga();
    String getNome();
}
