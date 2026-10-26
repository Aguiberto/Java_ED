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
    public void substituirNaAresta(Aresta aresta, String novoId){

        if(aresta == null){
            throw new IllegalArgumentException("Aresta não pode ser nula");
        }    

        aresta.setId(novoId);
    }

    public void inserirVertice(String nome){

        if(vertices.size() >= numVertices){
            redimencionarMatriz(numVertices+1);
        }

        int novoIndice = vertices.size();
        Vertice novoVertice = new Vertice(novoIndice, nome);
        vertices.add(novoVertice);
    }

    // leva em consideração um grafo direcionado (apenas uma insereção na matriz)
    public void inserirAresta(String id, Vertice vOrigem, Vertice vDestino, boolean direcionada){

        if(vOrigem == null || vDestino == null){
            throw new IllegalArgumentException("Vertices não podem ser nulos");
        }

        int origem = vOrigem.getIndice();
        int destino = vDestino.getIndice();

        Aresta novAresta = new Aresta(id, vOrigem, vDestino, direcionada);

        matrizAdjacencia[origem][destino].add(novAresta);

        if(!direcionada && origem != destino){
            matrizAdjacencia[destino][origem].add(novAresta);
        }
    }

    // ao remover um vertice a coluna e a linha 
    public boolean removerVertice(Vertice vertice){

        if(vertice == null || !vertices.contains(vertice)){
            return false;
        }

        int idxRemover = vertice.getIndice();

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
