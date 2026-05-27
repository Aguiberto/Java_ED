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

    public int height();
    public Iterator elements();
    public Iterator nos();
    public boolean isInternal();
    public boolean isExternal();
    public No root();
    public No parent();
    public int depth();

    public void replace();

    // ============= MÉTODOS ARVORE BINÁRIA ================

    public No leftChild()
    public No rightChild()
    public No hasLeft()
    public No hasRight()
    public void insert()
    public Object remove()


}