package rpg;

import rpg.classes.avancadas.Arquimago;
import rpg.classes.avancadas.Assassino;
import rpg.classes.avancadas.Cavaleiro;
import rpg.classes.basicas.Guerreiro;
import rpg.classes.basicas.Ladino;
import rpg.classes.basicas.Mago;
import rpg.classes.hibridas.ArqueiroMistico;
import rpg.classes.hibridas.CavaleiroArcano;
import rpg.classes.hibridas.Patrulheiro;

public class RPG {
  public static void main(String[] args) {
    Guerreiro guerreiro = new Guerreiro();
    Cavaleiro cavaleiro= new Cavaleiro();

    Mago mago = new Mago();
    Arquimago arquimago = new Arquimago();

    Ladino ladino = new Ladino();
    Assassino assassino = new Assassino();

    CavaleiroArcano cavaleiroArcano = new CavaleiroArcano();
    ArqueiroMistico arqueiroMistico = new ArqueiroMistico();
    Patrulheiro patrulheiro = new Patrulheiro();

    guerreiro.mostrarFicha();
    cavaleiro.mostrarFicha();
    mago.mostrarFicha();
    arquimago.mostrarFicha();
    ladino.mostrarFicha();
    assassino.mostrarFicha();
    cavaleiroArcano.mostrarFicha();
    arqueiroMistico.mostrarFicha();
    patrulheiro.mostrarFicha();
  }
}

