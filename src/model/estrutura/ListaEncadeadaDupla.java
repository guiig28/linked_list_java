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

    public int index(T elemento) throws IllegalArgumentException {
        if (this.inicio == null)
            throw new IllegalArgumentException("Não existe item na lista.")

        int index = 0;

        if (this.inicio.getValor() == elemento) 
            return index;
        
        NoDuplo<T> buffer = this.inicio;

        do {
            buffer = buffer.getProximo();
            index++;

            if (buffer.getValor == elemento) 
                return index;

        } while (buffer != null);

        throw new IllegalArgumentException("Item não encontrado.")
    }

    public void insert(int index, T elemento) throws IllegalArgumentException {
        if (index == 0) {
            NoDuplo<T> novo = new NoDuplo<>(elemento);

            if (this.inicio == null) {
                this.inicio = novo; 
                this.fim = novo;
            } else {
                NoDuplo<T> ex_inicio = this.inicio;
                novo.setProximo(ex_inicio);
                this.inicio = novo;
                ex_inicio.setAnterior(novo);
            }
        } else {
            this.insert(this.get(--index), elemento);
        }
    } 

    public void insert(NoDuplo<T> item, elemento) throws IllegalArgumentException {
        NoDuplo<T> novo = new NoDuplo(elemento);
        NoDuplo<T> proximo = item.getProximo();

        
        item.setProximo(novo);
        novo.setAnterior(item);
        novo.setProximo(proximo);
        proximo.setAnterior(novo);

        // item <> novo <> proximo
        
    }

}