package br.com.restaurante.visitor;

import br.com.restaurante.domain.ItemPedido;
import br.com.restaurante.domain.Pedido;

/**
 * Visitor para executar operacoes sobre elementos de pedido.
 */
public interface PedidoVisitor {

    /**
     * Visita um pedido.
     *
     * @param pedido pedido visitado.
     */
    void visitar(Pedido pedido);

    /**
     * Visita um item de pedido.
     *
     * @param itemPedido item visitado.
     */
    void visitar(ItemPedido itemPedido);
}