package VetorLigado;

public interface VetorLigadoIF{

    public boolean isEmpty();

    public int size();

    public Object elemAtRank(int index) throws VetorLigadoExcecao;

    public Object replaceAtRank(int index, Object objeto) throws VetorLigadoExcecao;

    public void insertAtRank(int index, Object objeto) throws VetorLigadoExcecao;

    public Object removeAtRank(int index) throws VetorLigadoExcecao;

}