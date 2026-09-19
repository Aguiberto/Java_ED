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

    public void remover(T valor){
        processoRemovedor(T valor);
    }

    public T buscar(T valor ){

    }

    public void mostrar(){

    }


    // ================= MÉTODOS AUXILIARES ==================

    public NoRN<T> getRaiz(){
        return this.raiz;
    }

    public NoRN<T> getNIL(){
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

        NoRN<T> novoNo = new NoRN<>(valor);
        NoRN<T> atual = this.raiz;

        while(atual != NIL){

            int comparacao = novoValor.compareTo(atual.getValor());
            if(comparacao > 0){
                atual = atual.getFilhoD();

            }else if( comparacao < 0){
                atual = atual.getFilhoE();

            }else{
                atual = novoNo;
            }
        }

        // correção do posicionamento
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



}