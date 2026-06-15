package br.com.restaurante.servico;

import br.com.restaurante.dominio.Pedido;

/**
 * Dependência usada para enviar pedidos confirmados à cozinha.
 */
public interface ReceptorPedidoCozinha {

    /**
     * Recebe um pedido confirmado.
     *
     * @param pedido pedido enviado.
     */
    void receber(Pedido pedido);
}
