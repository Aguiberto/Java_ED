public class NoHEAP{

    private int chave;
    private Object value;
    private NoHEAP pai;
    private NoHEAP filhoD;
    private NoHEAP filhoE;

    public NoHEAP(int prioridade, Object obj){

        this.chave = prioridade;
        this.value = obj;
        this.pai = null;
        this.filhoD = null;
        this.filhoE = null;
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
        this.filhoD = NovoFilhoD;
    }

    public NoHEAP getFilhoE(){
        return this.filhoE;
    }

    public void setFilhoE(NoHEAP NovoFilhoE){
        this.filhoE = NovoFilhoE;
    }

    public boolean isLeaf(){
        
        return this.filhoD == null && this.filhoE == null;
    }

    public int getChave(){
        return this.chave;
    }

    public void setChave(int novaChave){
        this.chave = novaChave;
    }
}