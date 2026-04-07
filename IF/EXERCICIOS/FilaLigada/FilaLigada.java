package FilaLigada;

public class FilaLigada implements InterfaceLigada {

    private NoFila head;
    private NoFila tail;
    private int length;
    
    public FilaLigada(){

        this.head = null;
        this.tail = null;
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

    public void enqueue(Object objeto){

        NoFila newNode = new NoFila();
        newNode.setValue(objeto);

        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            // vai dizer qual é o próximo do nó ao qual o tail aponta
            tail.setNext(newNode);

            // agora tail vai apontar para o novo nó
            tail = newNode;
        }

        length++;

    }

    public NoFila dequeue() throws FilaLExcecao{

        if(isEmpty()){
            throw new FilaLExcecao("FILA VAZIA!");
        }

        NoFila removed = new NoFila();
        removed.setValue(head.getValue());

        head = head.getNext();
        length--;

        return removed;
    }

    public Object first() throws FilaLExcecao{

        if(isEmpty()){
            throw new FilaLExcecao("FILA VAZIA!");
        }

        return head.getValue();
    }

    @Override 
    public String toString(){

        if(isEmpty()){
            return "Fila:[]";
        }

        StringBuilder fila = new StringBuilder();
        fila.append ("Fila: [");

        NoFila guide = head;

        while(guide != null){

            fila.append(guide.getValue());
            guide = guide.getNext();

            if(guide != null){
                fila.append("-> ");
            }
        }
        fila.append("]");
        return fila.toString();
    }   

}