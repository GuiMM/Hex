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
        Nodo a = new Nodo(0);Nodo n = new Nodo(13);
        Nodo b = new Nodo(1);Nodo o = new Nodo(14);
        Nodo c = new Nodo(2);Nodo p = new Nodo(15);
        Nodo d = new Nodo(3);//Nodo q = new Nodo(1);
        Nodo e = new Nodo(4);//Nodo r = new Nodo(1);
        Nodo f = new Nodo(5);//Nodo s = new Nodo(1);
        Nodo g = new Nodo(6);//Nodo t = new Nodo(1);
        Nodo h = new Nodo(7);//Nodo u = new Nodo(1);
        Nodo i = new Nodo(8);//Nodo v = new Nodo(1);
        Nodo j = new Nodo(9);//Nodo w = new Nodo(1);
        Nodo k = new Nodo(10);//Nodo x = new Nodo(1);
        Nodo l = new Nodo(11);//Nodo y = new Nodo(1);
        Nodo m = new Nodo(12);
        
        tabuleiro.add(a);tabuleiro.add(n);
        tabuleiro.add(b);tabuleiro.add(o);
        tabuleiro.add(c);tabuleiro.add(p);
        tabuleiro.add(d);//tabuleiro.add(q);
        tabuleiro.add(e);//tabuleiro.add(r);
        tabuleiro.add(f);//tabuleiro.add(s);
        tabuleiro.add(g);//tabuleiro.add(t);
        tabuleiro.add(h);//tabuleiro.add(u);
        tabuleiro.add(i);//tabuleiro.add(v);
        tabuleiro.add(j);//tabuleiro.add(w);
        tabuleiro.add(k);//tabuleiro.add(x);
        tabuleiro.add(l);//tabuleiro.add(y);
        tabuleiro.add(m);
        
    }
    
}
