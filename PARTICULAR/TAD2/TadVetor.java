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
        // vetor de inteiros
        this.dados = new int[this.tamanho];
        if (this.vaga != 0){
            for( int i = 0; i < this.tamanho; i++){
                this.dados[i] = this.vaga;
            }
        }
    }

    public int armazenar(int valor, int posicao){
        
        // verifica se o valor é valido
        if(!this.valorValido(valor)){
            return 1;
        }
        // verifica se a posição é valida
        if(!this.posicaoValida(posicao)){
            return 2;
        }
        // verifica se a posição é vaga (pode receber conteúdo?)
        if(this.dados[posicao] != this.vaga){
            return 3;
        }
        if(!this.podeRepetir()){
            int [] existe = this.localizar(valor,0);
            /* 1º posição do vetor informa quantas vezes o valor se repete
            e nas posições seguintes os índices em que se encontram o valor*/
            if(existe[0] > 0){
                return 4;
            }
        }
        // atribui o valor a posiçã desejada no vetor
        this.dados[posicao] = valor;
        return 0;
    }

    public int alterar(int valor, int posicao){
    // metodo quase igual ao método de armazenar

        if(!this.valorValido(valor)){
            return 1;
        }
        if(!this.posicaoValida(posicao)){
            return 2;
        }
        // diferenã está aqui que é == ao invés de !=
        if(this.dados[posicao] == this.vaga){
            return 3;
        }
        if(!this.podeRepetir()){
            int [] existe = this.localizar(valor,0);
            if(existe[0] > 0){
                return 4;
            }
        }

        this.dados[posicao] = valor ;
        return 0;
    }

    public int excluir(int posicao){

        if(!this.posicaoValida(posicao)){
            return 2;
        }
        if(this.dados[posicao] == this.vaga ){
            return 3;
        }
        
        // torna a posiçã informada como vaga
        this.dados[posicao] = this.vaga;

        return 0;
    }

    public int ler(int posicao){
    // só precisa verificar se a posição informada é valida

        if(!this.posicaoValida(posicao)){
            return 2;
        }

        return this.dados[posicao];
    }

    public int [] localizar (int valor, int nPrimeiros){

        int [] res = new int[this.tamanho];

        if(!this.valorValido(valor)){
            return res;
        }

        if (this.repete == 0){
            nPrimeiros = 1;
        }

        for( int i = 0; i < this.tamanho; i++){
            if(this.dados[i] == valor){
            // percorre todo o vetor
            // ao encontrar acumula a qtd no primeiro elemento (indice 0)
                res[0] ++;
                res[res[0]] = i;
                // guarda o valor dos índices como elementos do vetor a primeiros do segundo elemento

                if( res[0] == nPrimeiros){
                // para o laço ao acumular a quantidade solicitada pelo usuário
                    break;
                }
            }
        }

        return res;
    }

    public int armazenar1Vaga(int valor){

        if(!this.valorValido(valor)){
            return 1;
        }

        for(int i = 0; i < this.tamanho; i++){
            if (this.dados[i] == this.vaga){
                int res = this.armazenar(valor, i);
                return res;
            }
        }
        return -1;
    }

    public int removerUltima(){

        /*Percorre o vetor do final para o inicio
        isso torna o algoritmo mais eficiente 
        pois não precisará sempre percorrer o vetor até o final */
        for( int i = this.tamanho -1; i >=0; i--){
            if(this.dados[i] != this.vaga){
                return this.excluir(i);
            }
        }

        return -1;
    }

    private boolean valorValido(int valor){
        return valor >= this.minimo && valor <= this.maximo;
    }

    private boolean posicaoValida(int posicao){
        return posicao >= 0 && posicao < this.tamanho;
        // vetor começa com a posição 0 e termina em tamanho -1
        // por isso posição é > que tamanho e não >=
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