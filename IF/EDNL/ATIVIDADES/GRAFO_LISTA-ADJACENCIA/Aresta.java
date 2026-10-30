import java.util.Objects;

public class Aresta<T>{

    private String id;
    private Vertice<T> vOrigem;
    private Vertice<T> vDestino;
    private T dado;
    private boolean ehDirecionada;


    public Aresta(String id, Vertice<T> v1, Vertice<T> v2, boolean direcionada){

        this(id, v1, v2,null, false);
    }

    public Aresta(String id, Vertice<T> v1, Vertice<T> v2, T dado, boolean direcionada){
        this.id = id;
        this.vOrigem = v1;
        this.vDestino = v2;
        this.dado = dado;
        this.ehDirecionada = direcionada;
    }

    public String getId(){
        return  this.id;
    }

    public void setId(String novoId){
        this.id = novoId;
    }

    public T getDado(){
        return this.dado;
    }

    public void setDado(T novoDado){
        this.dado = novoDado;
    }

    public Vertice<T> getVerticeOrigem(){
        return  this.vOrigem;
    }

    public void setVerticeOrigem(Vertice<T> novaOrigem){
        this.vOrigem = novaOrigem;
    }

    public Vertice<T> getVerticeDestino(){
        return this.vDestino;
    }

    public void setVerticeDestino(Vertice<T> novoDestino){
        this.vDestino = novoDestino;
    }

    public boolean getDirecao(){
        return this.ehDirecionada;
    }

    public void setDirecionamento(boolean direcionamento){
        this.ehDirecionada = direcionamento;
    }

    @Override 
    public boolean equals(Object objeto){
        if(this == objeto) return true;
        if(objeto == null || getClass() != objeto.getClass()) return false;
        Aresta<?> aresta = (Aresta<?> ) objeto;
        return Objects.equals(id, aresta.id);
    }

    @Override 
    public int hashCode(){
        return  Objects.hash(id);
    }

    @Override 
    public String toString(){
        String conector = ehDirecionada ? "->" : "--";
        return id + ": " + vOrigem.getId() + conector + vDestino.getId() + (dado != null ? " [" + dado + "] " : " ");
    }


}