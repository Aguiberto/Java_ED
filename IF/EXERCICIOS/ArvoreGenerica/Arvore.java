import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arvore{

   private NoArvore raiz;
   private int tamanho;

   public Arvore(){
    raiz = null;
    tamanho = 0;
   }

   // Verifica se o nó não é nulo
   private NoArvore validarNo(NoArvore node) throws ArvoreExcecao{

      if( node == null){
         throw new ArvoreExcecao("o Nó não pode ser nulo");
      }

      return node;
   }

   // Retorna a quantidade total de elementos da árvore
   private int size(){
      return tamanho;
   }


   // Retorna a altura da árvore
   private int height(){

      if(tamanho == 0){
         return 0;
      }

      // Usa a raiz da árvore para saber a altura
      return alturaDoNo(raiz);
   }

   // Método auxiliar recursivo para calcular a altura de qualquer nó
   private int alturaDoNo(NoArvore node){

      if(node.getFilhos().isEmpty()){

         //Caso base a altura é igual 0
         return 0;
      }

      int maiorAlturaFilhos = 0;

      for(NoArvore filho : node.getFilhos()){

         // recursão
         int alturaFilho = alturaDoNo(filho);

         // Se a altura do filho for maior então atualiza o maior valor total
         if(alturaFilho > maiorAlturaFilhos){
            maiorAlturaFilhos = alturaFilho;
         }
      }

      //Soma mais um a cada nó percorrido
      return 1+maiorAlturaFilhos;
   }

   public boolean isEmpty(){
      
      return tamanho == 0;
   }

   // Retorna um Iterador que possibilida que o usuário possa navegar pela árvore
   // Dessa forma o usuário pode saber todos os elementos de uma árvore ou qualquer outra estrutura.
   public Iterator elements(){

      // lista para guardar os elementos da árvores
      List<Object> listaElementos = new ArrayList<>();

      // Método auxiliar para preOrdemElementoscher a lista usando Pré-ordem
      preOrdemElementos(this.raiz, listaElementos);

      return listaElementos.iterador();
   }

   private void preOrdemElementos(NoArvore no , List<Object> lista){

      if(no == null){
         return;
      }

      lista.add(no.get());

      for(NoArvore filho: no.getFilhos()){
         preOrdemElementos(filho,lista);
      }

   }



}

