public class DequeArray implements Deque{

    private Object [] deque;
    private int capacity;
    private int length;
    private int initial;
    private int last;

    public DequeArray(int capacity){

        this.capacity = capacity;
        deque = new Object[capacity];
        length = 0;
        initial = -1;
        last = capacity-1;

    }

    public boolean isEmpty(){

        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        return length;
    }

    public void pushFront(Object objeto){
        
        if(size == capacity-1){
            increaseCapacity()
        }

        initial++
        deque[initial] = objeto
        length ++

    }

    public Object popFront() throws DequeExcecao{

        if(isEmpty()){
            throw new DequeExcecao("Deque VAZIO!");
        }

        deque[first] = null;
        first--;
        length--;

    }

    public void pushBack(){

        if(size == capacity-1){
            increaseCapacity();
        }

        deque[last] = objeto
        last--;
        length++;

    }

    public Object popBack() throws DequeExcecao{

        if(isEmpty()){
            throw new DequeExcecao("Deque VAZIO!");
        }



    }

    public int first() throws DequeExcecao{
        return deque[first];
    }

    public int last() throws DequeExcecao{
        return deque[last];
    }

    @Override
    public String toString(){

    }

}