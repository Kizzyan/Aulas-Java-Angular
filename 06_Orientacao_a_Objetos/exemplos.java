class Exemplos {
  public static void main(String[] args) {
    
  }
}

class Animal {
  String nome;
  float peso;
  int idade;

  void dormir() {
    System.out.println("Dormiu.");
  }

  void comer() {
    System.out.println("Comeu.");
  }
}

// Sobrescrita de método
public class Animal {
   public String emitirSom() {
      return "Som genérico de animal";
   }
}

public class Gato extends Animal {
   @Override
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

  public void setIdade (int idade) {
    if (idade >= 0) {
      this.idade = idade;
    }
  }
}

// Abstração
// Interfaces
interface Emprego {
  void trabalhar();
}

class Barista implements Emprego {
  @override
  void trabalhar () {
    System.out.println("Misturar drinks.");
  }
}


