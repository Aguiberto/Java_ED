public interface FilaInterface {

    public boolean isEmpty();

    public int size();

    public void enqueue(Object objeto);

    public Object dequeue() throws FilaExcecao;

    public void reverse();

    public Object first() throws FilaExcecao;

}