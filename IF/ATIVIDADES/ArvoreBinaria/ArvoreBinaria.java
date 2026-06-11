import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria{

    private No raiz;
    private int tamanho;
    
    public ArvoreBinaria(){
        this.raiz = null;;
    }


    // ============== MÉTODOS DE ARVORE GENÉRCA =========

    public int size(){

        return tamanho;
    }

    public boolean isEmpty(){

        return tamanho == 0;
    }

    // Calcula a altura total da árvore
    public int height(){
        
       return AlturaNo(raiz);
    }

    // esse método usa o método nos()
    public Iterator elements(){

        List<Comparable> listaElementos = new ArrayList<>();

        Iterator<No> itNos = nos();

        while(itNos.hasNext()){

            //adição na lista
            //usa o método de iterator para pegar o próximo elemento
            // o proximo elemento é um nó e por isso usa o método getValeu para pegar o valor dentro do nó
            listaElementos.add(itNos.next().getValue());
        }

        return listaElementos.iterator();
    }

    public Iterator<No> nos(){

        List<No> listaNos = new ArrayList<>();
        inOrdem(raiz, listaNos);
        
        return listaNos.iterator();
    }


    public boolean isInternal(No no){

        return no.getFilhoD() != null || no.getFilhoE() != null;
    }

    public boolean isExternal(No no){

        return no.getFilhoD() == null && no.getFilhoE() == null;
    }

    public No root(){

        return this.raiz;
    }

    public No parent(No no){
        return no.getPai();
    }

    public int depth(No no){

        int profundidade = 0;

        while(no != raiz){

            no = no.getPai();
            profundidade++;
        }

        return profundidade;
    }

    public Comparable replace(No no, Comparable obj) throws ArvoreBinExcecao{

        No noValidado = validarNo(no);

        Comparable oldValue = noValidado.getValue();

        no.setValue(obj);

        return oldValue;
    }

    // ============= MÉTODOS ARVORE BINÁRIA ================

    public No leftChild(No node) throws ArvoreBinExcecao{
        
        No noValidado = validarNo(node);

        return noValidado.getFilhoE();
    }

    public No rightChild(No node) throws ArvoreBinExcecao{

        No noValidado = validarNo(node);

        return noValidado.getFilhoD();
    }

    public boolean hasLeft(No node) throws ArvoreBinExcecao { 

        No noValidado = validarNo(node);

        return noValidado.getFilhoE() != null;
    }

    public boolean hasRight(No node) throws ArvoreBinExcecao{

        No noValidado = validarNo(node);

        return noValidado.getFilhoD() != null;
    }

    public void insert(Comparable obj){

        raiz = insertRecursivo(raiz, obj);
    }

    public void remove(Comparable obj) throws ArvoreBinExcecao{

        if(isEmpty()){
            throw new ArvoreBinExcecao("A árvore já encontra-se vazia!");
        }

        raiz = processoRemovedor(raiz,obj);
    }
        
        
    public void mostrarArvore() {
        int altura = height();
        if (altura == -1) {
            System.out.println("Árvore vazia.");
            return;
        }

        // Calcula as dimensões da tabela de desenho
        int linhas = altura + 1;
        // A largura máxima de uma árvore cheia segue a fórmula: 2^(altura + 1) - 1
        int colunas = (int) Math.pow(2, altura + 1) - 1;

        // Cria uma matriz de strings preenchida com espaços em branco
        String[][] matriz = new String[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = " ";
            }
        }

        // Preenche a matriz de forma recursiva passando as coordenadas de desenho
        preencherMatriz(this.raiz, matriz, 0, 0, colunas - 1);

        // Imprime a matriz linha por linha no console
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println(); // Quebra de linha para o próximo nível
        }
    }

    // ==============   MÉTODOS AUXILIARES ==============

    private No validarNo(No no) throws ArvoreBinExcecao{

        if( no.getValue() == null){
            throw new ArvoreBinExcecao("Nó VAZIO");
        }

        return no;
    }

    // Calcula a altura de um nó (Não confundir com height)
    private int AlturaNo(No node){

        if(node == null){
            return -1;
        }

        int altura = 0;

        // calcula as alturas de cada lado
        int lefHeight = AlturaNo(node.getFilhoE());
        int rightHeight = AlturaNo(node.getFilhoD());

        // Escolhe a maior altura entre os dois lados
        int alturaTotal = Math.max(lefHeight,rightHeight) + 1;

        return alturaTotal;
    }

    private No insertRecursivo(No node, Comparable obj){

        if( node == null){
            tamanho++;
            return new No(obj);
        }

        if(obj.compareTo(node.getValue()) < 0){
            No filhoE = insertRecursivo(node.getFilhoE(), obj);
            node.setFilhoE(filhoE);
            filhoE.setPai(node);

        }
        else if(obj.compareTo(node.getValue()) > 0){
            No filhoD = insertRecursivo(node.getFilhoD(),obj);
            node.setFilhoD(filhoD);
            filhoD.setPai(node);
        }
        
        return node;
    }

    private void inOrdem(No node, List<No> lista){

        if(node != null){
            inOrdem(node.getFilhoE(),lista);
            lista.add(node);
            inOrdem(node.getFilhoD(),lista);
        }

    }

    private No processoRemovedor(No noBase, Comparable obj ){

        if(noBase == null){
            return null;
        }

        // procurando o nó
        if(obj.compareTo(noBase.getValue()) < 0){

          noBase.setFilhoE(processoRemovedor(noBase.getFilhoE(),obj));  

        }else if(obj.compareTo(noBase.getValue()) > 0){

            noBase.setFilhoD(processoRemovedor(noBase.getFilhoD(),obj));
        
        // Quando o nó for localiza cai no else
        }else{
            tamanho--;

            // Se não tiver filho esquerdo
            if(noBase.getFilhoE() == null){
                // Se tiver filho direito
                if(noBase.getFilhoD() != null){
                    noBase.getFilhoD().setPai(noBase.getPai());
                    // ajusta as referências entre avô e neto excluindo o pai
                }
                // Se não tem nenhum filho
                // No caso como o folha n tem filho é a mesma coisa que retornar null
                //  esse retorno volta para a linha 225
                // o pai seta o filho como null e corta sua ligação removendo o nó
                return noBase.getFilhoD();
 
            }else if(noBase.getFilhoD() == null){

                if(noBase.getFilhoE() != null){
                    noBase.getFilhoE().setPai(noBase.getPai());
                }

                return noBase.getFilhoE();
            }

            // CASO O NO TENHA 2 FILHOS

            // Cria um no que pega o primeiro filho da direita e depois vai descendo pela esquerda até o final
            No sucessor = menorNo(noBase.getFilhoD());
            // Substitui o valor no base pelo valor de um nó folha
            noBase.setValue(sucessor.getValue());

            noBase.setFilhoD(processoRemovedor(noBase.getFilhoD(),(Comparable)sucessor.getValue()));
            tamanho++;

        }
        return noBase;
    }

    private No menorNo(No noBase){

        while(noBase.getFilhoE() != null){
            noBase = noBase.getFilhoE();
        }

        return noBase;
    }

    // Método auxiliar que calcula onde cada nó deve ficar centralizado
    private void preencherMatriz(No noAtual, String[][] matriz, int linha, int esquerda, int direita) {
        if (noAtual == null) {
            return;
        }

        // Encontra o ponto médio (centro) do espaço disponível para este nó
        int meio = (esquerda + direita) / 2;
        
        // Guarda o valor do nó bem no centro daquela linha
        matriz[linha][meio] = String.valueOf(noAtual.getValue());

        // Para os filhos, dividimos o espaço horizontal pela metade:
        // O filho esquerdo ganha a metade da esquerda
        preencherMatriz(noAtual.getFilhoE(), matriz, linha + 1, esquerda, meio - 1);
        
        // O filho direito ganha a metade da direita
        preencherMatriz(noAtual.getFilhoD(), matriz, linha + 1, meio + 1, direita);
    }
}
    
