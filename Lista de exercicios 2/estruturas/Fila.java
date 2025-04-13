package estruturas;

public class Fila {
    private Documento[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new Documento[capacidade];
        this.inicio = 0;
        this.fim = -1;
        this.tamanho = 0;
    }

    public void enfileirar(Documento documento) {
        if (tamanho == capacidade) {
            System.out.println("Fila cheia!");
            return;
        }
        fim = (fim + 1) % capacidade;
        elementos[fim] = documento;
        tamanho++;
    }

    public Documento desenfileirar() {
        if (estaVazia()) {
            System.out.println("Fila vazia!");
            return null;
        }
        Documento documento = elementos[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return documento;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public void mostrarFila() {
        System.out.println("Documentos na fila:");
        for (int i = 0; i < tamanho; i++) {
            int index = (inicio + i) % capacidade;
            System.out.println(elementos[index].getNome() + " (" + elementos[index].getTamanho() + " KB)");
        }
    }
}