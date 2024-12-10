import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        // Para receber input do usuário via terminal, precisamos utilizar a classe Scanner
        Scanner scanner = new Scanner(System.in); // Instanciamos um Scanner e passamos o input do sistema como parâmetro
        // Utilizando a classe Scanner, podemos pular a etapa de validação de input, pois garantimos que o input seja do tipo numérico logo no momento da entrada
        double a = scanner.nextDouble(); // O método `nextDouble()` retorna um double
        String operador = scanner.next(); // O método `next()` retorna um String
        double b = scanner.nextDouble();
        scanner.close(); // Precisamos fechar o scanner para liberar recursos e evitar um vazamento de memória

        // Aqui implementamos 2 versãos do método cálculo
        // A primeira não retorna nenhum valor, apenas imprimindo uma mensagem no terminal. Isso significa que não podemos armazenar o resultado em uma variável
        calcular1(a, b, operador);
        // A segunda retorna o valor calculado, o que signfica que podemos armazena-lo em uma variável
        double resultado = calcular2(a, b, operador);
        // Porém, se quisermos exibir o resultado no terminal, precisamos fazer isso explicitamente com um novo System.out.println()
        System.out.println(a + " " + operador + " " + b + " = " + resultado); // O + aqui está sendo usado apenas para concatenar as strings, isso resultará em algo como "a operador b = resultado"
    }

    static void calcular1(double a, double b, String operador) {
        switch (operador) { // Aqui optamos por um switch case, pois ele é ideal para caso em que precisamos checar apenas uma condição para diferentes casos
            case "+":
                System.out.println("O resultado é " + (a + b) + "!");
                break;
            case "-":
                System.out.println("O resultado é " + (a - b) + "!");
                break;
            case "*":
                System.out.println("O resultado é " + (a * b) + "!");
                break;
            case "/":
                if (b != 0) {
                    System.out.println("O resultado é " + (a / b) + "!");
                } else {
                    System.out.println("Não é possível dividir por zero!");
                }
                break;
            default:
                System.out.println("Operador inválido!");
        }
    }

    static double calcular2(double a, double b, String operador) {
        return switch (operador) { // Essa forma de se escrever um switch case é um pouco mais moderna (Java 13+) e é uma alternativa mais concisa e elegante
            case "+" -> a + b; // Quando escrevemos fora de chaves, o resultado da expressão é retornado implicitamente
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                // Escrevendo dentro de chaves, o resultado da expressão precisa ser retornado explicitamente
                if (b != 0) {
                    // Para isso, utilizamos a palavra-chave yield, equivalente ao return de um método
                    yield a / b;
                } else {
                    System.out.println("Não é possível dividir por zero!");
                    // Aqui e no caso abaixo retornamos Infinito apenas para representar que a operação não resultou em um valor válido
                    yield Double.POSITIVE_INFINITY;
                }
            }
            default -> {
                System.out.println("Operador inválido!");
                yield Double.POSITIVE_INFINITY;
            }
        };
    }
}