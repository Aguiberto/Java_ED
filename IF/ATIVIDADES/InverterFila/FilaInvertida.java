public class FilaInvertida implements FilaInterface{

    private Object [] fila;
    private int length;
    private int capacity;
    private int growth;
    private int initial;
    private int last;

    public FilaInvertida(int capacity, int growth){

        this.capacity == capacity;
        this.growth == growth;
        fila = new Object[capacity];
        this.length = 0;
        this.initial = -1;
        this.last = length -1;
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

        if(size == capacity-1){
            increaseCapacity();
        }

        if(length == 0){
            fila[initial] = objeto;
        }

        fila[last] = objeto;
        length++;
    }

    // revisar esse método
    public Object dequeue() throws FilaExcecao{

        if(isEmpty()){
            new FilaExcecao("FILA VAZIA! Tente outra OPERAÇÃO!");
        }

        if(size == capacity / 3 ){
            decreaseCapacity();
        }
        
        Object removed = fila[initial];
        fila[initial] == null;
        initial++;

        length--;
        
    }

    public void switch(){
    //inverter o inicio e o fim

        int aux;
        aux = initial;
        initial = last;
        last = aux;

    }

    public int first(){
        return fila[initial];
    }

    @Override
    public String toString(){

        StringBuild filaStr = "[";
    }

}