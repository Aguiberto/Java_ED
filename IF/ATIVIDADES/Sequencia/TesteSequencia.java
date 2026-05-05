import java.util.Scanner;

public class TesteSequencia{

    public static void main(String[] args)throws InterruptedException{

        Scanner scanner = new Scanner(System.in);
        SequenciaMestra sequencia = new SequenciaMestra();

        while(true){

            System.out.println("\n" + "-------- Teste de Sequência: Sequência duplamente ligada --------" + "\n");

            System.out.println("==== Métodos Genéricos ====" + "\n");

            System.out.println("1 - Está VAZIA?");
            System.out.println("2 - TAMANHO");

            System.out.println("==== Métodos de Vetor ====" + "\n");

            System.out.println("3 - Consultar valor por índice");
            System.out.println("4 - TROCAR elemento");
            System.out.println("5 - INSERIR elemento");
            System.out.println("6 - REMOVER elemento");

            System.out.println("==== Métodos de Lista ====" + "\n");

            System.out.println("7 - Primeiro elemento");
            System.out.println("8 - Último elemento");
            System.out.println("9 - É o primeiro?");
            System.out.println("10 - É o último?");
            System.out.println("11 - ANTERIOR da lista");
            System.out.println("12 - PRÓXIMO da lista");
            System.out.println("13 - SUBSTITUIR elementos");
            System.out.println("14 - TROCAR elementos");
            System.out.println("15 - Inserir ANTES");
            System.out.println("16 - Inserir DEPOIS");
            System.out.println("17 - Inserir NO INÍCIO");
            System.out.println("18 - Inserir NO FINAL");
            System.out.println("19 - REMOVER elemento");
            System.out.println("20 - MOSTRAR  a lista");

            System.out.println("\n" + "99 - ENCERRAR programa");
            System.out.print("\n" + "Sua opção: " + "\n");

            int opcaoSequencia = scanner.nextInt();

            if(opcaoSequencia == 1){

                System.out.println("Você selecionou : Está Vazia?");
                System.out.println("Resposta: " + sequencia.isEmpty() + "\n");

            }else if(opcaoSequencia == 2 ){

                System.out.println("Você selecionou : Ver TAMANHO");
                System.out.println("Resposta: " + sequencia.size() + "\n");

            }else if(opcaoSequencia == 3){

                System.out.println("Consultar valor por indice");

                System.out.print("Informe o índice: ");
                int index = scanner.nextInt();

                System.out.print("O valor referente ao índice informado é: " + sequencia.elemeAtRank(index));

            }else if(opcaoSequencia == 4){

                System.out.println("TROCAR elemento");

                System.out.println("Informe o indice de deseja trocar o valor: ");
                int index = scanner.nextInt();

                System.out.println("Informe o valor que deseja coloca: ");
                int valor = scanner.nextInt();

                sequencia.replaceAtRank(index, valor);
                System.out.println("A nova sequência é: " + sequencia);

            }else if(opcaoSequencia == 5){

                System.out.println("Iserir elemento");

                System.out.print("Informe o indice onde deseja colocar o elemento: ");
                int index = scanner.nextInt();

                System.out.print("Agora informe o valor a ser adicionado: ");
                int valor = scanner.nextInt();

                sequencia.insertAtRank(index,valor);
                System.out.println("Sequencia: " + sequencia);

            }else if(opcaoSequencia == 6){

                System.out.println("Remover elemento");

                System.out.println("Informe o indice do valor que deseja remover: ");
                int index = scanner.nextInt();

                sequencia.remove(index);
                System.out.println("Sequencia: " + sequencia);
            

            }else if(opcaoSequencia == 7){

                System.out.println("Você selecionou : PRIMEIRO  elemento:");
                System.out.println("Resposta: " + sequencia.first() + "\n");                        

            }else if(opcaoSequencia == 8){

                System.out.println("Você selecionou : ULTIMO elemento");
                System.out.println("Resposta: " + sequencia.last() + "\n");                        


            }else if(opcaoSequencia == 9){

                System.out.println("Você selecionou : é o PRIMEIRO?:");
                
                System.out.print("Informe o valor para verificar se é o primeiro elemento: ");
                int valor = scanner.nextInt();

                System.out.println("Resposta: " + sequencia.isFirst(valor) + "\n");                        
                

            }else if(opcaoSequencia == 10){

                System.out.println("Você selecionou : É  o ULTIMO?");

                System.out.print("Informe o valor para verificar se é o último elemento: ");
                int valor = scanner.nextInt();

                System.out.println("Resposta: " + sequencia.isLast(valor) + "\n");                        


            }else if(opcaoSequencia == 11){

                System.out.println("Você selecionou : ANTERIOR  da lista");

                System.out.println("Informe o indice para saber qual é o valor anterior: ");
                int indice = scanner.nextInt();

                Object anteior = sequencia.before(indice);

                System.out.println("O valor anterior: " + anteior);


            }else if(opcaoSequencia == 12){

                System.out.println("Você selecionou : PRÓXIMO  da lista");

                System.out.println("Informe o índice para saber qual é o próximo: ");
                int indice = scanner.nextInt();

                Object proximo = sequencia.after(indice);

                System.out.println("O valor anterior: " + proximo);


            }else if(opcaoSequencia == 13){

                System.out.println("Você selecionou : SUBSTITUIR elementos");

                System.out.println("Qual índice do elemento a ser substituído: ");
                int substituido = scanner.nextInt();

                System.out.println("Informe o valor para substituir: ");
                int valor = scanner.nextInt();

                sequencia.replaceElement(substituido,valor);
                System.out.println("Valor substituído com sucesso");
                System.out.println(sequencia);


            }else if(opcaoSequencia == 14 ){

                System.out.println("Você selecionou : TROCAR  elementos");

                System.out.println("Informe o índice do 1º elemento: ");
                int primeiro = scanner.nextInt();

                System.out.println("Informe o índice do 2º elemento: ");
                int segundo = scanner.nextInt();

                sequencia.swapElements(primeiro,segundo);
                System.out.println("Elementos trocados com sucesso!");
                System.out.println(sequencia);

            }else if(opcaoSequencia == 15){

                System.out.println("Você selecionou : ver inserir ANTES");

                System.out.println("Informe um índice: ");
                int indice = scanner.nextInt();

                System.out.println("Informe um valor: ");
                int valor = scanner.nextInt();

                sequencia.insertBefore(indice,valor);
                System.out.println("\n" + sequencia);


            }else if(opcaoSequencia == 16){

                System.out.println("Você selecionou : ver inserir DEPOIS");

                System.out.println("Informe um índice: ");
                int indice = scanner.nextInt();

                System.out.println("Informe um valor: ");
                int valor = scanner.nextInt();

                sequencia.insertAfter(indice,valor);
                System.out.println("\n" + sequencia);                        

            }else if(opcaoSequencia == 17){

                System.out.println("Você selecionou : inserir no INICIO");
                System.out.println("Informe um valor: ");

                int opcao = scanner.nextInt();
                
                sequencia.insertFirst(opcao);
                System.out.println("\n" + sequencia);

            }else if(opcaoSequencia == 18){
                
                System.out.println("Você selecionou : inserir no FINAL");
                System.out.println("Informe um valor: ");

                int opcao = scanner.nextInt();
                
                sequencia.insertLast(opcao);
                System.out.println("\n" + sequencia);

            }else if(opcaoSequencia == 19){

                System.out.println("Você selecionou : REMOVER elemento");

                System.out.println("Informe um indice para o valor ser removido: ");
                int valor = scanner.nextInt();

                sequencia.remove(valor);
                System.out.println("Remoção realizada com sucesso!");
                System.out.println("\n" + sequencia);

            }else if(opcaoSequencia == 20){

                System.out.println("Você selecionou : MOSTRAR lista");
                System.out.println(sequencia);

            }else if(opcaoSequencia == 99){

                System.out.println("Encerrando ...");
                Thread.sleep(1000);
                break;

            }
        }
    }
}