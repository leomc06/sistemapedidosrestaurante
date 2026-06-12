package br.com.restaurante.factory;

import br.com.restaurante.domain.Pedido;
import java.math.BigDecimal;

/**
 * Fabrica concreta para pedidos de delivery.
 */
public class DeliveryFactory implements AtendimentoFactory {

    private static final BigDecimal TAXA_ENTREGA = new BigDecimal("8.00");

    @Override
    public CalculadoraTaxaPedido criarCalculadoraTaxa() {
        return pedido -> TAXA_ENTREGA;
    }

    @Override
    public ResumoPedido criarResumoPedido() {
        return new ResumoPedido() {
            @Override
            public String gerar(Pedido pedido) {
                return "Pedido delivery - total: R$ "
                        + pedido.calcularTotal().add(TAXA_ENTREGA);
            }
        };
    }
}