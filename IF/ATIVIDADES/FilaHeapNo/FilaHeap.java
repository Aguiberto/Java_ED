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
        return this.raiz.getValue();
    }

    // Toda inserção na heap tem local definido
    public void insert(int chave, Object obj){

        NoHEAP novoNo = new NoHEAP(chave, obj);

        if(isEmpty()){
            raiz = novoNo;
            tamanho ++;
            return;
        }

        int posicaoPai = (tamanho+1) / 2;

        // Descobrir onde o nó será inserido
        NoHEAP noAlvo = encontrarPosicao(posicaoPai);
        tamanho++;

        // ajustando as referências
        novoNo.setPai(noAlvo);
        if(noAlvo.getFilhoE() == null){
            noAlvo.setFilhoE(novoNo);
        }else{
            noAlvo.setFilhoD(novoNo);
        }

        // colocando na posição correta
        UpHeap(novoNo);
    }

    public Object removeMin()throws HeapExcecao{

        if(isEmpty()){
            throw new HeapExcecao("HEAP Vazia!");
        }

        // A remoção do menor é sempre a remoção da raiz para Árvore HEAP
        Object objRemovido = raiz.getValue();

        // Caso especial
        if(tamanho == 1){
            raiz = null;
            tamanho = 0;
            return objRemovido;
        }

        // A remoção física ocorre no último nó
        NoHEAP ultimoNo = encontrarPosicao(tamanho);

        // Ajustando as referências
        raiz.setChave(ultimoNo.getChave());
        raiz.setValue(ultimoNo.getValue());

        //Desconectar o pai do ultimo nó para removê-lo
        NoHEAP ultimoPai = ultimoNo.getPai();
        if(ultimoPai.getFilhoE() == ultimoNo){
            ultimoPai.setFilhoE(null);
        }else{
            ultimoPai.setFilhoD(null);
        }
        ultimoNo.setPai(null);

        tamanho --;

        // Corrige a posição do nó que substituiu a raiz temporariamente.
        DownHeap(raiz);

        return objRemovido;
    }

    public void mostrarArvore(){

        if(isEmpty()){
            System.out.println("HEAP Vazia");
            return;
        }

        mostraNo(raiz,0);
    }





    // ================== MÉTODOS AUXILIARES =================

    private void UpHeap(NoHEAP noAtual){

        // troca as chaves do no noAlvo com a chave de seu no pai enquanto a chave do no noAlvo for menor que a chave do no pai
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
           noAtual = noAtual.getPai();
        }
    }

    private void DownHeap(NoHEAP no){
        
        while(raiz.getFilhoE() != null){

            // Assume que o filho da esquerda é o menor
            NoHEAP menorFilho = no.getFilhoE();

            // Verifica se o filho direito é menor e se for verdadeiro atualiza
            if(raiz.getFilhoD() != null && no.getFilhoD().getChave() < menorFilho.getChave()){
                menorFilho = no.getFilhoD();
            }

            if(no.getChave() <= menorFilho.getChave()){
                break;
            }

            // Ajusta as chaves
            int chaveTemp = no.getChave();
            no.setChave(menorFilho.getChave());
            menorFilho.setChave(chaveTemp);

            Object valorTemp = no.getValue();
            no.setValue(menorFilho.getValue());
            menorFilho.setValue(valorTemp);

            no = menorFilho;
        }

    }
    
    /** pega tamanho+1 (tamanho noAlvo + elemento adicionado)
     * converte para binário ex: 6 = 110
     * ignora o primeiro elemento "1"
     * os proximo elementos indicam quantos passos serão dados e para qual direção
     * 1 = direita e 0 = esquerda
     * nesse caso anda um elemento para direita e outro para esquerda
    */
    private NoHEAP encontrarPosicao(int tamanhoArvore){

        String binario = Integer.toBinaryString(tamanhoArvore);
        NoHEAP noAlvo = raiz;

        for(int i = 1; i < binario.length();i++){
            if(binario.charAt(i) == 0){
                noAlvo = noAlvo.getFilhoE();
            }else{
                noAlvo = noAlvo.getFilhoD();
            }
        }

        return noAlvo;
    }

    private void mostraNo(NoHEAP no, int nivel){
        if(no == null){
            return;
        }

        mostraNo(no.getFilhoD(), nivel+1);

        for(int i = 0; i < nivel; i++){
            System.out.println("    ");
        }
        System.out.println("["+ no.getChave() + ":" + no.getValue() + "]");

        mostraNo(no.getFilhoE(), nivel + 1);
    }
}