import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

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

   // Retorna um Iterador com uma lista de elementos que possibilida que o usuário possa navegar pela árvore
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

   // retorna um Iterador com uma lista contendo todo os nós da arvore
   public Iterator nos(){

      // Cria uma lista que vai quartar os nós
      List<NoArvore> listaNos = new ArrayList<>();

      // Usa pré-ordem para ler a árvore e guardar os nós
      preOrdemNos(raiz, listaNos);

      // Retorna iteraor com uma lista de nós
      return listaNos.iterator();

   }

   // Ese método tem que ser criado porque o tipo de dado na lista é diferente do anterior
   private void preOrdemNos(NoArvore node, List<NoArvore> lista){

      if(node == null){
         return;
      }

      // Preenche a lista co cada nó percorrido 
      lista.add(node);

      for(NoArvore filho : node.getFilhos()){
         preOrdemNos(filho, lista)
      }
   }

   public NoArvore root(){
      return raiz;
   }

   // Recebe um nó e informa qual é o pai
   public NoArvore parent(NoArvore node) throws ArvoreExcecao{

      NoArvore noValidado = validarNo(node);

      return noValidado.getPai();

   }

   // Retorna um iterador com todos os filhos do no passado
   public Iterator children(NoArvore node) throws ArvoreExcecao{

      // Retorna um vetor com todos os filho do nó que foi passado
      NoArvore noValidado = validarNo(node);

      Vector<NoArvore> filhos = noValidado.getFilhos();

      return filhos.iterator();
   }

   public boolean isInternal(NoArvore node) throws ArvoreExcecao{

      NoArvore noValidado = validarNo(node);

      return  !noValidado.getFilhos().isEmpty();
      // tambem pode ser feito com children()
   }

   public boolean isExternal(NoArvore node) throws ArvoreExcecao{

      NoArvore noValidado = validarNo(node);

      return noValidado.getFilhos().isEmpty();
      // tambem pode ser feito com children()

   }

   public boolean isRoot(NoArvore node) throws ArvoreExcecao{

      NoArvore noValidado = validarNo(node);

      return noValidado == raiz;
   }
}

public int depth(NoArvore node) throws ArvoreExcecao{

   NoArvore noAtual = validarNo(node);
   int depth = 0;

   // enquanto o nó tiver pai a profundidade é incrementada e o nó é atualizado para o pai
   while(noAtual.getPai() != null){

      depth ++;
      noAtual = noAtual.getPai();
   }

   return depth;

}

