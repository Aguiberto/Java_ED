import java.util.Iterator;

public class ArvoreBinaria{

    private No raiz;
    private int tamanho;
    
    public ArvoreBinaria(){
        this.raiz = null;;
    }


    // ============== MÉTODOS DE ARVORE GENÉRCA =========

    public int size(){

        return tamanho;
    }

    public boolean isEmpty(){

        return tamanho == 0;
    }

    // Calcula a altura total da árvore
    public int height(){
        
       return AlturaNo(raiz);
    }

    // esse método usa o método nos()
    public Iterator elements(){

        List<Object> listaElementos = new ArrayList<>();

        Iterator<No> itNos = nos();

        while(itNos.hasNext()){

            //adição na lista
            //usa o método de iterator para pegar o próximo elemento
            // o proximo elemento é um nó e por isso usa o método getValeu para pegar o valor dentro do nó
            listaElementos.add(itNos.next().getValue());
        }

        return listaElementos.iterator();
    }

    public Iterator<No> nos(){

        List<No> listaNos = new ArrayList<>();
        inOrdem(raiz, listaNos);
        
        return listaNos.iterator();
    }


    public boolean isInternal(No no){

        return no.getFilhoD() != null || no.getFilhoE() != null;
    }

    public boolean isExternal(No no){

        return no.getFilhoD() == null && no.getFilhoE() == null;
    }

    public No root(){

        return this.raiz;
    }

    public No parent(No no){
        return no.getPai();
    }

    public int depth(No no){

        int profundidade = 0;

        while(no != raiz){

            no = no.getPai();
            profundidade++;
        }

        return profundidade;
    }

    public Object replace(No no, Object obj) throws ArvoreBinExcecao{

        No noValidado = validarNo(no);

        Object oldValue = noValidado.getValue();

        no.setValue(obj);

        return oldValue;
    }

    // ============= MÉTODOS ARVORE BINÁRIA ================

    public No leftChild(No node) throws ArvoreBinExcecao{
        
        No noValidado = validarNo(node);

        return noValidado.getFilhoE();
    }

    public No rightChild(No node) throws ArvoreBinExcecao{

        No noValidado = validarNo(node);

        return noValidado.getFilhoD();
    }

    public boolean hasLeft(No node) throws ArvoreBinExcecao { 

        No noValidado = validarNo(node);

        return noValidado.getFilhoE() != null;
    }

    public boolean hasRight(No node) throws ArvoreBinExcecao{

        No noValidado = validarNo(node);

        return noValidado.getFilhoD() != null;
    }

    public void insert(Comparable obj){

        raiz = insertRecursivo(raiz, obj);
    }

    public Object remove(Comparable obj) throws ArvoreBinExcecao{

        if(isEmpty()){
            throw new ArvoreBinExcecao("A árvore já encontra-se vazia!");
        }

        raiz = processoRemovedor(raiz,obj);

    }
        


    public String mostrarArvore()

    // ==============   MÉTODOS AUXILIARES ==============

    private No validarNo(No no) throws ArvoreBinExcecao{

        if( no.getValue() == null){
            throw new ArvoreBinExcecao("Nó VAZIO");
        }

        return no;
    }

    // Calcula a altura de um nó (Não confundir com height)
    private int AlturaNo(No node){

        if(node == null){
            return -1;
        }

        int altura = 0;

        // calcula as alturas de cada lado
        int lefHeight = AlturaNo(node.getFilhoE());
        int rightHeight = AlturaNo(node.getFilhoD());

        // Escolhe a maior altura entre os dois lados
        int alturaTotal = Math.max(lefHeight,rightHeight) + 1;

        return alturaTotal;
    }

    private No insertRecursivo(No node, Compareble obj){

        if( node == null){
            tamanho++;
            return new No(obj);
        }

        if(obj.compareTo(node.getValue() < 0)){
            No filhoE = insertRecursivo(node.getFilhoE(), obj);
            node.setFilhoE(filhoE);
            filhoE.setPai(node);

        }
        else if(obj.compareTo(node.getValue()) > 0){
            No filhoD = insertRecursivo(node.getFilhoD(),obj);
            node.setFilhoD(filhoD);
            filhoD.setPai(node);
        }
        
        return node
    }

    private void inOrdem(No node, ArrayList<Object> lista){

        if(node != null){
            inOrdem(node.getFilhoE(),lista);
            lista.add(node);
            inOrdem(node.getFilhoD(),lista);
        }

    }

    private No processoRemovedor(No noBase, Comparable obj ){

        if(noBase == null){
            return null;
        }

        

    }

    
}