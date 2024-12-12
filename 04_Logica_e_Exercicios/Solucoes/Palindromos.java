import java.util.Scanner;

public class Palindromos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String frase = scanner.nextLine();
        scanner.close();

        checar(frase);
    }

    static void checar(String frase) {
        // Aqui utilizamos a sintaxe com `var`, para omitir a necessidade de declarar o tipo da variável
        var builder = new StringBuilder(); // Precisamos instanciar uma classe StringBuilder, utilizada para manipulação de strings
        // Iremos aplicar alguns métodos a nossa frase invertida para sanitizá-la
        // Obs.: Sanitizar significa remover caracteres indesejados, como símbolos, pontuação ou espaços em branco
        var fraseInvertida = builder.append(frase) // Adicionamos a frase ao StringBuilder
                .reverse() // Invertemos a frase
                .toString() // Retornamos a frase invertida para String
                .toLowerCase() // Tornamos todos os caracteres da frase invertida minúsculos
                .replaceAll("[^a-zA-Z]", "") // Removemos todos os caracteres que não sejam letras
                .replace(" ", ""); // Removemos  os espaços em branco da frase invertida

        // Criamos uma variável para armazenar a frase original sanitizada
        String fraseSanitizada = frase.toLowerCase().replaceAll("[^a-zA-Z]", "").replace(" ", "");

        if (fraseSanitizada.equals(fraseInvertida)) { // Comparamos as frases sanitizadas
            System.out.println(frase + " é um palíndromo!");
        } else {
            System.out.println(frase + " não é um palíndromo!");
        }
    }
}