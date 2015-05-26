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
public class Hex {
    
    
    public boolean horizontalGanhou(){
        boolean ganhou=false;
        if(temCaminhoHorizontal()){
            ganhou=true;
        }
        
        return ganhou;
    }
    public boolean verticalGanhou(){
        boolean ganhou=false;
        if(temCaminhoVertical()){
            ganhou=true;
        }
        
        return ganhou;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        
    }

    private boolean temCaminhoHorizontal(Grafo grafo) {
        //busca do caminho
        ArrayList<Integer> caminhoPercorrido = new ArrayList<>();
        boolean chegouDoOutrolado = false;
        for (int i = 0; i < 4; i++) {
            if (grafo.tabuleiro.get(nivelColuna(i)).peca=='h') {
                caminhoPercorrido.add(i);
                for (int j = 0; j < ; j++) {
                    
                }
                    Node proxMarcado =
                    if (grafo.tabuleiro.get(nivelColuna(i)).peca=='h'){}
                    
                    if () {
                        chegouDoOutrolado=true;
                    }
                
                
                
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int nivelColuna(int i) {
        return i%4;
    }
    
}
