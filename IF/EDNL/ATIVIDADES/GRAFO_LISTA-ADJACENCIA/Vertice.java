import java.util.Objects;

public class Vertice<T> {
    
    private String id;
    private T dado;

    public Vertice(String id){
        this(id,null);
    }

    public Vertice(String id, T dado){

        if(id == null){
            throw new IllegalArgumentException("O informe o id do Vértice!");
        }

        this.id = id;
        this.dado = dado;
    }

    public String getId(){
        return this.id;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    @Override 
    public boolean equals(Object objeto){

        if(this == objeto) return true;
        if(objeto == null || getClass() != objeto.getClass()) return false;
        Vertice<?> vertice = (Vertice<?>) objeto;
        return Objects.equals(id, vertice.id);
    }

    @Override 
    public int hashCode(){
        return Objects.hash(id);
    }
    
    @Override 
    public String toString(){
        return id + (dado != null ? " (" + dado + ")":" ");
    }
}
