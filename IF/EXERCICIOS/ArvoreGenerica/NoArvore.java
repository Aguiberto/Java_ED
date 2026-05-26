import java.util.Vector;

public class NoArvore{

    private Object obj;
    private NoArvore pai;

    // Esse atributo é uma vetor  com todos os filhos (Cada filho é do tipo NoArvore)
    private Vector<NoArvore> filhos;



    /**No de árvore genérica começa com:
     * um objeto
     * sem pai definido
     * sem filho definido
     */
    public NoArvore(Object obj){

        this.obj = obj;
        this.pai = null;
        this.filhos = new Vector<NoArvore>();

    }

    public Object getObj(){
        return this.obj;
    }

    public void setObj(Object obj){
        this.obj = obj;
    }

    public NoArvore getPai(){
        return pai;
    }

    public void setPai(NoArvore pai){
        this.pai = pai;
    }

    // Retorna uma "lista" com todos os filhos
    public Vector<NoArvore> getFilhos(){
        return filhos;
    }

    public void adicionarFilho(NoArvore filho){

        // Define o pai do filho que vai ser adicionado
        filho.setPai(this);

        //Adiciona a lista de filhos desse nó um novo filho
        this.filhos.add(filho);
    }

}