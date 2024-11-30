import java.util.*;

@SuppressWarnings("unused")
class EstruturasDeDados {
  public static void main(String[] args) {

    //========== Arrays ==========
    int[] array1 = { 1, 2, 3, 4, 5 }; // Array de primitivos
    ArrayList<Integer> array2 = new ArrayList<Integer>(); // Array de objetos
    List<Integer> array3 = new ArrayList<>(); // Outra forma válida de criar um array de objetos
    // Dica: Quando criamos variáveis com genêricos, podemos omitir o tipo do genêrico na instanciação, pois ele é inferido
    //====================
    
    //========== Listas Encadeadas ==========
    LinkedList<Integer> lista1 = new LinkedList<Integer>(); // Listas podem ser instanciadas diretamente
    List<Integer> lista2 = new LinkedList<>(); // Ou instanciadas a partir da interface List, evitando acoplamento
    //====================

    //========== Filas ==========
    Queue<Integer> fila1 = new LinkedList<>(); // Filas em Java são interfaces, então devem ser instanciadas a partir de uma implementação concreta
    //====================

    //========== Pilhas ==========
    Stack<Integer> pilha1 = new Stack<>(); // Pilhas em Java são classes, então podem ser instanciadas diretamente
    //====================

    //========== Sets ==========
    Set<Integer> set1 = new HashSet<>(); // Sets em Java são interfaces, então devem ser instanciadas a partir de uma implementação concreta
    //====================

    //========== Matrizes ==========
    int[][] matriz1 = { { 1, 2, 3 }, { 4, 5, 6 } }; // Matriz bidimensional
    int[][] matriz2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; // Matriz tridimensional
    Integer[][] matriz3 = new Integer[5][5]; // Matriz bidimensional vazia com um máximo de 5 linhas e 5 colunas
    String[][][] matriz4 = new String[5][5][5]; // Matriz tridimensional vazia com um máximo de 5 espaços em cada direção
    //====================

    //========== Grafos ==========
    // Grafos não tem implementação nativa em Java, mas podem ser representados utilizando mapas ou arrays
    HashMap<String, String> grafo1 = new HashMap<>();
    String[][] grafo2 = { { "a", "b" },
                          { "a", "c" },
                          { "b", "d" },
                          { "b", "c" },
                          { "c", "d" }};
    //====================

    //========== Árvores ==========
    TreeMap<String, String> arvore1 = new TreeMap<>(); // Árvore utilizando a abordagem de mapa
    TreeSet<String> arvore2 = new TreeSet<>(); // Árvore utilizando a abordagem de sets
    //====================

    //========== Árvores ==========
    HashMap<String, String> mapa1 = new HashMap<>(); // Mapa Hash
    Hashtable<String, String> tabela1 = new Hashtable<>(); // Tabela Hash
    // Tabelas e Mapas hash tem comportamento semelhantes, mas algumas diferenças chave:
    // 1. Hashtables são mais otimizadas para aplicações que fazem uso de threads
    // 2. Hashtable não aceitam chaves ou valores nulos
    // 3. Hashmaps possuem uma subclasse (LinkedHashMap) que armazena os elementos em ordem de inserção
    HashSet<String> conjunto1 = new HashSet<>(); // Conjunto Hash
    //====================
  }
}
