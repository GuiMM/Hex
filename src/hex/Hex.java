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
    
    public boolean horizontalGanhou(Grafo g){
        boolean ganhou=false;
        ArrayList<Integer> visitados = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
           if (g.tabuleiro.get(i*4).peca=='h') {
               if(temCaminhoHorizontal( g.tabuleiro.get(i*4),visitados)){
                ganhou=true;
               } 
            }
        }
        
        return ganhou;
    }
    public boolean verticalGanhou(Grafo g){
        boolean ganhou=false;
        ArrayList<Integer> visitados = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            if (g.tabuleiro.get(i).peca=='v') {
               if(temCaminhoVertical(g.tabuleiro.get(i),visitados)){
                ganhou=true;
               } 
            }
           
        }
        
        return ganhou;
    }

    /**
     * @param args the command line arguments
     */
    

    private boolean temCaminhoHorizontal( Nodo atual,ArrayList<Integer> visitados) {
        //busca do caminho
        boolean chegouDoOutrolado = false;
        visitados.add(atual.numero);                                                //bota o vertice atual na lista de vertices já visitados.
        ArrayList<Nodo> fronteira;
        if (nivelColuna(atual.numero)==3) {
            return true;
        }
        fronteira = fronteiraPeca(atual,'h');                                       //analisa as fronteiras do nó atual, em busca do tipo de peça passado.
        fronteira = eliminaVisitados(fronteira,visitados);
        
        for (Nodo vizinhoDeAtual: fronteira) {                                      //passando por todos os vizinhos do no atual.
               chegouDoOutrolado = temCaminhoHorizontal( vizinhoDeAtual,visitados); 
               if (chegouDoOutrolado) {                                             //obriga a retornar caso encontre um caminho valido                    
                break;
                }
        }
        return chegouDoOutrolado;
    }
    
    private ArrayList<Nodo> fronteiraPeca(Nodo atual, char tipo) {
        ArrayList<Nodo> fronteira = new ArrayList<>();                              //guardará os vértices que fazem fronteira com o vertice atual
        
        for (Nodo v: atual.vizinhos) {                                              //passando por todos os vizinhos do no atual.
            if (v.peca==tipo) {
                fronteira.add(v);                                                   //colhe o no cuja peca é a horizontal.
            }
            
        }
        return fronteira;
    }

    private ArrayList<Nodo> eliminaVisitados(ArrayList<Nodo> fronteira, ArrayList<Integer> visitados) {
         ArrayList<Nodo> novaFronteira = new ArrayList<Nodo>();                                
         
         for (Nodo a: fronteira) {                                                  //passando por todos os vertices da fronteira
            novaFronteira.add(a);
             for (Integer b: visitados) {                                           //se o vertice 'a' em fronteira ja foi visitado ele nao fara mais parte da fronteira...
                if (a.numero==b) {
                    novaFronteira.remove(a);
                }
            }
        }
         return novaFronteira;
    }

    private int nivelColuna(int i) {
        return i%4;
    }
    private int nivelLinha(int i) {
        return i/4;
    }

    private boolean temCaminhoVertical(Nodo atual, ArrayList<Integer> visitados) {
         //busca do caminho
        boolean chegouDoOutrolado = false;
        visitados.add(atual.numero);                                                //bota o vertice atual na lista de vertices já visitados.
        ArrayList<Nodo> fronteira;
        if (nivelLinha(atual.numero)==3) {
            return true;
        }
        fronteira = fronteiraPeca(atual,'v');                                       //analisa as fronteiras do nó atual, em busca do tipo de peça passado.
        fronteira = eliminaVisitados(fronteira,visitados);
        
        for (Nodo vizinhoDeAtual: fronteira) {                                      //passando por todos os vizinhos do no atual.
            chegouDoOutrolado = temCaminhoVertical(vizinhoDeAtual,visitados); 
            if (chegouDoOutrolado) {                                                //obriga a retornar caso encontre um caminho valido
                break;
            }   
        }
        return chegouDoOutrolado;
    }
    
    
}
