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
public class Nodo {
    int numero;
    ArrayList<Nodo> vizinhos = new ArrayList<>();
    char peca;
    
    public Nodo(int num){
        numero=num;
    }

}
