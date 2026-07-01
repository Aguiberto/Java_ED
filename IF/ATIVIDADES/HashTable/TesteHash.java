import java.util.List;

public class TesteHash{

    public static void main(String[] args){


        TabelaHash<Integer,String> tabuaDePedra = new TabelaHash(7);

        tabuaDePedra.insertItem(1,"Aguiberto");
        tabuaDePedra.insertItem(2,"Stanilau");
        tabuaDePedra.insertItem(8,"Aguilar");
        tabuaDePedra.insertItem(15,"Aguinaldo");
        tabuaDePedra.insertItem(12,"Laurinda");
        tabuaDePedra.insertItem(14,"Exodia");
        
        System.out.println(tabuaDePedra.toString());
        System.out.println(tabuaDePedra.keys());
        System.out.println(tabuaDePedra.elements());
        
    }
}