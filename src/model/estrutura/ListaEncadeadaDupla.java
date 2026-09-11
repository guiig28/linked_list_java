package model.estrutura;

// import java.lang.Exception;
// import model.estrutura.NoDuplo;

public class ListaEncadeadaDupla<T> {
    private NoDuplo<T> inicio;
    private NoDuplo<T> fim;

    public void append(T elemento) {
        NoDuplo<T> buffer = new NoDuplo<>(elemento);

        if (this.fim == null) {
            this.fim = buffer;
            this.inicio = buffer;
        } else {
            NoDuplo<T> ex_ultimo = this.fim;
            ex_ultimo.setProximo(buffer);
            buffer.setAnterior(ex_ultimo);
            this.fim = buffer;
        }
    }

    public NoDuplo<T> get(int index) throws IllegalArgumentException {
        int i = 0;
        if (this.inicio == null)
            throw new IllegalArgumentException("Não existe item na lista.");

        NoDuplo<T> buffer = this.inicio;

        for (i = 0; i < index; i++) {
            if (buffer.getProximo() == null)
                break;

            buffer = buffer.getProximo();
        }

        if (i < index)
            throw new IllegalArgumentException("O índice informado não existe.");

        return buffer;
    }

}