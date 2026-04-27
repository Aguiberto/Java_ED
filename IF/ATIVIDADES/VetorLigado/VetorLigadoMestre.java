public class VetorLigadoMestre implements VetorLigadoIF{

    private NoVetor head;
    private NoVetor tail;
    private int length;

    public VetorLigadoMestre(){

        head = new NoVetor(null);
        tail = new NoVetor(null);

        head.setNext(tail);
        tail.setPrev(head);

        length = 0;
    }

    public boolean isEmpty(){
        
        return length == 0;
    }

    public int size(){

        return length;
    }

   public NoVetor searchNode (int index){

        if(index < 0 || index >= length){
            throw new VetorLigadoExcecao("Índice fora do VETOR");
        }

        if(isEmpty()){
            throw new VetorLigadoExcecao("Vetor VAZIO");
        }
        NoVetor noAUX;
        
        if(index <= length / 2){
            noAUX = head.getNext();

            for(int i = 0; i < index; i++){
                noAUX = noAUX.getNext();
            }

        }else{
            noAUX = tail.getPrev(); 

            for(int i = length-1; i > index; i--){
                noAUX = noAUX.getPrev(); 

            }

        }

        return noAUX;

   }

    public Object elemAtRank(int index){

        NoVetor TargetNode = searchNode(index);
        return TargetNode.getValue();

    }

    public void replaceAtRank(int index, Object objeto){

        NoVetor TargetNode = searchNode(index);
        TargetNode.setValue(objeto);

    }

    public void insertAtRank(int index, Object objeto){

        NoVetor newNode = new NoVetor(objeto);

        if(isEmpty()){

            newNode.setPrev(head);
            newNode.setNext(tail);

            head.setNext(newNode);
            tail.setPrev(newNode);

        }

        NoVetor TargetNode = searchNode(index);
        NoVetor BackTargetNode = TargetNode.getPrev();
        
        newNode.setNext(TargetNode);
        newNode.setPrev(BackTargetNode);

        BackTargetNode.setNext(newNode);
        TargetNode.setPrev(newNode);

        length++;

    }

    public Object removeAtRank(int index){

        NoVetor TargetNode = searchNode(index);
        Object value = TargetNode.getValue();

        NoVetor beforeNode = TargetNode.getPrev();
        NoVetor afterNode = TargetNode.getNext();

        beforeNode.setNext(afterNode);
        afterNode.setPrev(beforeNode);

        length--;

        return value;

    }

}