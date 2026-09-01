import java.util.ArrayList;
import java.util.List;

// 1. Classe de Nó Unificada
class NoGenerico {
    int valor;
    List<NoGenerico> filhos;
    NoGenerico portal; // O portal que conectará as duas árvores

    public NoGenerico(int valor) {
        this.valor = valor;
        this.filhos = new ArrayList<>();
        this.portal = null;
    }

    public void adicionarFilho(NoGenerico filho) {
        this.filhos.add(filho);
    }
}

// 2. Classe de Navegação e Transição
class NavegadorTransicional {

    // Método de travessia (Pré-Ordem adaptado para n-filhos)
    public void navegar(NoGenerico noAtual) {
        if (noAtual == null) {
            return;
        }

        // Imprime o nó atual
        System.out.print(noAtual.valor + " ");

        // Verifica se chegamos no "portal" para a outra árvore
        if (noAtual.portal != null) {
            System.out.print(" -> [PORTAL ATIVADO] -> ");
            // Teletransporta para a raiz da segunda árvore
            navegar(noAtual.portal); 
            return; // Encerra a árvore anterior para não duplicar caminhos
        }

        // Navega recursivamente por todos os filhos do nó atual
        for (NoGenerico filho : noAtual.filhos) {
            navegar(filho);
        }
    }

    // Método para encontrar o último nó visitado na Árvore Genérica (Pré-Ordem)
    // O último elemento será sempre o descendente mais à direita da árvore.
    public NoGenerico obterUltimoNoPreOrdem(NoGenerico no) {
        if (no == null) {
            return null;
        }
        
        // Se o nó não tiver filhos, ele mesmo é o último da sua ramificação
        if (no.filhos.isEmpty()) {
            return no;
        }

        // Pega o último filho da lista (o mais à direita) e continua descendo por ele
        NoGenerico ultimoFilho = no.filhos.get(no.filhos.size() - 1);
        return obterUltimoNoPreOrdem(ultimoFilho);
    }
}