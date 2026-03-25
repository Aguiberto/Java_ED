public class TesteRubroNegro{

    public static void main(String[] args){

        PilhaRubroNegraArray pilha = new PilhaRubroNegraArray();

        System.out.println(" =================== TESTE ADIÇÃO =======================");
        System.out.println();

        pilha.adicionarVermelho(1);
        pilha.adicionarVermelho(2);
        pilha.adicionarVermelho(3);
        pilha.adicionarVermelho(3);

        int TamanhoV = pilha.tamanhoVermelho();

        System.out.println("Pilha: " + pilha);
        System.out.println("Tamanho da pilha VERMELHA: " + TamanhoV);
    }

}