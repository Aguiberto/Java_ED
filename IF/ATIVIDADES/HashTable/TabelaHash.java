import java.util.List;

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

        return listaChaves
    }

    public List<V> elements(){

        List listaElementos = new ArrayList<>();

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

        } while(indiceAtual =! indiceInicial);
        
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

        do{
            // Se o espaço está vazio então o item pode ser adicionado
            if(tabela[posicaoAtual] == null ){
                tabela[posicaoAtual] = new Item(chave,valor);
                this.tamanho ++;
                return;
            }
            // Se a chave passada já existir, apenas e atualizado o valor
            if(tamanho[posicaoAtual].getChave().equals(chave)){
                tabela[posicaoAtual].setValor(valor);
                return;
            }

            posicaoAtual = (posicaoAtual + 1) % this.capacidade;

        }while(posicaoAtual != posicaoInicial);



        
    }

    public removeElement(){

    }

    @Override
    public String ToString(){

    }

    // ============== MÉTODOS AUXILIARES ==================

    // Esse método retorna a chave que informa a posição que o item será inserido
    public int getHash(K chave){

        if(chave == null){
            return 0;
        }

        return Math.abs(key.hashCode()) % capacidade;
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
                return achou = true;
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
            return false
        }

        // laço incrementa de 6 em 6 que são o que tem a possibilidade de ser primo depois do 5
        // o laço teste até a raiz do valor
        for(int i = 5; i*i <= valor ; i += 6){

            if( valor % i == 0 || valor % (i + 2) == 0){
                return false;
            }

            return false;
        }
    }

    // Aumenta a tabela hash e usa uma nova funcão para definir posições
    //  A partir dessa nova função os elementos serão readiciondos ao novo array maior
    private void rehash(){

    }
    

}