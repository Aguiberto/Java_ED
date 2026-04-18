package Lista;

public class ListaMestra implements ListaInterface{

// Esta classe implementa uma lista usando usando lista DUPLAMENTE ENCADEADA

    private NoDuplo head;
    private NoDuplo tail;
    private int length;

    public ListaMestra(){

        this.head = new NoDuplo(null);
        this.tail = new NoDuplo(null);
        this.length = 0;

    }

        // informa se está vazio
    public boolean isEmpty(){

        if( length == 0){
            return true;
        }else{
            return false;
        }

    }

    // informa o tamanho da lista
    public int size(){
        return this.length;
    }

    // informa qual é o primeiro da lista
    public NoDuplo isFirst() throws ListaExcecao{

    }

    // informa qual é o último da lista
    public NoDuplo isLast() throws ListaExcecao;

    // recebe um nó e informa qual é o valor do nó anterior
    public NoDuplo before(NoDuplo no) throws ListaExcecao;

    // recebe um nó e informa qual é o valor do próximo nó
    public NoDuplo after(NoDuplo no) throws ListaExcecao;

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

    @Override
    public String toString(){

    }

}