public class ArrayListaMestra implements ArrayListaInterface{

    private Object[] lista;
    private int length;
    private int capacity;

    public ArrayListaMestra(int initialCapacity){

        lista = new Object[initialCapacity];
        length = 0;
        capacity = initialCapacity;

    }

    public boolean isEmpty(){

        return length == 0;
    }

    public int size(){

        return length;
    }

    public void insertFirst(Object objeto){

    }

    public

}