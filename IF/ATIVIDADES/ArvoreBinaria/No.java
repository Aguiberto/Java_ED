public class No{

    private Comparable value;
    private No pai;
    private No filhoE;
    private No filhoD;

    public No(Comparable obj){

        value = obj;
        pai = null;
        filhoE = null;
        filhoD = null;

    }

    public Comparable getValue(){
        return this.value;
    }

    public void setValue(Comparable obj){
        this.value = obj;
    }

    public No getPai(){
        return this.pai;
    }

    public void setPai(No novoPai){
        this.pai = novoPai;
    }

    public No getFilhoE(){
        return this.filhoE;
    }

    public void setFilhoE(No novoFilhoE){
        this.filhoE = novoFilhoE;
    }

    public No getFilhoD(){
        return this.filhoD;
    }

    public void setFilhoD(No novoFilhoD){
        this.filhoD = novoFilhoD;
    }

}