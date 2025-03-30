package estruturas;

public class Iterador {
    
    Lista lista;
    No atual;

    public Iterador(Lista lista, No atual) {
        this.lista = lista;
        this.atual = atual;
    }

    public Boolean Proximo() {
        return this.atual.proximo != null;
    }

    public Boolean Anterior() {
        return this.atual.anterior != null;
    }

    public void proximo() {
        this.atual = atual.proximo;
    }

    public int getDadoAnterior() {
        return this.atual.anterior.dado;
    }

    public int getDadoProximo() {
        return this.atual.proximo.dado;
    }

    public int getDado() {
        return this.atual.dado;
    }

    public No getAtual() {
        return this.atual;
    }

    public void resetar() {
        this.atual = this.lista.inicio;
    }

    public void display() {
        if (this.Anterior()) {
            System.out.print("Anterior -> " + this.getDadoAnterior() + " | ");
        }

        System.out.print("No " + this.getDado());
        
        if (this.Proximo()) {
            System.out.println(" | Proximo -> " + this.getDadoProximo());
        }
        System.out.println("");
        this.proximo();
    }

    public void inserirAposAtual(int dado) {
        No novoNo = new No(dado);
        novoNo.anterior = this.atual;
        novoNo.proximo = this.atual.proximo;

        if (this.atual.proximo != null) {
            this.atual.proximo.anterior = novoNo;
        }
        this.atual.proximo = novoNo;
    }

    public void inserirAntesAtual(int dado) {
        No novoNo = new No(dado);
        novoNo.proximo = this.atual;
        novoNo.anterior = this.atual.anterior;

        if (this.atual.anterior != null) {
            this.atual.anterior.proximo = novoNo;
        }
        this.atual.anterior = novoNo;

        if (this.atual == this.lista.inicio) {
            this.lista.inicio = novoNo;
        }
    }

    public void removerAposAtual() {
        if (this.atual.proximo != null) {
            No proximoNo = this.atual.proximo.proximo;
            if (proximoNo != null) {
                proximoNo.anterior = this.atual;
            }
            this.atual.proximo = proximoNo;
        }
    }

    public void removerAntesAtual() {
        if (this.atual.anterior != null) {
            No anteriorNo = this.atual.anterior.anterior;
            if (anteriorNo != null) {
                anteriorNo.proximo = this.atual;
            }
            this.atual.anterior = anteriorNo;

            if (this.atual.anterior == null) {
                this.lista.inicio = this.atual;
            }
        }
    }
}
