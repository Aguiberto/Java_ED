package Pilha;

public class NoPilha {
    
    private Object value;
    private NoPilha next;

    // CLASSE SEM CONSTRUTOR

    public Object getValue(){
        return value;
    }

    public void setValue(Object NovoValor ){
        this.value = NovoValor;
    }

}