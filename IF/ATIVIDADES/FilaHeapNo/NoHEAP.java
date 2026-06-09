public class NoHEAP{

    private object value;
    private NoHEAP pai;
    private NoHEAP filhoD;
    private NoHEAP filhoE;

    public NoHEAP(Object obj){

        this.value = obj;
        this.pai = null;
        this.filhoD = null;
        this.filhoE = null
    }

    public Object getValue(){
        return this.value;
    }

    public void setValue(Object obj){
        this.value = obj;
    }

    public NoHEAP getPai(){
        return this.pai;
    }

    public void setPai(NoHEAP NovoPai){
        this.pai = NovoPai;
    }

    public NoHEAP getFilhoD(){
        return this.filhoD;
    }

    public void setFilhoD(NoHEAP NovoFilhoD){
        this.filhoD = NovoFilhoD
    }

    public NoHEAP getFilhoE(){
        return this.getFilhoE;
    }

    public void setFilhoE(NoHEAP NovoFilhoE){
        this.filhoE = NovoFilhoE;
    }
}