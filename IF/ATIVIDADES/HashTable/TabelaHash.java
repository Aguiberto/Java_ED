public class TabelaHash<K,V>{

    private Item<K,V> [] tabela;
    private int capacidade;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public TabelaHash(int capacidade){
        this.capacidade = capacidade;
        this.tamanho = 0;

        this.tabela =  (Item<K,V>[]) new Item[capacidade];
    }

    public int size(){
        return this.tamanho;
    }

    public boolean isEmpty(){
        return this.tamanho == 0;
    }

    // public keys(){

    // }

    // public elements(){

    // }

    // public findElement(){

    // }

    // Fazer Rehash se o limite de eficiencia tiver sido atingido(50% da capacidade)
    // Dobrar a capacidade
    public void insertItem(K chave, V valor) throws HashExcecao{

        int posicao = getHash(chave);

        // Guarda a primeira posição
        // A classe usa array circular então a primeira posição pode ser quaquer uma
        //Além disso o valor da posição vai mudando 
        int posicaoInicial = posicao;

        while(tabela[posicao] != null){

            if(tabela[posicao].getChave().equals(chave)){
                tabela[posicao].setValor(valor);

                return;
            }
            
            // Linear Probing
            // Lógica do array circular para movimentar o ponteiro do índice de forma cíclica
            posicao = (posicao + 1) % capacidade;

            if(posicao == posicaoInicial){
                throw new HashExcecao("Hash CHEIO!")
            }
        }

        tabela[posicao] = new Item<K,V>(chave,valor);
        tamanho++;
    }

    public removeElement(){

    }

    @Override
    public String ToString(){

    }

    // ============== MÉTODOS AUXILIARES ==================

    // Esse método retorna a chave que informa a posição do item
    public int getHash(K chave){

        if(chave == null){
            return 0;
        }

        return Math.abs(key.hashCode()) % capacidade;
    }

    private boolean testePrimo(int valor){

        // elimina todos os negativo, 0 e o 1
        if (valor <= 1){
            return false;
        }

        // aceita o 2 e 3
        if( valor <= 3){
            return true;
        }

        if( valor % 2 == 0 || valor % 3 == 0){
            return false
        }

        // laço incrementa de 6 em 6 que são o que tem a possibilidade de ser primo depois do 5
        // o laço teste até a raiz do valor
        for(int i = 5; i*i <= valor ; i += 6){
            if( valor % i == 0 || valor % (i + 2) == 0){
                return false;
            }
        }

        return true;

    }


}