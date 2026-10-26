package IF.EDNL.ATIVIDADES.GRAFO_MATRIZ;

public class Vertice {
    
    private int indice;
    private  String nome;

    public  Vertice(int indice, String nome){
        this.indice = indice;
        this.nome = nome;
    }

    public int getIndice(){
        return  this.indice;
    }

    public String getNome(){
        return  this.nome;
    }

    public void setNome(String novoNome){
        this.nome = novoNome;
    }

    @Override 
    public String toString(){
        return this.nome + " (Índice: " + this.indice + ")";
    }

}
