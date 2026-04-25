public class NoVetor{

    private NoVetor next;
    private NoVetor prev;
    private Object value;

    public NoVetor(){
        
        next = null;
        prev = null;
        value = null;

    }

    public void setValue(Object value){

        this.value = value;
    }

    public Object getValeu(){

        return this.value;
    }

    public void setNext(NoVetor next){

        this.next = next;
    }

}