import java.util.Scanner;

public class VetorTeste{

    public static void main(String arg[]){

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + "------------------------------------------");
        System.out.println("------- Teste para Vetor com LL ---------");
        System.out.println("------------------------------------------" + "\n");

        VetorLigadoMestre VetorLL = new VetorLigadoMestre();

        while(true){

            System.out.println("1 - Está vazio?");
            System.out.println("2 - Elemento no índice");
            System.out.println("3 - Trocar elemento");
            System.out.println("4 - Inserir por indice");
            System.out.println("5 - Remover elemento");
            System.out.println("\n"+"99 - ENCERRAR"+"\n");

            System.out.print("Escolha sua opção: ");
            int opc = scanner.nextInt();

            if(opc == 1){

                System.out.println("\n"+"Está vazio? " + VetorLL.isEmpty() + "\n");

            }else if(opc == 2){

                System.out.println("\n"+"Elemento do índice");

                System.out.print("Informe qual é o indice que você quer saber o elemento: ");
                int indice = scanner.nextInt();

                System.out.println("Valor: " + VetorLL.elemAtRank(indice) + "\n");

            }else if(opc == 3){

                System.out.println("\n"+"Trocar elemento"+"\n");


                System.out.print("Informe o indice onde vc quer inserir o elemento: ");
                int index = scanner.nextInt();

                System.out.print("\n"+"Qual valor que você deseja inserir: ");
                int valor = scanner.nextInt();
                
                VetorLL.replaceAtRank(index,valor);
                System.out.println("Seu vetor: " + VetorLL.toString());

            }else if(opc == 4){

                System.out.println("\n"+"Você escolheu 'INSERIR POR ÍNDICE'");
                System.out.print("Qual é o índice que vc deseja inserir um elemento: ");
                int index = scanner.nextInt();

                System.out.print("Agora informe o valor: ");
                int valor = scanner.nextInt();

                VetorLL.insertAtRank(index,valor);
                System.out.println("Seu vetor: " + VetorLL.toString());

            }else if(opc == 5){

                System.out.println("\n"+"Você escolheu 'REMOVER ELEMENTOS'");
                System.out.print("Qual é o indice do elemento que você deseja remover: ");
                int index = scanner.nextInt();

                VetorLL.removeAtRank(index);

                System.out.println("Seu vetor: " + VetorLL.toString());

            }else if(opc == 99){
                
                System.out.println("Você escolheu ENCERRAR");
                System.out.println("Volte sempre!");

                break;
            }
        }
    }
}