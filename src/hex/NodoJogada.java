/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hex;

import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class NodoJogada {
    Grafo jogada;
    int score;
    ArrayList<Grafo> proximas_Jogadas;
    ArrayList<Integer> scores;
    public NodoJogada(Grafo jogada){
        proximas_Jogadas = new ArrayList<>();
        this.jogada = jogada;
    
    }
    
}
