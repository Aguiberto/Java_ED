public interface InterfaceLigada{

    public boolean isEmpty();

    public int size();

    public void enqueue(NoFila objeto);

    public NoFila dequeue() throws FilaLExcecao;

    public NoFila first() throws FilaLExcecao;

}