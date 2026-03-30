package Fila;

public interface FaceFila{

    public int size();

    public void queue(Object objeto);

    public Object dequeue() throws FilaExcecao;

    public Object first() throws FilaExcecao;

    public boolean isEmpty();
}