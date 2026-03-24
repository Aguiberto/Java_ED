public class PilhaRubroNegra implements Pilha{

    private Object [] pilha;
    private int capacidade;
    private int indiceNegro;
    private int indiceVermelho;
    private int crescimento;


    public PilhaRubroNegra(){

        if(this.capacidade <= 0){
            throw PilhaVaziaExcecao('A pilha está vazia')
        }

        this.capacidade = 10;
        this.indiceVermelho = -1;
        this.indiceNegro = capacidade;
    }

    public int tamanhoVermelho(){
        return indiceVermelho;
    }

    public int tamanhoNegro(){
        return capacidade - (indiceNegro + 1);
    }

    public int tamanhoTotal(){
        return tamanhoVermelho() + tamanhoNegro();
    }

    public int topoVermelho() throws PilhaVaziaExcecao{

        if(tamanhoVermelho <= 0){
            throw PilhaVaziaExcecao('A pilha não tem nenhum elemento');
        }
        return this.indiceVermelho;
    }

    public int topoNegro() throws PilhaVaziaExcecao{

        if(tamanhoNegro <= 0){
            throw PilhaVaziaExcecao('A pilha não tem nenhum elemento');
        }
        return this.indiceNegro;
    }

    public Object adicionarVermelho(){

    }
    
    

}