package model.estrutura;

public class NoDuplo<T> {
    private T valor;
    private NoDuplo<T> anterior;
    private NoDuplo<T> proximo;

    // construtor
    public NoDuplo(T valor) {
        this.anterior = null;
        this.proximo = null;
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoDuplo<T> getAnterior() {
        return this.anterior;
    }

    public void setAnterior(NoDuplo<T> anterior) {
        this.anterior = anterior;
    }

    public NoDuplo<T> getProximo() {
        return this.proximo;
    }

    public void setProximo(NoDuplo<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return this.valor.toString();
    }
}