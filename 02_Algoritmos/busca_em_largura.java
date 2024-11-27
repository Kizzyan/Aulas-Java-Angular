import java.util.*;

// O algoritmo de busca em largura é um pouco mais situacional do que os anteriormente apresentados
// Sendo assim, iremos criar um contexto para que ele possa ser aplicado
// Imagine que você está buscando um carro usado na sua cidade e quer utilizar sua rede social para procurar por uma oferta
// Você resolver buscar por amigos e amigos de amigos que possam ter um carro a venda
// O objetivo é checar se há alguém na sua rede que esteja vendendo um carro, e qual o menor caminho até ela

class BuscaEmLargura {

    // Iniciamos montando nossa rede de conexões
    // A verbosidade do Java pode tornar a linha abaixo complicada, mas basicamente estamos criando uma tabela hash que associa um amigo a sua lista de amigos
    // E um Amigo possui um nome (String) e se ele possui ou não um carro para vender (Boolean)
    static HashMap<Amigo, List<Amigo>> rede = new HashMap<>();

    public static void main(String[] args) {

        // Iniciamos criando algumas pessoas e suas respectivas listas de amigos
        Amigo voce = new Amigo("Você", false);
        Amigo joao = new Amigo("João", false);
        Amigo maria = new Amigo("Maria", false);
        Amigo paulo = new Amigo("Paulo", false);
        Amigo pedro = new Amigo("Pedro", false);
        Amigo julia = new Amigo("Júlia", false);
        Amigo luiz = new Amigo("Luiz", false);
        Amigo carlos = new Amigo("Carlos", false);
        Amigo mariana = new Amigo("Mariana", false);
        Amigo silvio = new Amigo("Silvio", true);

        // Então, inserimos você e alguns amigos, com suas respectivas listas de amigos
        rede.put(voce, List.of(joao, maria, paulo));
        rede.put(joao, List.of(pedro, julia));
        rede.put(maria, List.of(luiz));
        rede.put(paulo,  List.of());
        rede.put(pedro, List.of(carlos, mariana));
        rede.put(julia,  List.of());
        rede.put(luiz,  List.of(silvio));
        rede.put(carlos, List.of());
        rede.put(mariana,  List.of());

        // Agora, iniciamos a busca partindo da sua rede de amigos
        System.out.println(buscaEmLargura(voce));
    }

    static Boolean buscaEmLargura(Amigo amigo) {
        // Criamos uma fila para armazenar os amigos que serão buscados
        Queue<Amigo> filaDeBusca = new LinkedList<>(rede.get(amigo));
        // E um set para armazenar os amigos que foram buscados
        Set<Amigo> buscados = new HashSet<>();

        // Iremos repetir a busca enquanto tiverem amigos a serem buscados (ou até acharmos alguém que possui um carro)
        while (!filaDeBusca.isEmpty()) {
            // Pegamos o primeiro amigo da fila (o método pool aqui é equivalente ao método getFirst())
            Amigo buscado = filaDeBusca.poll();
            // Checamos se o amigo em questão já foi buscado antes
            if (!buscados.contains(buscado)) {
                // Checamos, então, se ele possui um carro
                if (buscado.temCarro) {
                    System.out.println(buscado.nome + " possui um carro a venda!");
                    return true;
                // Caso não possua, definimos que as conexões dele também devem ser buscadas e o adicionamos à lista de buscados
                } else {
                    filaDeBusca.addAll(rede.get(buscado));
                    buscados.add(buscado);
                }
            }
        }
        // Caso nenhum amigo ou conexão tenha um carro, retornamos false
        return false;
    }

    static class Amigo {
        public String nome;
        public boolean temCarro;

        public Amigo(String nome, boolean temCarro) {
            this.nome = nome;
            this.temCarro = temCarro;
        }
    }

}