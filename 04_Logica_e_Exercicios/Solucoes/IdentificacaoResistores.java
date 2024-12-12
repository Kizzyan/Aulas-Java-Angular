import java.util.Arrays;
import java.util.Scanner;

public class IdentificacaoResistores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual a cor da primeira banda?");
        String cor1 = scanner.next();
        System.out.println("Qual a cor da segunda banda?");
        String cor2 = scanner.next();
        scanner.close();

        // Criamos uma array para armazenar as cores pois isso facilitará a iteração dentro do método
        String[] cores = {cor1, cor2};

        identificar(cores);
    }

    public static void identificar(String[] cores) {
        // Instanciamos um novo StringBuilder
        StringBuilder builder = new StringBuilder();
        // Criamos uma nova array para armazenar uma versão sanitizada das cores passadas
        String[] coresSanitizadas = Arrays.stream(cores) // Usamos a Stream API para manipular nossa array
                .map(String::toLowerCase) // Aplicamos o método toLowerCase() em todos os elementos da array
                .map(String::trim) // Aplicamos o método trim() em todos os elementos da array
                .toArray(String[]::new); // Retornamos a array sanitizada utilizando como parâmetro o construtor de array String[]::new
        // Obs.: A notação :: é chamada de "referência de método" e serve para referenciar um método sem precisar criar uma nova instância dele
        // Como o método map() aplica uma função em todos os elementos de uma array, podemos utilizar a notação :: para referenciar o método desejado em todos os elementos da array

        // Iteramos sobre nossa array de cores
        for (String cor : coresSanitizadas) {
            switch (cor) {
                // Caso a cor seja valida, adicionamos o valor correspondente ao StringBuilder
                case "preto" -> builder.append("0");
                case "marrom" -> builder.append("1");
                case "vermelho" -> builder.append("2");
                case "laranja" -> builder.append("3");
                case "amarelo" -> builder.append("4");
                case "verde" -> builder.append("5");
                case "azul" -> builder.append("6");
                case "violeta" -> builder.append("7");
                case "cinza" -> builder.append("8");
                case "branco" -> builder.append("9");
                // Caso a cor seja inválida, exibimos uma mensagem
                default -> System.out.println("Cor inválida!");
            }
        }

        // Convertemos o Valor do StringBuilder em um Inteiro
        int resistencia = Integer.parseInt(builder.toString());
        System.out.println("A resistência para um resistor com as bandas " + cores[0] + " e " + cores[1] + " é de " + resistencia + " ohms.");
    }
}