interface Pilha{

    int tamanhoNegro();

    int tamanhoVermelho();

    int tamanhoTotal();

    int indiceNegro();

    int indiceVermelho();

    void adicionarVermelho();

    void adicionarNegro();

    Object removerVermelho();

    Object removerNegro();

    int topoVermelho();

    int topoNegro();

}