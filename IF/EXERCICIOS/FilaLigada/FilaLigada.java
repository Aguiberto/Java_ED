public class FilaLigada implements InterfaceLigada {

    private NoFila head;
    private int length;
    
    public FilaLigada(){

        this.head = null;
        this.length = 0;
    }

    public boolean isEmpty(){

        if(length == 0){
            return true;
        }else{
            return false;
        }

    }

    public int size(){

        return this.length;
        
    }

    public void enqueue(NoFila objeto){

        NoFila newNode = new NoFila(objeto);

        newNode = head.getNext();
        head.setNext(newNode);

        length++;

    }

    public NoFila dequeue() throws FilaLExcecao{

        if(isEmpty()){
            throw new FilaLExcecao("FILA VAZIA!");
        }

        NoFila removed = head.getNext();
        head = head.getNext();

        length--;
    }

    public NoFila first() throws FilaLExcecao{

        if(isEmpty()){
            throw new FilaLExcecao("FILA VAZIA!");
        }

        return head;
    }

}