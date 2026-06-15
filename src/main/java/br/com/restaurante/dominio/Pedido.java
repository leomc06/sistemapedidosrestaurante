package br.com.restaurante.dominio;

import br.com.restaurante.visitor.PedidoVisitor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Pedido feito por uma mesa do restaurante.
 */
public class Pedido {

    public static final BigDecimal VALOR_MINIMO = new BigDecimal("10.00");

    private final Mesa mesa;
    private final List<ItemPedido> itens = new ArrayList<>();
    private StatusPedido status = StatusPedido.ABERTO;

    /**
     * Cria um pedido para uma mesa.
     *
     * @param mesa mesa de origem.
     */
    public Pedido(Mesa mesa) {
        if (mesa == null) {
            throw new IllegalArgumentException("A mesa é obrigatória.");
        }
        this.mesa = mesa;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    /**
     * Adiciona um item antes da confirmação do pedido.
     *
     * @param itemPedido item escolhido.
     */
    public void adicionarItem(ItemPedido itemPedido) {
        if (status != StatusPedido.ABERTO) {
            throw new IllegalStateException("Somente pedidos abertos podem receber itens.");
        }
        if (itemPedido == null) {
            throw new IllegalArgumentException("O item do pedido é obrigatório.");
        }
        itens.add(itemPedido);
    }

    /**
     * Calcula o valor total do pedido.
     *
     * @return soma dos subtotais.
     */
    public BigDecimal calcularTotal() {
        return itens.stream()
                .map(ItemPedido::calcularSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Confirma o pedido e aplica a regra de valor mínimo.
     */
    public void confirmar() {
        if (itens.isEmpty()) {
            throw new IllegalStateException("Não é possível confirmar pedido sem itens.");
        }
        if (calcularTotal().compareTo(VALOR_MINIMO) < 0) {
            throw new IllegalStateException("O pedido mínimo é de R$ 10,00.");
        }
        status = StatusPedido.CONFIRMADO;
    }

    /**
     * Altera o status operacional do pedido.
     *
     * @param novoStatus novo status.
     */
    public void atualizarStatus(StatusPedido novoStatus) {
        if (novoStatus == null) {
            throw new IllegalArgumentException("O status é obrigatório.");
        }
        status = novoStatus;
    }

    /**
     * Recebe um Visitor para operações de relatório.
     *
     * @param visitor operação aplicada ao pedido.
     */
    public void aceitar(PedidoVisitor visitor) {
        visitor.visitar(this);
    }
}
