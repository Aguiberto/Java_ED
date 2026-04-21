package Lista;

public class ListaMestra implements ListaInterface{

// Esta classe implementa uma lista usando usando lista DUPLAMENTE ENCADEADA

    private NoDuplo head;
    private NoDuplo tail;
    private int length;
    

    public ListaMestra(){

        // os nós sentinelas tem o valor nulo.
        this.head = new NoDuplo(null);
        this.tail = new NoDuplo(null);

        // os nós sentinelas devem começar ligados 
        // os elementos são adicionados no meio deles

        this.head.setNext(tail);
        this.tail.setPrev(head);

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

    // informa o primeiro elemento da lista
    public NoDuplo first() throws ListaExcecao{

        if(isEmpty()){
            throw new ListaExcecao("Lista VAZIA!")
        }

        return head.getNext();

    }

    // informa o último elemento da lista
    public NoDuplo last() throws ListaExcecao{

         if(isEmpty()){
            throw new ListaExcecao("Lista VAZIA!");
        }

        return tail.getPrev();
    }


    // informa se é o primeiro da lista
    public boolean isFirst(int index) throws ListaExcecao{

        if( isEmpty()){
            throw new ListaExcecao("Lista VAZIA");
        }

        if(index < 0 || index >= length){
            throw new ListaExcecao("Índice fora de alcançe");
        }

        //se o índex for 0 sempre vai ser o primeiro elemento
        return index == 0;
    }

    // informa se é o último da lista
    public boolean isLast(int index) throws ListaExcecao{

        if( isEmpty()){
            throw new ListaExcecao("Lista VAZIA");
        }

        if(index < 0 || index >= length){
            throw new ListaExcecao("Índice fora de alcançe");
        }

        // se o índice for o ultimo sempre será o ultimo elemento da lista
        return index == length-1;
    
    }

    // recebe um nó e informa qual é o valor do nó anterior
    public NoDuplo before(NoDuplo no) throws ListaExcecao{

        if(no == null){
            throw new ListaExcecao("Nó nulo");
        }

        if(no.getPrev() == head){
            throw new ListaExcecao("Valor fora da lista");
        }

        return no.getPrev();
    }

    // recebe um nó e informa qual é o valor do próximo nó
    public NoDuplo after(NoDuplo no) throws ListaExcecao{

         if(no == null){
            throw new FilaExcecao("Nó nulo");
        }

        if(no.getNext() == tail){
            throw new ListaExcecao("Valor fora da lista");
        }

        return no.getNext();
    }

    private NoDuplo searchNode(int index){

         if( index <0 || index < length-1){
            throw new ListaExcecao("Ìndic fora da lista");
        }

        if(isEmpty()){
            throw new ListaExcecao("A lista está VAZIA");
        }

        NoDuplo guide;

        // otimização
        if(index < length / 2){

            guide = head.getNext();

            for(int i = 0; i < length; i++){
                guide = guide.getNext();
            }

        }else{
        // percorrendo a lista de trás para a frente
            guide = tail.getPrev();

            for(int i = length-1; i > index; i--){
                guide = guide.getPrev();
            }
        }

        return guide;

    }

    // substitui um elemento da lista por outro no índice informado pelo valor informado
    public void replaceElement(int index, Object value) throws ListaExcecao{

        noDuplo OldNode = searchNode(index)
        OldNode.setValue(Object);
    
    }


    //inverte os elementos dos índices informados
    public void swapElements(int index, int index2) throws ListaExcecao;

    // adiciona um elemento antes do índice informado
    public void insertBefore(int index, Object value) throws ListaExcecao ;

    // adiciona um elemento depois do índice informado
    public void insertAfter(int index, Object value) throws ListaExcecao ;

    //adiciona no início
    public void insertFirst(Object objeto){
 
        // cria um novo nó
        NoDuplo newNode = new NoDuplo(objeto);
        // guarda o primeiro nó
        NoDuplo oldFirst = head.getNext();

        // o anterior do novo nó será o head
        newNode.setPrev(head);
        // o próximo do novo nó será o primeiro
        newNode.setNext(oldFirst);

        // o anteior no antigo primeiro será o novo nó
        oldFirst.setPrev(newNode);

        // o próximo do head será o  novo nó
        head.setNext(newNode);

        length++;

    }

    // adiciona o fim
    public void insertLast(Object objeto){

        NoDuplo newNode = new NoDuplo(objeto);
        NoDuplo oldLast = tail.getPrev();

        newNode.setPrev(oldLast);
        newNode.setNext(tail);

        oldLast.setNext(newNode);

        tail.setPrev(newNode);

        length++;

    }

    // remove o elemento solicitado
    public void remove(Object objeto) throws ListaExcecao;

    @Override
    public String toString(){

    }

}