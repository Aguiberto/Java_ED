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
                    return;
                }

            }else{

                atual = atual.getFilhoDireito();

                if(atual == null){

                    pai.getFilhoDireito(novoNo);
                    return;
                }

            }
        }
    }

    public Object remove(Node noRemovido){

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
                Fazer mudança de referências da seguinte maneira:
                Buscar o sucessor (Menor valor entre os maiores valores)
                Sucessos recebe as referências do valor removido
                Valor a ser removido tem referência para pai como null
                Valor a ser removido tem recebe valor null
         */

        Node atual = raiz;
        Node noAlvo = noRemovido

        while(atual != noAlvo){

            // encontrou o nó
            if(atual == noAlvo){

                // é um nó folha
                if(atual.getFilhoDireito() == null && atual.getFilhoEsquerdo() == null){
                    Node removido = atual;
                    atual.setValor(null);
                    atual.setPai(null);
                    return removido;

                // tem um filho
                }else if(atual.getFilhoDireito() != null || atual.getFilhoEsquerdo() != null){
                
                                       

                // tem dois filhos
                }else{

                }


            }else{
                // Nó não foi encontrado
                return;
            }

        }

    }

    public String mostrar(){

    }

    // ==================== MÉTODOS AUXILIARES ==============

    public boolean eFolha(Node no){

        if(no.getFilhoDireito() == null && no.getFilhoEsquerdo == null){
            return true;
        }else{
            return false;
        }
    
    public Node criarNo(Object valor){
        return Node novoNo = new Node(valor);
    }

}