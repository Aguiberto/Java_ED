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
        this.indiceNegro = capacidade -1;
    }

    public int tamanhoVermelho(){
        return this.indiceVermelho;
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

    public void adicionarVermelho(Object objeto){

        if(this.tamanhoVermelho + this.tamanhoNegro == this.capacidade){
            aumentarCapacidade()
        }

        pilha[++this.indiceVermelho] = objeto;
        this.tamanhoVermelho += 1;
    }

    public void adicionarNegro(Object objeto){

        if(this.tamanhoVermelho + this.tamanhoNegro == this.capacidade){
            aumentarCapacidade()
        }

        pilha[this.indiceNegro--] = objeto;
        this.tamanhoNegro += 1;
    }
    
    public Object [] aumentarCapacidade(Object [] pilha){

        Object [] nova_pilha = new Object[capacidade*2];

        // copia os valores do vermelho para a nova pilha
        for(int i = 0; i < indiceVermelho+1; i++ ){
            nova_pilha[i] = pilha[i];
        }

        // copia os valores negros para a nova pilha
        for(int i = capacidade; i > /**CRIAR ESSA CONDIÇÃO */ ;i--){
            nova_pilha[i] = pilha[i];
        }

        // pilha antiga agora aponta para a nova pilha
        pilha = nova_pilha;

        return pilha;

    }

    // REDUZIR CAPACIDADE

}