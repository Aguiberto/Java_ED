package ListaArray;

import java.util.Arrays;

public class ArrayListaMestra implements ArrayListaInterface{

    private Object[] lista;
    private int length;
    private int capacity;
    private int indexLast;
    private int indexFirst;

    public ArrayListaMestra(int initialCapacity){

        lista = new Object[initialCapacity];
        length = 0;
        capacity = initialCapacity;
        indexFirst = 0;
        indexLast = 0;

    }

    public boolean isEmpty(){

        return length == 0;
    }

    public int size(){

        return length;
    }

    public void insertFirst(Object objeto){

        
        if(length == capacity){
            increaseCapacity();
        }

        if(isEmpty()){

            lista[indexFirst] = objeto;

        }else{

            for(int i = 0; i < length; i++){
                lista[i+1] = lista[i];
            }
        }

        lista[indexFirst] = objeto;
        indexFirst ++;
        indexLast = indexFirst + 1;
        length++;
    }

    public void insertLast(Object objeto){

        if(length == capacity){
            increaseCapacity();
        }

        if(isEmpty()){

            lista[capacity-1] = objeto;

        }else{

            lista[indexLast] = objeto
            indexLast ++;

        }

        public void replaceElement(int index, Object objeto) throws ArrayListaExcecao {

            lista[index] = objeto;

        }

        public void swapElements(int index, intdex2) throws ArrayListaExcecao {

            Object aux;
            
            aux = lista[index2];
            lista[index2] = lista[index];
            lista[index] = aux;

        }

        public void before(int index, Object objeto) throws ArrayListaExcecao {

            if(isEmpty()){
                throw new ArrayListaExcecao("Array VAZIO!");
            }

            if(index >= length){
                throw new ArrayListaExcecao("Índice fora do array");
            }
            
            if( length >= capacity - 1){
                increaseCapacity();
            }

            for(int i = length-1; i >= index - 1; i--){
                
                lista[i] = lista[i-1];
            }

            lista[index-1] = objeto;

        }

        public void after(int index, Object objeto) throws ArrayListaExcecao{

            if(isEmpty()){
                throw new ArrayListaExcecao("Array VAZIO!");
            }

            if(index >= length){
                throw new ArrayListaExcecao("Índice fora do array");
            }
            
            if( length >= capacity - 1){
                increaseCapacity();
            }

            for(int i = length-1; i >= index - 1; i--){
                
                lista[i] = lista[i-1];
            }

            lista[index-1] = objeto;

        }

        public Object first() throws ArrayListaExcecao{
            return lista[indexFirst];

        }

        public Object last()throws ArrayListaExcecao{
            return lista[indexLast]
        }

        public boolean isFirst(int index) throws ArrayListaExcecao{
            return index == 0;
        }

        public boolean isLast(int index) throws ArrayListaExcecao{
            return index == length-1;
        }

        public void remove(Object objeto) throws ArrayListaExcecao{

                indexAux = 0
                while( lista[indexAux] != objeto){

                    indexAux ++;

                }

                for(int i = length-1; i >= indexAux; i-- ){
                    lista[i] = lista[i+1]
                }

                length--;
                indexLast--;
        }

        @Override
        public String toString(){
            return Arras.toString(lista);
        }
    }

}