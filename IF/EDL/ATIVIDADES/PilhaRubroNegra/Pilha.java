interface Pilha{

    int tamanhoNegro();

    int tamanhoVermelho();

    int tamanhoTotal();

    boolean vermelhoVazio();

    boolean negroVazio();

    void adicionarVermelho(Object objeto);

    void adicionarNegro(Object objeto);

    // Object removerVermelho();

    // Object removerNegro();

    Object topoVermelho();

    Object topoNegro();

}