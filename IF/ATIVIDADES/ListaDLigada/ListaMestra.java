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
    public Object first() throws ListaExcecao{

        if(isEmpty()){
            throw new ListaExcecao("Lista VAZIA!");
        }

        NoDuplo first = head.getNext();

        return first.getValue();
    }

    // informa o último elemento da lista
    public Object last() throws ListaExcecao{

         if(isEmpty()){
            throw new ListaExcecao("Lista VAZIA!");
        }

        NoDuplo last = tail.getPrev();

        return last.getValue();
    }


    // informa se é o primeiro da lista
    public boolean isFirst(Object objeto) throws ListaExcecao{

        if( isEmpty()){
            throw new ListaExcecao("Lista VAZIA");
        }

        
        return objeto == first();
    }

    // informa se é o último da lista
    public boolean isLast(Object objeto) throws ListaExcecao{

        if( isEmpty()){
            throw new ListaExcecao("Lista VAZIA");
        }

        return objeto == last();
    }

    // recebe um nó e informa qual é o valor do nó anterior
    // possivelmente está errado, esse método deve retornar um objeto
    public Object before(NoDuplo no) throws ListaExcecao{

        if(no == null){
            throw new ListaExcecao("Nó nulo");
        }

        if(no.getPrev() == head){
            throw new ListaExcecao("Valor fora da lista");
        }

        NoDuplo beforeNode = no.getPrev();

        return beforeNode.getValue();
    }

    // recebe um nó e informa qual é o valor do próximo nó
    public Object after(NoDuplo no) throws ListaExcecao{

         if(no == null){
            throw new ListaExcecao("Nó nulo");
        }

        if(no.getNext() == tail){
            throw new ListaExcecao("Valor fora da lista");
        }

        NoDuplo afterNode = no.getNext();

        return afterNode.getValue();
    }

    // método para buscar um nó.
    public NoDuplo searchNode(int index){

         if( index <0 || index >= length){
            throw new ListaExcecao("Ìndic fora da lista");
        }

        if(isEmpty()){
            throw new ListaExcecao("A lista está VAZIA");
        }

        NoDuplo guide;

        // otimização
        if(index < length / 2){

            guide = head.getNext();

            for(int i = 0; i < index; i++){
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

        NoDuplo OldNode = searchNode(index);
        OldNode.setValue(value);
    
    }


    //inverte os elementos dos índices informados
    public void swapElements(int index, int index2) throws ListaExcecao{

        NoDuplo fNode = searchNode(index);
        NoDuplo sNode = searchNode(index2);

        // nó auxiliar que grava o valor do primeiro;
        Object tempValue = fNode.getValue();

        //inserindo invertido
        fNode.setValue(sNode.getValue());
        sNode.setValue(tempValue);
    }

    // adiciona um elemento antes do índice informado
    public void insertBefore(int index, Object value) throws ListaExcecao{

        // pegando no atual e anterior
        NoDuplo currentNode = searchNode(index);
        NoDuplo oldBNode = currentNode.getPrev();

        // cria um no
        NoDuplo newNode = new NoDuplo(value);

        // atualiza os ponteiros para os vizinhos;
        newNode.setNext(currentNode);
        newNode.setPrev(oldBNode);

        // atualiza os ponteiros dos vizinhos;
        currentNode.setPrev(newNode);
        oldBNode.setNext(newNode);
        
        length++;

    }

    // adiciona um elemento depois do índice informado
    public void insertAfter(int index, Object value) throws ListaExcecao {

        NoDuplo currentNode = searchNode(index);
        NoDuplo afterNode = currentNode.getNext();

        NoDuplo newNode = new NoDuplo(value);

        newNode.setPrev(currentNode);
        newNode.setNext(afterNode);

        currentNode.setNext(newNode);
        afterNode.setPrev(newNode);

        length++;

    }

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
    public void remove(Object objeto) throws ListaExcecao{

        if(isEmpty()){
            throw new ListaExcecao("Lista VAZIA!");
        }

        NoDuplo guide = head.getNext();

        while( guide != tail){

            if( guide.getValue().equals(objeto)){
                break;
            }

            guide = guide.getNext();

        }

        if(guide == tail){
            throw new ListaExcecao("Objeto NÃO ENCONTADO");
        }

        NoDuplo beforeNode = guide.getPrev();
        NoDuplo afterNode = guide.getNext();

        beforeNode.setNext(afterNode);
        afterNode.setPrev(beforeNode);

        length--;
    }

    @Override
    public String toString(){
        

        if(isEmpty()){
            return "[Lista VAZIA]";
        }

        StringBuilder lista = new StringBuilder();
        lista.append("[HEAD] <-> ");

        NoDuplo current = head.getNext();

        while(current != tail){
            lista.append(current.getValue());
            lista.append(" <->");
            current = current.getNext();
        }
        lista.append("[TAIL]");

        return lista.toString();
    }

}