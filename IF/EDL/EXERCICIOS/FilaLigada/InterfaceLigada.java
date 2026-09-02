package FilaLigada;

public interface InterfaceLigada{

    public boolean isEmpty();

    public int size();

    public void enqueue(Object objeto);

    public NoFila dequeue() throws FilaLExcecao;

    public Object first() throws FilaLExcecao;

}