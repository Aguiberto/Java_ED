

public class NoFila{

    private Object value;
    private NoFila next;

    public NoFila(Object value){

        this.value = value;
        this.next = null;
    }

    public NoFila getNext(){
        return next;
    }

    public void setNext(NoFila next){
        this.next = next;
    }

}