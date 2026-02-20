import java.util.Scanner;

public class Main{

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);
        Numero  numero = new Numero();

        while(true){
            System.out.println("===========================");
            System.out.println("       Estudo do TAD       ");
            System.out.println("===========================");
            System.out.println(" 0 - encerrar");
            System.out.println(" 1 - ler valor");
            System.out.println(" 2 - atribuir valor");

            System.out.println("Escolha uma opção");

            int escolha = scanner.nextInt();

            if(escolha == 0){
                break;
            }else if (escolha == 1){
                System.out.println("\n\n" + numero.getValor() + "\n\n");
            }else if(escolha == 2){
                System.out.println("Informe o nome valor: ");
                float novo_valor = scanner.nextFloat();
                numero.setValor(novo_valor);
            }
        }

    }

}