package Fila;

public class FilaArray implements FaceFila{

    private Object [] line;
    private int initial;
    private int last;
    private int size;
    private int capacity;
    private int growth;


    public FilaArray(int capacity,int growth){

        this.capacity = capacity;
        this.growth = growth;
        this.line = new Object [capacity];
        this.initial = 0;
        this.last = 0;
        this.size = 0;

    }

    public boolean isEmpty(){
        if(initial == last){
            return true;
        }else{
            return false;
        }
    }

    public Object first(){

        if(isEmpty()){
            return "Fila VAZIA";
        }

        return line[initial];
    }

    public void queue(Object objeto){

        if(size == capacity){
            increaseCapacity();
        }

        line[initial] = objeto;
        last = (last + 1) % size;
        size ++;
    }

    public void increaseCapacity(){

        int new_capacity;

        if( growth == 0){
            new_capacity = capacity * 2;
        }else{
            new_capacity = capacity + growth;
        }

        Object[] new_line = new Object [new_capacity];

        for(int i = 0; i < size; i++){
            new_line[i] = line[i];
        }

        line = new_line;
        capacity = new_capacity;

    }


    public Object dequeue(){

        if(size == 0){     
            return "A fila está VAZIA";
        }

        Object removed = line[last];

        /**Isto apenas para fins de estudo
         * é desnecessário 
         * mas facilita a compreensão */
        line[last] = null;

        initial++;
        size--;

        return removed;
    }
}

