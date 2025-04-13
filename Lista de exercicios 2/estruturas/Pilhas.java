package estruturas;

public class Pilhas {
    private String[] elementos;
    private int topo;
    private int capacidade;

    public Pilhas(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new String[capacidade];
        this.topo = -1;
    }

    public void empilhar(String elemento) {
        if (topo == capacidade - 1) {
            System.out.println("Pilha cheia!");
            return;
        }
        elementos[++topo] = elemento;
    }

    public String desempilhar() {
        if (estaVazia()) {
            System.out.println("Pilha vazia!");
            return null;
        }
        return elementos[topo--];
    }

    public boolean estaVazia() {
        return topo == -1;
    }
}
