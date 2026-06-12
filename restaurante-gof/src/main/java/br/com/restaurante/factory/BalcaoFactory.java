package br.com.restaurante.factory;

import br.com.restaurante.domain.Pedido;
import java.math.BigDecimal;

/**
 * Fabrica concreta para pedidos de balcao.
 */
public class BalcaoFactory implements AtendimentoFactory {

    @Override
    public CalculadoraTaxaPedido criarCalculadoraTaxa() {
        return pedido -> BigDecimal.ZERO;
    }

    @Override
    public ResumoPedido criarResumoPedido() {
        return new ResumoPedido() {
            @Override
            public String gerar(Pedido pedido) {
                return "Pedido de balcao - total: R$ " + pedido.calcularTotal();
            }
        };
    }
}