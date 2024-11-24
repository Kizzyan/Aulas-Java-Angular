import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class OrdenancaoPorSelecao {
  public static void main(String[] args) {
    ArrayList<Integer> desordenada = new ArrayList<>(Arrays.asList(5, 1, 3, 9, 2, 10, 4, 7, 6, 8));
    System.out.println("Array original: " + desordenada.toString());
    double startTime = System.nanoTime();
    System.out.println("Array ordenado: " + ordenacaoPorSelecao(desordenada).toString());
    double finishTime = System.nanoTime();
    System.out.println("Tempo de execução: " + (finishTime - startTime)/1000000 + "ms");
  }

  // Primeiro precisamos definir um método para encontrar o menor elemento de uma lista
  // Dependendo da linguagem, essa função já pode estar pré-implementada
  static int encontrarMenor(ArrayList<Integer> lista) {
    // Declaramos o menor valor e o seu índice, assumindo inicialmente o primeiro elemento
    Integer menor = lista.getFirst(); // Dependendo da versão do java, pode ser necessário substituir getFirst por get(0)
   int menorIndice = 0;
    // Percorremos a lista
    for (int i = 0; i < lista.size(); i++) {
      // Checamos se o elemento atual é menor do que menor valor que definimos inicialmente
      if (lista.get(i) < menor) {
        // Se sim, atualizamos o menor valor e o seu índice
        menor = lista.get(i);
        menorIndice = i;
      }
    }
    return menorIndice;
  }

  static ArrayList<Integer> ordenacaoPorSelecao(ArrayList<Integer> lista) {
    // Declaramos uma nova lista aonde serão armazenados os elementos ordenados
    ArrayList<Integer> novaLista = new ArrayList<>();
    // Percorreremos a lista original enquanto ele não estiver vazia
    while (!lista.isEmpty()) {
      // Encontraremos o índice do menor elemento da lista
      int menor = encontrarMenor(lista);
      // Adicionaremos o menor elemento a nova lista
      novaLista.add(lista.get(menor));
      // Removeremos o menor elemento da lista original
      lista.remove(menor);
    }
    return novaLista;
  }
}
