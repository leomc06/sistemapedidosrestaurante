package br.com.restaurante.adapter;

import java.math.BigDecimal;

/**
 * Interface interna usada pelo sistema para processar pagamentos.
 */
public interface GatewayPagamento {

    /**
     * Realiza o pagamento de um valor.
     *
     * @param valor valor a ser pago.
     * @return true se o pagamento foi aprovado.
     */
    boolean pagar(BigDecimal valor);
}