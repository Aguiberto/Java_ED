public class NoVetor{

    private NoVetor next;
    private NoVetor prev;
    private Object value;

    public NoVetor(Object objeto){
        
        next = null;
        prev = null;
        value = objeto;

    }

    public void setValue(Object value){

        this.value = value;
    }

    public Object getValue(){

        return this.value;
    }

    public void setNext(NoVetor next){

        this.next = next;
    }

    public NoVetor getNext(){
        return this.next;
    }

    public void setPrev(NoVetor prev){
        this.prev = prev;
    }

    public NoVetor getPrev(){
        return this.prev;
    }

    

}