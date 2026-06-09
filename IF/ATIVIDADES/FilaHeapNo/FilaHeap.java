public class FilaHeap{

    private int length;
    private NoHEAP raiz;

    public FilaHeap(){

        this.raiz = null;
        this.length = 0;
    }

    private boolean isEmpty(){
        return length == 0;
    }

    // retorna o menor valor
    private Object min(){
        return this.raiz;
    }
}