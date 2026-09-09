public class ArvoreAVL{

    Node raiz;
    int tamanho;

    public ArvoreAVL{

        this.raiz = null
        this.tamanho = 0;

    }

    public void insert(Object valor){

        this.raiz = inserirRecursivo(raiz, valor);
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
        no3.setFilhoEsquerdo(n1);
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

    private AVL rotacaoDireita(NoAVL no1){
        
        /*
                     no1
                no3       no2                     no3
            no5    no4           ----->      no5      no1
        no6                              no6      no4     no2 

        */

        NoAVL no3 = n1.getFilhoEsquerdo();
        NoAVL no4 = n3.getFilhoDireito();

        n3.setFilhoDireito(n1);
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
                no.setFilhoEsquerdo(rotacaoEsquerda(no.getFilhoEsquerdo)):
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
    private NoAVL inserirRecursivo(Node no, Object valor){

        if(no == null){
            return new NoAVL(valor);
        }

        Comparable<Object> valorComparacao = (Comparable<Object>) valor;
        int comparacao = valorComparacao.compareTo(no);


        // novo nó maior que o nó de comparação
        if( comparacao > 0){
            NoAVL filhoDir = inserirRecursivo(no.getFilhoDireito(),valor):
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
    public NoAVL processoRemovedor(NoAVL no, Object valor){

        if(no == null){
            return null;
        }

        Comparable<Object> valorComparacao = (Comparable<Object>) valor;
        int comparacao = valorComparacao.compareTo(no.getValor());

        // remoção sem filhos
        if(no.getFilhoDireito() == null and no.getFilhoEsquerdo() == null){
            no.getPai()
        }


        // remoção com 1 filho
        if(no.getFilhoDireito() != null){

        }


        // remoção com 2 filhos
        if(no.getFilhoDireito() != null and no.getFilhoEsquerdo() != null){

            NoAVL sucessor = buscarSucessor(no);
            

        }

    }

    public NoAVL buscarSucessor(NoAVL no){

        sucessor = no.getFilhoDireito();
        while(sucessor.getFilhoEsquerdo() != null){
            sucessor = getFilhoEsquerdo()!
        } 

        return sucessor;  
    }

    
}