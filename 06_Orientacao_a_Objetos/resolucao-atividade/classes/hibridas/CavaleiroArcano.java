package rpg.classes.hibridas;

import rpg.classes.interfaces.ClasseDeForca;
import rpg.classes.interfaces.ClasseDeMagia;

public class CavaleiroArcano implements ClasseDeForca, ClasseDeMagia {
    private int forca = 10;
    private int inteligencia = 10;
    private int agilidade = 2;

    @Override
    public void atacar() {
        System.out.println("Causou " + this.forca + " de dano!");
    }

    @Override
    public void conjurar() {
        System.out.println("Causou " + this.inteligencia + " de dano!");
    }

    @Override
    public void mostrarFicha() {
        System.out.println(
                "------------ Cavaleiro Arcano ------------\n" +
                "Descrição: Uma classe híbrida baseada em força e inteligência.\n" +
                "Força: " + this.forca + "\n" +
                "Inteligência: " + this.inteligencia + "\n" +
                "Agilidade: " + this.agilidade + "\n"
        );
    }
}
