public class NoRN<T extends Comparable<T>>{

    private T valor;
    private NoRN<T> pai;
    private NoRN<T> filhoD;
    private NoRN<T> filhoE;
    private Cor cor;

    public NoRN(T valor, NoRN<T> NIL){
        this.valor = valor;
        this.pai = NIL;
        this.filhoD = NIL;
        this.filhoE = NIL;
        this.cor = Cor.RUBRO;
    }

    public NoRN(){

        this.cor = Cor.NEGRO;
        this.valor = null;
        this.pai = null;
        this.filhoD = null;
        this.filhoE = null;

    }

    public T getValor(){
        return this.valor;
    }

    public void setValor(T novoValor){
        this.valor = novoValor;
    }

    public NoRN<T> getPai(){
        return this.pai;
    }

    public void setPai(NoRN<T> novoPai){
        this.pai = novoPai;
    }

    public NoRN<T> getFilhoD(){
        return this.filhoD;
    }

    public void setFilhoD(NoRN<T> novoFilhoD){
        this.filhoD = novoFilhoD;
    }

    public NoRN<T> getFilhoE(){
        return this.filhoE;
    }

    public void setFilhoE(NoRN<T> novoFilhoE){
        this.filhoE = novoFilhoE;
    }

    public Cor getCor(){
       return this.cor;
    }

    public void setCor(Cor novaCor){
        this.cor = novaCor;
    }




}