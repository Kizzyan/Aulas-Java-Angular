# Exercícios

- Na lista abaixo, seguem alguns exercícios envolvendo: **estruturas de dados**, **algoritmos** e **lógica de programação**
- A solução para cada um dos exercícios pode ser encontrada na pasta `/Solucoes` deste repositório
- Busquem resolver cada um dos exercícios e só ir atrás das soluções se **realmente** sentirem que estão travados

### 01 - Crie uma calculadora
- Crie um programa que realize operações matemáticas simples
- Ele deve receber 3 parâmetros: **a**, **b** e **operador**
- Antes de executar as operações, o programa deve realizar algumas validações:
  - **a** e **b** são tipos numéricos
  - **operador** é um dos seguintes: `+`, `-`, `*` ou `/`
  - Caso a operação realizada seja de divisão, **b** NÃO pode ser 0
- **Desafio:** Desenvolva esse programa de forma que ele rode no terminal e aceite input de usuário
- **Código base:**
```java
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        // Utilize a classe Scanner caso quera aceitar input do usuário
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        String operador = scanner.next();
        double b = scanner.nextDouble();
        scanner.close();
        
        calcular(a, b, operador);
    }
}
``` 

### 02 - Verificador de anos bissextos
- Crie um programa que receba um dado ano e retorne se ele é bissexto ou não
- Lembre-se de implementar uma validação para garantir que o argumento passado seja um ano válido
- Um ano é bissexto se ele for divisível por 4 ou simultaneamente divisível por 100 e por 400

### 03 - Verificador de números narcisistas
- Um número narcisista é um número que seja igual ao soma dos seus dígitos elevados ao número de dígitos
- **Exemplo:** 
  - 9 = 9^1 = 9
  - 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
- Lembre-se de validar se o argumento de entrada é de fato um valor númerico e se NÃO é um tipo decimal

### 04 - Verificador de Palíndromos
- Palíndromos são frases que se leem da mesma forma da esquerda para a direita e da direita para a esquerda
- Crie um programa que receba uma frase e retorne se ela é um palíndromo ou não
- *Dica:* Para garantir que o programa funcione corretamente, é preciso higienizar o input:
  - Remova todos os espaços em branco e caracteres especiais
  - Transforme todas as letras em maiúsculas ou minúsculas
- **Código base:**
```java
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        // Utilize a classe Scanner caso quera aceitar input do usuário
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        String operador = scanner.next();
        double b = scanner.nextDouble();
        scanner.close();
        
        calcular(a, b, operador);
    }
}
``` 

### 05 - Sistema de criação de personagens
- Crie um sistema que receba o nome de um personagem e a sua classe
- Baseado na classe escolhida, o sistema irá rolar dados diferentes para determinados atributos
  - **Ladino:** D20 para Destreza, D12 para Forca e D8 para Inteligência
  - **Mago:** D20 para Inteligência, D12 para Destreza e D8 para Força
  - **Guerreiro:** D20 para Força, D12 para Destreza e D8 para Inteligência
- D20 significa um número aleatório entre 1 e 20, enquanto D12 entre 1 e 12 e D8 entre 1 e 8
- Depois de criado, o personagem deve possuir um método "mostrarFicha" que imprime na tela todas as informações do personagem
- **Dica:** Você precisa criar uma nova classe `Personagem` contendo todos os atributos necessários e instanciá-la cada vez que precisar gerar um novo personagem
- **Código base:**
```java
import java.util.Scanner;

public class CriadorDePersonagem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual o nome do personagem?");
        String nome = scanner.next();
        System.out.println("Qual a classe do personagem?");
        String classe = scanner.next();
        scanner.close();
        
        Personagem personagem = new Personagem(nome, classe);
        personagem.mostrarFicha();
    }
    
    public class Personagem {
        // Declares os atributos aqui (nome, classe, destreza, forca, inteligência)
      
        public Personagem (String nome, String classe) {
            // Inicialize os atributos aqui
            // Dica: Você pode utilizar condicionais, loops ou até outros métodos dentro de um método construtor 
        }
        
        public void mostrarFicha() {
            // Imprima na tela as informações do personagem
        }
    }
}
``` 

### 06 - Sistema de identificação de resistores
  - Resistores são componentes muito importantes de circuitos eletrônicos
  - Cada resistor possui um valor específico de resistência
  - Já que resistores costumam ser muito pequenos, nem sempre é viável ter o valor numérico no corpo do resistor
  - Por isso, utilizam-se **bandas coloridas** representado diferentes valores de resistência:
    - preto: 0
    - marrom: 1
    - vermelho: 2
    - laranja: 3
    - amarelo: 4
    - verde: 5
    - azul: 6
    - violeta: 7
    - cinza: 8
    - branco: 9
  - Sendo assim, caso um resistor possuas as bandas vermelha e azul, o valor de resistência é 26
  - Crie um sistema que receba as cores de um resistor e retorne o valor de resistência correspondente
  - **Dica:** Apenas as 2 primeiras bandas representam o valor de resistência, então você pode criar um método que receba apenas 2 argumentos ou uma array de 2 elementos

### 07 - Ache os pares para uma dada soma
- Dada uma array não ordenada qualquer, encontre todos os pares de valor que resultam em dada soma
- **Exemplo:**
  - Para uma array `[8, 7, 2, 5, 3, 1]` e uma soma desejada de 10
  - O resultado deve ser `[[8, 2], [7, 3]]`
  - Caso nenhum par seja encontrado, retorne uma array vazia `[]`
- **Código base:**
```java
import java.util.List;

class BuscarPares {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(8, 7, 2, 5, 3, 1);
        // ou int[] array = {8, 7, 2, 5, 3, 1};
        // Fica a seu critério utilizar com arrays de primitivos ou arrays de objetos
        int soma = 10;
        System.out.println("Os pares que resultam na soma " + soma + " são: " + buscarPares(array, soma));
        // Deve retornar: [[8, 2], [7, 3]]
    }

    // Declare o método buscarPares aqui
}
```
