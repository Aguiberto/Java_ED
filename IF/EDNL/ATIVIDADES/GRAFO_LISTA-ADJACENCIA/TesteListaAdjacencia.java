import java.util.List;

public class TesteListaAdjacencia{
    public static void main(String[] args) {
        
        GrafoListaAdjacencia<String> listaAdjacencia = new GrafoListaAdjacencia<>();

        System.out.println(" ====================== INICIANDO BATERIA DE TESTES : LISTA DE ADJACÊNCIA =========================");

      //TESTE DO MÉTODO: inserirVertice
        System.out.println("TESTE DO MÉTODO: inserirVertice");

        Vertice<String> v1 = new Vertice<>("1","v1");
        Vertice<String> v2 = new Vertice<>("2","v2");
        Vertice<String> v3 = new Vertice<>("3","v3");
        Vertice<String> v4 = new Vertice<>("4","v4");

        listaAdjacencia.inserirVertice(v1);
        listaAdjacencia.inserirVertice(v2);
        listaAdjacencia.inserirVertice(v3);
        listaAdjacencia.inserirVertice(v4);

        listaAdjacencia.mostrarGrafo();

        System.out.println();

        //TESTE DO MÉTODO: inserirAresta
        System.out.println("TESTE DO MÉTODO: inserirNaAresta");

        Aresta<String> a1 = new Aresta<>("1", v1, v2,"a1", true);
        Aresta<String> a2 = new Aresta<>("2", v2, v3,"a2", true);
        Aresta<String> a3 = new Aresta<>("3", v3, v1,"a3", false);
        Aresta<String> a4 = new Aresta<>("4", v4, v4,"a4", true);

        listaAdjacencia.inserirAresta(a1);
        listaAdjacencia.inserirAresta(a2);
        listaAdjacencia.inserirAresta(a3);
        listaAdjacencia.inserirAresta(a4);

        listaAdjacencia.mostrarGrafo();

        System.out.println();

        //TESTE DO MÉTODO: finalVertices
        System.out.println("TESTE DO MÉTODO: finalVertices");

        List<Vertice<String>> verticesFinais = listaAdjacencia.finalVertice(a3);

       if(verticesFinais != null && !verticesFinais.isEmpty()){

           if(verticesFinais.size() >= 2){
                int contador = 0;
                for(Vertice<String> vertice : verticesFinais){
                    System.out.print(vertice.getId());
                    contador += 1;
                    if(contador > 1){
                        break;
                    }else{
                        System.out.print(" e ");
                    }
                }
           }

       } else {
            System.out.println("Aresta não encontrada ou sem vertices");
       }

        System.out.println();

        //TESTE DO MÉTODO: ehAdjacente
        System.out.println("TESTE DO MÉTODO: ehAdjacente");

        boolean temAdjacencia1 = listaAdjacencia.ehAdjacente(v1, v2);
        boolean temAdjacencia2 = listaAdjacencia.ehAdjacente(v1, v4);

        System.out.println("V1 e V2 são adjacentes: " + temAdjacencia1);
        System.out.println("V1 e V4 são adjacentes: " + temAdjacencia2);
        System.out.println();

        //TESTE DO MÉTODO: oposto
        System.out.println("TESTE DO MÉTODO: oposto\n");

        Vertice<String> opositor = listaAdjacencia.oposto(v1, a1);
        System.out.println("O oposto de V1 na aresta A1 é o vertice: " + opositor.getId());

        System.out.println();

        //TESTE DO MÉTODO: substituirNoVertice
        System.out.println("TESTE DO MÉTODO: substituirNoVertice");

        listaAdjacencia.substituirNoVertice(v3, "vTeste");

        String v3Dado = v3.getDado();
        System.out.print("Novo dado: " + v3Dado + "\n");
        System.out.println();

        //TESTE DO MÉTODO: substituirNaAresta
        System.out.println("TESTE DO MÉTODO: substituirNaAresta");

        listaAdjacencia.substituirNaAresta(a3, "a3Teste");
        String a3Teste = a3.getDado();
        System.out.println("Novo dado: " + a3Teste);
        System.out.println();

        //TESTE DO MÉTODO: removerVertice
        System.out.println("TESTE DO MÉTODO: removerVertice \n");

        System.out.println("Removendo V1 ...\n");
        listaAdjacencia.removerVertice(v1);
        listaAdjacencia.mostrarGrafo();
        System.out.println();

        //TESTE DO MÉTODO: removerAresta
        System.out.println("TESTE DO MÉTODO: removerAresta \n");

        System.out.print("Removendo a aresta A4...\n");
        listaAdjacencia.removerAresta(a4);
        listaAdjacencia.mostrarGrafo();
        System.out.println();

        System.out.println(" =================================== TESTES FINALIZADOS ===========================================");
        System.out.println(" Tenha um BOM DIA e VOLTE SEMPRE!");

    }
}