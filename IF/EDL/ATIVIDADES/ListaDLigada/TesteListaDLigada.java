import java.util.Scanner;

public class TesteListaDLigada{

    public static void main(String[] args)throws InterruptedException{

        Scanner scanner = new Scanner(System.in);
        ListaMestra ListaNegra = new ListaMestra();

        while(true){

            System.out.println("\n" + "-------- Teste de LISTA: Lista duplamente ligada --------" + "\n");

            System.out.println("1 - Está VAZIA?");
            System.out.println("2 - TAMANHO");
            System.out.println("3 - Primeiro elemento");
            System.out.println("4 - Último elemento");
            System.out.println("5 - É o primeiro?");
            System.out.println("6 - É o último?");
            System.out.println("7 - ANTERIOR da lista");
            System.out.println("8 - PRÓXIMO da lista");
            System.out.println("9 - SUBSTITUIR elementos");
            System.out.println("10 - TROCAR elementos");
            System.out.println("11 - Inserir ANTES");
            System.out.println("12 - Inserir DEPOIS");
            System.out.println("13 - Inserir NO INÍCIO");
            System.out.println("14 - Inserir NO FINAL");
            System.out.println("15 - REMOVER elemento");
            System.out.println("16 - MOSTRAR  a lista");

            System.out.println("\n" + "99 - ENCERRAR programa");
            System.out.print("\n" + "Sua opção: " + "\n");

            int opcaoLista = scanner.nextInt();

            if(opcaoLista == 1){

                System.out.println("Você selecionou : Está Vazia?");
                System.out.println("Resposta: " + ListaNegra.isEmpty() + "\n");

            }else if(opcaoLista == 2 ){

                System.out.println("Você selecionou : Ver TAMANHO");
                System.out.println("Resposta: " + ListaNegra.size() + "\n");

            }else if(opcaoLista == 3){

                System.out.println("Você selecionou : PRIMEIRO  elemento:");
                System.out.println("Resposta: " + ListaNegra.first() + "\n");                        

            }else if(opcaoLista == 4){

                System.out.println("Você selecionou : ULTIMO elemento");
                System.out.println("Resposta: " + ListaNegra.last() + "\n");                        


            }else if(opcaoLista == 5){

                System.out.println("Você selecionou : é o PRIMEIRO?:");
                
                System.out.print("Informe o valor para verificar se é o primeiro elemento: ");
                int valor = scanner.nextInt();

                System.out.println("Resposta: " + ListaNegra.isFirst(valor) + "\n");                        
                

            }else if(opcaoLista == 6){

                System.out.println("Você selecionou : É  o ULTIMO?");

                System.out.print("Informe o valor para verificar se é o último elemento: ");
                int valor = scanner.nextInt();

                System.out.println("Resposta: " + ListaNegra.isLast(valor) + "\n");                        


            }else if(opcaoLista == 7){

                System.out.println("Você selecionou : ANTERIOR  da lista");

                System.out.println("Informe o indice para saber qual é o valor anterior: ");
                int indice = scanner.nextInt();

                NoDuplo NoProcurado = ListaNegra.searchNode(indice);
                Object anteior = ListaNegra.before(NoProcurado);

                System.out.println("O valor anterior: " + anteior);


            }else if(opcaoLista == 8){

                System.out.println("Você selecionou : PRÓXIMO  da lista");

                System.out.println("Informe o índice para saber qual é o próximo: ");
                int indice = scanner.nextInt();

                NoDuplo NoProcurado = ListaNegra.searchNode(indice);
                Object proximo = ListaNegra.after(NoProcurado);

                System.out.println("O valor anterior: " + proximo);


            }else if(opcaoLista == 9){

                System.out.println("Você selecionou : SUBSTITUIR elementos");

                System.out.println("Qual índice do elemento a ser substituído: ");
                int substituido = scanner.nextInt();

                System.out.println("Informe o valor para substituir: ");
                int valor = scanner.nextInt();

                ListaNegra.replaceElement(substituido,valor);
                System.out.println("Valor substituído com sucesso");
                System.out.println(ListaNegra);


            }else if(opcaoLista == 10 ){

                System.out.println("Você selecionou : TROCAR  elementos");

                System.out.println("Informe o índice do 1º elemento: ");
                int primeiro = scanner.nextInt();

                System.out.println("Informe o índice do 2º elemento: ");
                int segundo = scanner.nextInt();

                ListaNegra.swapElements(primeiro,segundo);
                System.out.println("Elementos trocados com sucesso!");
                System.out.println(ListaNegra);

            }else if(opcaoLista == 11){

                System.out.println("Você selecionou : ver inserir ANTES");

                System.out.println("Informe um índice: ");
                int indice = scanner.nextInt();

                System.out.println("Informe um valor: ");
                int valor = scanner.nextInt();

                ListaNegra.insertBefore(indice,valor);
                System.out.println("\n" + ListaNegra);


            }else if(opcaoLista == 12){

                System.out.println("Você selecionou : ver inserir DEPOIS");

                System.out.println("Informe um índice: ");
                int indice = scanner.nextInt();

                System.out.println("Informe um valor: ");
                int valor = scanner.nextInt();

                ListaNegra.insertAfter(indice,valor);
                System.out.println("\n" + ListaNegra);                        

            }else if(opcaoLista == 13){

                System.out.println("Você selecionou : inserir no INICIO");
                System.out.println("Informe um valor: ");

                int opcao = scanner.nextInt();
                
                ListaNegra.insertFirst(opcao);
                System.out.println("\n" + ListaNegra);

            }else if(opcaoLista == 14){
                
                System.out.println("Você selecionou : inserir no FINAL");
                System.out.println("Informe um valor: ");

                int opcao = scanner.nextInt();
                
                ListaNegra.insertLast(opcao);
                System.out.println("\n" + ListaNegra);

            }else if(opcaoLista == 15){

                System.out.println("Você selecionou : REMOVER elemento");

                System.out.println("Informe um valor para ser removido: ");
                int valor = scanner.nextInt();

                ListaNegra.remove(valor);
                System.out.println("Remoção realizada com sucesso!");
                System.out.println("\n" + ListaNegra);

            }else if(opcaoLista == 16){

                System.out.println("Você selecionou : MOSTRAR lista");
                System.out.println(ListaNegra);

            }else if(opcaoLista == 99){

                System.out.println("Encerrando ...");
                Thread.sleep(1000);
                break;

            }
        }
    }
}