import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Mergesort {
    public static void main(String[] args) {
        ArrayList<Integer> desordenada = new ArrayList<>(Arrays.asList(5, 1, 3, 4, 2, 10, 9, 7, 6, 8));
        System.out.println("Array original: " + desordenada.toString());
        double startTime = System.nanoTime();
        System.out.println("Array ordenado: " + mergesort(desordenada).toString());
        double finishTime = System.nanoTime();
        System.out.println("Tempo de execução: " + (finishTime - startTime)/1000000 + "ms");
    }

    // Primeiramente definimos uma função que será responsável pelo merge das sublistas
    static ArrayList<Integer> merge(ArrayList<Integer> esquerda, ArrayList<Integer> direita) {
        // Declaramos uma array para armazenar os resultados
        ArrayList<Integer> resultado = new ArrayList<>();
        // Percorremos as sublistas enquanto um delas não for vazia
        while (!esquerda.isEmpty() && !direita.isEmpty()) {
            // Caso o primeiro elemento da esquerda seja menor que o da direita, adicionamos ele aos resultados
            if (esquerda.getFirst() < direita.getFirst()) resultado.add(esquerda.removeFirst()); // Dependendo da versão do Java, pode ser necessário substituir getFirst e removeFirst por get(0) ou remove(0)
            // Do contrário, adicionamos o primeiro elemento da direita aos resultados
            else resultado.add(direita.removeFirst());
        }
        // Adicionamos então os elementos restantes aos resultados, que se encaixarão naturalmente na ordem correta
        while (!esquerda.isEmpty()) resultado.add(esquerda.removeFirst());
        while (!direita.isEmpty()) resultado.add(direita.removeFirst());
        return resultado;
    }

    // Aqui declaramos o algoritmo de merge sort
    static ArrayList<Integer> mergesort(ArrayList<Integer> lista) {
        // Definimos o caso base, que retornará a própria lista caso ela tenha apenas 1 elemento
        if (lista.size() < 2) return lista;
        // Caso contrário, dividimos a array em duas
        int meio = lista.size() / 2;
        // Aqui aplicamos o caso recursivo, dividindo e posteriormente mesclando as sublistas
        ArrayList<Integer> esquerda = mergesort(new ArrayList<Integer>(lista.subList(0, meio)));
        ArrayList<Integer> direita = mergesort(new ArrayList<Integer>(lista.subList(meio, lista.size())));
        return merge(esquerda, (direita));
    }
}
