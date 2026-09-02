public class HeapTest{

    public static void main(String[] args){

        FilaHeap prioridade = new FilaHeap();

        System.out.println("Está vazia: " + prioridade.isEmpty());
        System.out.println("Tamanho: " + prioridade.size());

        System.out.println("Inserindo elementos...");
        prioridade.insert(1,"idoso");
        prioridade.insert(2,"criança");
        prioridade.insert(4,"adolecente");
        prioridade.insert(3,"idoso");
        prioridade.insert(5,"adulto");
        prioridade.insert(6,"adulto");
        prioridade.insert(7,"adulto");

        prioridade.mostrarArvore();

        System.out.println("Dois pacientes foram atendido");
        prioridade.removeMin();
        prioridade.removeMin();

        prioridade.mostrarArvore();

        System.out.println("O Próximo da fila é : " + prioridade.min());

        System.out.println("Está vazia: " + prioridade.isEmpty());
        System.out.println("Tamanho: " + prioridade.size());
    }
}