package Pilha;

public class NoPilha {
    
    private Object value;
    private NoPilha next;

    public NoPilha(Object value){
        
        this.value = value;
        this.next = null;
    }

    public Object getValue(){
        return value;
    }

    public void setValue(Object NovoValor ){
        this.value = NovoValor;
    }

    public NoPilha getNext(){
        return next;
    }

    public void setNext(NoPilha next){
        this.next = next;
    }

}