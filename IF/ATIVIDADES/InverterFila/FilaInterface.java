public class FilaInterface {

    public boolean isEmpty();

    public int size();

    public void enqueue(Object objeto);

    public Object dequeue() throws FilaExcecao;

    public void switch();

    public Object first() throws FilaExcecao;

}