import java.util.Scanner;
import Fila.FilaArray;
import FilaLigada.FilaLigada;
import Pilha.PilhaMestra;

public class AGCSupremeTest {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------------");
        System.out.println("    SUPER SISTEMA DE TESTES AGC       ");
        System.out.println("--------------------------------------" + "\n");

        while(true){

            System.out.println("Qual estrutura de dados dejesa testar?" + "\n");

            System.out.println("1 - Pilha: Lista Ligada");
            System.out.println("2 - Fila: Array");
            System.out.println("3 - Fila: Lista Ligada");
            System.out.println("99 - ENCERRAR programa" + "\n");
            System.out.print("Sua opção: ");

            int opcaoInicial = scanner.nextInt();

            if(opcaoInicial == 99){
                System.out.println("Você escolheu 'ENCERRAR PROGRAMA!'");
                System.out.println("VOLTE SEMPRE!'");
                break;

            }else if(opcaoInicial == 1){

            // TESTE DE PILHA LIGADA    
            // TESTE DE PILHA LIGADA    
            // TESTE DE PILHA LIGADA    

                System.out.println("\n"+"-------- Teste da Pilha: LISTA LIGADA -----------"+"\n");

                PilhaMestra pilhaDeDinheiro = new PilhaMestra(); 

                while(true){

                    System.out.println("\n"+"1 - esta VAZIA?");
                    System.out.println("2 - Ver tamanho");
                    System.out.println("3 - ADICIONAR elemento");
                    System.out.println("4 - REMOVER elemento?");
                    System.out.println("5 - TOPO" + "\n");

                    System.out.println("98 - RETORNAR AO MENU INICIAL"+"\n");

                    System.out.print("Sua opção: ");
                    int pilhaOpcao = scanner.nextInt();

                    if(pilhaOpcao == 1){

                        System.out.println("Pilha está VAZIA? " + pilhaDeDinheiro.isEmpty());

                    }else if(pilhaOpcao == 2){

                        System.out.println("Tamanho da pilha: " + pilhaDeDinheiro.size());

                    }else if(pilhaOpcao == 3){

                        System.out.println("Você selecionou 'ADICIONAR'" + "\n");

                        System.out.print("Informe o valor: ");
                        int ElementoPilha = scanner.nextInt();

                        pilhaDeDinheiro.push(ElementoPilha);

                        System.out.println("Sua pilha: " + pilhaDeDinheiro.toString());

                    }else if(pilhaOpcao == 4){

                        System.out.println("Você escolheu 'REMOVER'");
                        System.out.println("Sua pilha: " + pilhaDeDinheiro.pop());

                    }else if(pilhaOpcao == 5){

                        System.out.println("PRIMEIRO elemento: " + pilhaDeDinheiro.top());

                    }else if(pilhaOpcao == 98){
                        break;
                    }

                }


            }else if(opcaoInicial == 2){

            // TESTE DE FILA
            // TESTE DE FILA
            // TESTE DE FILA

            System.out.print("Informe a capacidade da FILA: ");
            int capacidadeFilaArray = scanner.nextInt();

            System.out.print("De quanto será o crescimento: ");
            int crescimentoFilaArray = scanner.nextInt();

            FilaArray FilaDoLanche = new FilaArray (capacidadeFilaArray,crescimentoFilaArray);

                while(true){

                    System.out.println("\n" + "-------- Teste da FILA: ARRAY  -----------" + "\n");

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

            }else if(opcaoInicial == 3){

                //TESTE DE FILA COM LISTA LIGADA
                //TESTE DE FILA COM LISTA LIGADA
                //TESTE DE FILA COM LISTA LIGADA

                FilaLigada FiladoSus = new FilaLigada();

                while(true){

                    System.out.println("\n" + "-------- Teste da FILA: Lista Ligada  -----------" + "\n");

                    System.out.println("1 - Está VAZIA?");
                    System.out.println("2 - ADICIONAR elemento");
                    System.out.println("3 - REMOVER elemento");
                    System.out.println("4 - PRIMEIRO elemento");
                    System.out.println("\n" + "98 - Voltar para o MENU PRINCIPAL");
                    System.out.print("\n" + "Sua opção: ");

                    int opcaoLigada = scanner.nextInt();

                    if(opcaoLigada == 1){

                         System.out.println("\n" + "Fila está vazia? " + FiladoSus.isEmpty());

                    }else if(opcaoLigada == 2){

                        System.out.println("Você selecionou 'ADICIONAR'" + "\n");
                        System.out.print("Qual valor:");

                        int valor = scanner.nextInt();
                        FiladoSus.enqueue(valor);

                        System.out.println("\n" + "Sua fila: " + FiladoSus);

                    }else if(opcaoLigada == 3){

                        System.out.println("Você selecionou 'REMOVER'");

                        FiladoSus.dequeue();

                        System.out.println(FiladoSus);

                    }else if(opcaoLigada == 4){

                        System.out.println("Você escolheu 'PRIMEIRO ELEMENTO'");
                        System.out.println("O primeiro elemento é: " + FiladoSus.first());                        

                    }else if(opcaoLigada == 98){
                        break;
                    }


                }

            } // PROXIMA ESTRUTURA DE DADOS ... else if ...

        }
    }
}