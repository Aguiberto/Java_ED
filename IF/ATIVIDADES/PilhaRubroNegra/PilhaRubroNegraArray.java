public class PilhaRubroNegraArray implements Pilha{

    private Object [] pilha;
    private int capacidade;
    private int indiceNegro;
    private int indiceVermelho;
    private int crescimento;

    public PilhaRubroNegraArray(){

        this.capacidade = 10;
        this.pilha = new Object[capacidade];
        this.indiceVermelho = -1;
        this.indiceNegro = capacidade -1;
    }

    public int tamanhoVermelho(){
        return this.indiceVermelho+1;
    }

    public int tamanhoNegro(){
        return this.capacidade - this.indiceNegro;
    }

    public int tamanhoTotal(){
        return tamanhoVermelho() + tamanhoNegro();
    }

    public Object topoVermelho() throws PilhaVaziaExcecao{

        if(tamanhoVermelho() <= 0){
            throw new PilhaVaziaExcecao("A pilha não tem nenhum elemento");
        }
        return pilha[this.indiceVermelho];
    }

    public Object topoNegro() throws PilhaVaziaExcecao{

        if(tamanhoNegro() <= 0){
            throw new PilhaVaziaExcecao("A pilha não tem nenhum elemento");
        }
        return pilha[this.indiceNegro];
    }

    public void adicionarVermelho(Object objeto){

        if(tamanhoTotal() == this.capacidade){
            aumentarCapacidade();
        }

        pilha[++this.indiceVermelho] = objeto;
    }

    public void adicionarNegro(Object objeto){

        if(this.tamanhoVermelho() + this.tamanhoNegro() == this.capacidade){
            aumentarCapacidade();
        }

        pilha[this.indiceNegro--] = objeto;
    }
    
    private void aumentarCapacidade(){

        int novaCapacidade = capacidade * 2;
        Object [] novaPilha = new Object[novaCapacidade];

        // copia os valores do vermelho para a nova pilha
        for(int i = 0; i < indiceVermelho+1; i++ ){
            novaPilha[i] = pilha[i];
        }

        // copia os valores negros para a nova pilha
        int qtdNegro = tamanhoNegro();
        int novoIndiceNegro = novaCapacidade - qtdNegro;

        for(int i = 1; i <= qtdNegro; i++){
            novaPilha[novaCapacidade - i] = pilha[capacidade - i];
        }

        // pilha antiga agora aponta para a nova pilha
        this.pilha = novaPilha;
        this.capacidade = novaCapacidade;
        this.indiceNegro = novoIndiceNegro;

        @Override
        

    }

    // REDUZIR CAPACIDADE

}