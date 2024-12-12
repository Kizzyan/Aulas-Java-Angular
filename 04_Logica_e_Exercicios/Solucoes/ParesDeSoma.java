import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ParesDeSoma {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(8, 7, 2, 5, 3, 1);
        int soma = 10;
        System.out.println("Os pares que resultam na soma " + soma + " são: " + buscarPares(array, soma));
    }

    public static List<List<Integer>> buscarPares(List<Integer> array, int soma) {
        // Primeiro, declaramos uma array para armazenar os pares
        List<List<Integer>> pares = new ArrayList<>();

        // Então, percorremos a nossa array
        // Nesse caso, utilizar um for clássico é necessário pois precisamos acessar posições diferentes simultaneamente
        // Um for melhor (ou for each) nos permite acessar apenas uma posição por vez
        for (int i = 0; i < array.size(); i++) {
            // Para cada número na nossa array, checaremos se ele possui um par que resulta na soma para cada número posterior na array
            // Para isso, utilizaremos um segundo for
            // Ex.: Suponha a array [1,2,3,4], o processo seria algo como 1 → 1+2, 1+3 // 2 → 2+3, 2+4 // 3 → 3+4 // 4 → encerramos o loop
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(i) + array.get(j) == soma) { // Checamos se o par resulta na soma
                    List<Integer> par = new ArrayList<>(); // Se sim, criamos uma array para armazenar o par
                    // Adicionamos ambos os elementos ao par
                    par.add(array.get(i));
                    par.add(array.get(j));
                    // Adicionamos o par à lista de pares
                    pares.add(par);
                }
            }
        }

        return pares;
    }
}