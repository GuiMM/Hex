/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hex;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class Hex {
    
    public NodoJogada MinMax(Grafo jogada, int profundidade , char jogador){
        NodoJogada novo = new NodoJogada(jogada);
        if (profundidade==10) {
            novo.score = 0;
            return novo;
        }
        if (horizontalGanhou(jogada)) {                                         //
            novo.score = -1;
            return novo;
        }
        if (verticalGanhou(jogada)) {
            novo.score = 1;
            return novo;
        }
        
        //se o jogador for a maquina, ele segue a heuristica das pontes, se nao puder mais formarmos pontes, nós geramos peças aleatoriamente...(esta heuristica trabalha depois da primeira jogada)
        ArrayList<Grafo> possiveisJogadas = null;
        if (jogador == 'v' & profundidade>1) {
            possiveisJogadas = heuristicaPontes(jogada , jogador);
        }
        if (jogador == 'v' & profundidade<=1) {
            possiveisJogadas = primeiraJogadaMaquina(jogada , jogador);
        }
       
        if (possiveisJogadas==null) {
            possiveisJogadas = gerarJogadas(jogada, jogador);
        }
        //se o jogador for a maquina, ele segue a heuristica das pontes, se nao puder mais formarmos pontes, nós geramos peças aleatoriamente...
        
        
        //construindo, para todos os grafos retornados, um objeto NodoJogada.   
        for (int i = 0; i <possiveisJogadas.size(); i++) {
            NodoJogada novoFilho = new NodoJogada(possiveisJogadas.get(i));
            novo.proximas_Jogadas.add(novoFilho);
        }
        
        //chamndo o codigo de novo
        for (int i = 0; i < novo.proximas_Jogadas.size(); i++) {
            if (jogador == 'h'){
                //System.out.println("to aqui chamndo pra v");
                int auxScore = MinMax(novo.proximas_Jogadas.get(i).jogada,profundidade+1,'v').score;
                novo.scores.add(auxScore);
            }else{
                //System.out.println("to aqui chamndo pra h");
                int auxScore = MinMax(novo.proximas_Jogadas.get(i).jogada,profundidade+1,'h').score;
                novo.scores.add(auxScore);
            }
            
            //aqui a gente faz a poda
            if (jogador=='v' && novo.scores.get(i)==-1) {
                novo.score=1;
                return novo;
            }else
                if (jogador=='h'&& novo.scores.get(i)==-1) {
                    novo.score = -1;
                    return novo;
            }
        }
        if (profundidade%2==0) {                                                //par é máx
            int maiorScore = maximoScore(novo.scores);
            novo.score = maiorScore;
        //    System.out.println("to aqui pegando o maiorScore");
        }
        else {
            int menorScore = minimoScore(novo.scores);                          //min é impar
            novo.score = menorScore;
            //System.out.println("to aqui pegando o menor score");
        }
        //System.out.println("to aqui retornando");    
        return novo;
    }
    
    public void start(Grafo inicio){
        //implementar o jogo. Minmax ta pronto(mas falta debugar).
        boolean jogarNovamente =true;
        Grafo jogo = new Grafo();
        NodoJogada arvoreMinMax;
        char pecaHumano;
        boolean alguemGanhou = false;
        Scanner tec = new Scanner(System.in);
        int jogadaHumano;
        System.out.println("vc vai jogar com a peça h ");
        pecaHumano = 'h';
        
        
        do{ //quer jogar de novo?
            //primeira jogada do humano 
             System.out.println("escolha uma posição para sua jogada");
             jogadaHumano = tec.nextInt();
             while (jogo.tabuleiro.get(jogadaHumano).peca!= ' ' || jogadaHumano>jogo.tabuleiro.size() || jogadaHumano<0) {   //pede outro digito até q seja valido
                 System.out.println("esta posição esta ocupada, faça outra jogada válida");
             }
             jogo.tabuleiro.get(jogadaHumano).peca=pecaHumano;
             arvoreMinMax = MinMax(jogo,0,'v');
        do{  //loop do jogo
            
            
            //jogada do computador
             int jogadaComputador = minimoScore(arvoreMinMax.scores);
             arvoreMinMax = arvoreMinMax.proximas_Jogadas.get(jogadaComputador);
             jogo.tabuleiro=arvoreMinMax.jogada.tabuleiro;
             
             if (horizontalGanhou(jogo)||verticalGanhou(jogo)) {
                 if ((horizontalGanhou(jogo) & pecaHumano=='h')||(verticalGanhou(jogo) & pecaHumano=='v')) {
                     System.out.println("Vc ganhou humano! ¬¬");
                 }else
                     System.out.println("eu ganhei fii.");
                 alguemGanhou =true;
            }
             
             //jogada do humano
             System.out.println("escolha uma posição para sua jogada");
             jogadaHumano = tec.nextInt();
             while (jogo.tabuleiro.get(jogadaHumano).peca!= ' ' || jogadaHumano>jogo.tabuleiro.size() || jogadaHumano<0) {   //pede outo digito até q seja valido
                 System.out.println("esta posição esta ocupada, faça outra jogada válida");
                 jogo.tabuleiro.get(jogadaHumano).peca=pecaHumano;
             }
            
             
        
        }while(!alguemGanhou);   
            System.out.println("quer jogar de novo? s/n");
            char resposta = tec.nextLine().charAt(0);
            if (resposta=='n') {
                jogarNovamente = false;
            }
        
        }while(jogarNovamente);
        
    
    }
    
    
    public boolean horizontalGanhou(Grafo g){
        
        boolean ganhou=false;
        try{
        ArrayList<Integer> visitados = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
           if (g.tabuleiro.get(i*4).peca=='h') {
               if(temCaminhoHorizontal( g.tabuleiro.get(i*4),visitados)){
                ganhou=true;
               } 
            }
        }
        }catch(Exception e){printGrafo(g);}
        return ganhou;
        
    }
    public boolean verticalGanhou(Grafo g){
        boolean ganhou=false;
        try{
        ArrayList<Integer> visitados = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            if (g.tabuleiro.get(i).peca=='v') {
               if(temCaminhoVertical(g.tabuleiro.get(i),visitados)){
                ganhou=true;
               } 
            }
           
        }
        }catch(Exception e){printGrafo(g);}
        return ganhou;
    }

    /**
     * @param args the command line arguments
     */
    

    private boolean temCaminhoHorizontal( Nodo atual,ArrayList<Integer> visitados)throws Exception{
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
    
    private ArrayList<Nodo> fronteiraPeca(Nodo atual, char tipo)throws Exception {
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

    private boolean temCaminhoVertical(Nodo atual, ArrayList<Integer> visitados)throws Exception {
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

    public ArrayList<Grafo> gerarJogadas(Grafo jogada, char jogador) {
        ArrayList<Grafo> jogadas = new ArrayList<>();
        for (int i = 0; i < jogada.tabuleiro.size(); i++) {
            if (jogada.tabuleiro.get(i).peca==' ') {
                jogada.tabuleiro.get(i).peca=jogador;
                Grafo novo =  jogada;
                novo = copiarGrafo(jogada);
                jogadas.add(novo);
                jogada.tabuleiro.get(i).peca=' ';
                
            }
        }
        return jogadas;
    }
    Grafo copiarGrafo(Grafo original) {
        Grafo copia = new Grafo();
        for (int i = 0; i <original.tabuleiro.size();i++) {
            copia.tabuleiro.get(i).peca = original.tabuleiro.get(i).peca;
        }
        return copia;
    }

    private int maximoScore(ArrayList<Integer> scores) {
        int maior = -1;
        for (int i = 0; i < scores.size(); i++) {
            if (maior<scores.get(i)) {
                maior=scores.get(i);
            }
        }
        return maior;
    }

    private int minimoScore(ArrayList<Integer> scores) {
         int menor = 1;
        for (int i = 0; i < scores.size(); i++) {
            if (menor>scores.get(i)) {
                menor=scores.get(i);
            }
        }
        return menor;
    }

    private ArrayList<Grafo> heuristicaPontes(Grafo jogada, char jogador) {
        ArrayList<Grafo> possiveisJogadas = new ArrayList<>();
        for (Nodo a:jogada.tabuleiro) {
            if (a.peca==jogador) {
                if (a.numero+5<jogada.tabuleiro.size()) {
                    jogada.tabuleiro.get(a.numero+5).peca=jogador;
                    Grafo novo;
                    novo = copiarGrafo(jogada);
                    possiveisJogadas.add(novo);
                    jogada.tabuleiro.get(a.numero+5).peca=' ';
                }
                if (a.numero-5>=0) {
                    jogada.tabuleiro.get(a.numero-5).peca=jogador;
                    Grafo novo;
                    novo = copiarGrafo(jogada);
                    possiveisJogadas.add(novo);
                    jogada.tabuleiro.get(a.numero-5).peca=' '; 
                }
                if (a.numero+7<jogada.tabuleiro.size()) {
                    jogada.tabuleiro.get(a.numero+7).peca=jogador;
                    Grafo novo;
                    novo = copiarGrafo(jogada);
                    possiveisJogadas.add(novo);
                    jogada.tabuleiro.get(a.numero+7).peca=' ';
                }
                if (a.numero-7>=0) {
                    jogada.tabuleiro.get(a.numero-7).peca=jogador;
                    Grafo novo;
                    novo = copiarGrafo(jogada);
                    possiveisJogadas.add(novo);
                    jogada.tabuleiro.get(a.numero-7).peca=' ';
                    
                }
            }
        }
        return possiveisJogadas;
    }

    private ArrayList<Grafo> primeiraJogadaMaquina(Grafo jogada, char jogador) {
        ArrayList<Grafo> jogadas = new ArrayList<>();
        int parametro = 0;                                                          //vamos usar este parametro para fazer a jogada inicial da maquina(será a posicao iniciaal do jogador humano)
        for (int i = 0; i < jogada.tabuleiro.size(); i++) {
            if (jogada.tabuleiro.get(i).peca=='h') {
                parametro = i;
                break;
            }
        }
                int geradorJogada = (int) Math.round( Math.random() *16 );
                while(nivelColuna(parametro)==nivelColuna(geradorJogada)){
                   geradorJogada  = (int)Math.random()*16; 
                
                }   
                jogada.tabuleiro.get(geradorJogada).peca=jogador;
                Grafo novo;
                novo = copiarGrafo(jogada);
                jogadas.add(novo);
                jogada.tabuleiro.get(geradorJogada).peca=' ';
        return jogadas;
    }

    private void printGrafo(Grafo g) {
        for (int i = 0; i < g.tabuleiro.size(); i++) {
            System.out.println(i+" = "+g.tabuleiro.get(i));
            System.out.println("");
        }
        
    }
    
    
}
