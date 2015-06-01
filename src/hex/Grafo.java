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
public class Grafo {
    ArrayList<Nodo> tabuleiro;
    Grafo(){
        tabuleiro = new ArrayList<>();
        Nodo a0 = new Nodo(0);Nodo a13 = new Nodo(13);
        Nodo a1 = new Nodo(1);Nodo a14 = new Nodo(14);
        Nodo a2 = new Nodo(2);Nodo a15 = new Nodo(15);
        Nodo a3 = new Nodo(3);//Nodo q = new Nodo(1);
        Nodo a4 = new Nodo(4);//Nodo r = new Nodo(1);
        Nodo a5 = new Nodo(5);//Nodo s = new Nodo(1);
        Nodo a6 = new Nodo(6);//Nodo t = new Nodo(1);
        Nodo a7 = new Nodo(7);//Nodo u = new Nodo(1);
        Nodo a8 = new Nodo(8);//Nodo v = new Nodo(1);
        Nodo a9 = new Nodo(9);//Nodo w = new Nodo(1);
        Nodo a10 = new Nodo(10);//Nodo x = new Nodo(1);
        Nodo a11 = new Nodo(11);//Nodo y = new Nodo(1);
        Nodo a12 = new Nodo(12);
        
        tabuleiro.add(a0);
        tabuleiro.add(a1);
        tabuleiro.add(a2);
        tabuleiro.add(a3);//tabuleiro.add(q);
        tabuleiro.add(a4);//tabuleiro.add(r);
        tabuleiro.add(a5);//tabuleiro.add(s);
        tabuleiro.add(a6);//tabuleiro.add(t);
        tabuleiro.add(a7);//tabuleiro.add(u);
        tabuleiro.add(a8);//tabuleiro.add(v);
        tabuleiro.add(a9);//tabuleiro.add(w);
        tabuleiro.add(a10);//tabuleiro.add(x);
        tabuleiro.add(a11);//tabuleiro.add(y);
        tabuleiro.add(a12);
        tabuleiro.add(a13);
        tabuleiro.add(a14);
        tabuleiro.add(a15);
        
        //adicionando vizinhos.
        
        tabuleiro.get(0).vizinhos.add(a4);
        tabuleiro.get(0).vizinhos.add(a1);
        tabuleiro.get(1).vizinhos.add(a0);
        tabuleiro.get(1).vizinhos.add(a4);
        tabuleiro.get(1).vizinhos.add(a5);
        tabuleiro.get(1).vizinhos.add(a2);
        tabuleiro.get(2).vizinhos.add(a1);
        tabuleiro.get(2).vizinhos.add(a5);
        tabuleiro.get(2).vizinhos.add(a6);
        tabuleiro.get(2).vizinhos.add(a3);
        tabuleiro.get(3).vizinhos.add(a2);
        tabuleiro.get(3).vizinhos.add(a6);
        tabuleiro.get(3).vizinhos.add(a7);
        tabuleiro.get(4).vizinhos.add(a0);
        tabuleiro.get(4).vizinhos.add(a1);
        tabuleiro.get(4).vizinhos.add(a5);
        tabuleiro.get(4).vizinhos.add(a8);
        tabuleiro.get(5).vizinhos.add(a4);
        tabuleiro.get(5).vizinhos.add(a1);
        tabuleiro.get(5).vizinhos.add(a2);
        tabuleiro.get(5).vizinhos.add(a6);
        tabuleiro.get(5).vizinhos.add(a8);
        tabuleiro.get(5).vizinhos.add(a9);
        tabuleiro.get(6).vizinhos.add(a5);
        tabuleiro.get(6).vizinhos.add(a2);
        tabuleiro.get(6).vizinhos.add(a3);
        tabuleiro.get(6).vizinhos.add(a7);
        tabuleiro.get(6).vizinhos.add(a9);
        tabuleiro.get(6).vizinhos.add(a10);
        tabuleiro.get(7).vizinhos.add(a3);
        tabuleiro.get(7).vizinhos.add(a6);
        tabuleiro.get(7).vizinhos.add(a10);
        tabuleiro.get(7).vizinhos.add(a11);
        tabuleiro.get(8).vizinhos.add(a4);
        tabuleiro.get(8).vizinhos.add(a5);
        tabuleiro.get(8).vizinhos.add(a9);
        tabuleiro.get(8).vizinhos.add(a12);
        tabuleiro.get(9).vizinhos.add(a8);
        tabuleiro.get(9).vizinhos.add(a5);
        tabuleiro.get(9).vizinhos.add(a6);
        tabuleiro.get(9).vizinhos.add(a10);
        tabuleiro.get(9).vizinhos.add(a12);
        tabuleiro.get(9).vizinhos.add(a13);
        tabuleiro.get(10).vizinhos.add(a9);
        tabuleiro.get(10).vizinhos.add(a6);
        tabuleiro.get(10).vizinhos.add(a7);
        tabuleiro.get(10).vizinhos.add(a11);
        tabuleiro.get(10).vizinhos.add(a13);
        tabuleiro.get(10).vizinhos.add(a14);
        tabuleiro.get(11).vizinhos.add(a7);
        tabuleiro.get(11).vizinhos.add(a10);
        tabuleiro.get(11).vizinhos.add(a14);
        tabuleiro.get(11).vizinhos.add(a15);
        tabuleiro.get(12).vizinhos.add(a8);
        tabuleiro.get(12).vizinhos.add(a9);
        tabuleiro.get(12).vizinhos.add(a13);
        tabuleiro.get(13).vizinhos.add(a12);
        tabuleiro.get(13).vizinhos.add(a9);
        tabuleiro.get(13).vizinhos.add(a10);
        tabuleiro.get(13).vizinhos.add(a14);
        tabuleiro.get(14).vizinhos.add(a13);
        tabuleiro.get(14).vizinhos.add(a10);
        tabuleiro.get(14).vizinhos.add(a11);
        tabuleiro.get(14).vizinhos.add(a15);
        tabuleiro.get(15).vizinhos.add(a11);
        tabuleiro.get(15).vizinhos.add(a14);
    }

    
    
}
