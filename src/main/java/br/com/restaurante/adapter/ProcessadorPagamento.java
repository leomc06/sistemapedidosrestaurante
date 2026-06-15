package br.com.restaurante.adapter;

import java.math.BigDecimal;

/**
 * Interface interna de pagamento usada pelo sistema.
 */
public interface ProcessadorPagamento {

    /**
     * Solicita o pagamento de um valor.
     *
     * @param valor valor em reais.
     * @return verdadeiro quando o pagamento é aprovado.
     */
    boolean pagar(BigDecimal valor);
}
