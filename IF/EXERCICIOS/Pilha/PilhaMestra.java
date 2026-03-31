package Pilha;

// IMPLEMENTANDO UMA PILHA USANDO LISTA LIGADA

public class PilhaMestra implements PilhaLigada{

    private NoPilha head;
    public int size;

    public PilhaMestra(){

        this.head = null;
        this.size = 0;

    }

    public boolean isEmpty(){

        if(head == null){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return this.size;
    }

    public void push(Object objeto){

        NoPilha newNode = new NoPilha(objeto);

        newNode.setNext(head);
        head = newNode;
        size ++;

    }

    public Object pop() throws PilhaExcecao{

        if(isEmpty()){
            throw new PilhaExcecao("Pilha VAZIA");
        }

        Object removed = head.getNext();
        head = head.getNext();

        size--;
        return removed;

    }

    public Object top() throws PilhaExcecao{
        
        if(isEmpty()){
            return new PilhaExcecao("Pilha VAZIA!");
        }
        return head.getValue();
    }

    @Override
    public String toString(){

        if (isEmpty()) {
            return "Pilha vazia";
        }
        
        StringBuilder sb = new StringBuilder();
        NoPilha atual = head;
        
        sb.append("[TOPO] -> ");
        while (atual != null) {
            sb.append(atual.getValue()).append(" -> ");
            atual = atual.getNext();
        }
        sb.append("null");
        
        return sb.toString();
    }

}