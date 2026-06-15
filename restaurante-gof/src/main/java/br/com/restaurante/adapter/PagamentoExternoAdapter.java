package br.com.restaurante.adapter;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Adapter que converte o pagamento interno para o formato do serviço externo.
 */
public class PagamentoExternoAdapter implements ProcessadorPagamento {

    private final SistemaPagamentoExterno sistemaPagamentoExterno;

    /**
     * Cria o adaptador.
     *
     * @param sistemaPagamentoExterno sistema externo simulado.
     */
    public PagamentoExternoAdapter(SistemaPagamentoExterno sistemaPagamentoExterno) {
        this.sistemaPagamentoExterno = sistemaPagamentoExterno;
    }

    @Override
    public boolean pagar(BigDecimal valor) {
        int centavos = valor.multiply(new BigDecimal("100"))
                .setScale(0, RoundingMode.HALF_UP)
                .intValueExact();
        return "APROVADO".equalsIgnoreCase(sistemaPagamentoExterno.autorizarCobranca(centavos));
    }
}
