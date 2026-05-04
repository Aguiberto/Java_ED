public class SequenciaMestra implements SequenciaInterface{

    private No head;
    private No tail;
    private int length;

    public SequenciaMestra(){

        this.length == 0;
        head.getNext(tail);
        tail.getPrev(head);

    }

    // ========= MÉTODOS PONTE =============

    public No atRank(int index){

        int aux = 0
        No target = head.getNext();

        while( aux != index){
            target = target.getNext();
            aux++;    
        }

        return target;
    }

    public int rankOf(No node){

        int index = 0;
        No searcher = head.getNext();

        while (searcher != node){
            searcher = searcher.getNext();
            index ++;
        }

        return index;

    }

    // ======= MÉTODOS GENÉRICOS ===========

    public boolean isEmpty(){
        return length == 0;
    }

    public int size(){
        return length;
    }


    // ======== MÉTODOS DE VETOR ===========




    // ======== MÉTODOS DE LISTA ============



}