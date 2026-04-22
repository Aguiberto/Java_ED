package Lista;

public class NoDuplo {

    private Object value;
    private NoDuplo prev;
    private NoDuplo next;

    public NoDuplo(Object objeto){
    
    /**Nó inicia com o valor informado
     * o anterior aponta para o vazio
     * o próximo também aponta para o vazio
     */

        this.value = objeto;
        this.prev = null;
        this.next = null;

    }

    // muda o valor do nó
    public void setValue(Object objeto){
        this.value = objeto;
    }

    // informa o valor do nó
    public Object getValue(){
        return this.value;
    }

    // diz quem vai ser próximo do nó desse nó
    public void setNext(NoDuplo no){
         this.next = no;
    }

    // mostra qual é o próximo do nó
    public NoDuplo getNext(){
        return  next;
    }

    // diz quem vai ser o anterior a esse nó
    public void setPrev(NoDuplo no){
         this.prev = no;
    }

    // mostra qual é o nó anterior
    public NoDuplo getPrev(){
        return prev;
    }

}