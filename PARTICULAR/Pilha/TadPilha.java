public class TadPilha{

    private final int tamanho;
    private int topo;
    private int[] pilha;

    private int retorno;

    public TadPilha(int tam){
        this.tamanho = tam;
        this.topo = -1;
        this.pilha = new int[tam];
    }

    public int getRetorno(){
        return retorno;
    }

    public boolean full(){
        return this.topo == this.tamanho -1;
    }

    public int qtd(){
        return this.topo +1;
    }

    public boolean empty(){
        return this.qtd() == 0;
    }

    public boolean push(int valor){

        if(!this.full()){

            this.topo += 1;
            this.pilha[this.topo] = valor;
            return true;

        } else {
            return false;
        }
    }

    public boolean pop(){

        if(this.empty()){
            return false;
        } 
        // diminui o tamanho da pilha
        this.retorno = this.pilha[this.topo];
        this.topo--;
        return true;
    }

    public String print(){
        String ret = "";
        if(this.empty()){
            return "A pilha está vazia";
        }
        ret += " A pilha tem " + this.qtd() + "elementos \n";
        for (int i = 0; i <= this.topo; i++){
            ret += this.pilha[i] + " ";
        }
        return ret;
    }


}