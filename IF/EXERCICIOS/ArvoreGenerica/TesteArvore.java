public class TesteArvore{

    public static void main(String[] args){

        Arvore Yggdrasil = new Arvore("Ymir");
        NoArvore raiz = Yggdrasil.root();

        System.out.println("Ymir é o primeiro gigante!");
        System.out.println("Ymir teve como filho vários outros gigantes");

        NoArvore gigantes = Yggdrasil.addChild(raiz,"Gigantes");
        Yggdrasil.mostrarArvore();

        System.out.println("Esse gigentes tiveram como um dos filhos Loki");
        NoArvore loki = Yggdrasil.addChild(gigantes,"Loki");

        System.out.println("Loki deu origem ao terrível lobo gigante Ferir, o causador do ragnarok!");
        NoArvore fenrir = Yggdrasil.addChild(loki, "Fenrir");
        Yggdrasil.mostrarArvore();

        System.out.println("Logo em seguida veios os irmãos de Fenrir!");
        System.out.println("Jormungand , Serpente colossal que aterroriza Midgard!");
        System.out.println("E Sleipenir o cavalo de 8 patas!");

        NoArvore slepenir = Yggdrasil.addChild(loki, "Slepnir");
        NoArvore jormungandr = Yggdrasil.addChild(loki, "Jormungandr");

        Yggdrasil.mostrarArvore();

        // System.out.println("Odin vendo a agilidade de destreza de Slipenir o pegou para-si");
        // System.out.println("Além disso Thor o deus do trovão");
        // Yggdrasil.removeNode(slepenir);
        // Yggdrasil.removeNode(jormungandr);

        // System.out.println("Sendo assim " + Yggdrasil.parent(fenrir).getObj() + " Foi se vingar");
        
    
    } 
}