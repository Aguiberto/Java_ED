import java.util.Arrays;

public class FilaCircularArray {

    private Object fila [];
    private int inicio;
    private int fim;
    private int tamanho;
    private int incremento;

    public FilaCircularArray(int tamanho, int incremento){

    this.fila = new Object[tamanho];
    this.tamanho = tamanho;
    this.incremento = incremento;
    this.inicio = 0;
    this.fim = 0;

    }

    public boolean estaVazia(){
        if( inicio == fim){
            return true;
        }else{
            return false;
        }
    }

    public int tamanho(){
        return (tamanho - inicio + fim) % tamanho;
    }

    public Object primeiro() throws FilaExcecao{
        if(estaVazia()){
            throw new FilaExcecao("A pilha está VAZIA");
        }
        return fila[inicio];
    }

    public void adicionar(Object objeto){

        //Verifica se a fila está cheia
        if(tamanho() == tamanho - 1){
            aumentarTamanho();
        }

        fila[fim] = objeto;
        fim = (fim + 1) % tamanho;
    }

    public void aumentarTamanho() {

        int novoTamanho;

        if(incremento == 0){
            novoTamanho = tamanho * 2;
        }else{
            novoTamanho = tamanho + incremento;   
        }

        Object filaMaior [] = new Object[novoTamanho];
        int AntigoInicio = inicio;

        for (int novoInicio = 0; novoInicio < tamanho; novoInicio++){
            filaMaior[novoInicio] = fila[AntigoInicio];
            AntigoInicio = (AntigoInicio + 1) % tamanho;
        }

        fim = tamanho();
        inicio = 0;
        tamanho = novoTamanho;
        fila = filaMaior;
    }

    public Object remover() throws FilaExcecao{

        if(estaVazia()){
            throw new FilaExcecao("A fila esta VAZIA");
        }

        Object removido = fila[inicio];
        fila[inicio] = null;
        inicio = (inicio+1) % tamanho;

        return removido;

    }

    @Override
    public String toString(){
        return Arrays.toString(fila);
    }



}