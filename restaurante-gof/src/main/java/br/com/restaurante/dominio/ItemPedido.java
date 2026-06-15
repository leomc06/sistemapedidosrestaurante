package br.com.restaurante.dominio;

import java.math.BigDecimal;

/**
 * Item escolhido pelo cliente antes de confirmar o pedido.
 */
public class ItemPedido {

    private final ItemCardapio itemCardapio;
    private final int quantidade;

    /**
     * Cria um item de pedido.
     *
     * @param itemCardapio item selecionado no cardápio.
     * @param quantidade quantidade solicitada.
     */
    public ItemPedido(ItemCardapio itemCardapio, int quantidade) {
        if (itemCardapio == null) {
            throw new IllegalArgumentException("O item do cardápio é obrigatório.");
        }
        if (!itemCardapio.isDisponivel()) {
            throw new IllegalArgumentException("O item precisa estar disponível.");
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
     * Calcula o subtotal do item.
     *
     * @return preço unitário multiplicado pela quantidade.
     */
    public BigDecimal calcularSubtotal() {
        return itemCardapio.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }
}
