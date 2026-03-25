public class TesteRubroNegro{

    public static void main(String[] args){

        PilhaRubroNegraArray pilha = new PilhaRubroNegraArray();



        System.out.println(" =================== TESTE ADIÇÃO =============================");
        System.out.println();

        pilha.adicionarVermelho(1);
        pilha.adicionarVermelho(2);
        pilha.adicionarVermelho(3);
        pilha.adicionarVermelho(3);

        
        System.out.println();
        System.out.println("============================ Pilha Vermelha ==================");
        System.out.println("Pilha: " + pilha);
        System.out.println("Tamanho da pilha VERMELHA: " + pilha.tamanhoVermelho());
        System.out.println("Topo pilha VERMELHA: " + pilha.topoVermelho());
        System.out.println("===============================================================");
        System.out.println();

        pilha.adicionarNegro(7);
        pilha.adicionarNegro(8);
        pilha.adicionarNegro(9);

        System.out.println();
        System.out.println("======================== Pilha Negra ==========================");
        System.out.println("Pilha: " + pilha);
        System.out.println("Tamanho da pilha NEGRA: " + pilha.tamanhoNegro());
        System.out.println("Topo pilha NEGRA: " + pilha.topoNegro());
        System.out.println("===============================================================");


    }

}