

public class Vetor implements VetorInterface{

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

    public Object elemAtRank(Object index) throws VectorExcecao{

        if( index >= length){
            throw new VectorExcecao("Índice fora do array");
        }

        return vetor[index];
    }

    public Object replaceAtRank(int index, Object objeto) throws VectorExcecao{

        if( index >= length){
            throw new VectorExcecao("Índice fora do array");
        }
        
       Object exchaged = vetor[index];
       vetor[index] = objeto;

       return exchanged;
    } 

    public void insertAtRank(int index, Object objeto){

        if(index <= length){
            throw new VectorExcecao("Índice fora do arary");
        }

        //Mover os elementos uma casa a partir do índice informado
        for(int i = index; i < length; i++){

            if(i > capacity){
                increaseCapacity();
            }

            vetor[i+1] = i;
        }

        vetor[index] = objeto;

    }

    public void increaseCapacity(){

        Object newCapacity = capacity * 2;
        Object[] newVector = new Object[newCapacity];
        for(int i = 0; i < length; i++){
            newVector[i] = vetor[i];
        }

        capacity = newCapacity;
        vetor = newVector;
    }




}