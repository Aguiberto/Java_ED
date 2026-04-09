import java.util.Arrays;

// Para possibilitar a inverção é necessário criar uma Fila CIRCULAR

public class FilaInvertida implements FilaInterface{

    private Object [] fila;
    private int length;
    private int capacity;
    private int growth;
    private int initial;
    private int last;
    private boolean isReversed;

    public FilaInvertida(int capacity, int growth){

        this.capacity = capacity;
        this.growth = growth;
        fila = new Object[capacity];
        this.length = 0;
        this.initial = 0;
        this.last = 0;
        isReversed = false;
    }

    public boolean isEmpty(){
        if(length == 0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return this.length;
    }

    // revisar esse método
    public void enqueue(Object objeto){

        if(length == capacity-1){
            increaseCapacity();
        }

        // Quando a fila está invertida a adição ocorre no início
        if(isReversed){

            initial = (initial - 1 + capacity) % capacity;
            fila[last] = objeto;
            
        } else {

            fila[last] = objeto;
            last = (last + 1) % capacity;
        }

        length++;
    }

    public void increaseCapacity(){

        Object [] newArray;
        int newCapacity = 0;

        if(growth == 0){
            newCapacity = capacity * 2;
        }else{
            newCapacity = capacity + growth;
        }

        newArray = new Object[newCapacity];
        for(int i = 0; i < length; i++){
            newArray[i] = fila[i];
        }

        capacity = newCapacity;
        fila = newArray;

    }

    // revisar esse método
    public Object dequeue() throws FilaExcecao{
        
        Object removed;

        if(isEmpty()){
           throw new FilaExcecao("FILA VAZIA! Tente outra OPERAÇÃO!");
        }

        if(length == capacity / 3 ){
            decreaseCapacity();
        }

        //Quando a fila está invertida a remoção acontece do fim
        if(isReversed){

            last = (last - 1 + capacity) % capacity;
            removed = fila[last];
            fila[last] = null;

        }else{

         // quando a fila não está inverida a remoção ocorre normalmente no início
        removed = fila[initial];
        fila[initial] = null;
        initial = (initial + 1) % capacity;
        }

        length--;
        return removed;
    }

    public void decreaseCapacity(){

        int newCapacity = capacity / 2;
        Object[] newArray = new Object[newCapacity];

        for(int i = 0; i < length;i++){
            newArray[i] = fila[i];
        }

        fila = newArray;
        capacity = newCapacity;
    }

    public void reverse(){
        
        if(isReversed == false){
            isReversed = true;
        }else{
            isReversed = false;
        }

    }

    public Object first() throws FilaExcecao{

        if(isEmpty()){
            throw new FilaExcecao("A Fila está VAZIA!");
        }

        if(isReversed){
            int lastCircular = (last - 1 + capacity) % capacity;
            return fila[lastCircular];
        }

        return fila[initial];
    }

    @Override
    public String toString(){
        return Arrays.toString(fila);
    }

}