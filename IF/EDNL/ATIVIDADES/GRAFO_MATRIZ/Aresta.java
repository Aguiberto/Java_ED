package IF.EDNL.ATIVIDADES.GRAFO_MATRIZ;

public class Aresta {
    
    private String id;
    private String nome;
    private Vertice vOrigem;
    private Vertice vDestino;
    private boolean direcionada;

    public Aresta( String id, Vertice origem, Vertice destino, boolean direcionada){
        this.id = id;
        this.vOrigem = origem;
        this.vDestino = destino;
        this.direcionada = direcionada;
    }
    
    // verifica se um vertice pertence a aresta
    public boolean contemVertice(Vertice vertice){
        return vOrigem.equals(vertice) || vDestino.equals(vertice);
    }

    public boolean isDirecionada(){
        return this.direcionada;
    }

    public String getId(){
        return this.id;
    }

    public Vertice getVOrigem(){
        return this.vOrigem;
    }

    public Vertice getVDestino(){
        return this.vDestino;
    }

    public void setId(String novoId){
        this.id = novoId;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String novoNome){
        this.nome = novoNome;
    }
}
