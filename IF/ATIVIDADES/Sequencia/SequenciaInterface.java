public interface SequenciaInterface{

    // ========== MÉTODOS GENÉRICOS ==========

    public boolean isEmpty();

    public int size();

    // =========== METODOS DE VETOR ==========

    // mostra o elemento do indice informado
    public Object elemeAtRank(int index);

    // troca o valor do inidice informado
    public void replaceAtRank(int index, Object objeto) throws SequenciaExcecao;

    // insere um elemento no indice informado
    public void insertAtRank(int index, Object objeto) throws SequenciaExcecao;

    // remove o elemento do indice informado
    public Object remove(int index);

    // =========== MÉTODOS DE LISTA =============

    // mostra o primeiro elemento
    public Object first() throws SequenciaExcecao;

    // mostra o último elemento
    public Object last() throws SequenciaExcecao;

    // mostra um elemento antes do índice informado
    public Object before(int index) throws SequenciaExcecao;

    // mostra um elemento depois do indice informado
    public Object after(int index) throws SequenciaExcecao;

    // substitui o elemento do índice informado
    public void replaceElement(int index, Object objeto) throws SequenciaExcecao;

    // troca os elementos de posição
    public void swapElements(int index, int index2) throws SequenciaExcecao;

    //insere um elemento antes do indice informado
    public void insertBefore(int index, Object objeto) throws SequenciaExcecao;

    //insere um elemendo depois do indice informado
    public void insertAfter(int index, Object objeto) throws SequenciaExcecao;

    // insere um elemento no inicio
    public void insertFirst(Object objeto);

    // insere um elemento no fim
    public void insertLast(Object objeto);

    // ========== MÉTODOS PONTE =======

    // recebe um indice e  devolve um nó
    public No atRank(int index);

    // recebe um nó e devolve um índice
    public int rankOf(No node);

}