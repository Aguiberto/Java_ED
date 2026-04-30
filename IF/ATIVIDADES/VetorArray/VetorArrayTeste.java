import java.util.Scanner;

public class VetorArrayTeste{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Vetor vetor = new Vetor();

        while(true){

            System.out.println("\n" + "-------------- Teste de VETOR: Array -------------" + "\n");

            System.out.println("1 - Está VAZIA?");
            System.out.println("2 - TAMANHO");
            System.out.println("3 - Consultar valor por índice");
            System.out.println("4 - TROCAR elemento");
            System.out.println("5 - INSERIR elemento");
            System.out.println("6 - REMOVER elemento");
            System.out.println("\n" + "99 - Voltar para o MENU PRINCIPAL");
            System.out.print("\n" + "Sua opção: ");

            int opcaoVetor = scanner.nextInt();

            if(opcaoVetor == 1){

                System.out.println("Está vazio? " + vetor.isEmpty());

            }else if(opcaoVetor == 2){

                System.out.println("Tamanho do Vetor: " + vetor.size());

            }else if(opcaoVetor == 3){

                System.out.println("Informe qual índice que você deseja consultar o valor: ");
                int indice = scanner.nextInt();

                System.out.println("O valor do índice " + indice + " é: " + vetor.elemAtRank(indice));

            }else if(opcaoVetor == 4){

                System.out.println("Você escolheu TROCAR elementos");
                System.out.println("Informe qual é o índice do elemento que dejesa que seja trocado: ");
                int indice = scanner.nextInt();

                System.out.println("Agora informe qual valor a substituir: " );
                int valor = scanner.nextInt();

                System.out.println("O valor substituido foi: " + vetor.replaceAtRank(indice,valor));
                System.out.println("Vetor: " + vetor.toString());

            }else if(opcaoVetor == 5){

                System.out.println("Você escolheu: Inserir elemento por íNDICE");
                System.out.println("Informe o índice: ");
                int indice = scanner.nextInt();

                System.out.println("Informe o valor: ");
                int valor = scanner.nextInt();

                vetor.insertAtRank(indice,valor);

                System.out.println("Array: " + vetor.toString());

            }else if(opcaoVetor == 6){

                System.out.println("Você escolheu: REMOVER pelo ÍNDICE");
                System.out.println("Informe o índice: ");
                int indice = scanner.nextInt();
                
                vetor.removeAtRank(indice);

                System.out.println("Array: " + vetor.toString());
            
            }else if(opcaoVetor == 99){

                System.out.println("Você escolheu ENCERRAR");
                System.out.println("Até mais, BOM DESCANSO!");
                break;
            }
            
        }

    }
}