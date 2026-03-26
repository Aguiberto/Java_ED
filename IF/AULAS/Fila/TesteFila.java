import java.util.Scanner;

public class TesteFila {

    public static void main(String[] arg){

        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================== ");
        System.out.println("           SISTEMA AGC DE TESTES            ");
        System.out.println("=========================================== ");
        System.out.println();

        System.out.println("Informe o tamanho da fila: ");
        int tamanho = scanner.nextInt();

        System.out.println("Informe o incremento: ");
        int incremento = scanner.nextInt();

        FilaCircularArray FilaDoLanche = new FilaCircularArray(tamanho,incremento);

        while(true){

            /**TESTES
             * 1 - Adiciona e mostra o array
             * 2 - Remove e mostra o array
             * 3 - Mostra o PRIMEIRO elemento
             * 4 - Informa o TAMANHO do array
             * 5 - Informa se está VAZIO
             * 6 - ENCERRA  o programa
             */ 

            System.out.println("Escolha uma opção abaixo: ");
            System.out.println();

            System.out.println("1 - Testar ADIÇÃO");
            System.out.println("2 - Testar REMOÇÃO");
            System.out.println("3 - Mostrar o PRIMEIRO");
            System.out.println("4 - Mostrar o TAMANHO  da fila");
            System.out.println("5 - Está vazio?");
            System.out.println("6 - ENCERRAR o programa");
            System.out.println();

            System.out.println("SUA OPCAO: ");
            int opcao = scanner.nextInt();

            if(opcao == 1){

            }
            if()
        }
    }
}