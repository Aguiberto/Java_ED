import java.util.Iterator;

public class TesteArvore{

    public static void main(String[] args){

        Arvore Yggdrasil = new Arvore("Ymir");
        NoArvore raiz = Yggdrasil.root();

        System.out.println("Ymir é o primeiro gigante!");
        System.out.println("Ymir teve como filho vários outros gigantes");

        NoArvore gigantes = Yggdrasil.addChild(raiz,"Gigantes");
        Yggdrasil.mostrarArvore();

        System.out.println("Esse gigentes tiveram como um dos filhos Loki e Odin");
        NoArvore loki = Yggdrasil.addChild(gigantes,"Loki");
        NoArvore odin = Yggdrasil.addChild(gigantes, "Odin");
        Yggdrasil.mostrarArvore();

        System.out.println("Loki deu origem ao terrível lobo gigante Ferir, o causador do ragnarok!");
        NoArvore fenrir = Yggdrasil.addChild(loki, "Fenrir");
        Yggdrasil.mostrarArvore();

        System.out.println("Logo em seguida veios os irmãos de Fenrir!");
        System.out.println("Jormungand , Serpente colossal que aterroriza Midgard!");
        System.out.println("E Sleipenir o cavalo de 8 patas!");

        NoArvore sleipnir = Yggdrasil.addChild(loki, "Slepnir");
        NoArvore jormungandr = Yggdrasil.addChild(loki, "Jormungandr");
        Yggdrasil.mostrarArvore();

        System.out.println("Odin, teve como filho Thor o deus do Trovão!");
        NoArvore thor = Yggdrasil.addChild(odin, "Thor");
        Yggdrasil.mostrarArvore();

        System.out.println("Nesse momento a Yggdrasil já tinha crescido bastante com um total de : " + Yggdrasil.size() + " criaturas");
        System.out.println("Com todo seu esplendor essa bela árvore atravessava " + Yggdrasil.height() + " mundo com sua altura");


        System.out.println("Thor filho de " + Yggdrasil.parent(thor).getObj() + "derrotou Jormungandr em uma terrível batalha");
        Yggdrasil.removeNode(jormungandr);
        Yggdrasil.mostrarArvore();

        
        System.out.println("Odin sendo o deus que tudo pode ver olhou para cima na árvore Yggdrasil e percebeu que Ymir 'A criatura suprema' estava " + Yggdrasil.depth(odin) + " mundos acima dele e por isso roubou Sleipenir de Loki para chegar conseguir chegar ao topo da Yggdrasil");
        System.out.println("Vendo esse cenário Loki covenceu seu irmão adotivo a ir para o seu lado, tratando-o como um filho");
        Yggdrasil.swapElements(sleipnir,thor);

        Yggdrasil.mostrarArvore();

        System.out.println("Assim Loki ficou com os seguintes filhos: ");
        
        Iterator filhosLoki = Yggdrasil.children(loki);
        while( filhosLoki.hasNext()){

           NoArvore filhoAtual = (NoArvore) filhosLoki.next();
           System.out.println(filhoAtual.getObj());
        }

        System.out.println("Aproveitando-se que Odin estava ocupado em sua busca por Ymir loki de maneira astura transformou Thor em um troll");
        
        // o nó que thor está é o slipeiner portanto para substuitir o valor thor devo fazer a mudança no no sleipenir
        Yggdrasil.replace(sleipnir, "Troll");
        Yggdrasil.mostrarArvore();

    } 
}