import java.util.Iterator;

public class ArvoreBinaria{

    private No raiz;
    private int tamanho;
    
    public ArvoreBinaria(){
        this.raiz = null;;
    }

    // ==============   MÉTODOS AUXILIARES ==============

    public No validarNo(No no) throws ArvoreBinExcecao{

        if( no.getValue() == null){
            throw new ArvoreBinExcecao("Nó VAZIO");
        }

        return no;
    }


    // ============== MÉTODOS DE ARVORE GENÉRCA =========

    public int size(){

        return tamanho;
    }

    public boolean isEmpty(){

        return tamanho == 0;
    }

    public int height(){
        
    }

    public Iterator elements();

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

    public No leftChild()
    public No rightChild()
    public No hasLeft()
    public No hasRight()
    public void insert()
    public Object remove()


}