package br.com.restaurante.servico;

import br.com.restaurante.dominio.Pedido;
import br.com.restaurante.dominio.StatusPedido;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Painel que acompanha os pedidos ativos da cozinha.
 */
public class PainelCozinhaService implements ReceptorPedidoCozinha {

    public static final int LIMITE_PEDIDOS_ATIVOS = 20;

    private final List<Pedido> pedidosAtivos = new ArrayList<>();

    @Override
    public void receber(Pedido pedido) {
        if (pedidosAtivos.size() >= LIMITE_PEDIDOS_ATIVOS) {
            throw new IllegalStateException("O painel da cozinha atingiu o limite de pedidos.");
        }
        pedidosAtivos.add(pedido);
    }

    /**
     * Atualiza o status e arquiva pedidos entregues.
     *
     * @param pedido pedido alterado.
     * @param status novo status.
     */
    public void atualizarStatus(Pedido pedido, StatusPedido status) {
        pedido.atualizarStatus(status);
        if (status == StatusPedido.ENTREGUE) {
            pedidosAtivos.remove(pedido);
        }
    }

    /**
     * Lista os pedidos ainda visíveis no painel.
     *
     * @return pedidos ativos.
     */
    public List<Pedido> listarPedidosAtivos() {
        return Collections.unmodifiableList(pedidosAtivos);
    }
}
