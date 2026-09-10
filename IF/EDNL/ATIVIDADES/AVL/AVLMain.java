public class AVLMain{

    public static void main(String [] args){

        ArvoreAVL arvoreDeNatal = new ArvoreAVL();
        arvoreDeNatal.insert(10);
        arvoreDeNatal.insert(5);
        arvoreDeNatal.insert(2);
        arvoreDeNatal.insert(8);
        arvoreDeNatal.insert(15);
        arvoreDeNatal.insert(22);
        arvoreDeNatal.mostrar();

        System.out.println();
        System.out.println();
        arvoreDeNatal.remover(5);
        arvoreDeNatal.mostrar();

    }
}