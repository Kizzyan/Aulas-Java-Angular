package rpg.classes.avancadas;


import rpg.classes.basicas.Ladino;

public class Assassino extends Ladino {
    private int forca = 7;
    private int inteligencia = 5;
    private int agilidade = 15;

    public void ataqueFurtivo() {
        System.out.println("Causou " + this.agilidade*2 + " de dano!");
    }

    @Override
    public void mostrarFicha() {
        System.out.println(
                "------------ Assassino ------------\n" +
                        "Descrição: Uma classe avançada baseada em agilidade.\n" +
                        "Força: " + this.forca + "\n" +
                        "Inteligência: " + this.inteligencia + "\n" +
                        "Agilidade: " + this.agilidade + "\n"
        );
    }
}
