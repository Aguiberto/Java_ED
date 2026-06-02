import java.util.Iterator;

public class ArvoreBinaria{

    private No raiz;
    private int tamanho;
    
    public ArvoreBinaria(){
        this.raiz = null;;
    }

    // ==============   MÉTODOS AUXILIARES ==============

    private No validarNo(No no) throws ArvoreBinExcecao{

        if( no.getValue() == null){
            throw new ArvoreBinExcecao("Nó VAZIO");
        }

        return no;
    }

    private calcularAltura(No node){

        if(node == null){
            return -1;
        }

        int altura = 0;

        int lefHeight = height(node.getFilhoE());
        int rightHeight = height(node.getFilhoD());

        int alturaTotal = Math.max(lefHeight,rightHeight) + 1;

        return alturaTotal;
    }

    private insertRecursivo(No node, Object obj){

        if( noAtual == null){
            return new No(obj);
        }
    }

    private void inOrdem(No node, ArrayList<Object> lista){

        if( node == null){
            return;
        }

        lista.add(node.getValue());

        for( No )

    }


    // ============== MÉTODOS DE ARVORE GENÉRCA =========

    public int size(){

        return tamanho;
    }

    public boolean isEmpty(){

        return tamanho == 0;
    }

    public int height(){
        
       return calcularAltura(raiz);
    }

    public Iterator elements(){

        // cria o array que vai guardar os elementos
        List<Object> elementos = new ArrayList<>();

        // chama o método que vai organizar os elementos da árvore na lista
        inOrdem(raiz, elementos);

        // devolve uma lista com o iterator
        return elementos.iterator();
    }

    public Iterator nos();


    public boolean isInternal(No no){

        return no.getFilhoD() || no.getFilhoE();
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

    public void insert(Object obj){

        raiz = insertRecursivo(raiz, obj);
    }

    public Object remove(No node)

    public String mostrarArvore()
}