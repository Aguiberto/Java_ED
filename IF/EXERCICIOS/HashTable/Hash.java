import java.util.ArrayList;

public class Hash{

    class item{

        public int chave;
        public  List<No> valor; 

        public item(Object obj, int chave){

            this.valor = new ArrayList<>(No);
            this.chave = chave;

        }

    }

    class No{

        public Object valorNo;
        public No antes;
        public No depois;

    }

    private List<item> tabela;
    private int tamanho;
    private int capacidade;

    public hash(){

        this.tamanho = 0;
        this.capacidade = 11;
        tabela = new ArrayList<>(capacidade);

    }

    public void insert(int chave, Object obj){

        // calcular a chave para saber onde vai ser inserido o elemento
        item novo = new item(chave, obj);

        chaveNaHash = hashKey(chave);

        tabela.add(chaveNaHash,obj);
        tamanho ++;
    }


    private int hashKey(int chave){
        
        int valor = chave % capacidade;
        return valor;

    }
}