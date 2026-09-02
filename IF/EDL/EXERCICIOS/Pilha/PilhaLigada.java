package Pilha;

public interface PilhaLigada {
    
    public boolean isEmpty();

    public int size();

    public void push(Object objeto);

    public Object pop() throws PilhaExcecao;

    public Object top() throws PilhaExcecao;
    
}