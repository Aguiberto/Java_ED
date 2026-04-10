import java.util.Scanner;

public class teste{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + "------------------------------------------");
        System.out.println("------- Teste para inverter Arary --------");
        System.out.println("------------------------------------------" + "\n");

        FilaInvertida FilaDoLanche = new FilaInvertida(10,0);

        while(true){

            System.out.println("1 - Está vazio?");
            System.out.println("2 - Adicionar");
            System.out.println("3 - Remover");
            System.out.println("4 - Primeiro elemento");
            System.out.println("5 - Inverter array");
            System.out.println("\n"+"99 - ENCERRAR"+"\n");

            System.out.print("Escolha sua opção: ");
            int opc = scanner.nextInt();

            if(opc == 1){

                System.out.println("\n"+"Está vazio? " + FilaDoLanche.isEmpty() + "\n");

            }else if(opc == 2){

                System.out.println("\n"+"ADICIONAR ELEMENTO");

                System.out.print("Informe qual valor adiconar: ");
                int valor = scanner.nextInt();

                FilaDoLanche.enqueue(valor);
                System.out.println("Sua fila: " + FilaDoLanche + "\n");

            }else if(opc == 3){

                System.out.println("\n"+"REMOVER VALOR");
                FilaDoLanche.dequeue();

                System.out.println("Sua fila: " + FilaDoLanche + "\n");

            }else if(opc == 4){

                System.out.println("\n"+"Primeiro valor da fila: " + FilaDoLanche.first() + "\n");

            }else if(opc == 5){

                System.out.println("\n"+"INVERTER FILA");
                FilaDoLanche.reverse();

                System.out.println("Fila invertida: " + FilaDoLanche + "\n");

            }else if(opc == 99){
                
                System.out.println("Você escolheu ENCERRAR");
                System.out.println("Volte sempre!");

                break;
            }
        }
    }

}