package Fila;

import java.util.Arrays;

public class FilaArray{

    private Object [] line;
    private int initial;
    private int last;
    private int capacity;
    private int growth;


    public FilaArray(int capacity,int growth){

        this.capacity = capacity;
        this.growth = growth;
        this.line = new Object [capacity];
        this.initial = 0;
        this.last = 0;

    }

    public boolean isEmpty(){
        if(last == initial){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return (capacity - initial + last) % capacity;
    }

    public Object first() throws FilaExcecao{

        if(isEmpty()){
            throw new FilaExcecao("Fila VAZIA!");
        }

        return line[initial];
    }

    public void enqueue(Object objeto){

        if(size() == capacity-1){
            increaseCapacity();
        }

        line[last] = objeto;
        last = (last + 1) % capacity;
     
    }

    public void increaseCapacity(){

        int new_capacity;

        if( growth == 0){
            new_capacity = capacity * 2;
        }else{
            new_capacity = capacity + growth;
        }

        Object[] new_line = new Object [new_capacity];
        int oldInitial = initial;
        int currentSize = size();
        for(int i = 0; i < currentSize; i++){
            new_line[i] = line[oldInitial];
            oldInitial = (oldInitial + 1) % capacity;

        }

        last = currentSize;
        initial = 0;
        line = new_line;
        capacity = new_capacity;
    }


    public Object dequeue() throws FilaExcecao{

        if(isEmpty()){     
            throw new FilaExcecao("Fila VAZIA!");
        }

        Object removed = line[initial];

        /**Isto apenas para fins de estudo
         * é desnecessário 
         * mas facilita a compreensão */
        line[initial] = null;

        initial = (initial + 1) % capacity;

        return removed;
    }

    @Override
    public String toString(){
        return Arrays.toString(line);
    }
}

