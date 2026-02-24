public class Utils{

    private static final String cab = "\n\nOperação NÃO executada." ;
    private static final String rab = "\n\n" ;

    public static void printRet(int codigo){
        
        if(codigo == -1){
            System.out.println(cab + "Elemento inexistente." + rab);

        }else if(codigo == 0){
            System.out.println("Operação bem sucedida" + rab);
            
        }else if(codigo == 1){
            System.out.println(cab + "Valor fora da faixa prevista" + rab);

        }else if(codigo == 2){
            System.out.println(cab + "Posição fora das fronteiras do vetor" + cab);

        }else if(codigo == 3){
            System.out.println(cab + " A posicao ja contem o previsto pela operação" + "('ocupada' em caso de inclusão ou 'vaga' em caso de remoção)" + rab);

        }else if(codigo == 4){
            System.out.println(cab + "valor já existente (repetição não permitida)." + rab);
        }
    }

}