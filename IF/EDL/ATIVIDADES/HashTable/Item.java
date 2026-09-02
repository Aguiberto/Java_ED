public class Item<K,V>{

    private K chave;
    private V valor;

    public Item(K chave, V valor){
        this.chave = chave;
        this.valor = valor;
    }

    public K getChave(){
        return chave;
    }

    public void setChave(K novaChave){
        this.chave = novaChave;
    }

    public V getValor(){
        return this.valor;
    }

    public void setValor(V novoValor){
        this.valor = novoValor;
    }

}