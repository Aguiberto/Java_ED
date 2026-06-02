import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;

/**Detalhes da arvore
 * Já nasce com raiz
 * Não é possível remover raiz
 * Remoção de um nó interno remove toda a subarvore
 */

public class Arvore{

   private NoArvore raiz;
   private int tamanho;

   public Arvore(Object objRaiz){

      raiz = new NoArvore(objRaiz);
      tamanho = 1;

   }

   // Verifica se o nó não é nulo
   private NoArvore validarNo(NoArvore node) throws ArvoreExcecao{

      if( node == null){
         throw new ArvoreExcecao("o Nó não pode ser nulo");
      }

      return node;
   }

   // QUESTÃO 3
   // Retorna a quantidade total de elementos da árvore
   public int size(){
      return tamanho;
   }

   // QUESTÃO 2C
   // Retorna a altura da árvore
   public int height(){

      if(tamanho == 0){
         return 0;
      }

      // Usa a raiz da árvore para saber a altura
      return alturaDoNo(raiz);
   }

   // Método auxiliar recursivo para calcular a altura de qualquer nó
   // A altura é medida da distância da referência até o nó folha mais afastado.
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

      return listaElementos.iterator();
   }

   private void preOrdemElementos(NoArvore no , List<Object> lista){

      if(no == null){
         return;
      }

      lista.add(no.getObj());

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
         preOrdemNos(filho, lista);
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

      List<NoArvore> filhos = noValidado.getFilhos();

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

   // QUESTÃO 2B
   public int depth(NoArvore node) throws ArvoreExcecao{

      NoArvore noAtual = validarNo(node);
      int profundidade = 0;

      // enquanto o nó tiver pai a profundidade é incrementada e o nó é atualizado para o pai
      while(noAtual.getPai() != null){

         profundidade ++;
         noAtual = noAtual.getPai();
      }

      return profundidade;

   }

   // QUESTÃO 2A
   // troca o elemento do no informado pelo valor informado e retorna o antigo valor
   public Object replace(NoArvore node, Object obj) throws ArvoreExcecao{

      NoArvore noValidado = validarNo(node);

      Object exchaged = noValidado.getObj();

      noValidado.setObj(obj);

      return exchaged;

   }

   // Adiciona e retorna um novo nó
   public NoArvore addChild(NoArvore pai, Object obj)throws ArvoreExcecao{

      NoArvore noPai = validarNo(pai);

      NoArvore newChild = new NoArvore(obj);
      noPai.adicionarFilho(newChild);

      this.tamanho++;

      return newChild;
   }


   // Para remover o nó de uma árvore basta remover sua ligação com o pai
   public Object removeNode(NoArvore node) throws ArvoreExcecao{

      NoArvore noAlvo = validarNo(node);

      if(noAlvo == this.raiz){
         throw new ArvoreExcecao("Não é permitido remover a raiz da árvore");
      }

      int qtdDeletados = calcularSubArvore(noAlvo);

      NoArvore alvoPai = noAlvo.getPai();

      // Tira a referência do filho para o pai
      // tir a referência do pai para o filho
      alvoPai.getFilhos().remove(noAlvo);
      noAlvo.setPai(null);

      tamanho = tamanho - qtdDeletados;

      return noAlvo.getObj();
   }

   // ============= MÉTODOS ADICIONAIS ============

   // QUESTÃO 2A
   public void swapElements(NoArvore node1, NoArvore node2) throws ArvoreExcecao{

      NoArvore noValidado1 = validarNo(node1);
      NoArvore noValidado2 = validarNo(node2);

     Object ObjAuxiliar = noValidado1.getObj();

      noValidado1.setObj(noValidado2.getObj());
      noValidado2.setObj(ObjAuxiliar);

   }

   public int calcularSubArvore(NoArvore no){
      int total = 1;

      for(NoArvore filho: no.getFilhos()){
         total += calcularSubArvore(filho);
      }

      return total;
   }

   // usa travessia pré-ordem dessa própria classe
   public void mostrarArvore() throws ArvoreExcecao{

     if(isEmpty()){
         System.out.println("[Árvore Vazia]");
         return;
      }

      List<NoArvore> listaInOrdem = new ArrayList<>();
      inOrdemNos(raiz, listaInOrdem);

      // 1. Define a quantidade de linhas baseada na altura
      int qtdLinhas = (height() + 1) * 2;

      // 2. CORREÇÃO: Descobre o tamanho exato de colunas somando o texto de todos os nós
      int qtdColunas = 0;
      for (NoArvore no : listaInOrdem) {
         String textoNo = "[" + no.getObj().toString() + "]";
         qtdColunas += textoNo.length() + 2; // Tamanho do texto + 2 espaços de separação
      }

      // 3. Cria a matriz com o tamanho perfeito
      char[][] arvore = new char[qtdLinhas][qtdColunas];
      for(char[] linha : arvore){
         Arrays.fill(linha, ' ');
      }

      // 4. Preenche a matriz com os nós nas posições corretas
      int colunaAtual = 0;
      for(NoArvore no : listaInOrdem){
         String textoNo = "[" + no.getObj().toString() + "]";

         int linhaY = 0;
         try {
            // CORREÇÃO: Tratando a exceção que o método depth exige
            linhaY = depth(no) * 2; 
         } catch (ArvoreExcecao e) {
            System.out.println("Erro ao calcular profundidade do nó " + textoNo + ": " + e.getMessage());
            return;
         }

         // Desenha o nó caractere por caractere na linha e coluna certas
         for(int i = 0; i < textoNo.length(); i++){
            arvore[linhaY][colunaAtual + i] = textoNo.charAt(i);
         }

         // Avança a coluna para o próximo nó da lista
         colunaAtual += textoNo.length() + 2;
      }

      // 5. Imprime a matriz no console eliminando espaços em branco inúteis no fim
      for(char[] linha : arvore){
         String l = new String(linha).stripTrailing();
         if(!l.isEmpty()){
            System.out.println(l);
         }
      }
   
   }

   // Estratégia "in-ordem" adaptada
   // Organiza dentro da lista passada todos os elementos da arvore
   private void inOrdemNos(NoArvore node, List<NoArvore> lista){

      if(node == null){
         return;
      }

      List<NoArvore> filhos = node.getFilhos();
      int metade = filhos.size() / 2;

      // Visito a primeira metade dos filhos
      for(int i = 0; i < metade; i++){

         //RECURSSÃO
         inOrdemNos(filhos.get(i),lista);
      }

      // Quando chega no caso base adiciona o nó atual a lista
      // Ao terminar a primeira metade o atual será o nó passado como parêmtro que vai ser o no pai
      lista.add(node);

      // Visita a segunda metade dos filhos
      for(int i = metade; i < filhos.size(); i++){
         inOrdemNos(filhos.get(i), lista);
      }
   }

}

