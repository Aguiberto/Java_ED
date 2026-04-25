public interface ArrayListaInterface{

    public boolean isEmpty();

    public int size();

    public void InsertFirst(Object objeto);

    public void InsertAfter(Object objeto);

    public void replaceElement(int index, Object objeto) throws ArrayListaExcecao;

    public void swapElements(int index, int index2) throws ArrayListaExcecao;

    public Object before(int index) throws ArrayListaExcecao;

    public Object after(int index) throws ArrayListaExcecao;

    public Object first() throws ArrayListaExcecao;

    public Object last() throws ArrayListaExcecao;

    public boolean isFirst(int index) throws ArrayListaExcecao ;

    public boolean isLast(int index) throws ArrayListaExcecao;

}