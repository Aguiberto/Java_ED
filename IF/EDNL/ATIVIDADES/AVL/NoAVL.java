public class NoAVL{

    private Object valor;
    private NoAVL pai;
    private NoAVL filhoDireito;
    private NoAVL filhoEsquerdo;
    private int altura;

    public NoAVL(){
        this.valor == null;
        this.pai == null
        this.filhoDireito == null;
        this.filhoEsquerdo == null;
    }

    public NoAVL getValor(){
        return this.valor;
    }

    public NoAVL getFilhoDireito(){
        return this.filhoDireito;
    }

    public NoAVL getFilhoEsquerdo(){
        return this.filhoEsquerdo;
    }

    public NoAVL getPai(){
        return this.pai;
    }

    public int getAltura(){
        return this.altura;
    }

    public void setValor(Object novoValor){
        this.valor = valor;
    }

    public void setPai(NoAVL novoPai){
        this.pai = novoPai;
    }

    public void setFilhoEsquerdo(NoAVL novoFilhoEsquerdo){
        this.filhoEsquerdo = novoFilhoEsquerdo;
    }

    public void setFilhoDireito(NoAVL novoFilhoDireito){
        this.filhoDireito = novoFilhoDireito;
    }
    
    public void setAltura(int novaAltura){
        this.altura = novaAltura;
    }

}