import java.util.LinkedList;
import java.util.Queue;

public class ArvoreAVL{

    NoAVL raiz;
    int tamanho;

    public ArvoreAVL(){

        this.raiz = null;
        this.tamanho = 0;

    }

    public void insert(Object valor){

        this.raiz = inserirRecursivo(raiz, valor);
    }

    public void remover(Object valor){
        this.raiz = processoRemovedor(this.raiz, valor);
    }

    public void mostrar() {
        if (this.raiz == null) {
            System.out.println("Árvore vazia!");
            return;
        }

        int alturaTotal = obterAltura(this.raiz);
        Queue<NoAVL> fila = new LinkedList<>();
        fila.add(this.raiz);

        int nivel = 0;
        while (nivel < alturaTotal) {
            int nosNoNivel = fila.size();
            
            // Espaçamento dinâmico baseado na profundidade do nível
            int espacoEntre = (int) Math.pow(2, alturaTotal - nivel + 1) - 1;
            int espacoInicial = (int) Math.pow(2, alturaTotal - nivel) - 1;

            imprimirEspacos(espacoInicial);

            for (int i = 0; i < nosNoNivel; i++) {
                NoAVL atual = fila.poll();

                if (atual != null) {
                    int fb = rebalancear(atual);
                    System.out.print(atual.getValor() + "[" + fb + "]");
                    
                    fila.add(atual.getFilhoEsquerdo());
                    fila.add(atual.getFilhoDireito());
                } else {
                    System.out.print("     "); // Espaço reserva para nós nulos
                    fila.add(null);
                    fila.add(null);
                }

                imprimirEspacos(espacoEntre);
            }
            System.out.println("\n");
            nivel++;
        }
    }


    // ========================================================
    // ================= MÉTOOS AUXILIARES ====================
    // ========================================================

    // informa a altura de um nó
    private int obterAltura(NoAVL no){

        if(no == null){
            return 0;
        }

        return no.getAltura();

    }

    // calcula o fator de balanceamento de um nó
    private int fatorBalanceamento(NoAVL no){

        if(no == null){
            return 0;
        }

        int fatorB = obterAltura(no.getFilhoEsquerdo()) - obterAltura(no.getFilhoEsquerdo());
        return fatorB;
    }

    // atualiza a altura do no
    private void atualizarAltura(NoAVL no){

        if(no != null){

            int altEsq = obterAltura(no.getFilhoEsquerdo());
            int altDir = obterAltura(no.getFilhoDireito());

            return no.setAltura(1 + Math.max(altEsq, altDir));
        }
    }

    private NoAVL rotacaoEsquerda(NoAVL no1){

        /* 
                no1                                no3
            no2       no3         ---->      no1        no5
                  no4     no5            no2     no4        no6
                             no6
        */

        // salva os nós que serão usados
        NoAVL no3 = no1.getFilhoDireito();
        NoAVL no4 = no3.getFilhoEsquerdo();

        //modifica as referências dos pais
        no3.setFilhoEsquerdo(no1);
        no1.setFilhoDireito(no4);

        // verifica se o no3 tem filho (pode ser que não tenha)
        if(no4 != null){
            no4.setPai(no1);
        }

        // muda a referência dos ponteiros dos pais
        no3.setPai(no1.getPai());
        no1.setPai(no3);
       
       atualizarAltura(no1);
       atualizarAltura(no3);

       // retorna o nó que vai assumir o topo
       return no3;

    }

    private NoAVL rotacaoDireita(NoAVL no1){
        
        /*
                     no1
                no3       no2                     no3
            no5    no4           ----->      no5      no1
        no6                              no6      no4     no2 

        */

        NoAVL no3 = no1.getFilhoEsquerdo();
        NoAVL no4 = no3.getFilhoDireito();

        no3.setFilhoDireito(no1);
        no1.setFilhoEsquerdo(no4);

        if(no4 != null){
            no4.setPai(no1);
        }

        no3.setPai(no1.getPai());
        no1.setPai(no3);

        atualizarAltura(no4);
        atualizarAltura(no3);

        return no3;
    }

    private NoAVL rebalancear(NoAVL no){

        if(no == null){
            return no;
        }

        atualizarAltura(no);
        int fb = fatorBalanceamento(no);

        // desbalanceado a ESQUERDA
        if( fb > 1){

            // rotação dupla a direita : começa com uma rotação a esquerda 
            if(fatorBalanceamento(no.getFilhoEsquerdo()) < 0){
                no.setFilhoEsquerdo(rotacaoEsquerda(no.getFilhoEsquerdo()));
            }

            // rotação simples a direto
            // continuação da rotação dupla
            return rotacaoDireita(no);

        }

        // desbalanceado a direita
        if(fb < -1){
            
            // rotação dupla a esquerda: começa com balanceamento a direita
            if(fatorBalanceamento(no.getFilhoDireito()) > 0){
                no.setFilhoDireito(rotacaoDireita(no.getFilhoDireito()));
            }

            // rotação simples a esquerda
            return rotacaoEsquerda(no);
        }

        // se já estiver balanceado
        return no;
    }
    

    @SupressWarnings("Unchecked")
    private NoAVL inserirRecursivo(NoAVL no, Object valor){

        if(no == null){
            return new NoAVL(valor);
        }

        Comparable<Object> valorComparacao = (Comparable<Object>) valor;
        int comparacao = valorComparacao.compareTo(no);


        // novo nó maior que o nó de comparação
        if( comparacao > 0){
            NoAVL filhoDir = inserirRecursivo(no.getFilhoDireito(),valor);
            no.setFilhoDireito(filhoDir);
            filhoDir.setPai(no);

        
        // novo nó menor que o valor de comparação
        }else if( comparacao < 0){
        
            NoAVL filhoEsq = inserirRecursivo(no.getFilhoEsquerdo(),valor);
            no.setFilhoEsquerdo(filhoEsq);
            filhoEsq.setPai(no);

        //valores iguais
        }else{
            return no;
        }

        return rebalancear(no);

    }

    @SupressWarnings("Unchecked")
    public NoAVL processoRemovedor(NoAVL noBase, Object valor){

        if(noBase == null){
            return null;
        }

        Comparable<Object> valorComparacao = (Comparable<Object>) valor;
        int comparacao = valorComparacao.compareTo(noBase.getValor());

        /*
        comparacao = 0: Valores iguais, objeto achado
        comparacao = 1: valor informado maior que o valor do nó 
        comparacao = -1: valor informado menor que o do nó
         */

        // Realizando a busca pelo valor a ser removido
        if(comparacao < 0){
            NoAVL filhoEsq = processoRemovedor(noBase.getFilhoEsquerdo(),valor);
            noBase.setFilhoEsquerdo(filhoEsq);
            if(filhoEsq != null) filhoEsq.setPai(noBase);

        }else if(comparacao > 0){
        
        // VALOR ENCONTRADO
        }else{

            // testa se pelo menos um dos filhos é null (ambos os filhos podem ser null)
            if(noBase.getFilhoEsquerdo() == null || noBase.getFilhoDireito() == null){

                NoAVL temp = (noBase.getFilhoEsquerdo() != null) ? noBase.getFilhoEsquerdo() : noBase.getFilhoDireito();

                // não tem nenhum filho
                if(temp == null){
                    noBase = null;
                } else {
                    temp.setPai(noBase.getPai());              // filho do nó passa apontar para o seu avô (no removido)
                    noBase = temp;                         // filho do no assume o lugar do no
                }

            // se tiver os dois filhos
            } else {

                NoAVL substituto = buscarSucessor(noBase);        // encontra o valor substituto
                noBase.setValor(substituto);            // muda o valor do nó a ser removido pelo valor do substituto

                
                NoAVL novoFilhoD = processoRemovedor(noBase.getFilhoDireito(),substituto.getValor());   // percorre toda a arvore até achar o substituto e remove-lo fisicamene
                noBase.setFilhoDireito(novoFilhoD);                                                     // reordena a referência do pai para o filho
                if(novoFilhoD == null) novoFilhoD.setPai(noBase);                                       // reordena referência do filho para o pai

            }

            if( noBase == null){
                return null;
            }

            return rebalancear(noBase);
        }
    }

    public NoAVL buscarSucessor(NoAVL no){

        NoAVL sucessor = no.getFilhoDireito();
        while(sucessor.getFilhoEsquerdo() != null){
            sucessor = no.getFilhoEsquerdo();
        } 

        return sucessor;  
    }

    private void imprimirEspacos(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            System.out.print(" ");
        }
    }
    
}