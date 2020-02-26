package com.tiagods.jokenpo.observer;

import com.tiagods.jokenpo.enums.Escolha;
import com.tiagods.jokenpo.observer.model.Jogador;
import com.tiagods.jokenpo.observer.model.JogadorInterface;

import javax.swing.*;

public class Humano extends JogadorInterface implements Jogador {

    public Humano(String nome) {
        super(nome);
    }
    @Override
    public Escolha joga() {
        int i = -1;
        while(i != 0) {
            String text = "Escolha um valor\n0-Sair\t 1-Pedra\t 2-Papel\t 3-Tesoura";
            String value = JOptionPane.showInputDialog(null,text,
                    "");

            if(value!=null && value.matches("^[0-3]{0,1}")) {
                if(value.equals("0")) {
                    setSair(true);
                    break;
                }
                Escolha escolha = value.equals("1") ? Escolha.PEDRA : (
                            value.equals("2") ? Escolha.PAPEL : Escolha.TESOURA       );
                changeState(escolha);
                break;
            }
            else {
                JOptionPane.showMessageDialog(null, "Parametro invalido, tente novamente");
                i=-1;
            }
        }
        return null;
    }

    public void changeState(Escolha escolha){
        setChanged();
        notifyObservers(escolha);
    }
}
