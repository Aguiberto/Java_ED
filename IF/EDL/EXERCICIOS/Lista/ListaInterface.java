package Lista;

public interface ListaInterface {

    // informa se está vazio
    public boolean isEmpty();

    // informa o tamanho da lista
    public int size();

    // informa o primeiro elemento da lista
    public Object first() throws ListaExcecao;

    // informa o último elemento da lista
    public Object last() throws ListaExcecao;

    // informa se é o primeiro da lista
    public boolean isFirst(int index);

    // informa se é o último da lista
    public boolean isLast(int index);

    // recebe um nó e informa qual é o valor do nó anterior
    public Object before(NoDuplo no) throws ListaExcecao;

    // recebe um nó e informa qual é o valor do próximo nó
    public Object after(NoDuplo no) throws ListaExcecao;

    // substitui um elemento da lista por outro no índice informado pelo valor informado
    public void replaceElement(int index, Object value) throws ListaExcecao;

    //inverte os elementos dos índices informados
    public void swapElements(int index, int index2) throws ListaExcecao;

    // adiciona um elemento antes do índice informado
    public void insertBefore(int index, Object value) throws ListaExcecao ;

    // adiciona um elemento depois do índice informado
    public void insertAfter(int index, Object value) throws ListaExcecao ;

    //adiciona no início
    public void insertFirst(Object objeto);

    // adiciona o fim
    public void insertLast(Object objeto);

    // remove o elemento solicitado
    public void remove(Object objeto) throws ListaExcecao;

}