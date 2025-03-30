package estruturas;

public class Lista {

    public No inicio;

    public void List() {
        this.inicio = null;
    }

    public void adicionarAoInicio(int valor) {
        No no = new No(valor);

        if (this.inicio == null) {
            this.inicio = no;
            return;
        }

        this.inicio.anterior = no;

        no.proximo = this.inicio;
        this.inicio = no;
    }

    public void adicionarAoFinal(int dado) {
        No novoNo = new No(dado);
        if (this.inicio == null) {
            this.inicio = novoNo;
        } else {
            No atual = this.inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
            novoNo.anterior = atual;
        }
    }

    public void mostrarNos() {
        Iterador iterador = this.getIterador();
        
        while (iterador.getAtual() != null) {
            iterador.display();
        }
    }

    public void remover(int valor) {
        No noAux = this.inicio;

        while (noAux != null && noAux.dado != valor) {
            noAux = noAux.proximo;
        }

        if (noAux == null) {
            System.out.println("Valor não encontrado");
            return;
        }

        noAux.anterior.proximo = noAux.proximo;
        noAux.proximo.anterior = noAux.anterior;
    }

    public void inserirAposValor(int valor, int dado) {
        No atual = this.inicio;
        while (atual != null && atual.dado != valor) {
            atual = atual.proximo;
        }
        if (atual != null) {
            No novoNo = new No(dado);
            novoNo.proximo = atual.proximo;
            novoNo.anterior = atual;
            if (atual.proximo != null) {
                atual.proximo.anterior = novoNo;
            }
            atual.proximo = novoNo;
        }
    }

    public Iterador getIterador() {
        return new Iterador(this, this.inicio);
    }

    public int contarNos() {
        int contador = 0;
        No atual = this.inicio;
        while (atual != null) {
            contador++;
            atual = atual.proximo;
        }
        return contador;
    }

    public int tamanho() {
        return contarNos();
    }
}
