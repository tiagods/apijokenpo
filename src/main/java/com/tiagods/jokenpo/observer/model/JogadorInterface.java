package com.tiagods.jokenpo.observer.model;

import java.util.Observable;

public abstract class JogadorInterface extends Observable {
    private boolean sair = false;
    private String nome;
    public JogadorInterface(String nome){
        this.nome=nome;
    }
    public String getNome() {
        return nome;
    }
    public void setSair(boolean sair){this.sair=sair;};
    public boolean isSair(){ return sair;};
}
