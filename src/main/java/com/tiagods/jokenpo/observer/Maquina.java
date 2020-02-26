package com.tiagods.jokenpo.observer;

import com.tiagods.jokenpo.enums.Escolha;
import com.tiagods.jokenpo.observer.model.Jogador;
import com.tiagods.jokenpo.enums.Resultado;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class Maquina implements Observer, Jogador {

    Resultado resultado = Resultado.EMPATE;

    @Override
    public Escolha joga() {
        return Escolha.getRandom();
    }
    @Override
    public String getNome() {
        return "Robo";
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado=resultado;
    }

    public void update(Observable arg0, Object arg1) {
        Humano observado = (Humano) arg0;
        Escolha humano = Escolha.valueOf(arg1.toString());

        Escolha maquina = joga();

        Resultado resultado = Resultado.EMPATE;
        if(humano==maquina){
            this.setResultado(Resultado.EMPATE);
        }
        else if(maquina==Escolha.PEDRA && humano==Escolha.TESOURA
        || maquina==Escolha.PAPEL && humano==Escolha.PEDRA
        || maquina==Escolha.TESOURA && humano==Escolha.PAPEL
        ){
            this.setResultado(Resultado.GANHOU);
            resultado = Resultado.PERDEU;
        }
        else{
            this.setResultado(Resultado.PERDEU);
            resultado = Resultado.GANHOU;
        }
        JOptionPane.showMessageDialog(null, "Você escolheu "+ humano+"!!!\nMaquina escolheu : "+maquina+"\nResultado, você:"+resultado.toString());
    }
}
