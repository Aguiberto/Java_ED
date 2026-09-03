public class MainABB{
    public static void main(String[] args){

        ArvoreBB arvore = new ArvoreBB();

            arvore.insert(4);
            arvore.insert(2);
            arvore.insert(6);
            arvore.insert(1);
            arvore.insert(3);
            arvore.insert(5);
            arvore.insert(7);

            arvore.mostrar();

            arvore.remover(3);
            arvore.remover(5);
            arvore.mostrar();

    }
}