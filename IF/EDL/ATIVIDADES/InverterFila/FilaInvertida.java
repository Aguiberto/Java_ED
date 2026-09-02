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
        this.isReversed = false;
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
            fila[initial] = objeto;
            
        } else {

            fila[last] = objeto;
            last = (last + 1) % capacity;
        }

        length++;
    }

    public void increaseCapacity(){

    // Os elementos do array precisam ser reorganizados 
    // em um array circular pode acontecer deles ficarem espaçados
    // toda vez que os elementos forem copiados eles precisam retornar ao índice 0

        int newCapacity;

        if(growth == 0){
            newCapacity = capacity * 2;
        }else{
            newCapacity = capacity + growth;
        }

        Object[] newArray = new Object[newCapacity];
        for(int i = 0; i < length; i++){
            newArray[i] = fila[(initial + i) % capacity];
            
        }

        capacity = newCapacity;
        fila = newArray;
        initial = 0;
        last = length;

    }

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

    // Em um array circular os do array podem estar espaçados
    //Sendo assim o método precisa reorganizar os elementos
    // Apos reorganizado os elementos podem ser copiados para o novo array



        int newCapacity = capacity / 2;
        if(newCapacity < 1){
            newCapacity = 1;
        }

        Object[] newArray = new Object[newCapacity];

        for(int i = 0; i < length;i++){
            newArray[i] = fila[(initial + i) % capacity];
        }

        fila = newArray;
        capacity = newCapacity;
        initial = 0;
        last = length;
        
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