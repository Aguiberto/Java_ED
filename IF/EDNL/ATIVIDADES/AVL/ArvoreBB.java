import java.util.Queue;
import java.util.LinkedList;

public class ArvoreBB{

    private Node raiz;
    private int tamanho;

    public ArvoreBB(){
        this.raiz = null;
    }

    public void insert(Object valor){

        /* Condições para adicionar um novo nó:
         * Verificar se tem raiz, se nao tiver o no inserido vai ser a raiz
         * A inserção deve ser em um nó folha
         * Percorrer toda a arvore comparando o valor a ser inserido com os nós e ir descendo para direita ou para esquerda
         * Se o valor a ser inserido for maior que o no atual ir para a direita
         * Se for menor ir para a esquerda
         * Se for igual retornar nada
         */

        Node novoNo = criarNo(valor);

        if( raiz == null){
            raiz = novoNo;
            return;
        }

        // buscar local de inserção

        Node atual = this.raiz;
        Node pai = null;

        while(atual != null){

            pai = atual;

            Comparable valorAtual = (Comparable) atual.getValor();
            Comparable valorNovo = (Comparable) valor;

            int comparacao = valorNovo.compareTo(valorAtual);

            if(comparacao == 0){

                return;

           }else if(comparacao < 0){
               
                atual = atual.getFilhoEsquerdo();

                if(atual == null){

                    pai.setFilhoEsquerdo(novoNo);
                    novoNo.setPai(novoNo);
                    return;
                }

            }else{

                atual = atual.getFilhoDireito();

                if(atual == null){

                    pai.setFilhoDireito(novoNo);
                    novoNo.setPai(novoNo);
                    return;
                }

            }
        }
    }

    public Object remover(Object valor){

        Node noRemovido = buscar(valor);
        if( noRemovido == null){
            return null;
        }

        Object valorRemovido = noRemovido.getValor();
        removerNo(noRemovido);

        return valorRemovido;

    }

public void mostrar() {
        if (this.raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }

        Queue<Node> fila = new LinkedList<>();
        fila.add(this.raiz);

        int altura = calcularAltura(this.raiz);
        int espacoInicial = (int) Math.pow(2, altura) * 2;

        while (!fila.isEmpty()) {
            int noNoNivel = fila.size();
            
            // Imprime espaçamento antes do primeiro nó do nível
            imprimirEspacos(espacoInicial);

            for (int i = 0; i < noNoNivel; i++) {
                Node atual = fila.poll();

                if (atual != null) {
                    System.out.print(atual.getValor());
                    fila.add(atual.getFilhoEsquerdo());
                    fila.add(atual.getFilhoDireito());
                } else {
                    System.out.print(" ");
                    // Mantém o alinhamento para filhos ausentes
                    fila.add(null);
                    fila.add(null);
                }

                // Espaçamento entre os nós do mesmo nível
                imprimirEspacos(espacoInicial * 2 - 1);
            }

            System.out.println("\n"); // Quebra para o próximo nível
            espacoInicial /= 2; // Reduz o espaço pela metade a cada nível abaixo

            // Condição de parada: se a fila só contiver 'null', encerra
            if (todasPonteirosNulos(fila)) {
                break;
            }
        }
    }

    // ==================== MÉTODOS AUXILIARES ==============


    public Node criarNo(Object valor){
        Node novoNo = new Node(valor);
        return novoNo;
    }

    public Node buscar(Object valor){

        Node atual = this.raiz;
        Comparable alvo = (Comparable) valor;

        while( atual != null){

            Comparable valorAtual = (Comparable) atual.getValor();
            int comparacao = alvo.compareTo(valorAtual);
            
            if(comparacao == 0){

                return atual;
                // encontrou o valor

            }else if(comparacao < 0){
                
                atual = atual.getFilhoEsquerdo();
                // o valor passado é menor

            }else{

                atual = atual.getFilhoDireito();
                // o valor passado e maior
            }
        }   
        // Se não encontrar nada
        return null;
    }


    public Node obterSucessor(Node no){

        if(no == null || no.getFilhoDireito() == null){
            return null;
        }

        Node sucessor = no.getFilhoDireito();
        while(sucessor.getFilhoEsquerdo() != null){

            sucessor = sucessor.getFilhoEsquerdo();

        }

        return sucessor;

    }

    public void removerNo(Node no){

            /*
                                Condições
            0. Buscar o nó

            1. Remover um nó folha:
                Apenas atribuir null ao valor
            
            2. Remover um nó com um filho:
                Fazer mudanças de referências da seguinte maneira:
                O filho assume o lugar do pai
                O filho passa a ser filho do avô
                O avô passa a ser pai do filho

            3. Remover um nó com 2 filhos
                Busca o sucessor
                Substitui o valor do nó a ser removido pelo valor do sucessor
                Remove fisicamento o sucessor (mais simples)
         */

        // Caso 3 : No com 2 filhos
        if (no.getFilhoDireito() != null && no.getFilhoEsquerdo() != null){

            Node sucessor = obterSucessor(no);
            no.setValor(sucessor.getValor());
            removerNo(sucessor);
            return;        
        } 

        Node filho = (no.getFilhoEsquerdo() != null) ? no.getFilhoEsquerdo() : no.getFilhoDireito();
        Node pai = no.getPai();


        if (filho != null){
            filho.setPai(pai);
            // o pai do atributo é o avô do filho
            // esse comando faz a conexão do filho com o avô
            // "Remove o pai"
        }

        // Caso 1 : No folha
        if( pai == null){
            this.raiz = filho;
            // esse nó era a raiz
            // o filho dele toma o lugar dele
            // a ele( a raiz) é removido e o filho se torna o novo raiz

        //Caso 2a : no com 1 filho
        }else if(no == pai.getFilhoEsquerdo()){
        //caso com 1 filho sendo esse filho o esquerdo

            // é o filho esquerdo?
            pai.setFilhoEsquerdo(filho);
            // o neto passa ser o filho esquerdo

        // Caso 2b: no com 1 filho
        }else{
        //caso com 1 filho sendo esse filho o direito

            pai.setFilhoDireito(filho);
            // neto passa ser o filho direito
        }

        no.setPai(null);
        no.setFilhoEsquerdo(null);
        no.setFilhoDireito(null);
    }

    private int calcularAltura(Node no) {
        if (no == null) return 0;
        int altEsq = calcularAltura(no.getFilhoEsquerdo());
        int altDir = calcularAltura(no.getFilhoDireito());
        return 1 + Math.max(altEsq, altDir);
    }

    // Método auxiliar para imprimir 'n' espaços na mesma linha
    private void imprimirEspacos(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            System.out.print(" ");
        }
    }

    // Método auxiliar para saber quando parar o loop
    private boolean todasPonteirosNulos(Queue<Node> fila) {
        for (Node no : fila) {
            if (no != null) return false;
        }
        return true;
    }

}