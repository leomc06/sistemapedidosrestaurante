package br.com.restaurante.visitor;

import br.com.restaurante.dominio.Pedido;

/**
 * Visitor aplicado sobre pedidos para operações de relatório.
 */
public interface PedidoVisitor {

    /**
     * Visita um pedido.
     *
     * @param pedido pedido visitado.
     */
    void visitar(Pedido pedido);
}
