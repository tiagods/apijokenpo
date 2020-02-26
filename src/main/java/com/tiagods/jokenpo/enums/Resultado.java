package com.tiagods.jokenpo.enums;

public enum Resultado {
    GANHOU("Ganhou"),PERDEU("Perdeu"),EMPATE("Empatou");

    private String descricao;
    Resultado(String descricao){
        this.descricao=descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
