package br.com.restaurante.factory;

import br.com.restaurante.domain.Pedido;

/**
 * Define o contrato para geracao de resumo de pedido.
 */
public interface ResumoPedido {

    /**
     * Gera uma descricao resumida do pedido.
     *
     * @param pedido pedido que sera resumido.
     * @return texto resumido do pedido.
     */
    String gerar(Pedido pedido);
}