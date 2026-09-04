public class ArvoreAVL{

    Node raiz;
    int tamanho;
    boolean estaBaleceada;

    public ArvoreAVL{

        this.raiz = null
        this.tamanho = 0;
        this.estaBaleceada = false;

    }

    public void insert{

        // Para fazer o insert é necessário fazer o balancear

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




    
}