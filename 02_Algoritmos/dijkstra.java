import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Semelhante ao algoritmo de busca em largura, o algoritmo de dijkstra geralmente necessita de um contexto de aplicação
// Imagine que você está em um ponto inicial que iremos chamar de "começo" e quer chegar a um ponto final que iremos chamar de "fim"
// Você possui 2 pontos A e B que você pode passar para alcançar o ponto final e quer saber qual o caminho mais rápido para chegar a ele
// No entanto, diferentemente da busca em largura, em que todas as arestas tem o mesmo "peso", aqui você leva tempos diferentes para ir de um ponto a outro
// Sendo assim, existe a possibilidade que o caminho mais rápido não necessariamente seja o caminho de menos arestas

class Dijkstra {

  // Iniciamos criando um grafo para armazenar nossas combinações de vértices e suas respectivas ligações
  static HashMap<String, HashMap<String, Integer>> grafo = new HashMap<>();
  // Então, criamos uma tabela separada para armazenar os custos de cada ligação
  static HashMap<String, Integer> custos = new HashMap<>();
  // E uma tabela para armazenar os pais de cada ligação
  static HashMap<String, String> pais = new HashMap<>();
  // E uma tabela para armazenar os nodulos processados (declaramos essa tabela em escopo global por ela será usada por múltiplos métodos)
  static List<String> processados = new ArrayList<>();

  public static void main(String[] args) {
    // Iniciamos criando alguns nodulos e suas respectivas ligações
    grafo.put("começo", new HashMap<>(){{ put("a", 6); put("b", 2); }});
    grafo.put("a", new HashMap<>(){{ put("fim", 1); }});
    grafo.put("b", new HashMap<>(){{ put("a", 3); put("fim", 5); }});
    grafo.put("fim", new HashMap<>());

    // Populamos nossa tabela de custos
    custos.put("a", 6);
    custos.put("b", 2);
    custos.put("fim", (int) Double.POSITIVE_INFINITY);

    // Populamos nossa tabela de pais
    pais.put("a", "começo");
    pais.put("b", "começo");
    pais.put("fim", null);

    // Executamos o algoritmo
    dijkstra();
  }

  // Primeiramente, precisamos criar um método para encontrar o nodulo com o menor custo
  static String acharMenorCusto (HashMap<String, Integer> custos) {
    // Declaramos o menor custo e o seu nodulo
    // Inicializamos o menor custo como infinito para garantir que ele seja sempre atualizado
    // Como HashMaps não tem ordem definida, não podemos simplesmente definir o menor custo como o primeiro valor da tabela que nem fizemos no algoritmo de busca binária
    int menorCusto = (int) Double.POSITIVE_INFINITY;
    String noduloMenorCusto = null;
    // Iteramos sobre as chaves da nossa tabela de custos
    for (String nodulo : custos.keySet()) {
      // Definimos o custo como o custo do nódulo atual
      int custo = custos.get(nodulo);
      // Checamos se o custo atual é menor do que o menor custo atual, e se esse nódulo ainda não foi processado
      if (custo < menorCusto && !processados.contains(nodulo)) {
        // Se sim, atualizamos o menor custo e o seu nódulo
        menorCusto = custo;
        noduloMenorCusto = nodulo;
      }
    }
    // Por fim, retornamos o nódulo com o menor custo
    return noduloMenorCusto;
  }

  static void dijkstra() {
    // Começamos executando o método acima para encontrar o nódulo com menor custo
    String nodulo = acharMenorCusto(custos);
    // Repetimos o processo enquanto houver nodulos para processar
    while (nodulo != null) {
      // Definimos o custo para o nódulo atual
      int custo = custos.get(nodulo);
      // Buscamos os vizinhos do nódulo atual
      HashMap<String, Integer> vizinhos = grafo.get(nodulo);
      // Iteramos sobre as chaves dos vizinhos
      for (String vizinho : vizinhos.keySet()) {
        // Definimos um novo custo, sendo a soma do custo atual e o custo do vizinho
        int novoCusto = custo + vizinhos.get(vizinho);
        // Checamos se o novo custo é menor do que o custo do vizinho
        if (custos.get(vizinho) > novoCusto) {
          // Caso sim, atualizamos o custo e o pai do vizinho
          custos.put(vizinho, novoCusto);
          pais.put(vizinho, nodulo);
        }
      }
      processados.add(nodulo);
      nodulo = acharMenorCusto(custos);
    }
    System.out.println("pais: " + pais);
    System.out.println("custos: " + custos);
  }
}
