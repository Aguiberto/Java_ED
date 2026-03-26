interface Fila{

    public int tamanho();

    public boolean estaVazio();

    public Object primeiro() throws FilaVaziaExcecao;

    public void adicionar(Object objeto);

    public Object remover(Object objeto) throws FilaVaziaExcecao;

   

}