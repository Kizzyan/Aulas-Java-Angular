// Sobrescrita de método
public class Animal {
   public String emitirSom() {
      return "Som genérico de animal";
   }
}

public class Gato extends Animal {
   @Override // a anotação @Override é essencial para sobrescever métodos herdados
   public String emitirSom() {
      return "Miau";
   }
}

// Sobrecarga de Método (Sem herança)
public class Calculadora{

    public int somar(int a, int b){
        return a + b;
    }

    public int somar(int a, int b, int c){
        return a + b + c;
    }
}

// Sobrecarga de Método (com Herança)
public class Cao extends Animal {
   @Override
   public String emitirSom() {
      return "Latido";
   }

   public String emitirSom(int intensidade){
      return "Latido com intensidade " + intensidade;
   }
}

// Encapsulamento
class Pessoa {
  private int idade;

  // Nesse caso, o Encapsulamento também está permitindo a validação dos dados recebidos
  public void setIdade (int idade) {
    if (idade >= 0) {
      this.idade = idade;
    }
  }
}

// Interfaces
interface Empregado {
  void trabalhar();
}

interface Sociavel {
  void conversar();
}

class Barista implements Empregado, Sociavel {
  @override
  void trabalhar () {
    System.out.println("Misturar drinks.");
  }

  @override
  void conversar () {
    System.out.println("Conversar com os clientes.");
  }
}

// Classes Abstratas
abstract class Mamifero {
  public void dormir () {
    System.out.println("zzz...");
  }

  public void descreverHabitosAlimentares();
}

class Leao extends Mamifero {
  // dormir já está herdado e não precisa ser sobrescrito

  @Override
  public void descreverHabitosAlimentares () {
    System.out.println("Leões são carnívoros.");
  }
}
