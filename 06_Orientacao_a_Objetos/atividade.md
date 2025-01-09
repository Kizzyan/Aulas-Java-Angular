# Aula 06 - Atividade

## Crie um sistemas de classes de RPG, possuindo classes básicas, avançadas e híbridas

- O sistema deve possui 3 classes principais: Guerreiro, Mago e Ladino
  - Cada uma das classes deve possuir uma classe superior, sendo essas:
    - Guerreiro: Cavaleiro
    - Mago: Arquimago
    - Ladino: Assassino
  - As classes mistas devem ser:
    - Guerreiro + Ladino: Patrulheiro
    - Guerreiro + Mago: Cavaleiro Arcano
    - Mago + Ladino: Arqueiro Místico
- Todas as classes devem possuir os atributos Força, Inteligência e Agilidade
- Todas as classes devem possuir um método `mostrarFicha()`, que inclui:
  - Nome da classe
  - Breve descrição
  - Atributos
- Segue abaixo os métodos e atributos que cada classe deve possuir:

```
• Guerreiro:
  → Atributos: Força 10, Inteligência 5 e Agilidade 7
  → Habilidades: Atacar (causa dano = força)
• Mago:
  → Atributos: Força 7, Inteligência 10 e Agilidade 5
  → Habilidades: Conjurar (causa dano = inteligência)
• Ladino:
  → Atributos: Força 5, Inteligência 7 e Agilidade 10
  → Habilidades: Disparar (causa dano = agilidade)

• Cavaleiro:
  → Atributos: Força 15, Inteligência 7 e Agilidade 5
  → Habilidades: Atacar e Ataque Furioso (causa dano = força x 2)
• Arquimago:
  → Atributos: Força 5, Inteligência 15 e Agilidade 7
  → Habilidades: Conjurar e Conjuração Arcana (causa dano = inteligência x 2)
• Assassino:
  → Atributos: Força 7, Inteligência 5 e Agilidade 15
  → Habilidades: Disparar e Ataque Furtivo (causa dano = agilidade x 2)

• Cavaleiro Arcano:
  → Atributos: Força 10, Inteligência 10 e Agilidade 2
  → Habilidades: Atacar e Conjurar
• Arqueiro Místico:
  → Atributos: Força 2, Inteligência 10 e Agilidade 10
  → Habilidades: Disparar e Conjurar
• Patrulheiro:
  → Atributos: Força 10, Inteligência 2 e Agilidade 10
  → Habilidades: Disparar e Atacar
```

- Dicas:
  - Lembrem-se que Java não permite herança múltipla através de classes, mas sim através de interfaces
  - TODOS os métodos declarados em uma interface devem ser implementados pelas classes que os herdarem
  - Não é necessário sobrescrever atributos da mesma forma que métodos (com @Override), o ato de declarar o mesmo atributo em uma classe filha já é suficiente para indicar à JVM qual atributo na cadeia hierárquica está sendo referenciado
