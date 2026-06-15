package br.com.restaurante.servico;

import br.com.restaurante.dominio.Mesa;
import br.com.restaurante.dominio.StatusPedido;
import java.math.BigDecimal;

/**
 * Calcula e fecha a conta da mesa.
 */
public class ContaService {

    /**
     * Calcula o total de pedidos confirmados ou em atendimento.
     *
     * @param mesa mesa consultada.
     * @return valor total.
     */
    public BigDecimal calcularTotal(Mesa mesa) {
        return mesa.getPedidos().stream()
                .filter(pedido -> pedido.getStatus() != StatusPedido.CANCELADO)
                .map(pedido -> pedido.calcularTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Fecha a conta e bloqueia a mesa até liberação manual.
     *
     * @param mesa mesa fechada.
     */
    public void fecharConta(Mesa mesa) {
        mesa.getPedidos().forEach(pedido -> pedido.atualizarStatus(StatusPedido.FECHADO));
        mesa.bloquear();
    }
}
