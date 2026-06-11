package br.com.restaurante.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa um pedido realizado no restaurante.
 */
public class Pedido {

    private final TipoPedido tipoPedido;
    private final List<ItemPedido> itens;
    private StatusPedido status;

    /**
     * Cria um pedido.
     *
     * @param tipoPedido tipo de atendimento do pedido.
     */
    public Pedido(TipoPedido tipoPedido) {
        if (tipoPedido == null) {
            throw new IllegalArgumentException("O tipo do pedido e obrigatorio.");
        }

        this.tipoPedido = tipoPedido;
        this.status = StatusPedido.ABERTO;
        this.itens = new ArrayList<>();
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    /**
     * Adiciona um item ao pedido.
     *
     * @param itemPedido item que sera adicionado.
     */
    public void adicionarItem(ItemPedido itemPedido) {
        if (status != StatusPedido.ABERTO) {
            throw new IllegalStateException("Somente pedidos abertos podem receber itens.");
        }
        if (itemPedido == null) {
            throw new IllegalArgumentException("O item do pedido e obrigatorio.");
        }

        itens.add(itemPedido);
    }

    /**
     * Calcula o valor total do pedido.
     *
     * @return soma dos subtotais dos itens.
     */
    public BigDecimal calcularTotal() {
        return itens.stream()
                .map(ItemPedido::calcularSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Fecha o pedido para impedir novas alteracoes.
     */
    public void fechar() {
        if (itens.isEmpty()) {
            throw new IllegalStateException("Nao e possivel fechar um pedido sem itens.");
        }

        status = StatusPedido.FECHADO;
    }

    /**
     * Cancela o pedido.
     */
    public void cancelar() {
        status = StatusPedido.CANCELADO;
    }
}