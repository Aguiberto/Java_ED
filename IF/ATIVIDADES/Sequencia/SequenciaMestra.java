public class SequenciaMestra implements SequenciaInterface{

    private No head;
    private No tail;
    private int length;

    public SequenciaMestra(){

        this.length == 0;
        head.getNext(tail);
        tail.getPrev(head);

    }

    // ========= MÉTODOS PONTE =============

    public No atRank(int index){

        int aux = 0
        No target = head.getNext();

        while( aux != index){
            target = target.getNext();
            aux++;    
        }

        return target;
    }

    public int rankOf(No node){

        int index = 0;
        No searcher = head.getNext();

        while (searcher != node){
            searcher = searcher.getNext();
            index ++;
        }

        return index;

    }

    // ======= MÉTODOS GENÉRICOS ===========

    public boolean isEmpty(){
        return length == 0;
    }

    public int size(){
        return length;
    }


    // ======== MÉTODOS DE VETOR ===========

    // mostra o elemento do indice informado
    public Object elemeAtRank(int index) throws SequenciaExcecao{

        if(length == 0){
            throw new SequenciaExcecao("Sequência VAZIA!");
        }
        if(index < 0 || index >= length){
            throw new SequenciaExcecao("Índice fora da Sequência");
        }

        No TargetNode = atRank(index);

        return TargetNode.getValue();

    }

    // troca o valor do inidice informado
    public void replaceAtRank(int index, Object objeto) throws SequenciaExcecao{

        if(length == 0){
            throw new SequenciaExcecao("Sequência VAZIA!");
        }
        if(index < 0 || index >= length){
            throw new SequenciaExcecao("Índice fora da Sequência");
        }

        No TargetNode = atRank(index);
        TargetNode.setValue(Object);

    }

    // insere um elemento no indice informado
    public void insertAtRank(int index, Object objeto) throws SequenciaExcecao{

        if(length == 0){
            throw new SequenciaExcecao("Sequência VAZIA!");
        }
        if(index < 0 || index >= length){
            throw new SequenciaExcecao("Índice fora da Sequência");
        }

        No newNode = new No(objeto);

        No TargetNode = atRank(index);
        No beforeNode = TargetNode.getPrev();
        No afterNode = TargetNode.setNext();

        newNode.setNext(afterNode);
        newNode.setPrev(beforeNode);
        
        beforeNode.setNext(newNode);
        afterNode.setPrev(newNode);

        length++;
    }

    // remove o elemento do indice informado
    public Object remove(int index) throws SequenciaExcecao{

        if(length == 0){
            throw new SequenciaExcecao("Sequência VAZIA!");
        }
        if(index < 0 || index >= length){
            throw new SequenciaExcecao("Índice fora da Sequência");
        }

        No TargetNode = atRank(index);

        No beforeNode = TargetNode.getPrev();
        No afterNode = TargetNode.setNext();

        beforeNode.setNext(afterNode);
        afterNode.setPrev(beforeNode);

        TargetNode.setPrev(null);
        TargetNode.setNext(null);

        length--;
    }


    // ======== MÉTODOS DE LISTA ============

    // mostra o primeiro elemento
    public Object first() throws SequenciaExcecao{

        if(length == 0){
            throw new SequenciaExcecao("Sequência VAZIA!");
        }

        return head.getNext();
    }

    // mostra o último elemento
    public Object last() throws SequenciaExcecao{

        if(length == 0){
            throw new SequenciaExcecao("Sequência VAZIA!");
        }

        return tail.getPrev();
    }

    // mostra um elemento antes do índice informado
    public Object before(int index) throws SequenciaExcecao{

        if(length == 0){
            throw new SequenciaExcecao("Sequência VAZIA!");
        }
        if(index < 0 || index >= length){
            throw new SequenciaExcecao("Índice fora da Sequência");
        }

        No TargetNode = atRank(index);

        return TargetNode.getPrev();

    }

    // mostra um elemento depois do indice informado
    public Object after(int index) throws SequenciaExcecao{

        if(length == 0){
            throw new SequenciaExcecao("Sequência VAZIA!");
        }
        if(index < 0 || index >= length){
            throw new SequenciaExcecao("Índice fora da Sequência");
        }

        No TargetNode = atRank(index);

        return TargetNode.getNext();

    }

    // substitui o elemento do índice informado
    public void replaceElement(int index, Object objeto) throws SequenciaExcecao{

        if(length == 0){
            throw new SequenciaExcecao("Sequência VAZIA!");
        }
        if(index < 0 || index >= length){
            throw new SequenciaExcecao("Índice fora da Sequência");
        }

        No TargetNode = atRank(index);
        TargetNode.setValue(objeto);

    }

    // troca os elementos de posição
    public void swapElements(int index, int index2) throws SequenciaExcecao{

        if(length == 0){
            throw new SequenciaExcecao("Sequência VAZIA!");
        }
        if(index < 0 || index >= length){
            throw new SequenciaExcecao("Índice fora da Sequência");
        }

        No target1 = atRank(index);
        No target2 = atRank(index2);

        No aux.setValue(target1.getValue());

        target1.setValue(target2.getValue());
        target2.setValue(aux.getValue());

    }

    //insere um elemento antes do indice informado
    public void insertBefore(int index, Object objeto) throws SequenciaExcecao{

        if(length == 0){
            throw new SequenciaExcecao("Sequência VAZIA!");
        }
        if(index < 0 || index >= length){
            throw new SequenciaExcecao("Índice fora da Sequência");
        }

        No newNode = new No(objeto);

        No TargetNode = atRank(index);
        No beforeNode = TargetNode.getPrev();

        newNode.setPrev(beforeNode);
        newNode.setNext(TargetNode);

        TargetNode.setPrev(newNode);
        beforeNode.setNext(newNode);

        length++;
    }

    //insere um elemendo depois do indice informado
    public void insertAfter(int index, Object objeto) throws SequenciaExcecao{

        if(length == 0){
            throw new SequenciaExcecao("Sequência VAZIA!");
        }
        if(index < 0 || index >= length){
            throw new SequenciaExcecao("Índice fora da Sequência");
        }

        No newNode = new No(objeto);

        No TargetNode = atRank(index);
        No afterNode = TargetNode.getNext();

        newNode.setPrev(TargetNode);
        newNode.setNext(afterNode);

        TargetNode.setNext(newNode);
        afterNode.setPrev(newNode);

        length++;
    }

    // insere um elemento no inicio
    public void insertFirst(Object objeto){

        if(length == 0){

            No newNode = new No(objeto);
            
            head.setNext(newNode);
            tail.setPrev(newNode);

            newNode.setPrev(head);

            length++;

        }else{

            No newNode = new No(objeto);

            No first = head.getNext();

            newNode.setPrev(head);
            newNode.setNext(first);

            head.setNext(newNode);
            first.setPrev(newNode);

            length++;
        }
        
    }

    // insere um elemento no fim
    public void insertLast(Object objeto){

         if(length == 0){

            No newNode = new No(objeto);
            
            head.setNext(newNode);
            tail.setPrev(newNode);

            newNode.setPrev(head);

            length++;
            
        }else{

            No newNode = new No(objeto);

            No last = tail.getPrev();

            newNode.setPrev(last);
            newNode.setNext(tail);

            last.setNext(newNode);
            tail.setPrev(newNode);

            length++;
        }
    }

    @Override
    public string toString(){

        Stringbuilder sb = new StringBuilder();
        sb.append("[HEAD] -> ");
        
        No guide = head.getNext();
        while( guide != tail){

            sb.append(guide.getValue());
            sb.append(" <-> ");

            guide = guide.getNext();

        }

        sb.append("[TAIL]");

        return sb.toString();

    }
}