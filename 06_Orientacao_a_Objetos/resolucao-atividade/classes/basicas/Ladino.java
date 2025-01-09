package rpg.classes.basicas;


import rpg.classes.interfaces.ClasseDeAgilidade;

public class Ladino implements ClasseDeAgilidade {
    private int forca = 5;
    private int inteligencia = 7;
    private int agilidade = 10;

    @Override
    public void disparar() {
        System.out.println("Causou " + this.agilidade + " de dano!");
    }

    @Override
    public void mostrarFicha() {
        System.out.println(
                "------------ Ladino ------------\n" +
                "Descrição: Uma classe básica baseada em agilidade.\n" +
                "Força: " + this.forca + "\n" +
                "Inteligência: " + this.inteligencia + "\n" +
                "Agilidade: " + this.agilidade + "\n"
        );
    }
}
