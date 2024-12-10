import java.util.Scanner;

public class NumerosNarcisistas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        scanner.close();

        checar(numero);
    }

    static void checar(Integer numero) {
        Integer soma = 0; // Inicializamos uma variável soma, de valor 0, para amarzenar o resultado que será incrementado no loop
        String numeroString = String.valueOf(numero); // Convertemos o input do usuário em uma String. Ex.: 153 -> "153"
        int tamanho = numeroString.length(); // Obtemos o tamanho da String. Ex.: "153" -> tamanho = 3

        for (char c : numeroString.toCharArray()) { // Iteramos sobre cada caracter da String convertida em uma array. Ex.: "153" -> [1, 5, 3]
            int valorDigito = Character.getNumericValue(c); // Obtemos o valor numérico do caracter. Ex.: '1' -> 1, '5' -> 5, '3' -> 3
            soma += (int) Math.pow(valorDigito, tamanho); // Calculamos incrementalmente o resultado da soma. Ex.: 1^3 + 5^3 + 3^3
            // No Java, não possuimos o operador de potência, então utilizamos o Math.pow() da biblioteca padrão do Java
            // O trecho `(int)` se chama casting. Estamos pedindo para a JVM tratar o resultado do método pow (que retorna um double) como um int
            // Casting só é possível se os tipos forem compatíveis. Nesse caso, ambos int e float são tipos numéricos
        }

        if (soma.equals(numero)) { // Como soma e numero são do tipo Integer, podemos utilizar o métodos equals() ao invés do operador comparativo ==
            System.out.println(numero + " é narcisista");
        } else {
            System.out.println(numero + " não é narcisista");
        }
    }
}