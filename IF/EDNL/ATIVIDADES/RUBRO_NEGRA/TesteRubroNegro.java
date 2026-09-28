public class TesteRubroNegro {
    public static void main(String[] args) {
        
        ArvoreRN<Integer> arvoreUrubu = new ArvoreRN<>();


        // toda vez que há uma rotação da arvore é executado o mostrar()
        arvoreUrubu.inserir(55);
        arvoreUrubu.inserir(35);
        arvoreUrubu.inserir(75);
        arvoreUrubu.mostrar();

        arvoreUrubu.inserir(25);
        arvoreUrubu.inserir(45);
        arvoreUrubu.inserir(65);
        arvoreUrubu.inserir(55);
        arvoreUrubu.inserir(85);
        arvoreUrubu.mostrar();

        arvoreUrubu.inserir(15);
        arvoreUrubu.inserir(30);
        arvoreUrubu.mostrar();

        arvoreUrubu.remover(55);
        arvoreUrubu.mostrar();

        arvoreUrubu.inserir(50);
        arvoreUrubu.mostrar();

    }
}
