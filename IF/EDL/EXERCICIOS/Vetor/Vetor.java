package Vetor;
import java.util.Arrays;

public class Vetor implements VectorInterface{

/**Vetor é uma classe que usao o índice em seus métodos
 * Permite fazer remoção e adição em pontos específicos do array
 * Tem o método replace, que substitui o elemento do índice escolhido
 */

    private Object[] vetor;
    private int capacity;
    private int length;


    public Vetor(){

        capacity = 10;
        vetor = new Object[capacity];
        length = 0;

    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        if(length == 0){
            return true;
        }else{
            return false;
        }
    }

    public Object elemAtRank(int index) throws VectorExcecao{

        if( index >= length){
            throw new VectorExcecao("Índice fora do array");
        }

        return vetor[index];
    }

    public Object replaceAtRank(int index, Object objeto) throws VectorExcecao{

        if( index >= length){
            throw new VectorExcecao("Índice fora do array");
        }
        
       Object exchanged = vetor[index];
       vetor[index] = objeto;

       return exchanged;
    } 

    public void insertAtRank(int index, Object objeto){

       // verificando se o índice é válido
        if(index < 0 || index > capacity){
            throw new VectorExcecao("Índice fora do array");
        }

        if(length == capacity){
            increaseCapacity();
        }

        //Mover os elementos para direita
        //Começar do final até o índice desejado
        for(int i = length-1; i >= index; i--){

            vetor[i+1] = vetor[i];
        }

        vetor[index] = objeto;
        length++;
    }

    public void increaseCapacity(){

        int newCapacity = capacity * 2;
        Object[] newVector = new Object[newCapacity];
        for(int i = 0; i < length; i++){
            newVector[i] = vetor[i];
        }

        capacity = newCapacity;
        vetor = newVector;
    }

    public Object removeAtRank(int index) throws VectorExcecao{

        if(index < 0 || index >= length){
        // nesse caso a remoção deve ocorrer onde já há elementos ocupados

            throw new VectorExcecao("Índice fora do array");
        }
        
        Object removed = vetor[index];

        // Move para a esquerda todos os elementos do array
        // Usa o proximo índice do que foi informado
        // 'remover' -> 'suprimir'
        for(int i = index + 1; i < length; i++){
            vetor[i-1] = vetor[i];
        }

        //limpando o ultimo valor para não ficar duplicado
        vetor[length-1] = null;
        length--;

        if(length <= capacity / 4){
            decreaseCapacity();
        }

        return removed;

    }

    public void decreaseCapacity(){

        int newCapacity = capacity / 2;
        Object[] newVector = new Object[newCapacity];

        for(int i = 0; i < length; i++){
            newVector[i] = vetor[i];
        }

        vetor = newVector;
        capacity = newCapacity;
    }

    @Override
    public String toString(){
       return Arrays.toString(vetor);
    }


}