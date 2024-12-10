import java.util.Scanner;

public class AnoBissexto  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Novamente, o uso da classe Scanner nos permitir validar automaticamente se o input é um valor numérico
        int ano = scanner.nextInt(); // Dessa vez, utilizamos o método nextInt(), pois sabemos que anos são sempre números inteiros
        scanner.close();

        checar(ano);
    }

    static void checar(int ano) {
        // Aqui precisamos fazer um extenso uso dos operadores lógicos
        // Primeiro, verificamos se o ano é divisível por 4 (o operador % retorna o resto da divisão, logo se o resto for 0, o ano é divisível por 4)
        // Em seguida, conferimos se além de divisível por 4, ele NÃO É divisível por 100 OU É divisível por 400
        // Lembrando que no operador && (e), ambos os lados da condição devem ser verdadeiros
        // Já no operador || (ou), apenas um dos lados da condição precisa ser verdadeiro
        if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
            System.out.println(ano + " é bissexto");
        } else {
            System.out.println(ano + " não é bissexto");
        }
    }
}