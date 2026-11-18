public class MatrizAdj{

    private int qtdVertices;
    private int[][] matriz;

    public MatrizAdj(int qtdVertices){

        this.qtdVertices = qtdVertices;
        this.matriz = new int[qtdVertices][qtdVertices];

    }

    public void addAresta(int origem, int destino, int valor){

        if(origem >= 0 && origem < qtdVertices && destino >= 0 && destino < qtdVertices){

            matriz[origem][destino] = valor;
            matriz[destino][origem] = valor;

        }else{
            System.out.println("Vértice inválido!");
        }
    }


    public void mostrarMatriz(){

        System.out.println("Matriz de adjacência: ");
        for(int i = 0; i < qtdVertices; i++){
            for(int j = 0; j < qtdVertices; j++){
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int verticeMenorCaminho(boolean[] visitados, int[] distancias){

        int menorDistancia = Integer.MAX_VALUE;
        int indiceDoMenor = -1;

        /* percorre todos os vértices e confere 
        se a distância para aquele vertice é menor
        que para o que tem a menor distância anterior */
        for(int i=0; i < qtdVertices; i++){

            /*Se o vértice tiver a menor ditância então o valor de menor distância é atualizado
            e o método informa qual é o vértice que apresenta esse valor */
            if(!visitados[i] && distancias[i] < menorDistancia){
                menorDistancia = distancias[i];
                indiceDoMenor = i;
            }

        }

        return indiceDoMenor;
    }


    public void solucaoDijkstra(int origem){

        int[] distancias = new int[qtdVertices];
        boolean[] visitados = new boolean[qtdVertices];

        // inicio
        for(int i=0; i < qtdVertices; i++){
            distancias[i] = Integer.MAX_VALUE;                     // ditância inicial = infinito
            visitados[i] = false;                                  // começa sem nenhum vertice ter sido visitado
        }

        distancias[origem] = 0;

        // quando todos os vertices já tiverem sido visitados o algoritmo encerra
        for (int contagem = 0; contagem < qtdVertices -1; contagem++){

            int verticeW = verticeMenorCaminho(visitados, distancias);
            visitados[verticeW] = true;

            for(int vVez=0; vVez < qtdVertices; vVez++){

                if(!visitados[vVez] && 
                    matriz[verticeW][vVez] != 0 && 
                    distancias[verticeW] != Integer.MAX_VALUE &&
                    distancias[verticeW] + matriz[verticeW][vVez] < distancias[vVez]){

                        // atualização da distância do vertice que está servindo de comparação
                        distancias[vVez] = distancias[verticeW] + matriz[verticeW][vVez];
                    }
            }

        }

        System.out.print("\nMenores distância a partir do vertice " + origem);
        for(int i=0; i < qtdVertices; i++){
            System.out.println("Até o vértice " + i + " -> " + distancias[i]);
        }

    }

}

