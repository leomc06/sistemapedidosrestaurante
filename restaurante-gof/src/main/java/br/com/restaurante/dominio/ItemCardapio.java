package br.com.restaurante.dominio;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Representa um item exibido no cardápio digital.
 */
public class ItemCardapio {

    private final String nome;
    private final String descricao;
    private final String foto;
    private final CategoriaItem categoria;
    private BigDecimal preco;
    private boolean disponivel;

    /**
     * Cria um item do cardápio.
     *
     * @param nome nome do item.
     * @param descricao descrição simples do item.
     * @param foto referência da foto exibida no cardápio.
     * @param categoria categoria do item.
     * @param preco preço unitário.
     * @param disponivel indica se o item pode ser pedido.
     */
    public ItemCardapio(String nome, String descricao, String foto, CategoriaItem categoria,
            BigDecimal preco, boolean disponivel) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do item é obrigatório.");
        }
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descrição do item é obrigatória.");
        }
        if (foto == null || foto.isBlank()) {
            throw new IllegalArgumentException("A foto do item é obrigatória.");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("A categoria do item é obrigatória.");
        }
        validarPreco(preco);
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
        this.categoria = categoria;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFoto() {
        return foto;
    }

    public CategoriaItem getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    /**
     * Atualiza dados controlados pelo gerente.
     *
     * @param novoPreco novo preço do item.
     * @param disponivel nova disponibilidade.
     */
    public void atualizar(BigDecimal novoPreco, boolean disponivel) {
        validarPreco(novoPreco);
        this.preco = novoPreco;
        this.disponivel = disponivel;
    }

    private void validarPreco(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (!(objeto instanceof ItemCardapio outro)) {
            return false;
        }
        return Objects.equals(nome, outro.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
