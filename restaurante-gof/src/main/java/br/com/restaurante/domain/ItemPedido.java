package br.com.restaurante.domain;

import java.math.BigDecimal;

/**
 * Representa um item incluido em um pedido.
 */
public class ItemPedido {

    private final ItemCardapio itemCardapio;
    private final int quantidade;

    /**
     * Cria um item de pedido.
     *
     * @param itemCardapio item selecionado do cardapio.
     * @param quantidade quantidade solicitada.
     */
    public ItemPedido(ItemCardapio itemCardapio, int quantidade) {
        if (itemCardapio == null) {
            throw new IllegalArgumentException("O item do cardapio e obrigatorio.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }

        this.itemCardapio = itemCardapio;
        this.quantidade = quantidade;
    }

    public ItemCardapio getItemCardapio() {
        return itemCardapio;
    }

    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Calcula o subtotal do item no pedido.
     *
     * @return preco unitario multiplicado pela quantidade.
     */
    public BigDecimal calcularSubtotal() {
        return itemCardapio.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }
}
