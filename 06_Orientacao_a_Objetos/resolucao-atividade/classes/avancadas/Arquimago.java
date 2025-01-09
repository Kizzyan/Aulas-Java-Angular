package rpg.classes.avancadas;


import rpg.classes.basicas.Mago;

public class Arquimago extends Mago {
    private int forca = 5;
    private int inteligencia = 15;
    private int agilidade = 7;

    public void conjuracaoArcana() {
        System.out.println("Causou " + this.inteligencia*2 + " de dano!");
    }

    @Override
    public void mostrarFicha() {
        System.out.println(
                "------------ Arquimago ------------\n" +
                "Descrição: Uma classe avançada baseada em inteligência.\n" +
                "Força: " + this.forca + "\n" +
                "Inteligência: " + this.inteligencia + "\n" +
                "Agilidade: " + this.agilidade + "\n"
        );
    }
}
