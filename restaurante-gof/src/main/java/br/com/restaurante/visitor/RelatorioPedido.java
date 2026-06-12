package br.com.restaurante.visitor;

import br.com.restaurante.domain.ItemPedido;
import br.com.restaurante.domain.Pedido;

/**
 * Visitor responsavel por montar um relatorio textual do pedido.
 */
public class RelatorioPedidoVisitor implements PedidoVisitor {

    private final StringBuilder relatorio = new StringBuilder();

    @Override
    public void visitar(Pedido pedido) {
        relatorio.append("Pedido: ")
                .append(pedido.getTipoPedido())
                .append(" | Status: ")
                .append(pedido.getStatus())
                .append(System.lineSeparator());
    }

    @Override
    public void visitar(ItemPedido itemPedido) {
        relatorio.append("- ")
                .append(itemPedido.getQuantidade())
                .append("x ")
                .append(itemPedido.getItemCardapio().getNome())
                .append(" = R$ ")
                .append(itemPedido.calcularSubtotal())
                .append(System.lineSeparator());
    }

    /**
     * Retorna o relatorio gerado.
     *
     * @return relatorio em texto.
     */
    public String getRelatorio() {
        return relatorio.toString();
    }
}