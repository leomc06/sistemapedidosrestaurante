package br.com.restaurante.visitor;

import br.com.restaurante.dominio.ItemPedido;
import br.com.restaurante.dominio.Pedido;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Visitor que acumula dados simples para relatório gerencial.
 */
public class RelatorioPedidoVisitor implements PedidoVisitor {

    private final Map<String, Integer> quantidadePorItem = new HashMap<>();
    private BigDecimal faturamento = BigDecimal.ZERO;

    @Override
    public void visitar(Pedido pedido) {
        faturamento = faturamento.add(pedido.calcularTotal());
        for (ItemPedido itemPedido : pedido.getItens()) {
            quantidadePorItem.merge(itemPedido.getItemCardapio().getNome(), itemPedido.getQuantidade(), Integer::sum);
        }
    }

    public Map<String, Integer> getQuantidadePorItem() {
        return Map.copyOf(quantidadePorItem);
    }

    public BigDecimal getFaturamento() {
        return faturamento;
    }

    /**
     * Gera uma descrição simples do relatório.
     *
     * @return texto do relatório.
     */
    public String gerarTexto() {
        return "Itens: " + quantidadePorItem + " | Faturamento: " + faturamento;
    }
}
