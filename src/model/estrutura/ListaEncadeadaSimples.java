package model.estrutura;

import java.lang.Exception;
import model.estrutura.NoSimples;

public class ListaEncadeadaSimples<T> {
    private NoSimples<T> inicio = null; // rendundante

    public void append(T elemento) {
        NoSimples<T> buffer = new NoSimples<>(elemento);

        if (this.inicio == null) {
            this.inicio = buffer;
        } else {
            this.last().setProximo(buffer);
        }
    }

    public NoSimples<T> get(int index) throws IllegalArgumentException {
        int i = 0;
        if (this.inicio == null)
            throw new IllegalArgumentException("Não existe item na lista.");

        NoSimples<T> buffer = this.inicio;

        for (i = 0; i < index; i++) {
            if (buffer.getProximo() == null)
                break;

            buffer = buffer.getProximo();
        }

        if (i < index)
            throw new IllegalArgumentException("O índice informado não existe.");

        return buffer;
    }

    public int index(T elemento) throws IllegalArgumentException {
        if (this.inicio == null)
            throw new IllegalArgumentException("Não existe item na lista.");

        int index = 0;

        if (this.inicio.getValor() == elemento)
            return index;

        NoSimples<T> buffer = this.inicio;

        do {
            if (buffer.getValor() == elemento)
                return index;

            buffer = buffer.getProximo();
            index++;
        } while (buffer != null);
        throw new IllegalArgumentException("Item não encontrado.");
    }

    public NoSimples<T> last() throws IllegalArgumentException {
        if (this.inicio == null)
            throw new IllegalArgumentException("Não existe item na lista.");

        NoSimples<T> buffer = this.inicio;

        while (buffer.getProximo() != null)
            buffer.getProximo();

        return buffer;
    }

    public void remove(int index) {
        if (index == 0) {
            this.inicio.setValor(null); // apagando o valor do nó

            if (this.inicio.getProximo() == null) {
                this.inicio = null; // apagando o nó da lista
            } else {
                NoSimples<T> buffer = this.inicio.getProximo();
                this.inicio.setProximo(null); // apagando a referencia do nó
                this.inicio = buffer;
            }
        } else {
            NoSimples<T> buffer_anterior = this.get(index - 1);
            NoSimples<T> buffer_atual = buffer_anterior.getProximo();
            NoSimples<T> buffer_prox = buffer_atual.getProximo();

            buffer_anterior.setProximo(buffer_prox);
            buffer_atual.setProximo(null);
            buffer_atual.setValor(null);
        }
    }

    public int total() {
        if (this.inicio == null)
            return 0;

        NoSimples<T> buffer = this.inicio;
        int total_elementos = 0;

        do {
            total_elementos++;
            buffer = buffer.getProximo();
        } while (buffer != null);

        return total_elementos;
    }

    @Override
    public String toString() {
        if (this.inicio == null)
            return "[]";

        StringBuilder builder = new StringBuilder("[");
        NoSimples<T> buffer = this.inicio;
        builder.append(buffer.getValor());

        while (buffer.getProximo() != null) {
            builder.append(", ");
            buffer = buffer.getProximo();
            builder.append(buffer.getValor());
        }
        builder.append("]");

        return builder.toString();
    }
}