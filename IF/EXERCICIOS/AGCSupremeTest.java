import java.util.Scanner;
import Fila.FilaArray;

public class AGCSupremeTest {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------------");
        System.out.println("    SUPER SISTEMA DE TESTES AGC       ");
        System.out.println("--------------------------------------" + "\n");

        while(true){

            System.out.println("Qual estrutura de dados dejesa testar?" + "\n");

            System.out.println("2 - Fila");
            System.out.println("99 - ENCERRAR programa" + "\n");
            System.out.print("Sua opção: ");

            int opcaoInicial = scanner.nextInt();

            if(opcaoInicial == 99){
                System.out.println("Você escolheu 'ENCERRAR PROGRAMA!'");
                System.out.println("VOLTE SEMPRE!'");
                break;

            }else if(opcaoInicial == 2){
            // TESTE DE FILA

            FilaArray FilaDoLanche = new FilaArray (10,0);

                while(true){

                    System.out.println("\n" + "-------- Teste da FILA:ARRAY  -----------" + "\n");

                    System.out.println("1 - Está VAZIA?");
                    System.out.println("2 - ADICIONAR elemento");
                    System.out.println("3 - REMOVER elemento");
                    System.out.println("4 - PRIMEIRO elemento");
                    System.out.println("\n" + "98 - Voltar para o MENU PRINCIPAL");
                    System.out.print("\n" + "Sua opção: ");

                    int filaOpcao = scanner.nextInt();
                    
                    if(filaOpcao == 1){
                        
                        System.out.println("\n" + "Fila está vazia? " + FilaDoLanche.isEmpty());

                    }else if(filaOpcao == 2){
                        
                        System.out.println("Você selecionou 'ADICIONAR'" + "\n");
                        System.out.print("Qual valor:");

                        int valor = scanner.nextInt();
                        FilaDoLanche.enqueue(valor);

                        System.out.println("\n" + "Sua fila: " + FilaDoLanche);

                    }else if(filaOpcao == 3){

                        System.out.println("Você selecionou 'REMOVER'");

                        FilaDoLanche.dequeue();

                        System.out.println(FilaDoLanche);

                    }else if(filaOpcao == 4){
                        
                        System.out.println("Você escolheu 'PRIMEIRO ELEMENTO'");
                        System.out.println("O primeiro elemento é: " + FilaDoLanche.first());

                    }else if(filaOpcao == 98){
                        System.out.println(" Retornando ao menu inicial");
                        break;
                    }

                }

            } // Segunda opção de ESTRUTURA DE DADO PARA TESTAR - else if (){} ...s

        }

        
        
    }
}