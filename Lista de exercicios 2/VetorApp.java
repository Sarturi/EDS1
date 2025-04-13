import estruturas.Lista;
import estruturas.Iterador;
import estruturas.Vetor;
import estruturas.Pilhas;
import estruturas.Fila;
import estruturas.Documento;

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

        System.out.println("Pilhas.java");
        Pilhas pilhaDesfazer = new Pilhas(10);
        Pilhas pilhaRefazer = new Pilhas(10);
        String textoAtual = "";

        // Inserir texto inicial
        textoAtual = inserirTexto(pilhaDesfazer, pilhaRefazer, textoAtual, "Texto inicial");
        System.out.println("Texto atual: " + textoAtual);

        // Adicionar mais texto
        textoAtual = inserirTexto(pilhaDesfazer, pilhaRefazer, textoAtual, " + mais texto");
        System.out.println("Texto atual: " + textoAtual);

        // Desfazer
        textoAtual = desfazer(pilhaDesfazer, pilhaRefazer, textoAtual);
        System.out.println("Texto após desfazer: " + textoAtual);

        // Refazer
        textoAtual = refazer(pilhaDesfazer, pilhaRefazer, textoAtual);
        System.out.println("Texto após refazer: " + textoAtual);

        // Adicionar novo texto
        textoAtual = inserirTexto(pilhaDesfazer, pilhaRefazer, textoAtual, " + novo texto");
        System.out.println("Texto atual: " + textoAtual);

        // Desfazer múltiplas vezes
        textoAtual = desfazer(pilhaDesfazer, pilhaRefazer, textoAtual);
        textoAtual = desfazer(pilhaDesfazer, pilhaRefazer, textoAtual);
        System.out.println("Texto após múltiplos desfazer: " + textoAtual);

        System.out.println("Fila.java");
        Fila filaImpressao = new Fila(5);

        // Adiciona documentos na fila
        filaImpressao.enfileirar(new Documento("Documento1", 100));
        filaImpressao.enfileirar(new Documento("Documento2", 200));
        filaImpressao.enfileirar(new Documento("Documento3", 300));

        // Mostra a fila
        filaImpressao.mostrarFila();

        // Imprime os documentos
        System.out.println("Imprimindo documentos:");
        while (!filaImpressao.estaVazia()) {
            Documento doc = filaImpressao.desenfileirar();
            System.out.println("Imprimindo: " + doc.getNome() + " (" + doc.getTamanho() + " KB)");
        }

        // Mostra a fila após impressão
        filaImpressao.mostrarFila();
    }

    public static String inserirTexto(Pilhas pilhaDesfazer, Pilhas pilhaRefazer, String textoAtual, String novoTexto) {
        pilhaDesfazer.empilhar(textoAtual);
        pilhaRefazer = new Pilhas(10); // Limpa a pilha de refazer
        return textoAtual + novoTexto;
    }

    public static String desfazer(Pilhas pilhaDesfazer, Pilhas pilhaRefazer, String textoAtual) {
        if (!pilhaDesfazer.estaVazia()) {
            pilhaRefazer.empilhar(textoAtual);
            return pilhaDesfazer.desempilhar();
        }
        System.out.println("Nada para desfazer!");
        return textoAtual;
    }

    public static String refazer(Pilhas pilhaDesfazer, Pilhas pilhaRefazer, String textoAtual) {
        if (!pilhaRefazer.estaVazia()) {
            pilhaDesfazer.empilhar(textoAtual);
            return pilhaRefazer.desempilhar();
        }
        System.out.println("Nada para refazer!");
        return textoAtual;
    }
}