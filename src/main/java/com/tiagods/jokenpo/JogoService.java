package com.tiagods.jokenpo;

import com.tiagods.jokenpo.enums.Resultado;
import com.tiagods.jokenpo.observer.Humano;
import com.tiagods.jokenpo.observer.Maquina;
import com.tiagods.jokenpo.observer.model.Jogador;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class JogoService {


    public void comecarJogo(String nome){
        Map<Integer, Jogador> map = new HashMap<>();
        Humano humano = new Humano(nome);
        Maquina maquina =  new Maquina();
        humano.addObserver(maquina);
        int i = 1;
        while(i <= 10){
            if(humano.isSair()) break;
            humano.joga();
            Resultado resultadoMaquina = maquina.getResultado();
            map.put(i, verificarQuemGanhou(resultadoMaquina,maquina,humano));
            i++;
        }
        print(map);
    }

    /**
     *
     * @param resultadoMaquina verifica se a maquina ganhou ou perdeu
     * @param maquina Jogador
     * @param humano Jogador
     * @return Jogador que ganhou, em caso de empate, null
     */
    public static Jogador verificarQuemGanhou(Resultado resultadoMaquina, Maquina maquina, Humano humano){
        return resultadoMaquina.equals(Resultado.GANHOU) ? maquina : (
                resultadoMaquina.equals(Resultado.PERDEU)? humano : null
        );
    }

    /**
     * @param map
     * Enviar lista para impressao
     */
    public void print(Map<Integer, Jogador> map){
        int jogador1 = 0;
        int jogador2 = 0;

        StringBuilder builder = new StringBuilder();
        for(int c : map.keySet()){
            Object object = map.get(c)==null?Resultado.EMPATE:map.get(c);
            String toString = (object instanceof Resultado) ? Resultado.EMPATE.toString(): ((Jogador)object).getNome();
            builder.append("Jogada : "+c).append("\t Resultado: "+ toString+"\n");
            if(object instanceof Humano) jogador1 += 1;
            else if(object instanceof Maquina) jogador2 +=1;
        };
        Resultado resultadoFinal = jogador1>jogador2?Resultado.GANHOU:(
                jogador1==jogador2?Resultado.EMPATE:Resultado.PERDEU
        );
        builder.append("Resultado final! Voce=" +jogador1+"\t Maquina: " +jogador2+"\n");
        builder.append(resultadoFinal.equals(Resultado.GANHOU)?"Parabens você ganhou!":(
                resultadoFinal.equals(Resultado.EMPATE)?"Empatou":"Que pena, você perdeu"
        ));
        JOptionPane.showMessageDialog(null, builder.toString());
    }
}
