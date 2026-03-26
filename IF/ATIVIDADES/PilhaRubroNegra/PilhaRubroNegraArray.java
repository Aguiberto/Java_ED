import java.util.Arrays;

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

    public boolean vermelhoVazio(){
        if(tamanhoVermelho() == 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean negroVazio(){
        if(tamanhoNegro() == 0){
            return true;
        }else{
            return false;
        }
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
        return pilha[this.indiceNegro + 1];
    }

    public void adicionarVermelho(Object objeto){

        if(tamanhoTotal() == this.capacidade){
            aumentarCapacidade();
        }

        pilha[++indiceVermelho] = objeto;
    }

    public void adicionarNegro(Object objeto){

        if(this.tamanhoVermelho() + this.tamanhoNegro() == this.capacidade){
            aumentarCapacidade();
        }

        pilha[indiceNegro--] = objeto;
    }

    public Object removerVermelho() throws PilhaVaziaExcecao{

        if(vermelhoVazio()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }

        Object removidoV = indiceVermelho--;

        if(tamanhoTotal() >= capacidade / 3){
            reduzirCapacidade();
        }

        return removidoV;
        
    }

    public Object removerNegro() throws PilhaVaziaExcecao{

        if(negroVazio()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }

        Object removidoN = pilha[indiceNegro++];

        if(tamanhoTotal >= capacidade / 3){
            reduzirCapacidade;
        }

        return removidoN;
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
    }

    private void reduzirCapacidade(){

        int capacidadeReduzida = capacidade / 2;
        Object [] pilhaMenor = new  Object [capacidadeReduzida]

        //Copiando os elementos da pilha vermelha para o novo array
        for(int i = 0; i < indiceVermelho; i++){
            pilhaMenor[i] = pilha[i];
        }

        //Copiando os elementos da pilha negra para o novo array
        int qtdNegro = tamanhoNegro();
        for(int i = 1; i <= qtdNegro; i++){
            pilhaMenor[capacidadeReduzida - i] = pilha[capacidade - i];
        }

        pilha = pilhaMenor;
        capacidade = capacidadeReduzida;
        indiceNegro = capacidade - qtdNegro;
    }

    @Override
    public String toString(){
        return Arrays.toString(this.pilha);
    }

}