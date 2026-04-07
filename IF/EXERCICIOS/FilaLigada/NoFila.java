package FilaLigada;

public class NoFila{

    private Object value;
    private NoFila next;

    public NoFila(){

        this.value = null;
        this.next = null;
    }

    public NoFila getNext(){
        return next;
    }

    public void setNext(NoFila next){
        this.next = next;
    }

    public Object getValue(){
        return value;
    }

    public void setValue(Object value){
        this.value = value;
    }

}