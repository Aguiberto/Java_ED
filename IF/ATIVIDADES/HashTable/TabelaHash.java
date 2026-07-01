import java.util.List;
import java.util.ArrayList;

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

    public List<K> keys(){

        List<K> listaChaves = new ArrayList<>();

        for(int i = 0; i < this.capacidade; i++){
            if(tabela[i] != null){
                listaChaves.add(tabela[i].getChave());
            }
        }

        return listaChaves;
    }

    public List<V> elements(){

        List<V> listaElementos = new ArrayList<>();

        for(int i = 0; i < this.capacidade; i++){
            if(tabela[i] != null){
                listaElementos.add(tabela[i].getValor());
            }
        }

        return listaElementos;

    }

    public V findElement(K chave){

        if(chave == null){
            return null;
        }

        int indiceAtual = Math.abs(chave.hashCode()) % this.capacidade;
        int indiceInicial = indiceAtual;

        do{

            if(tabela[indiceAtual] == null){
                return null;
            }

            if(tabela[indiceAtual].getChave().equals(chave)){
                return tabela[indiceAtual].getValor();
            }

            indiceAtual = (indiceAtual + 1) % this.capacidade;

        } while(indiceAtual != indiceInicial);
        
        return null;

    }

    // Fazer Rehash se o limite de eficiencia tiver sido atingido(50% da capacidade)
    // Dobrar a capacidade
    public void insertItem(K chave, V valor) throws HashExcecao{

        int posicao = getHash(chave);

        // Guarda a primeira posição
        // A classe usa array circular então a primeira posição pode ser quaquer uma
        //Além disso o valor da posição vai mudando 
        int posicaoInicial = posicao;
        int posicaoAtual = posicaoInicial;

        if((double) (tamanho + 1) / capacidade >= 0.75){
            rehash();
        }

        do{
            // Se o espaço está vazio então o item pode ser adicionado
            if(tabela[posicaoAtual] == null ){
                tabela[posicaoAtual] = new Item(chave,valor);
                this.tamanho ++;
                return;
            }
            // Se a chave passada já existir, apenas e atualizado o valor
            if(tabela[posicaoAtual].getChave().equals(chave)){
                tabela[posicaoAtual].setValor(valor);
                return;
            }

            posicaoAtual = (posicaoAtual + 1) % this.capacidade;

        }while(posicaoAtual != posicaoInicial);
    }

    // public removeElement(){

    // }

    @Override
    public String toString(){

        StringBuilder construtor = new StringBuilder();

        construtor.append("--- TBELA HASH (Tamanho: ")
                 .append(this.tamanho)
                 .append(" | Capacidade: ")
                 .append(this.capacidade)
                 .append(") --- \n");

        for(int i  = 0 ; i < this.capacidade; i++){

            construtor.append("[").append(i).append("]");

            if(tabela[i] == null){
                construtor.append("<vazio>\n");
            }else{
                construtor.append("Chave: ").append(tabela[i].getChave())
                          .append("-> Valor: ").append(tabela[i].getValor())
                          .append("\n");
            }
        }

        construtor.append("--------------------");
        return construtor.toString();

    }

    // ============== MÉTODOS AUXILIARES ==================

    // Esse método retorna a chave que informa a posição que o item será inserido
    public int getHash(K chave){

        if(chave == null){
            return 0;
        }

        return Math.abs(chave.hashCode()) % capacidade;
    }

    private int proximoPrimo(int numero){

        int primo = numero;
        boolean achou = false;

        if(numero <= 1){
            return 2;
        }

        while(!achou){
            primo++;

            if(testePrimo(primo)){
                achou = true;
            }
        }

        return primo;

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
            return false;
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

    // Aumenta a tabela hash e usa uma nova funcão para definir posições
    //  A partir dessa nova função os elementos serão readiciondos ao novo array maior
    private void rehash(){

        // pega vê o próximo valor primo depois do dobro da capacidade atual
        int novaCapacidade = proximoPrimo(this.capacidade * 2);
        // salva a tabela antiga
        Item<K,V> [] tabelaVelha = this.tabela;

        // aumenta a capacidade do array para o proximo primo depois do dobro
        this.tabela = (Item<K,V> []) new Item[novaCapacidade];
        this.capacidade = novaCapacidade;
        this.tamanho = 0;

        // Percorre todo o array de itens, se o index tiver preenchido pega esse indice e valor a adicona ao novo array.
        //
        for(int i=0; i < tabelaVelha.length; i++){
            if(tabelaVelha[i] != null){
                insertItem(tabelaVelha[i].getChave(), tabelaVelha[i].getValor());
            }
        }

    }
    

}