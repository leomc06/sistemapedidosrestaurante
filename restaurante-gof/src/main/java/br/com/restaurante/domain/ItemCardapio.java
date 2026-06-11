package br.com.restaurante.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Representa um item disponivel no cardapio do restaurante.
 */
public class ItemCardapio {

    private final String nome;
    private final CategoriaItem categoria;
    private final BigDecimal preco;

    /**
     * Cria um item de cardapio.
     *
     * @param nome nome do item.
     * @param categoria categoria do item.
     * @param preco preco unitario do item.
     */
    public ItemCardapio(String nome, CategoriaItem categoria, BigDecimal preco) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do item e obrigatorio.");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("A categoria do item e obrigatoria.");
        }
        if (preco == null || preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O preco do item deve ser maior que zero.");
        }

        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaItem getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ItemCardapio)) {
            return false;
        }
        ItemCardapio that = (ItemCardapio) object;
        return Objects.equals(nome, that.nome)
                && categoria == that.categoria
                && Objects.equals(preco, that.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, categoria, preco);
    }
}