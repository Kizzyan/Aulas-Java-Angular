class PesquisaBinaria {
  public static void main(String[] args) {
    // Array de elementos a serem analisados (lembrem-se que a contagem de posições começa em 0)
    int[] v = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
    // Chamada para o método do algoritmo. O resultado que deve ser retornado aqui é "4", pois 10 está na posição 4 da array
    System.out.println(pesquisaBinaria(v, 10));
  }

  // Algoritmo de pesquisa binária, retorno a posição de determinado elemento dentro de uma lista ordenada
  // Não precisamos definir um nivel de segurança para o método (private ou public) porque ele não está sendo invocado por outra classe
  // Ele precisa ser static para poder ser invocado diretamente, sem a criação de uma instânica (como está sendo feito no método main)
  static int pesquisaBinaria(int[] listaOrdenada, int valorCorreto) {
    // Declaramos o início e o fim da array
    int inicio = 0;
    // O fim deve ser o tamanho da array -1 porque a contagem de posições começa em 0
    int fim = listaOrdenada.length - 1;
    // Iremos iterar enquanto o início for menor ou igual ao fim
    while (inicio <= fim) {
      // Calculamos a posição do meio
      int meio = (inicio + fim) / 2;
      // Obtemos o valor do meio (também chamado de pivot)
      int valor = listaOrdenada[meio];
      // Se o valor do meio for o valor correto, retornamos o meio e finalizamos nossa função
      if (valor == valorCorreto) return meio;
      // Se o valor do meio for maior que o valor correto, ou seja, o valor correto se encontra na metade inferior, definimos o meio como novo fim 
      if (valor > valorCorreto) fim = meio - 1;
      // Se o valor do meio for menor que o valor correto, ou seja, o valor correto se encontra na metade superior, definimos o meio como novo inicio 
      else inicio = meio + 1;
    }
    // Caso nenhum valor seja encontrado, retornamos -1
    return -1;
  }
}
