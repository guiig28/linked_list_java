package model.estrutura;

public class NoSimples<T> {
    private T valor;
    private NoSimples<T> proximo;

    // construtor
    public NoSimples(T valor) {
        this.proximo = null; // redundante
        this.valor = valor;
    }

    public NoSimples(T valor, NoSimples<T> proximo) {
        this.valor = valor;
        this.proximo = proximo;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoSimples<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoSimples<T> proximo) {
        this.proximo = proximo;
    }

    @Override // para reescrever metodos da superclasse
    public String toString() {
        return valor.toString();
    }
}