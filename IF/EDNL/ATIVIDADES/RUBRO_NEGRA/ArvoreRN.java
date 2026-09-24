public class ArvoreRN<T extends Comparable<T>>{

    public NoRN<T> raiz;
    public NoRN<T> NIL;

    public ArvoreRN(){
        
        NIL = new NoRN<>();
        NIL.setCor(Cor.NEGRO);

        this.raiz = NIL;
    }

    public void inserir(T valor){
        processoDeInsercao(T valor);
    }

    public void remover(T valor)
        processoRemovedor(T valor);
    }

    public NoRN<T> buscar(T valor ){

        NoRN<t> atual = this.raiz;
        while(atual.getValor() != null){

            Comparable valor = (Comparable) valor;
            int comparacao = atual.getValor().compareTo(valor);

            if(atual < 0){
                atual = atual.getFilhoE();

            }else if(atual > 0){
                atual = atual.getFilhoD();

            }else{
                return atual;
            }

        }

        return null;

    }

    public void mostrar(){

    }


    // ================= MÉTODOS AUXILIARES ==================

    public NoRN<T> getRaiz(){
        return this.raiz;
    }

    public NoRN<T> getNil(){
        return this.NIL;
    }

    public NoRN<T> getAvo(NoRN<T> no){

        NoRN<T> pai = no.getPai();
        NoRN<T> avo = pai.getPai();

        return avo;
    }

    public NoRN<T> getTio(NoRN<T> no){

        
        NoRN<T> pai = no.getPai();
        NoRN<T> avo = no.getAvo(no);

        if(avo == NIL){
            return NIL;
        }

        if(avo.getFilhoD() != pai){
            return avo.getFilhoD();
        }else{
            return avo.getFilhoE();
        }
    }

    public void processoDeInsercao(T valor){

        NoRN<T> novoNo = new NoRN<>(valor,NIL);
        NoRN<T> atual = this.raiz;
        NoRN<T> pai = NIL;

        // percorre a arvore até chegar em uma folha; atual -> folha
        while(atual != NIL){

            // essa variável serve de âncora para não perder a referência para o nó anterior
            pai = atual

            int comparacao = novoValor.compareTo(atual.getValor());
            if(comparacao > 0){
                atual = atual.getFilhoD();

            }else if( comparacao < 0){
                atual = atual.getFilhoE();

            }else{
                return;
            }
        }

        // insere o nono nó na raiz
        novoNo.setPai(pai);

        // faz o pai apontar para o nó que foi inserido na árvore
        if(pai == NIL){
            this.raiz = novoNo;

        }else if(valor.compareTo(pai.getValor() < 0)){
            pai.setFilhoE(novoNo);

        }else{
            pai.setFilhoD(novoNo);
        }

        rebalanceamento(novoNo);
    }

    public void rebalanceamento(NoRN<T> noAjuste){

        /*
        Verificar os casos

           1. Pai negro
                Apenas faz a adição

           2. Pai e tio rubros e avô negro
                repintamento recursivo

           3. Pai rubro, tio e avô negros
                3.a - Rotação a  direita 
                3.b - Rotação a  esquerda
                3.c - Rotação dupla a direita
                3.d - Rotação dupla a esquerda  
         */

        while(noAjuste.getPai().getCor() == Cor.RUBRO){

            NoRN<T> pai = noAjuste.getPai();
            NoRN<T> avo = getAvo(noAjuste);

            // pai é RUBRO e é filho esquerdo
            if(pai == avo.getFilhoE()){

                if(tio.getCor == Cor.RUBRO){
                    pai.setCor(Cor.NEGRO);
                    tio.setCor(Cor.NEGRO);
                    avo.setCor(Cor.RUBRO);
                    noAjuste = avo;
                
                // tio é negro; CASO 3.
                }else{
                    
                    // caso em zigue-zague
                    if(noAjuste == pai.getFilhoD()){
                        noAjuste = pai;
                        rotacaoEsquerda(noAjuste);
                        pai = noAjuste.getPai();

                    }

                    // caso 3 com filhos alinhados
                    // inverter as cores do pai e do avô e realizar a rotação
                    pai.setCor(Cor.NEGRO);
                    avo.setCor(Cor.RUBRO);
                    rotacaoDireita(avo);
                        
                }

            // o pai é filho direito
            }else{

                NoRN<T> tio = avo.getFilhoE();

                if(tio.getCor() == Cor.RUBRO){

                    pai.setCor(Cor.NEGRO);
                    tio.setCor(Cor.NEGRO);
                    avo.setCor(Cor.RUBRO);
                    noAjuste = avo

                // tio é NEGRO; Caso 3
                }else{
                    
                    // caso 3 filho em zigue-zague
                    if(noAjuste == pai.getFilhoE()){
                        noAjuste = pai;
                        rotacaoEsquerda(noAjuste);
                        pai = noAjuste.getPai();
                    }

                    // caso 3 filhos alinhados
                    pai.setCor(Cor.NEGRO);
                    avo.setCor(Cor.RUBRO);
                    rotacaoEsquerda(avo);

                }
            }
        }

        this.raiz.setCor(Cor.NEGRO);
    }

    public void rotacaoDireita(NoRN<T> no1){

        /*
                         no1
                    no2      no5 --->        no2
               no3     no6               no3     no1
            no4                      no4      no6   no5

         */                                

        NoRN<T> no2 = no1.getFilhoE();   
        NoRN<T> no5 = no1.getFilhoD();


        no1.setFilhoE(no2.getFilhoD());
        if(no2.getFilhoD =! NIL){
            no2.getFilhoD.setPai(no1);
        }

        no2.setPai(no1.getPai());

        if(no1.getPai() == NIL){
            this.raiz = no2;

        }else if(no1 == n1.getPai().getFilhoE){
            no1.getPai.setFilhoE(no2);

        }else{
            no1.getPai().setFilhoD(no2);
        }

        no2.setFilhoD(no1);
        no1.setPai(no2);

    }

    public void rotacaoEsquerda(NoRN<T> no1){

        /*
                    no1                             no2
               no5       no2      ----->      no1        no3
                     no6      no3          no5     no6         no4
                                no4
         */


        NoRN<T> no2 = no1.getFilhoD();
        NoRN<T> no5 = no1.getFilhoE();

        no1.setFilhoD(no2.getFilhoE());
        no2.getFilhoE().setPai(no1);

        no2.setPai(no1.getPai());
        if(no1.getPai() == NIL){
            this.raiz = no2;

        }else if(no1 == no1.getPai().getFilhoE()){
            no1.getPai().setFilhoE(no2);

        }else{
            no1.getPai().setFilhoD(no2);
        }

        no2.setFilhoE(no1);
        no1.setPai(no2);       
        
    }

    public NoRN processoRemovedor(NoRN noBase ,T valorRemovido){

        if(noBase == null){
            return null;
        }

        int comparacao = valorRemovido.compareTo(noBase.getValor());

        if(comparacao < 0){

            // desce recurssivamente pelo lado esquerdo até encontrar o nó
            NoRN<T> filhoEsq = processoRemovedor(noBase.getFilhoE(), valorRemovido);
            noBase.setFilhoE(filhoEsq);    
            if(filhoEsq != null) filhoEsq.setPai(noBase);   // Refaz a referência com o pai                                                 // quando filhoEsq = null então o setFilhoE(null) remove o valor


        }else if(comparacao > 0){
            // desce recurssivamente pelo lado direito até encontrar o nó
            NoRN<T> filhoDir = processoRemovedor(nobase.getFilhoD(), valorRemovido);
            nobase.setFilhoD(filhoDir);  
            if(filhoDir != null) filhoDir.setPai(noBase);

        // valor encontrado
        }else{

            // verifica se tem algum filho
            if(noBase.getFilhoD() == null || noBase.getFilhoE() == null){

                NoRN<T> filhoSupeito = (noBase.getFilhoE() != null) ? nobase.getFilhoE() : nobase.getFilhoD();

                // não tem nenhum filho
                if(filhoSupeito == null){
                    noBase = null;
                
                // tem um filho
                }else{
                    filhoSupeito.setPai(noBase.getPai());   // filho faz referência para o avô cortando a ligação com o pai
                    noBase = filhoSupeito;                  // filho assume o lugar do pai
                }

            // tem dois filhos
            }else{

                NoRN<T> substituto = buscarSucessor(nobase);
                noBase.setValor(substituto.getValor());

                NoRN<T> novoFilhoD = processoRemovedor(nobase.getFilhoD(), substituto.getValor());
                nobase.setFilhoD(novoFilhoD);

                if(novoFilhoD == null){
                    novoFilhoD.setPai(noBase);
                }

            }

        }

        if(nobase == null){
            return null;
        }

    }

    public NoRN<T> buscarSucessor(NoRN<T> noSucedido){

        NoRN<T> sucessor = noSucedido.getFilhoD();
        while(sucessor.getFilhoE() != NIL){
            sucessor = sucessor.getFilhoE();
        }
        return sucessor;

    }
    
}