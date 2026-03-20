public class PilhaArray implements Pilha{

    private int capacidade;
    private Object [] array;
    private int topo;
    private int FC;

    public PilhaArray(int capacidade, int crescimento){

        this.capacidade = capacidade;
        
        //pilha vazia começa com índice em -1
        this.topo = -1;
        this.FC = crescimento;

        if(crescimento <= 0){
            FC = 0;
        }

        this.array = new Object[capacidade];
    }

    public void push(Object artefato){

        // verifica se a pilha está cheia
        if(topo >= capacidade-1){

            if(FC == 0){
            // estratégia de duplicação
                capacidade *= 2;
            } else {
            // estratégia de incremento
                capacidade += FC;
            }

            Object novo_array[] = new Object[capacidade];
            for(int i = 0; i < array.length; i++){
                novo_array[i] = array[i];
            }

            array = novo_array;
        }
        array[++topo] = artefato;

    }

    public boolean isEmpty(){
        return topo == -1;
    }

    public int size(){
        return topo+1;
    }

    public Object pop() throws PilhaVaziaExcecao{
        
        if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }

        return array[topo--];

    }

    public Object top() throws PilhaVaziaExcecao{

        if(isEmpty()){
            throw new PilhaVaziaExcecao("A pilha está vazia");
        }

        return array[topo];

    }


}