package rpg.classes.hibridas;

import rpg.classes.interfaces.ClasseDeAgilidade;
import rpg.classes.interfaces.ClasseDeMagia;

public class ArqueiroMistico implements ClasseDeAgilidade, ClasseDeMagia {
    private int forca = 2;
    private int inteligencia = 10;
    private int agilidade = 10;

    @Override
    public void disparar() {
        System.out.println("Causou " + this.agilidade + " de dano!");
    }

    @Override
    public void conjurar() {
        System.out.println("Causou " + this.inteligencia + " de dano!");
    }

    @Override
    public void mostrarFicha() {
        System.out.println(
                "------------ Arqueiro Místico ------------\n" +
                "Descrição: Uma classe híbrida baseada em agilidade e inteligência.\n" +
                "Força: " + this.forca + "\n" +
                "Inteligência: " + this.inteligencia + "\n" +
                "Agilidade: " + this.agilidade + "\n"
        );
    }
}
