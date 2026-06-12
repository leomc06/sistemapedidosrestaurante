package br.com.restaurante.adapter;

import java.math.BigDecimal;

/**
 * Adapter que permite usar o sistema externo de pagamento
 * por meio da interface interna GatewayPagamento.
 */
public class PagamentoExternoAdapter implements GatewayPagamento {

    private final SistemaPagamentoExterno sistemaPagamentoExterno;

    /**
     * Cria o adapter de pagamento.
     *
     * @param sistemaPagamentoExterno dependencia externa adaptada.
     */
    public PagamentoExternoAdapter(SistemaPagamentoExterno sistemaPagamentoExterno) {
        if (sistemaPagamentoExterno == null) {
            throw new IllegalArgumentException("O sistema externo e obrigatorio.");
        }

        this.sistemaPagamentoExterno = sistemaPagamentoExterno;
    }

    @Override
    public boolean pagar(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do pagamento deve ser maior que zero.");
        }

        int valorEmCentavos = valor.multiply(new BigDecimal("100")).intValue();
        String resultado = sistemaPagamentoExterno.autorizarCobranca(valorEmCentavos);

        return "APROVADO".equals(resultado);
    }
}