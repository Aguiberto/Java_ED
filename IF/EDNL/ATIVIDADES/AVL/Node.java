public class Node{

    private Object valor;
    private Node pai;
    private Node filhoEsquerdo;
    private Node filhoDireito;

    public Node(Object valor){
        this.valor = valor;
    }

    public Object getValor(){
        return this.valor;
    }

    public void setValor(Object novoValor){
        this.valor = novoValor;
    }

    public Node getPai(){
        return this.pai;
    }

    public void setPai(Node novoPai){
        this.pai = novoPai;
    }

    public Node getFilhoEsquerdo(){
        return this.filhoEsquerdo;
    }

    public void setFilhoEsquerdo(Node novoFilhoEsquerdo){
        this.filhoEsquerdo = novoFilhoEsquerdo;
    }

    public Node getFilhoDireito(){
        return this.filhoDireito;
    }

    public void setFilhoDireito(Node novoFilhoDireito){
        this.filhoDireito = novoFilhoDireito;
    }

}