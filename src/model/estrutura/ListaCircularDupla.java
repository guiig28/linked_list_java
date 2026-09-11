package model.estrutura;

// import java.lang.Exception;
// import model.estrutura.NoDuplo;

public class ListaCircularDupla<T> {
    private NoDuplo<T> ultimo_elemento;
    private int total = 0;

    public void append(T elemento) {
        NoDuplo<T> novo = new NoDuplo<>(elemento);

        if (this.ultimo_elemento == null) {
            this.ultimo_elemento = novo;
            novo.setAnterior(novo);
            novo.setProximo(novo);
        } else {
            No<T> buffer_ultimo = this.ultimo_elemento;
            No<T> buffer_proximo = this.ultimo_elemento.getProximo();
            novo.setAnterior(buffer_ultimo);
            novo.setProximo(buffer_proximo);    
            buffer_proximo.setAnterior(novo);
            buffer_ultimo.setProximo(novo);
            this.ultimo_elemento = novo;
        }

        total++;
    }

    public NoDuplo<T> getLast() throws IllegalArgumentException {
        if (this.ultimo_elemento == null)
            throw new IllegalArgumentException("Não existe item na lista.");
        
        return this.ultimo_elemento;
    }

    public void remove(No<T> elemento) {
        No<T> anterior = elemento.getAnterior();
        No<T> proximo = elemento.getProximo();

        // se somente um elemento na lista: 
        if (this.ultimo_elemento == elemento && this.ultimo_elemento == elemento) {
            this.ultimo_elemento = null;
        } else {
            anterior.setProximo(proximo);
            proximo.setAnterior(anterior);

            if (this.ultimo_elemento == elemento) {
                this.ultimo_elemento == anterior;
            }

            elemento.setAnterior(null);
            elemento.setProximo(null);
            elemento.setValor(null);
        }

        total--;
    }

    public int total() {
        return this.total;
    }
}