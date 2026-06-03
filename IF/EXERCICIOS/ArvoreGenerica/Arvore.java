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

   private int colunaGlobal = 0; // Controla a posição horizontal da esquerda para a direita

   public void mostrarArvore() {
      if (isEmpty()) {
         System.out.println("[Árvore Vazia]");
         return;
      }

      // 1. Instancia uma lista para calcular dinamicamente a largura máxima necessária
      List<NoArvore> todosNos = new ArrayList<>();
      
      preOrdemNos(raiz, todosNos);

      int qtdLinhas = (height() + 1) * 2;
      
      // Estima uma largura segura baseada no tamanho dos textos
      int larguraEstimada = 0;
      for (NoArvore no : todosNos) {
         larguraEstimada += ("[" + no.getObj().toString() + "]").length() + 2;
      }

      char[][] matriz = new char[qtdLinhas][larguraEstimada * 2]; // Margem de segurança dobrada
      for (char[] linha : matriz) {
         Arrays.fill(linha, ' ');
      }

      // 2. Reseta o contador e calcula as posições recursivamente
      this.colunaGlobal = 0;
      calcularCoordenadas(raiz, matriz);

      // 3. Imprime a matriz na tela
      for (char[] linha : matriz) {
         String l = new String(linha).stripTrailing();
         if (!l.isEmpty()) {
            System.out.println(l);
         }
      }
   }

   // Método recursivo que calcula o X (coluna) e Y (linha) de forma centralizada
   private int calcularCoordenadas(NoArvore node, char[][] matriz) {
      if (node == null) return 0;

      String textoNo = "[" + node.getObj().toString() + "]";
      int linhaY = 0;
      try {
         linhaY = depth(node) * 2;
      } catch (ArvoreExcecao e) {
         return 0;
      }

      List<NoArvore> filhos = node.getFilhos();
      int colunaX;

      if (filhos.isEmpty()) {
         // CASO BASE: Se for folha, pega a coluna atual disponível
         colunaX = this.colunaGlobal;
         this.colunaGlobal += textoNo.length() + 2; // Avança para o próximo vizinho
      } else {
         // RECURSÃO: Primeiro calcula a posição de todos os filhos
         int primeiraColunaFilho = calcularCoordenadas(filhos.get(0), matriz);
         
         for (int i = 1; i < filhos.size(); i++) {
            calcularCoordenadas(filhos.get(i), matriz);
         }
         
         int ultimaColunaFilho = filhos.get(filhos.size() - 1).getFilhos().isEmpty() 
            ? this.colunaGlobal - ("[" + filhos.get(filhos.size() - 1).getObj().toString() + "]").length() - 2
            : this.colunaGlobal - 10; // Ajuste técnico aproximado para subárvores

         // CENTRALIZAÇÃO: O pai fica no meio geométrico entre o primeiro e o último filho
         colunaX = (primeiraColunaFilho + ultimaColunaFilho) / 2;
         
         // Se a centralização jogar o pai para trás de onde deveria, realinha com a folha
         if (colunaX < primeiraColunaFilho) {
             colunaX = primeiraColunaFilho;
         }
      }

      // Desenha o texto do nó na matriz na posição calculada
      for (int i = 0; i < textoNo.length(); i++) {
         if (colunaX + i < matriz[0].length) {
            matriz[linhaY][colunaX + i] = textoNo.charAt(i);
         }
      }

      return colunaX; // Retorna a coluna onde este nó foi desenhado
   }
}

