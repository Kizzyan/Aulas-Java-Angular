package rpg.classes.basicas;

import rpg.classes.interfaces.ClasseDeMagia;

public class Mago implements ClasseDeMagia {
    private int forca = 7;
    private int inteligencia = 10;
    private int agilidade = 5;

    @Override
    public void conjurar() {
        System.out.println("Causou " + this.inteligencia + " de dano!");
    }

    @Override
    public void mostrarFicha() {
        System.out.println(
                "------------ Mago ------------\n" +
                "Descrição: Uma classe básica baseada em inteligência.\n" +
                "Força: " + this.forca + "\n" +
                "Inteligência: " + this.inteligencia + "\n" +
                "Agilidade: " + this.agilidade + "\n"
        );
    }
}
