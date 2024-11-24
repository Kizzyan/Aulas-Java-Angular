import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Quicksort {
    public static void main(String[] args) {
        ArrayList<Integer> desordenada = new ArrayList<>(Arrays.asList(5, 1, 3, 4, 2, 10, 9, 7, 6, 8));
        System.out.println("Array original: " + desordenada.toString());
        double startTime = System.nanoTime();
        System.out.println("Array ordenado: " + quicksort(desordenada).toString());
        double finishTime = System.nanoTime();
        System.out.println("Tempo de execução: " + (finishTime - startTime)/1000000 + "ms");
    }

    static List<Integer> quicksort(List<Integer> lista) {
        // Definimos uma nova lista aonde serão armazenados os elementos ordenados
        List<Integer> novaLista = new ArrayList<>();
        // Definimos uma lista para os elementos menores que o pivot
        List<Integer> menores;
        // Definimos uma lista para os elementos maiores que o pivot
        List<Integer> maiores;
        // Definimos o pivot
        int pivot;
        // Definimos o caso base, em que retornamos a própria array caso ela tenha apenas 1 elementos
        if (lista.size() < 2) return lista;
        // Caso contrário, definimos o pivot, e dividimos a array em duas, uma com os menores e outra com os maiores
        else {
            // A escolha do pivot fica a criterio do desenvolvedor, nesse caso optamos pelo primeiro valor da array
            pivot = lista.get(lista.size()/2);
            // Aqui utilizamos a Stream API do Java para filtrar os menores e maiores
            menores = lista.stream().filter(x -> x < pivot).toList();
            maiores = lista.stream().filter(x -> x > pivot).toList();
        }
        // Geramos uma nova lista organizada, colocando menores + pivot + maiores
        // Aqui é aonde ocorre a recursão do algoritmo, aplicando o quicksort em cada uma das sublistas
        novaLista.addAll(quicksort(menores));
        novaLista.add(pivot);
        novaLista.addAll(quicksort(maiores));
        return novaLista;
    }
}
