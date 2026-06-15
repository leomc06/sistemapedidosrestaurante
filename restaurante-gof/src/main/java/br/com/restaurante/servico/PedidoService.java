package br.com.restaurante.servico;

import br.com.restaurante.dominio.Pedido;

/**
 * Coordena a confirmação do pedido do cliente.
 */
public class PedidoService {

    private final ReceptorPedidoCozinha receptorPedidoCozinha;

    /**
     * Cria o serviço.
     *
     * @param receptorPedidoCozinha destino do pedido confirmado.
     */
    public PedidoService(ReceptorPedidoCozinha receptorPedidoCozinha) {
        this.receptorPedidoCozinha = receptorPedidoCozinha;
    }

    /**
     * Confirma o pedido e envia para a cozinha.
     *
     * @param pedido pedido revisado pelo cliente.
     */
    public void confirmar(Pedido pedido) {
        pedido.confirmar();
        pedido.getMesa().registrarPedido(pedido);
        receptorPedidoCozinha.receber(pedido);
    }
}
