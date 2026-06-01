public class TesteFilaPrioridade {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("      INICIANDO TESTES DA HEAP ARRAY     ");
        System.out.println("=========================================\n");

        // 1. Inicialização (Capacidade inicial pequena = 3 para testar expansão)
        HeapArray heap = new HeapArray(3);
        
        System.out.println("--- Teste 1: Estado Inicial ---");
        System.out.println("Está vazia? " + heap.isEmpty()); 
        System.out.println("Tamanho atual: " + heap.size()); 
        System.out.println(heap + "\n");

        // 2. Teste de Inserção e Ordenação (UpHeap)
        System.out.println("--- Teste 2: Inserções (UpHeap) ---");
        // CORREÇÃO AQUI: Nome da variável corrigido sem o espaço em branco
        int[] elementosParaInserir = {45, 20, 15, 30, 5, 10};
        
        for (int elemento : elementosParaInserir) {
            System.out.println("Inserindo: " + elemento);
            heap.insert(elemento);
            System.out.println(" -> Menor no topo atual: " + heap.min());
            System.out.println(" -> " + heap);
        }
        System.out.println("\nEstá vazia após inserções? " + heap.isEmpty()); 
        System.out.println("Tamanho final após inserções: " + heap.size()); 
        System.out.println("\n");

        // 3. Teste de Remoção em Ordem de Prioridade (DownHeap)
        System.out.println("--- Teste 3: Remoções em Ordem (DownHeap) ---");
        System.out.println("Os elementos devem sair estritamente do MENOR para o MAIOR:\n");
        
        int contagem = 1;
        while (!heap.isEmpty()) {
            System.out.print("Remoção #" + contagem + ": ");
            Comparable removido = heap.remove();
            System.out.println("Saiu [" + removido + "]");
            System.out.println(" -> Próximo no topo: " + heap.min());
            System.out.println(" -> " + heap + "\n");
            contagem++;
        }

        // 4. Verificação Final de Segurança
        System.out.println("--- Teste 4: Estado Pós-Remoções ---");
        System.out.println("Está vazia agora? " + heap.isEmpty()); 
        System.out.println("Tamanho final: " + heap.size()); 
        System.out.println("Tentar espiar o menor (min): " + heap.min()); 
        System.out.println("Tentar remover de heap vazia: " + heap.remove()); 
        
        System.out.println("\n=========================================");
        System.out.println("         TODOS OS TESTES CONCLUÍDOS      ");
        System.out.println("=========================================");
    }
}