package IF.EDNL.ATIVIDADES.GRAFO_MATRIZ;
public class TesteGrafo{
    public static void main(String[] args) {
        
        System.out.println(" ============ TESTE DE MULTIGRAFO MISTO ===========");

        Grafo matriz = new Grafo(2);

        System.out.println("\n----- 1. Inserindo Vertices -----");

        Vertice vA = matriz.inserirVertice("A");
        Vertice vB = matriz.inserirVertice("B");
        System.out.println("-> Vértices 'A' e 'B' inseridos.");

        System.out.println("\nMatriz após inserir A e B");
        matriz.imprimirMatriz();

        Vertice vC = matriz.inserirVertice("C");
        System.out.println("-> Vértice 'C' inserido");

        System.out.println("\nMatriz após nova inserção");
        matriz.imprimirMatriz();

        System.out.println("\n----- 2. Inserindo Arestas -----");

        System.out.println("-> Inserindo arestas direcionadas");
        Aresta e1 = matriz.inserirAresta(1,"e1",vA,vB,true);

        System.out.println("-> Inserindo arestas direcionadas");
        Aresta e2 = matriz.inserirAresta(2,"e2",vA,vB,true);

        System.out.println("-> Inserindo arestas não direcionadas");
        Aresta e3 = matriz.inserirAresta(3,"e3",vA,vB,false);

        System.out.println("-> Inserindo laços");
        matriz.inserirAresta(4,"e4",vC,vC,false);

        System.out.println("\nMatriz após inserção de arestas");
        matriz.imprimirMatriz();


        // TESTE MÉTODO finalVertices()
        System.out.println("TESTE DE MÉTODO: finalVertices()");
        Vertice verticeFinal = matriz.finalVertice(e1);
        System.out.println(" Vertice final da aresta e1 (A<->B): " + verticeFinal);
        System.out.println();

        // TESTE MÉTODO eAdjacente()
        System.out.println("TESTE DE MÉTODO: eAdjacente()");
        System.out.println(" A e B são adjacentes? " + matriz.eAdjacente(vA, vB) );
        System.out.println(" A e C são adjacentes? " + matriz.eAdjacente(vA, vC) );
        System.out.println();


        // TESTE MÉTODO oposto()
        System.out.println("TESTE DE MÉTODO: oposto()");
        Vertice opostoB = matriz.verticeOposto(vB, e3);
        System.out.println(" O Oposto de B na aresta e3 (B <-> A): " + (opostoB != null ? opostoB.getNome(): "null"));
        System.out.println();


        // TESTE DO MÉTODO substituirNoVertice()
        System.out.println("TESTE DE MÉTODO: finalVertices()");
        matriz.substituirNoVertice(vB,"verticeB");
        System.out.println("Novo nome do vertice B: " + vB.getNome());
        System.out.println();



        // TESTE DO MÉTODO substituirNaAresta()
        System.out.println("TESTE DE MÉTODO: finalVertices()");
        matriz.substituirNaAresta(e3, "aresta3");
        System.out.println("Novo nome da aresta e3: " + e3.getNome());
        System.out.println();

        matriz.imprimirMatriz();
        System.out.println();

    }
}