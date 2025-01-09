package rpg.classes.basicas;

import rpg.classes.interfaces.ClasseDeForca;

public class Guerreiro implements ClasseDeForca {
  private int forca = 10;
  private int inteligencia = 5;
  private int agilidade = 7;

  @Override
  public void atacar() {
    System.out.println("Causou " + this.forca + " de dano!");
  }

  @Override
  public void mostrarFicha() {
    System.out.println(
            "------------ Guerreiro ------------\n" +
            "Descrição: Uma classe básica baseada em força.\n" +
            "Força: " + this.forca + "\n" +
            "Inteligência: " + this.inteligencia + "\n" +
            "Agilidade: " + this.agilidade + "\n"
    );
  }
}
