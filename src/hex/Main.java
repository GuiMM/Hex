/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hex;

import java.util.ArrayList;

/**
 *
 * @author MQGuilherme
 */
public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Hex jogo = new Hex();
        grafo.tabuleiro.get(4).peca='h';
        grafo.tabuleiro.get(1).peca='h';
        grafo.tabuleiro.get(5).peca='h';
        grafo.tabuleiro.get(2).peca='h';
        grafo.tabuleiro.get(6).peca='h';
        grafo.tabuleiro.get(10).peca='h';
        grafo.tabuleiro.get(7).peca='h';
        grafo.tabuleiro.get(2).peca='v';
        grafo.tabuleiro.get(5).peca='h';
        grafo.tabuleiro.get(9).peca='v';
        grafo.tabuleiro.get(10).peca='v';
        grafo.tabuleiro.get(11).peca='v';
        grafo.tabuleiro.get(13).peca='v';
        //ArrayList<Grafo> aux = new ArrayList<>();
        //aux = jogo.gerarJogadas(grafo, 'v');
        System.out.println(jogo.verticalGanhou(grafo));
        System.out.println(jogo.horizontalGanhou(grafo));
    }
}
