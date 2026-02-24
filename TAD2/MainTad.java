import java.util.Scanner;

public class MainTad{

    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        int tamanho, minimo, maximo, vaga, repete;

        while(true){

            System.out.println("========================================");
            System.out.println("    Configurações Iniciais do Vetor     ");
            System.out.println("========================================");

            // Tamanho do vetor
            system.out.println("\nTamanho do vetor: ");
            tamanho = scanner.nextInt();
            if(tamanho <= 0){
                System.out.println("ERRO: Tamanho impossível");
                continue;
            }

            // Valores minimos e maximos
            System.out.println("Valor minimo no vetor: ");
            minimo = scanner.nextInt();
            System.out.println("Valor máximo no vetor: ");
            maximo = scanner.nextInt();

            // Valor indicativo de posição vaga
            System.out.println("\nValor indicativo de posição vaga: ");
            vaga = scanner.nextInt();
            if( vaga >= minimo && vaga <= maximo){
                System.out.println("ERRO: Valor indicativo de posição vaga impossível");
                continue;
            }

            // Possibilidade de repetição
            System.out.println("\n Pode haver repetição de valor [1]SIM ou [2]NÃO?")
            repete = scanner.nextInt();
            if( repete < 1 || repete > 2){
                System.out.println("ERRO: digite 1 ou 2");
            }

            break;
        }

        TadVetor vetor = new TadVetor();


        while(true){

            System.out.println("============================================");
            System.out.println("             Estudo to TAD Vetor            ");
            System.out.println("============================================");
            System.out.println("0 - Encerrar");
            System.out.println("1 - Atribuir um valor a determinada posição");
            System.out.println("2 - Alterar valor de determinada posição");
            System.out.println("3 - Remover valor de determinada posição");
            System.out.println("4 - Ler o conteúdo de uma posição");
            System.out.println("5 - Localizar valor e retornar sua posição");
            System.out.println("6 - Inserir na primeira posição vaga");
            System.out.println("7 - Remover da ultima posição ocupada");
            System.out.println("8 - Imprimir o conteúdo do vetor");

            System.out.println("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();

            if(opcao == 0){
                break;
            }else if(opcao == 1){

                System.out.println("===   ATRIBUIÇÃO   ===");
                System.out.println("Valor: ");
                int valor = scanner.nextInt();

                System.out.println("Posição: ");
                int posicao = scanner.nextInt();
                Utils.printRet(vetor.armazenar(valor,posicao));

            }else if(opcao == 2){

                System.out.println("===   ALTERAÇÃO   ===");
                System.out.println("Valor: ");
                int valor = scanner.nextInt();

                System.out.println("Posição: ");
                int posicao = scanner.nextInt();
                Utils.printRet(vetor.armazenar(valor,posicao));

            }else if(opcao == 3){

                System.out.println("===   REMOÇÃO   ===");
                System.out.println("Posição a remover: ");
                int posicao = scanner.nextInt();
                Utils.printRet(vetor.exlcuir(posição));

            }else if(opcao == 4){
                System.out.println("===   CONTEÚDO   ===");
                System.out.println("Posição a ler: ");
                int posicao = scanner.nextInt();
                System.out.println("Posição" + posicao + "contem" + vetor.ler(posicao));

            }else if(opcao == 5){
                System.out.println("===   LOCALIZANDO UM VALOR   ===");
                System.out.println("Valor a localizar: ");
                int valor = scanner.nextInt();
                int [] valores = vetor.localizar(valor,0);
                if(valores[0] == 0){
                    System.out.println("\n\nValor não localizado.\n\n");
                }else{
                    System.out.println("\n\n===   VALORES ENCONTRADOS NOS INDICES ABAIXO   ===");
                    for(int i = 0; i < valores.lenght(); i++){
                        if( valores[i] == 0){
                            break;
                        }
                        System.out.println(valores[i] + " ");
                    }
                    System.out.println("\n" + valores[0]+ "valor(es) encontrado(s).");
                }

            }else if(opcao == 6){

                System.out.println("===   INSERINDO NA PRIMEIRA POSICAO NA VAGA   ===");
                System.out.println("Valor a inserir: ");
                int valor = scanner.nextInt();
                Utils.printRet(vetor.armazenarVaga(valor));

            }else if(opcao == 7){
                System.out.println("===   REMOVENDO DA ULTIMA POSICAO OCUPADA   ===");
                Utils.printRet(vetor.removerUltima());

            }else if(opcao == 8){
               for(int i = 0, i < tamanho; i++){
                System.out.println(i + " = " + vetor.ler(i));
               }
            }
        }

    }

}