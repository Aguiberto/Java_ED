package Pilha;

// IMPLEMENTANDO UMA PILHA USANDO LISTA LIGADA

public class PilhaMestra implements PilhaLigada{

    private NoPilha stack;
    private NoPilha head;
    public int size;

    public PilhaMestra(){

        this.head = null;
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

        

    }

    public Object pop() throws PilhaExcecao{

    }

    public Object top() throws PilhaExcecao{

    }

    @Override
    public String toString(){

    }



}