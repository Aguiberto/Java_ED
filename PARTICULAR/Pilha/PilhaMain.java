import java.util.Scanner;

public class PilhaMain{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------------------");
        System.out.println("PROGRAMA PARA ESTUDO DO TAD PILHA - VERSÃO 1");
        System.out.println("--------------------------------------------");
        System.out.println("");
        System.out.println("Tamanho máximo da pilha");

        int qtd = scanner.nextInt();

         TadPilha pilha = new TadPilha(qtd);

        while(true){
            System.out.println("\n\n----------------------------------------");
            System.out.println("PROGRAMA PARA ESTUDO DO TAD PILHA - VERSÃO 1");
            System.out.println("          Conteudo: numeros inteiros        ");
            System.out.println("          Capacidade: " + qtd + " elementos " );
            System.out.println("\n\n----------------------------------------");
            System.out.println("");
            System.out.println("0 - Encerrar");
            System.out.println("1 - Inserir um elemento");
            System.out.println("2 - Extrair um elemento");
            System.out.println("3 - Imprimir a pilha");
            System.out.println("");

            System.out.println("Opção: ");
            int opc = scanner.nextInt();

            if(opc == 0){
                break;
            } else if (opc == 1){

                System.out.print("Valor do elemento a inserir: ");
                int opc1 = scanner.nextInt();

                if(pilha.push(opc1)){
                    System.out.println("Inserção bem sucedida!");
                }else{
                    System.out.println("Inserção falhou!");
                }

            }else if(opc == 2){

                if(pilha.pop()){
                    System.out.println(("Extração bem sucedida. Valor do elemento = " + pilha.getRetorno()));
                }else{
                    System.out.println("Extração falhou");
                }

            }else if (opc == 3){
                System.out.println(pilha.print());
            }
        }

    }
}