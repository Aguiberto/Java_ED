public class FilaArray implements FaceFila{

    private Object [] line;
    private Object initial;
    private Object last;
    private int size;
    private int capacity;
    private int growth;


    public FilaArray(int capacity,int growth){

        this.capacity = capacity;
        this.growth = growth;
        this.line = new [capacity];
        this.first = 0;
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

        return line[first];
    }

    public void queue(Object objeto){

        if(size == capacity){
            increaseCapacity();
        }

        line[initial] = Object;
        initial ++;
        size ++;
    }

    public void increaseCapacity(){
        
    }


    public Object dequeue(){


    }
}

