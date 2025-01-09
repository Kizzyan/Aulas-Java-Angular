package rpg.classes.avancadas;

import rpg.classes.basicas.Guerreiro;

public class Cavaleiro extends Guerreiro {
  private int forca = 15;
  private int inteligencia = 7;
  private int agilidade = 5;

  public void ataqueFurioso() {
    System.out.println("Causou " + this.forca*2 + " de dano!");
  }

  @Override
  public void mostrarFicha() {
    System.out.println(
            "------------ Cavaleiro ------------\n" +
            "Descrição: Uma classe avançada baseada em força.\n" +
            "Força: " + this.forca + "\n" +
            "Inteligência: " + this.inteligencia + "\n" +
            "Agilidade: " + this.agilidade + "\n"
    );
  }
}
