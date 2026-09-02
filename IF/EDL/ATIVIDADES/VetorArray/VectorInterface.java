public interface VectorInterface{
    
    public int size();

    public boolean isEmpty();

    public Object elemAtRank(int index) throws VectorExcecao;
    // retorna o valor do índice escolhido.

    public Object replaceAtRank(int index, Object value) throws VectorExcecao;
    // Substitui um valor no array e mostra qual foi substituído.

    public void insertAtRank(int index, Object valeu) throws VectorExcecao;
    // Insere o valor no índice informado.

    public Object removeAtRank(int index) throws VectorExcecao;
    // Remove um valor do índice informado.


}