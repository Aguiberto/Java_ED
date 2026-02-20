/**Valor máximo 100
 * Valor minimo 0
 * Valores entre 40 e 60 não são permitidos, tem que ser convertidos para 40 ou 60
 */


public class Numero{

    private float valor;

    public Numero(){
        this.valor = 0;
    }

    public float getValor(){
        return valor;
    }

    public void setValor(float valor){

        if(valor < 0){
            valor = 0;
            System.out.println("Valor corrigido para 0");
        }

        if(valor > 100){
            valor = 100;
            System.out.println("Valor corrigido para 100");
        }

        if(valor > 40 && valor <60){
            if( valor < 50){
                valor = 40;
                System.out.println("Valor corrigido para 40");
            } else {
                valor = 60;
                System.out.println("Valor corrigido para 60");
            }
        }

        this.valor = valor;
        System.out.println("Novo valor atribuido");

    }
}