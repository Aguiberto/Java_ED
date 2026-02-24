/**O armazenamento é do tipo int
 * há um valor minimo e máximo suportado no vetor
 * há um valor que será armazenado nas posições vagas
 */

/**MÉTODOS
 * atribuir um valor em determinada posição
 * alterar o valor em determinada posição
 * remover o valor de determinada posição
 * ler o conteudo de uma posição
 * localizar o valor e retornar sua posição
 * inserir na primeira posição vaga
 * remover da ultima posição ocupada
 * imprimir o conteúdo do vertor
 */

public class TadVetor{

    private final int tamanho;
    private final int minimo;
    private final int maximo;
    private final int vaga;
    private final int repete;

    private int[] dados;

    public TadVetor(int tamanho, int minimo, int maximo, int vaga, int repete){
        this.tamanho = tamanho;
        this.minimo = minimo;
        this.maximo = maximo;
        this.vaga = vaga;
        this.repete = repete;

        // cria um vetor e preenche-o com o valor indicativo de posição vaga
        this.dados = new int[this.tamanho];
        if (this.vaga != 0){
            for( int i = 0; i < this.tamanho; i++){
                this.dados[i] = this.vaga;
            }
        }
    }

    public int armanezar(int valor, int posicao){
        
        // verifica se o valor é valido
        if(!this.valorValido(valor)){
            return 1;
        }
        // verifica se a posição é valida
        if(this.posicaoValida(posicao)){
            return 2;
        }
        // verifica se a posição é vaga (pode receber conteúdo?)
        if(this.dado[posicao] != this.vaga){
            return 3;
        }
        if(!this.podeRepetir()){
            int [] existe = this.localizar(valor,0);
            if(existe[0] > 0){
                return 4;
            }
        }

        this.dados[posicao] = valor;
    }

    public int removerUlima(){

        for( int i = this.tamanho -1; i >=0; i--){
            if(this.dado[i] != this.vaga){
                return this.exlcuir(i);
            }
        }

    }

    private boolean valorValido(int valor){
        return valor >= this.minimo && valor <= this.maximo;
    }

    private boolean posicaoValida(int posicao){
        return posicao >= 0 && posicao < this.tamanho;
    }

    private boolean podeRepetir(){
        return this.repete == 1;
    }

    public void limparVetor(){
        for(int i = 0; i < tamanho; i++){
            this.dados[i] = this.vaga;
        }
    }
}