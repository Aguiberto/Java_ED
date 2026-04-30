import java.util.Arrays;

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

    private void increaseCapacity(){

        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];

        for(int i = 0; i < length; i++){
            newArray[i] = lista[i];
        }

        lista = newArray;
        capacity = newCapacity;

    }

    public void insertFirst(Object objeto){

        
        if(length == capacity){
            increaseCapacity();
        }

        // para abrir espaço para inserir um elemento os elementos devem ser movimentados do final
        for(int i = length-1; i >= 0; i--){
            lista[i+1] = lista[i];
        }
    
        lista[0] = objeto;
        length++;
    }

    public void insertLast(Object objeto){

        if(length == capacity-1){
            increaseCapacity();
        }

        lista[length] = objeto;
        length++;
    }


    public void replaceElement(int index, Object objeto) throws ArrayListaExcecao {

        if(isEmpty()){
            throw new ArrayListaExcecao("Lista VAZIA!");
        }

        if(index < 0 || index > capacity-1){
            throw new ArrayListaExcecao("Index fora da lista");
        }

        lista[index] = objeto;

    }

    public void swapElements(int index, int index2) throws ArrayListaExcecao {

        Object aux;
        
        aux = lista[index2];
        lista[index2] = lista[index];
        lista[index] = aux;

    }

    public void insertBefore(int index, Object objeto) throws ArrayListaExcecao {


        if(index <= 0 || index >= length){
            throw new ArrayListaExcecao("Índice fora do array");
        }

        if( length >= capacity - 1){
        increaseCapacity();
        }

        for(int i = length-1; i >= index-1; i--){
            
            lista[i+1] = lista[i];
        }

        lista[index-1] = objeto;
        length++;
        
    }

    public void insertAfter(int index, Object objeto) throws ArrayListaExcecao{

        if(isEmpty()){

            lista[0] = objeto;

        }else{

            if(index < 0 || index >=length){
            throw new ArrayListaExcecao("Índice fora do array");
        }
        
        if( length >= capacity - 1){
            increaseCapacity();
        }

        for(int i = length-1; i > index; i--){
            
            lista[i] = lista[i-1];
        }

        lista[index+1] = objeto;
        length++;
        }
    }

    public Object first() throws ArrayListaExcecao{

        if(isEmpty()){
            throw new ArrayListaExcecao("Lista VAZIA!");
        }

        return lista[0];

    }

    public Object last()throws ArrayListaExcecao{

        if(isEmpty()){
            throw new ArrayListaExcecao("Lista VAZIA!");
        }

        // se a lista só tiver um elemento o ultimo elemento também será o primeiro.
        if(length == 1){
            return lista[0];
        }

        return lista[length-1];
    }

    public boolean isFirst(Object objeto) throws ArrayListaExcecao{

        if(isEmpty()){
            throw new ArrayListaExcecao("Lista VAZIA!");
        }

        return lista[0] == objeto;
    }

    public boolean isLast(Object objeto) throws ArrayListaExcecao{

        if(isEmpty()){
            throw new ArrayListaExcecao("Lista VAZIA!");
        }

        return lista[length-1] == objeto;
    }

    public Object before(int index) throws ArrayListaExcecao{

        if( index < 0 || index >= length){
            throw new ArrayListaExcecao("Índice fora de alcance");
        }

        return lista[index-1];
    }

    public Object after(int index) throws ArrayListaExcecao{

         if( index < 0 || index >= length){
            throw new ArrayListaExcecao("Índice fora de alcance");
        }

        return lista[index+1];
    }

    public void remove(Object objeto) throws ArrayListaExcecao{

            int ObjectIndex = -1;

            for(int i = 0; i < length; i++){
                if(lista[i] == objeto){
                    ObjectIndex = i; 
                }
            }

            if (ObjectIndex == -1){
                throw new ArrayListaExcecao("Objeto NÃO ENCONTRADO na lista");
            }

            for(int i = ObjectIndex; i < length-1; i++){
                lista[i] = lista[i+1];
            }
            
            lista[length-1] = null;
            length--;
    }

    @Override
    public String toString(){
        return Arrays.toString(lista);
    }

}