public interface Deque{

    public boolean isEmpty();

    public int size();

    public void pushFront(Object objeto);

    public Object popFront() throws DequeExcecao;

    public void pushBack(Object objeto);

    public Object popBack() throws DequeExcecao;

    public Object first() throws DequeExcecao;

    public Object last() throws DequeExcecao;
}