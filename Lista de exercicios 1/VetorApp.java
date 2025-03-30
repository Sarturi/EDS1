import estruturas.Lista;
import estruturas.Iterador;
import estruturas.Vetor;

public class VetorApp {

    public static void main(String[] args) {
        System.out.println("Lista.java");
        Lista lista = new Lista();

        // Cria a lista
        int[] valores = {2, 7, 9, 12, 16, 21, 27, 33, 42, 54};
        for (int valor : valores) {
            lista.adicionarAoFinal(valor);
        }

        System.out.println("Lista inicial:");
        lista.mostrarNos();

        System.out.println("\nInserindo final da lista:");
        System.out.println("Antes:");
        lista.mostrarNos();
        lista.adicionarAoFinal(60);
        System.out.println("Depois:");
        lista.mostrarNos();

        System.out.println("Nos na lista: " + lista.contarNos());

        System.out.println("Inserindo 25 depois do 21:");
        System.out.println("Antes:");
        lista.mostrarNos();
        lista.inserirAposValor(21, 25);
        System.out.println("Depois:");
        lista.mostrarNos();

        System.out.println("lista tamanho: " + lista.tamanho());

        System.out.println("Iterador.java");
        Iterador iterador = new Iterador(lista, lista.inicio);

        System.out.println("Iterando pela lista:");
        while (iterador.Proximo()) {
            iterador.display();
        }

        System.out.println("Inserindo 70 depois do no atual:");
        iterador.resetar();
        iterador.proximo();
        System.out.println("Antes:");
        lista.mostrarNos();
        iterador.inserirAposAtual(70);
        System.out.println("Depois:");
        lista.mostrarNos();

        System.out.println("\nRemovendo o proximo no:");
        System.out.println("Antes:");
        lista.mostrarNos();
        iterador.removerAposAtual();
        System.out.println("Depois:");
        lista.mostrarNos();

        System.out.println("Inserindo 5 antes do no atual:");
        System.out.println("Antes:");
        lista.mostrarNos();
        iterador.inserirAntesAtual(5);
        System.out.println("Depois:");
        lista.mostrarNos();

        System.out.println("Removendo o nó anterior:");
        System.out.println("Antes:");
        lista.mostrarNos();
        iterador.removerAntesAtual();
        System.out.println("Depois:");
        lista.mostrarNos();

        System.out.println("Vetor.java");
        Vetor vetor = new Vetor(10);

        for (int valor : valores) {
            vetor.adicionar(valor);
        }

        System.out.println("Vetor inicio:");
        vetor.mostrarElementos();

        System.out.println("Busca binária 21:");
        int posicao = vetor.buscaBinaria(21);
        if (posicao != -1) {
            System.out.println("Valor encontrado na posição: " + posicao);
        } else {
            System.out.println("Valor não encontrado.");
        }

        System.out.println("Inserindo no início do vetor:");
        System.out.println("Antes:");
        vetor.mostrarElementos();
        vetor.inserirNoInicio(1);
        System.out.println("Depois:");
        vetor.mostrarElementos();

        System.out.println("Removendo 9:");
        System.out.println("Antes:");
        vetor.mostrarElementos();
        vetor.removerPorValor(9);
        System.out.println("Depois:");
        vetor.mostrarElementos();

        System.out.println("Ve se tem 33 no vetor:");
        vetor.contem(33);
    }
}