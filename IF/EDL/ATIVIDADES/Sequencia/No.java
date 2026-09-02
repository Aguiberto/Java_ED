public class No{

    private No next;
    private No prev;
    private Object value;

    public No( Object objeto){

        this.value = objeto;
        this.next = null;
        this.prev = null;
    }

    public Object getValue(){
        return value;
    }

    public void setValue(Object objeto){
        this.value = objeto;
    }

    public No getNext(){
        return this.next;
    }

    public void setNext(No next){
        this.next = next;
    }

    public No getPrev(){
        return this.prev;
    }

    public void setPrev(No prev){
        this.prev = prev;
    }


}