public class TesteArvore{

    public static void main(String[] args){

        ArvoreBinaria Yggdrasil = new ArvoreBinaria();

        System.out.println("Adicionando elementos...");
        Yggdrasil.insert(45);
        Yggdrasil.insert(23);
        Yggdrasil.insert(18);
        Yggdrasil.insert(35);
        Yggdrasil.insert(99);
        Yggdrasil.insert(150);

        Yggdrasil.mostrarArvore();

        System.out.println("Removendo elementos");

        Yggdrasil.remove(23);
        Yggdrasil.mostrarArvore();

        System.out.println("Segundo teste para o remove");
        Yggdrasil.remove(150);
        Yggdrasil.mostrarArvore();

        No raiz = Yggdrasil.root();

        System.out.println();
        System.out.println("A raiz tem filho DIREITO? " + Yggdrasil.hasRight(raiz));
        System.out.println("A raiz tem filho ESQUERDO? " + Yggdrasil.hasLeft(raiz));

        System.out.println();
        System.out.println("Filho ESQUERDO do raiz: " + Yggdrasil.leftChild(raiz).getValue());
        System.out.println("Filho DIREITO do raiz: " + Yggdrasil.rightChild(raiz).getValue());

        System.out.println();
        System.out.println("Tamanho da árvore: " + Yggdrasil.size());

        System.out.println();
        System.out.println("Altura da Árvore: " + Yggdrasil.height());

        System.out.println();
        System.out.println("Está Vazio? " + Yggdrasil.isEmpty());


        No filhoDireito = raiz.getFilhoD();
        No filhoEsquerdo = raiz.getFilhoE();

        System.out.println();
        System.out.println("35 é nó interno: " + Yggdrasil.isInternal(filhoEsquerdo));
        System.out.println("35 é um nó externo: " + Yggdrasil.isExternal(filhoEsquerdo));

        System.out.println();
        System.out.println("99 é um nó interno: " + Yggdrasil.isInternal(filhoDireito));
        System.out.println("99 é um nó externo: " + Yggdrasil.isExternal(filhoDireito));

        System.out.println("Qual é o pai do 99: " + Yggdrasil.parent(filhoDireito).getValue());
        System.out.println("");


        No no18 = filhoEsquerdo.getFilhoE();
        System.out.println("Qual é a profundida do Nó 18: " + Yggdrasil.depth(no18));
    }
}