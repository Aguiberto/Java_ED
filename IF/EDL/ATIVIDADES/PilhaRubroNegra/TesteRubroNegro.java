public class TesteRubroNegro{

    public static void main(String[] args){

        PilhaRubroNegraArray pilha = new PilhaRubroNegraArray();

        System.out.println();
        System.out.println(" ======================================= TESTE ADIÇÃO ===========================================");
        System.out.println();

        pilha.adicionarVermelho(1);
        pilha.adicionarVermelho(2);
        pilha.adicionarVermelho(3);
        pilha.adicionarVermelho(3);

        System.out.println("============================ Pilha Vermelha ==================");
        System.out.println("Pilha: " + pilha);
        System.out.println("Tamanho da pilha VERMELHA: " + pilha.tamanhoVermelho());
        System.out.println("Topo pilha VERMELHA: " + pilha.topoVermelho());
        System.out.println();

        pilha.adicionarNegro(7);
        pilha.adicionarNegro(8);
        pilha.adicionarNegro(9);

        System.out.println("======================== Pilha Negra ==========================");
        System.out.println("Pilha: " + pilha);
        System.out.println("Tamanho da pilha NEGRA: " + pilha.tamanhoNegro());
        System.out.println("Topo pilha NEGRA: " + pilha.topoNegro());
        System.out.println();

        System.out.println(" ================================ TESTE AUMENTAR CAPACIDADE ====================================");
        System.out.println();

        /**A pilha já tem 7/10 elementos */
        pilha.adicionarVermelho(4);
        pilha.adicionarVermelho(4);
        pilha.adicionarNegro(10);
        pilha.adicionarNegro(11);

        System.out.println("                          Pilha com nova capacidade             " );
        System.out.println(pilha);

        System.out.println();

        System.out.println(" ======================================== TESTE REMOÇÃO ========================================");
        System.out.println();

        pilha.removerVermelho();
        pilha.removerVermelho();

        System.out.println("====================================== Pilha Vermelha =================================");
        System.out.println("Pilha: " + pilha);
        System.out.println("Tamanho da pilha VERMELHA: " + pilha.tamanhoVermelho());
        System.out.println("Topo pilha VERMELHA: " + pilha.topoVermelho());
        System.out.println();

        pilha.removerNegro();

        System.out.println("======================================= Pilha Negra =====================================");
        System.out.println("Pilha: " + pilha);
        System.out.println("Tamanho da pilha NEGRA: " + pilha.tamanhoNegro());
        System.out.println("Topo pilha NEGRA: " + pilha.topoNegro());
        System.out.println();

        System.out.println(" ============================== TESTE REDUÇÃO DE CAPACIDADE ======================================");
        System.out.println();

        pilha.removerNegro();
        pilha.removerVermelho();
        System.out.println("          Pilha com nova capacidade           " );
        System.out.println(pilha);
        System.out.println();

        System.out.println(" ====================================== TESTE PILHA VAZIA =========================================");

        pilha.removerVermelho();
        pilha.removerVermelho();
        
        System.out.println("A pilha VERMELHA está vazia: " + pilha.vermelhoVazio());

        pilha.removerNegro();
        pilha.removerNegro();
        System.out.println("A pilha NEGRA está vazia: " + pilha.negroVazio());
        System.out.println();

        System.out.println(" ====================================== TESTE DE EXCECAO =========================================");
        System.out.println();

        pilha.topoNegro();
    }

}