import java.util.List;

public class TesteHash{

    public static void main(String[] args){


        TabelaHash<Integer,String> tabuaDePedra = new TabelaHash(7);

        tabuaDePedra.insertItem(1,"Aguiberto");
        tabuaDePedra.insertItem(2,"Aguisvaldo");
        tabuaDePedra.insertItem(8,"Aguilar");
        tabuaDePedra.insertItem(15,"Aguibenia");
        tabuaDePedra.insertItem(12,"Aguido");
        tabuaDePedra.insertItem(14,"Aguibar");
        
        System.out.println(tabuaDePedra.toString());
        System.out.println(tabuaDePedra.keys());
        System.out.println(tabuaDePedra.elements());

        System.out.println("O elemento do com a chave 8 é: " + tabuaDePedra.findElement(8));
        System.out.println("Aguinaldo e Aguibar estão indo embora...");
        tabuaDePedra.removeElement(15);
        tabuaDePedra.removeElement(12);
        System.out.println(tabuaDePedra.toString());

        System.out.println("Aguinaldo descidiu voltar para o seu canto ...");
        tabuaDePedra.insertItem(15,"Aguinaldo");
        System.out.println(tabuaDePedra.toString());
    }
}