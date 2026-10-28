package IF.EDNL.ATIVIDADES.GRAFO_MATRIZ;

/*O GRAFO IMPLEMENTADO É DO TIPO
 MULTIGRAFO: PODECONTER LAÇOS E 
 ARESTAS PARALELAS */

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Grafo {
    
    private List<Vertice> vertices;
    private List<Aresta> [][] matrizAdjacencia;
    private int numVertices;

    public Grafo(int numVertices){

        this.numVertices = numVertices;
        this.vertices = new ArrayList<>();

        this.matrizAdjacencia = new ArrayList[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++){
            for( int j = 0; j < numVertices; j++){
                matrizAdjacencia[i][j] = new ArrayList<>();
            }
        }

    }
    
    // retorna uma lista de vertices final da aresta
    public Vertice finalVertice(Aresta aresta){
        
        if(aresta == null){
            throw new  IllegalArgumentException("A aresta não pode ser nula.");
        }
        return aresta.getVDestino();
    }

    public Vertice verticeOposto(Vertice vertice, Aresta aresta){

        if( vertice == null || aresta == null){
            throw new IllegalArgumentException(" Vertice ou Aresta não podem ser nulos");
        }

        Vertice origem = aresta.getVOrigem();
        Vertice destino = aresta.getVDestino();

        if(vertice.equals(origem)){
            return destino;

        } else if(vertice.equals(destino)){
            return  origem;

        }else{
            throw new IllegalArgumentException(" O vértice informado não pertence a esta aresta");
        }
    }

    // pode ser aplicado para um grafo direcionado ou não direcionado
    public boolean eAdjacente(Vertice vertice1, Vertice vertice2){
        
        if( vertice1 == null || vertice2 == null){
            throw new IllegalArgumentException("Os vertices não podem ser nulos");
        }

        int primeiroV = vertice1.getIndice();
        int segundoV = vertice2.getIndice();

        boolean existeNaIda = !matrizAdjacencia[primeiroV][segundoV].isEmpty();
        boolean existeNaVolta = !matrizAdjacencia[segundoV][primeiroV].isEmpty();

        return existeNaIda || existeNaVolta;
    }

    // método usado para alterar o valor do vértice(no caso o nome)
    public void substituirNoVertice(Vertice vertice , String novoNome){

        if(vertice == null){
            throw new IllegalArgumentException("Vértice não pode ser nulo");
        }

        vertice.setNome(novoNome);
    }

    // método usado para alterar o valor de uma aresta(no caso o nome)
    public void substituirNaAresta(Aresta aresta, String novoNome){

        if(aresta == null){
            throw new IllegalArgumentException("Aresta não pode ser nula");
        }    

        aresta.setNome(novoNome);
    }

    public Vertice inserirVertice(String nome){

        if(vertices.size() >= numVertices){
            redimencionarMatriz(numVertices+1);
        }

        int novoIndice = vertices.size();
        Vertice novoVertice = new Vertice(novoIndice, nome);
        vertices.add(novoVertice);

        return novoVertice;
    }

    // leva em consideração um grafo direcionado (apenas uma insereção na matriz)
    public Aresta inserirAresta(int id,String nome, Vertice vOrigem, Vertice vDestino, boolean direcionada){

        if(vOrigem == null || vDestino == null){
            throw new IllegalArgumentException("Vertices não podem ser nulos");
        } 

        int origem = vOrigem.getIndice(); 
        int destino = vDestino.getIndice();

        Aresta novaAresta = new Aresta(id,nome, vOrigem , vDestino, direcionada);

        matrizAdjacencia[origem][destino].add(novaAresta);
 
        if(!direcionada && origem != destino){
            matrizAdjacencia[destino][origem].add(novaAresta);
        }

        return novaAresta;
    }

    // ao remover um vertice a coluna e a linha 
    public boolean removerVertice(Vertice vertice){
        
        // verifica se o vertice é nulo ou se não existe
        if(vertice == null || !vertices.contains(vertice)){
            return false;
        }

        int idxVerticeRemovido = vertice.getIndice();
        int totalAnterior = vertices.size();

        //remove o vertice buscando pelo seu índice na lista
        this.vertices.remove(idxVerticeRemovido);

        //ajusta os índices dos vertices que estavam a frente do vertice removido
        for(int i = idxVerticeRemovido; i < vertices.size(); i++){
            vertices.get(i).setIndice(i);
        }

        // Ajusta as linhas para cima
        for(int i= idxVerticeRemovido; i < totalAnterior -1; i++){
            for(int j = 0; j < totalAnterior; j++){
                matrizAdjacencia[i][j] = matrizAdjacencia[i+1][j];          // a linha removida recebe a linha de baixo
            }
        }

        // Ajusta as colunas para a esquerda
        for(int j = idxVerticeRemovido; j < totalAnterior -1; j++){
            for(int i = 0; i < totalAnterior; i++){
                matrizAdjacencia[i][j] = matrizAdjacencia[i][j+1];            // a coluna removida recebe a coluna da direita
            }
        }

        // limpa a antiga ultima posição
        int ultimoIdx = totalAnterior -1;
        for(int k = 0; k < totalAnterior; k++){
            matrizAdjacencia[ultimoIdx][k] = new ArrayList<>();             // limpa a linha guardando um array vazio
            matrizAdjacencia[k][ultimoIdx] = new ArrayList<>();             // limpa a coluna guardando um array vazio
        }

        return true;

    }

    public boolean removerAresta(Aresta aresta){

        if(aresta == null){
            return false;
        }

        int i = aresta.getVOrigem().getIndice();
        int j = aresta.getVDestino().getIndice();

        // remove a aresta no sentido direto
        boolean removida = matrizAdjacencia[i][j].remove(aresta);

        // remove no sentido inverso caso a aresta seja não direcionada
        if(removida && !aresta.isDirecionada() && i != j){
            matrizAdjacencia[j][i].remove(aresta);
        }

        return removida;
    }

    public void imprimirMatriz(){
        
        int qtdVertices = this.vertices.size();

        if(qtdVertices == 0){
            System.out.println("O grafo está vazio");
            return;
        }

        System.out.println(" ----------------- GRAFO: MATRIZ DE ADJACÊNCIA -------------------");

        System.out.printf("            ");
        for(Vertice v : this.vertices){
            System.out.printf("%-12s", v.getNome());
        }
        System.out.println();

        for(int i= 0; i < qtdVertices; i++){
            System.out.printf("%-12s",vertices.get(i).getNome());

            for(int j = 0; j < qtdVertices; j++){
               
                int qtdArestas = this.matrizAdjacencia[i][j].size();

                System.out.printf("%-12d",qtdArestas);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------\n");
    }

    // ========= MÉTODOS AUXILIARES ========

    public List<Vertice> getVertice(){
        return this.vertices;
    }

    public List<Aresta>[][] getMatriz(){
        return  this.matrizAdjacencia;
    }

    private void redimencionarMatriz(int novaCapacidade){

        List<Aresta>[][] novaMatriz = new ArrayList[novaCapacidade][novaCapacidade];

        for( int i = 0; i< novaCapacidade; i++){
            for(int j = 0; j < novaCapacidade; j++){
                novaMatriz[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < numVertices; i++){
            for( int j = 0; j < numVertices; j++){
                novaMatriz[i][j] = matrizAdjacencia[i][j];
            }
        }

        this.matrizAdjacencia = novaMatriz;
        this.numVertices = novaCapacidade;
    }

    // =====================================
    //              ITERADORES  
    // =====================================
    
    private Iterator<Aresta> arestasIncidentes(Vertice vertice){

        List<Aresta> incidentes = new ArrayList<>();
        int idx = vertice.getIndice();

        for(int j = 0; j < numVertices; j++){
            incidentes.addAll(matrizAdjacencia[idx][j]);
        }

        for(int i = 0; i < numVertices; i++){
            if( i != idx){
                incidentes.addAll(matrizAdjacencia[i][idx]);
            }
        }

        return incidentes.iterator();
    }

    private Iterator<Vertice> vertices(){
        return  vertices.iterator();

    }

    private Iterator<Aresta> arestas(){
        List<Aresta> todasArestas = new ArrayList<>();

        for(int i = 0; i < numVertices; i++){
            for(int j = 0; j < numVertices; j++){
                todasArestas.addAll(matrizAdjacencia[i][j]);
            }
        }

        return  todasArestas.iterator();
    }
}
