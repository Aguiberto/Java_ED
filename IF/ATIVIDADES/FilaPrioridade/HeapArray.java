// HEAP IMPLEMENTADO COM 
/**Definição heap
 * As chaves dos pais são menores que as dos filhos
 * Todos os níveis devem estar completos
 * O preenchimento da HEAP é da direita para a esquerda
 * O índice 0 sempre será VAZIO
 */

public class HeapArray{

    private Comparable[] heap;
    // Comparable garante que qualquer objeto na heap possa ser comparado

    private int length;
    private int capacity;


    public HeapArray(int capacity){

        this.capacity = capacity;
        heap = new Comparable[capacity + 1];
        length = 0;

    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public Object min(){

        if(isEmpty()){
            return "Não há nada na HEAP";
        }

        return heap[1];
    }

    // adição na heap sempre será no último nível  e ultimo elemento da esquerda para a direita
    // usando um array sempre será no ultimo índice
    public void insert(Comparable obj){

        if(length + 1 >= capacity){
            increaseCapacity();
        }
       
        length ++; 
        heap[length] = obj;

        // organizando o heap 
        upHeap(length);
    }

    // Remove sempre o raiz
    // A remoção ocorre com a substituição da raiz pelo último elemento
    public Comparable remove(){

        if(isEmpty()){
            return " HEAP Vazia!";
        }

        Comparable removed = heap[1];

        heap[1] = heap[length];
        heap[length] = null; 
        length--;

        if(length > 0){

            // começa com a raiz
            downHeap(1);
        }

        return removed;
    }

    // ============ MÉTODOS AUXILIARES ===========

    private void increaseCapacity(){

        int newCapacity = capacity * 2;
        Comparable[] newArray = new Comparable[newCapacity];

        for(int i = 0; i <= length; i++){
            newArray[i] = heap[i];
        }

        capacity = newCapacity;
        heap = newArray;
    }

    public void upHeap(int indiceNo ){

        // o índice do nó fica mudando conforme ele muda de posição
        // Ao ir diminuindo chegará uma hora que o laço encerrará e o elemento vai estar em sua posição correta na heap
        while (indiceNo > 1){
            int indicePai = indiceNo / 2;

            if(heap[indiceNo].compareTo(heap[indicePai]) < 0){

                Comparable aux = heap[indiceNo];
                heap[indiceNo] = heap[indicePai];
                heap[indicePai] = aux;

                indiceNo = indicePai;
            } else {
                break;
            }
        }
    }

    public void downHeap(int indiceNo){
        
        while(2 * indiceNo <= length){

            int leftSon = 2 * indiceNo;
            int rightSon = (2 * indiceNo) + 1;

            // fica definido que o filho esquerdo é menor
            int menor = leftSon;

            // Redefine o da direita como o menor
            if(rightSon <= length && heap[rightSon].compareTo(heap[leftSon]) < 0){
                menor = rightSon;
            }

            // Se o indice do nó passado for menor que o menor defindo anteriormente o laço encerra
            if(heap[indiceNo].compareTo(heap[menor]) <= 0){
                break;
            }

            Comparable aux = heap[indiceNo];
            heap[indiceNo] = heap[menor];
            heap[menor] = aux;

            indiceNo = menor;
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Heap vazia: []";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Heap atual: [");
        for (int i = 1; i <= length; i++) {
            sb.append(heap[i]);
            if (i < length) {
                sb.append(", ");
            }
        }
        sb.append("] (Tamanho: ").append(length).append(")");
        return sb.toString();
    }

}