package rpg.classes.hibridas;

import rpg.classes.interfaces.ClasseDeAgilidade;
import rpg.classes.interfaces.ClasseDeForca;

public class Patrulheiro implements ClasseDeAgilidade, ClasseDeForca {
    private int forca = 10;
    private int inteligencia = 2;
    private int agilidade = 10;

    @Override
    public void disparar() {
        System.out.println("Causou " + this.agilidade + " de dano!");
    }

    @Override
    public void atacar() {
        System.out.println("Causou " + this.forca + " de dano!");
    }

    @Override
    public void mostrarFicha() {
        System.out.println(
                "------------ Patrulheiro ------------\n" +
                "Descrição: Uma classe híbrida baseada em agilidade e força.\n" +
                "Força: " + this.forca + "\n" +
                "Inteligência: " + this.inteligencia + "\n" +
                "Agilidade: " + this.agilidade + "\n"
        );
    }
}
