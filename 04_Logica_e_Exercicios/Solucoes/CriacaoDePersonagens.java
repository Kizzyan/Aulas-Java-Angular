import java.util.Random;
import java.util.Scanner;

public class CriacaoDePersonagens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o nome do personagem?");
        String nome = scanner.next();
        System.out.println("Qual a classe do personagem?\nL para Ladino - M para Mago - G para Guerreiro");
        String classe = scanner.next();
        scanner.close();

        Personagem personagem = new Personagem(nome, classe);
        personagem.mostrarFicha();
    }
}

class Personagem {
    // A depender da IDE que você está utilizando, os atributos abaixo podem receber um alerta como "Campo xxxx pode ser final"
    // Isso ocorre porque não declaramos nenhum método que altere esses atributos após instanciados, logo, a IDE assume que eles podem ser constantes
    // Para esse caso particular, pode-se ignorar o alerta, mas na maior parte dos casos recomenda-se tornar atributos não modifáveis como "final" por questões de boas práticas
    private String nome;
    private String classe;
    private int destreza;
    private int forca;
    private int inteligencia;
    // Utilizamos a classe Random da biblioteca padrão para gerar valores aleatórios
    private final Random random = new Random();

    // Definimos o construtor para nossa classe
    // O construtor é o método especial utilizado para instanciar objetos da classe
    // Ele é invocado assim que a palavra chave `new` for utilizada
    // Ele não possui um valor de retorno, pois retorna implicitamente um novo objeto de sua própria classe
    public Personagem(String nome, String classe) {
        this.nome = nome;
        this.classe = classe;
        this.destreza = rolarDestreza(classe);
        this.forca = rolarForca(classe);
        this.inteligencia = rolarInteligencia(classe);
    }

    // Definimos o método de rolagem como private, pois não há necessidade ou sentido de acessá-los externamente
    private int rolarDestreza(String classe) {
        // Utilizamos um switch para definir a rolagem adequada de acordo com a classe
        return switch (classe) {
            // Preciamos incluir o "+ 1" por o método nextInt retorna um valor a partir o 0, e não há o lado 0 em um dado
            case "L" -> random.nextInt(20) + 1;
            case "M" -> random.nextInt(12) + 1;
            case "G" -> random.nextInt(8) + 1;
            default -> 0;
        };
    }

    private int rolarForca(String classe) {
        return switch (classe) {
            case "L" -> random.nextInt(12) + 1;
            case "M" -> random.nextInt(8) + 1;
            case "G" -> random.nextInt(20) + 1;
            default -> 0;
        };
    }

    private int rolarInteligencia(String classe) {
        return switch (classe) {
            case "L" -> random.nextInt(8) + 1;
            case "M" -> random.nextInt(20) + 1;
            case "G" -> random.nextInt(12) + 1;
            default -> 0;
        };
    }

    public void mostrarFicha() {
        System.out.println("==== Ficha do Personagem ===="
                         + "\nNome: " + this.nome
                         + "\nClasse: " + this.classe
                         + "\nDestreza: " + this.destreza
                         + "\nForça: " + this.forca
                         + "\nInteligência: " + this.inteligencia
                         + "\n=============================");
    }
}
