public class Principal {
    public static void main(String[] args) {
        NavegadorTransicional navegador = new NavegadorTransicional();

        // --- CONSTRUINDO A ÁRVORE GENÉRICA ---
        NoGenerico raizGenerica = new NoGenerico(10);
        NoGenerico no20 = new NoGenerico(20);
        NoGenerico no30 = new NoGenerico(30);
        NoGenerico no40 = new NoGenerico(40);

        raizGenerica.adicionarFilho(no20);
        raizGenerica.adicionarFilho(no30);
        no30.adicionarFilho(no40); // 40 é filho de 30 (nó mais profundo à direita)

        // --- CONSTRUINDO O HEAP ---
        // (Representado em nós para que o navegador consiga ler continuamente)
        NoGenerico raizHeap = new NoGenerico(100);
        NoGenerico no90 = new NoGenerico(90);
        NoGenerico no80 = new NoGenerico(80);

        raizHeap.adicionarFilho(no90);
        raizHeap.adicionarFilho(no80);

        // --- CONFIGURANDO O PORTAL AUTOMATICAMENTE ---
        // 1. Encontra quem será o último elemento impresso da Árvore 1
        NoGenerico ultimoNo = navegador.obterUltimoNoPreOrdem(raizGenerica);

        // 2. Aponta o portal dele para a raiz da Árvore 2 (Heap)
        if (ultimoNo != null) {
            ultimoNo.portal = raizHeap;
            System.out.println("Configuração: Portal criado no nó [" + ultimoNo.valor + "] apontando para [" + raizHeap.valor + "].\n");
        }

        // --- EXECUTA A TRAVESSIA UNIFICADA ---
        System.out.print("Travessia Completa: ");
        navegador.navegar(raizGenerica);
        System.out.println();
    }
}