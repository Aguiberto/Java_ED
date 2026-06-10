public class FilaHeap{

    private int tamanho;
    private NoHEAP raiz;

    public FilaHeap(){

        this.raiz = null;
        this.tamanho = 0;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

    public int size(){
        return this.tamanho;
    }

    // retorna o menor valor
    public Object min(){
        return this.raiz;
    }

    // Toda inserção na heap tem local definido
    public void insert(int chave, Object obj){

        NoHEAP novoNo = new NoHEAP(chave, obj);

        if(isEmpty()){
            raiz = novoNo;
            tamanho ++;
            return;
        }

        // Descobrir onde o nó será inserido


    }

    public Object removeMin(){

    }

    // ================== MÉTODOS AUXILIARES =================

    public void UpHeap(NoHEAP noAtual){

        // troca as chaves do no atual com a chave de seu no pai enquanto a chave do no atual for menor que a chave do no pai
        while( noAtual.getPai() != null && noAtual.getChave() < noAtual.getPai().getChave()){
            
            // Trocando as chaves
            int chaveTemporaria = noAtual.getChave();
            noAtual.setChave(noAtual.getPai().getChave());
            noAtual.getPai().setChave(chaveTemporaria);

            // Trocando os valores
            Object valorTemporario = noAtual.getValue();
            noAtual.setValue(noAtual.getPai().getValue());
            noAtual.getPai().setValue(valorTemporario);

            // Sobe o nó na árvore
            noAtual = noAtual.getValue();
        }
    }



}