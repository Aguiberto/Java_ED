package Pilha;

// IMPLEMENTANDO UMA PILHA USANDO LISTA LIGADA

public class PilhaMestra implements PilhaLigada{

    private NoPilha head;
    public int size;

    public PilhaMestra(){

        this.head = null
        this.size = 0

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

        NoPilha new_node = new NoPilha(objeto);

        new_node.setNext(head);
        head = new_node
        size ++;

    }

    public Object pop() throws PilhaExcecao{

        if(isEmpty()){
            throw new PilhaExcecao("Pilha VAZIA");
        }

        Object removed = head.getNext();

        size--;
        return valorRemovido;

    }

    public Object top() throws PilhaExcecao{
        
        if(isEmpty()){
            return PilhaExcecao("Pilha VAZIA!");
        }
        return head.getValue();
    }

    @Override
    public String toString(){

    }



}