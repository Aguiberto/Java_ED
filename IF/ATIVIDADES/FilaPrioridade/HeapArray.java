import java.util.Vector;


// HEAP IMPLEMENTADO COM 
/**Definição heap
 * As chaves dos pais são menores que as dos filhos
 * Todos os níveis devem estar completos
 * O preenchimento da HEAP é da direita para a esquerda
 * O índice 0 sempre será VAZIO
 */

public class HeapArray[

    private Vector<Object> heap;
    int ultimoNo;

    public HeapArray(){

        Vector heap = new Vector<>();

        // ultimo nó tem começa sendo o primeiro elemento
        int ultimoNo = 1;

    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        return heap.size() == 0;
    }

    public Object heapMin(){

        // O menor valor em uma HEAP é sempre a raiz
        return heap[1];
    }

    // A adição de um elemento sempre acontece no ultimo elemento 
    public void insert(Object value){

        heap[heap.size()] = heap.insert(value)
        
        upHeap();
    }

    public Object removeMin(int index){
        
        // Substituir a raiz com a chave do último elemento
        heap[1] = heap[heap.size()];

        // Removendo o valor
        Object removed = heap.remove(heap[1]);

        // Reorganizando
        downHeap();

        return removed;
    }    

    // MÉTODOS AUXILIARES

    private void upHeap(){

        // Substituir a chave raiz com o último valor;
        // 
    }

    private void downHeap();

]