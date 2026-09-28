import java.util.LinkedList;
import java.util.Queue;

public class ArvoreRN<T extends Comparable<T>>{

    public NoRN<T> raiz;
    public NoRN<T> NIL;

    public ArvoreRN(){
        
        NIL = new NoRN<>();
        NIL.setCor(Cor.NEGRO);

        this.raiz = NIL;
    }

    public void inserir(T valor){
        processoDeInsercao(valor);
    }

    public void remover(T valor){

        NoRN<T> alvo = buscar(valor);
        if( alvo == NIL){
            return ;
        }

        // pode ser o filho do nó removido (tinha 1 filho), o sucessor tradicional(tinha dois filho), ou null (não tinha filhos)
        NoRN<T> noRemovido = (alvo.getFilhoE() == NIL || alvo.getFilhoD() == NIL) ? alvo: buscarSucessor(alvo);
        Cor corRemovido = noRemovido.getCor();

        // nó retornado é o substituto do nó que foi removido
        NoRN<T> xSubstituto = processoRemovedor(this.raiz,valor);

        // Ajustes precisam ser feitos caso um nó negro seja removido
        if(corRemovido == Cor.NEGRO){
            corrigirRemocao(xSubstituto);
        }

    }

    public NoRN<T> buscar(T valor){

        NoRN<T> atual = this.raiz;
        while(atual != NIL && atual.getValor() != null){

            int comparacao = atual.getValor().compareTo(valor);

            if(comparacao < 0){
                atual = atual.getFilhoD();

            }else if(comparacao > 0){
                atual = atual.getFilhoE();
 
            }else{
                return atual;
            }
        }

        return NIL;
    }

    public void mostrar() {

        if (this.raiz == NIL || this.raiz.getValor() == null) {
            System.out.println("Árvore Vazia!");
            return;
        }

        int altura = getAltura(this.raiz);
        Queue<NoRN<T>> fila = new LinkedList<>();
        fila.add(this.raiz);

        System.out.println("\n================================== ÁRVORE RUBRO-NEGRA  ===============================\n");

        int nivelAtual = 0;

        while (nivelAtual < altura) {
            int nosNoNivel = fila.size();
            
            // Espaçamento antes do primeiro elemento do nível
            int espacoInicial = (int) Math.pow(2, altura - nivelAtual - 1) - 1;
            // Espaçamento entre os elementos do mesmo nível
            int espacoEntre = (int) Math.pow(2, altura - nivelAtual) - 1;

            imprimirEspacos(espacoInicial * 6); // Multiplica pela largura da representação de cada nó

            for (int i = 0; i < nosNoNivel; i++) {
                NoRN<T> no = fila.poll();

                if (no != NIL) {
                    String cor = (no.getCor() == Cor.RUBRO) ? "[R]" : "[N]";
                    System.out.printf("%2d%s", no.getValor(), cor);

                    fila.add(no.getFilhoE());
                    fila.add(no.getFilhoD());
                } else {
                    System.out.print("     "); // Espaço vazio para manter a simetria de nós nulos
                    fila.add(NIL);
                    fila.add(NIL);
                }

                imprimirEspacos(espacoEntre * 6);
            }

            System.out.println("\n"); // Nova linha ao mudar de nível
            nivelAtual++;
        }

        System.out.println("===========================================================================================\n");
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
        NoRN<T> avo = getAvo(no);

        if(avo == NIL || avo == null){
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
            pai = atual;

            int comparacao = valor.compareTo(atual.getValor());
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

        }else if(valor.compareTo(pai.getValor()) < 0){
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

                // se pai é filho esquerdo então o tio é filho direito;
                NoRN<T> tio = avo.getFilhoD();

                if(tio.getCor() == Cor.RUBRO){
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

            // o pai é filho DIREITO
            }else{

                // nesse caso o tio é filho ESQUERDO
                NoRN<T> tio = avo.getFilhoE();

                if(tio.getCor() == Cor.RUBRO){

                    pai.setCor(Cor.NEGRO);
                    tio.setCor(Cor.NEGRO);
                    avo.setCor(Cor.RUBRO);
                    noAjuste = avo;

                // tio é NEGRO; Caso 3
                }else{
                    
                    // caso 3 filho em zigue-zague
                    if(noAjuste == pai.getFilhoE()){
                        noAjuste = pai;
                        rotacaoDireita(noAjuste);
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
        if(no2.getFilhoD() != NIL){
            no2.getFilhoD().setPai(no1);
        }

        no2.setPai(no1.getPai());

        if(no1.getPai() == NIL){
            this.raiz = no2;

        }else if(no1 == no1.getPai().getFilhoE()){
            no1.getPai().setFilhoE(no2);

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

        if(no2.getFilhoE() != NIL){
            no2.getFilhoE().setPai(no1);

        }

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

    public NoRN<T> processoRemovedor(NoRN<T> noBase ,T valorRemovido){

        if(noBase == NIL || noBase == null){
            return NIL;
        }

        int comparacao = valorRemovido.compareTo(noBase.getValor());

        if(comparacao < 0){

            // desce recurssivamente pelo lado esquerdo até encontrar o nó
            NoRN<T> filhoEsq = processoRemovedor(noBase.getFilhoE(), valorRemovido);
            noBase.setFilhoE(filhoEsq);    
            if(filhoEsq != NIL) filhoEsq.setPai(noBase);   // Refaz a referência com o pai                                                 // quando filhoEsq = null então o setFilhoE(null) remove o valor


        }else if(comparacao > 0){
            // desce recurssivamente pelo lado direito até encontrar o nó
            NoRN<T> filhoDir = processoRemovedor(noBase.getFilhoD(), valorRemovido);
            noBase.setFilhoD(filhoDir);  
            if(filhoDir != NIL) filhoDir.setPai(noBase);

        // valor encontrado
        }else{

            // verifica se tem algum filho
            if(noBase.getFilhoD() == NIL || noBase.getFilhoE() == NIL){

                NoRN<T> filhoSupeito = (noBase.getFilhoE() != NIL) ? noBase.getFilhoE() : noBase.getFilhoD();

                // não tem nenhum filho
                if(filhoSupeito == NIL){
                    noBase = NIL;
                
                // tem um filho
                }else{
                    filhoSupeito.setPai(noBase.getPai());   // filho faz referência para o avô cortando a ligação com o pai
                    noBase = filhoSupeito;                  // filho assume o lugar do pai
                }

            // tem dois filhos
            }else{

                NoRN<T> substituto = buscarSucessor(noBase);
                noBase.setValor(substituto.getValor());

                NoRN<T> novoFilhoD = processoRemovedor(noBase.getFilhoD(), substituto.getValor());
                noBase.setFilhoD(novoFilhoD);

                if(novoFilhoD != NIL){
                    novoFilhoD.setPai(noBase);

                }

            }

        }

        // no que será o substituto do nó removido na arvore
        return noBase;
    }

    public NoRN<T> buscarSucessor(NoRN<T> noSucedido){

        NoRN<T> noRemovido = noSucedido.getFilhoD();
        while(noRemovido.getFilhoE() != NIL){
            noRemovido = noRemovido.getFilhoE();
        }
        return noRemovido;

    }

    private void corrigirRemocao(NoRN<T> xSubstituto){
        
        /*
            v = removido
            x = substituto
            w = irmão do removido
         */

        // Não é necessário fazer ajustes caso o substituto seja vermelho.
        // SITUAÇÃO 3
        while(xSubstituto != raiz && xSubstituto.getCor() == Cor.NEGRO){
            
            // Casos em que o substituto é filho esquerdo
            if(xSubstituto == xSubstituto.getPai().getFilhoE()){

                NoRN<T> wIrmao = xSubstituto.getPai().getFilhoD();

                // Caso 3.1 - irmão rubro
                if(wIrmao.getCor() == Cor.RUBRO){

                    wIrmao.setCor(Cor.NEGRO);
                    xSubstituto.getPai().setCor(Cor.NEGRO);
                    rotacaoEsquerda(xSubstituto.getPai());
                    wIrmao = xSubstituto.getPai().getFilhoD();          // Muda a referência para W assumir o lugar do pai
                }

                // Caso 3.2 - irmão negro com filhos negros
                if(wIrmao.getFilhoE().getCor() == Cor.NEGRO && wIrmao.getFilhoD().getCor() == Cor.NEGRO){

                    // Caso 3.2a - todos negros
                    if(xSubstituto.getPai().getCor() == Cor.NEGRO){

                        wIrmao.setCor(Cor.RUBRO);
                        xSubstituto = xSubstituto.getPai(); //duplo negro passa para o pai

                    // Caso 3.2b - pai rubro    
                    }else{

                        wIrmao.setCor(Cor.RUBRO);             // apenas pinta o irmão e o duplo negro some
                    }

                    wIrmao.setCor(Cor.RUBRO);
                    xSubstituto = xSubstituto.getPai();     //move a referência de um nó negro para cima

                // o irmão tem algum filho RUBRO
                }else{
                    
                    //Caso 3.3
                    if(wIrmao.getFilhoD().getCor() == Cor.NEGRO){

                        wIrmao.setCor(Cor.RUBRO);
                        wIrmao.getFilhoE().setCor(Cor.NEGRO);
                        rotacaoDireita(wIrmao);
                        wIrmao = xSubstituto.getPai().getFilhoD();  // corrige a referência após a rotação

                    }

                    wIrmao.setCor(xSubstituto.getPai().getCor());
                    wIrmao.getFilhoD().setCor(Cor.NEGRO);
                    xSubstituto.getPai().setCor(Cor.NEGRO);
                    rotacaoEsquerda(xSubstituto.getPai());
                    xSubstituto = this.raiz;

                }


            // xSubstituto é filho DIREITO (casos espelhados)
            }else{

                NoRN<T> wIrmao = xSubstituto.getPai().getFilhoE();

                // 3.1 - irmão rubro
                if(wIrmao.getCor() == Cor.RUBRO){

                    wIrmao.setCor(Cor.NEGRO);
                    xSubstituto.getPai().setCor(Cor.RUBRO);
                    rotacaoDireita(xSubstituto.getPai());
                    wIrmao = xSubstituto.getPai().getFilhoE();

                // 3.2 - irmão negro
                }else{

                    // dois filhos negros
                    if(wIrmao.getFilhoD().getCor() == Cor.NEGRO && wIrmao.getFilhoE().getCor()== Cor.NEGRO){
                        
                        //3.2a todos negros
                        if(xSubstituto.getPai().getCor() == Cor.NEGRO){
                            wIrmao.setCor(Cor.RUBRO);
                            wIrmao = xSubstituto.getPai();

                        //3.2b negros com pai rubro
                        }else{
                            wIrmao.setCor(Cor.RUBRO);
                        }

                    // algum filho rubro
                    }else{

                        // 3.3 - filho direito RUBRO  e filho esquerdo NEGRO
                        if(wIrmao.getFilhoE().getCor() == Cor.NEGRO){
                            wIrmao.getFilhoD().setCor(Cor.NEGRO);
                            wIrmao.setCor(Cor.RUBRO);
                            rotacaoEsquerda(wIrmao);
                            wIrmao = xSubstituto.getPai().getFilhoE();
                        }
                        
                        // 3.4 - filho esquerdo RUBRO
                        wIrmao.setCor(xSubstituto.getPai().getCor());
                        xSubstituto.getPai().setCor(Cor.NEGRO);
                        wIrmao.getFilhoE().setCor(Cor.NEGRO);
                        rotacaoDireita(xSubstituto.getPai());
                        xSubstituto = this.raiz;

                    }

                }

            }

        }

        // CASO 2: o substituto é RUBRO
        xSubstituto.setCor(Cor.NEGRO);
    }

    private int getAltura(NoRN<T> no) {

        if (no == NIL || no == null) {
            return 0;
        }

        return 1 + Math.max(getAltura(no.getFilhoE()), getAltura(no.getFilhoD()));
    }

    
    private void imprimirEspacos(int quantidade) {

        for (int i = 0; i < quantidade; i++) {
            System.out.print(" ");
        }
    }

}