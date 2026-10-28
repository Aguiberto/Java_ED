import java.util.*;

public class GrafoListaAdjacencia<T> {

    private Map< Vertice<T>, List<Aresta<T>> > listaAdjacencias;

    public GrafoListaAdjacencia(){
        this.listaAdjacencias = new HashMap<>() ;
    }

    public void inserirVertice(Vertice<T> vertice){

        if(vertice == null){
            throw new IllegalArgumentException("Vértice não pode ser nulo!");
        }

        if(!listaAdjacencias.containsKey(vertice)){
            listaAdjacencias.put(vertice, new ArrayList<>());
        }
    }

    public void inserirAresta(Aresta<T> aresta){

        if(aresta == null){
            throw new IllegalArgumentException("Aresta nula, insira uma aresta válida");
        }

        Vertice<T> origem = aresta.getVerticeOrigem();
        Vertice<T> destino = aresta.getVerticeDestino();

        // Adiciona a aresta ao vértice de origem (chave)
        listaAdjacencias.get(origem).add(aresta);

        if(!aresta.getDirecao()){
            listaAdjacencias.get(destino).add(aresta);
        }

    }

    public List<Vertice<T>> finalVertice(Aresta<T> aresta){

        if(aresta == null){
            return Collections.emptyList();
        }

        List<Vertice<T>> verticesFinais = new ArrayList<>();
        verticesFinais.add(aresta.getVerticeOrigem());
        verticesFinais.add(aresta.getVerticeDestino());
  
        return verticesFinais;
    }

    public Vertice<T> oposto(Vertice<T> vertice, Aresta<T> aresta){

        if(vertice == null || aresta == null){
            throw new IllegalArgumentException("O vértice ou aresta nulo");
        }

        Vertice<T> origem = aresta.getVerticeOrigem();
        Vertice<T> destino = aresta.getVerticeDestino();

        if(vertice.equals(origem)){
            return destino;

        }else if( vertice.equals(destino)){
            return origem;

        }else{
            throw new IllegalArgumentException("O vertice informado não pertence a aresta");
        }
    }

    public boolean ehAdjacente(Vertice<T> v1, Vertice<T> v2){

        if(v1 == null || v2 == null){
            throw new IllegalArgumentException("Os vertices não podem ser nulos");
        }

        List<Aresta<T>> arestasV1 = listaAdjacencias.get(v1);

        if(arestasV1 == null || arestasV1.isEmpty()){
            return  false;
        }

        for(Aresta<T> aresta : arestasV1){
            
            // Verifica se os vertices são adjacentes para arestas direcionadas
            if(aresta.getDirecao()){

                if(aresta.getVerticeOrigem().equals(v1) && aresta.getVerticeDestino().equals(v2)){
                    return true;
                }
            
            // Se não for direcionada
            }else{

                Vertice<T> origem = aresta.getVerticeOrigem();
                Vertice<T> destino = aresta.getVerticeDestino();

                if((origem.equals(v1)) && destino.equals(v2) || (origem.equals(v2) && destino.equals(v1))){
                    return true;
                }
            }
        }

        return false;
    }


    

}
