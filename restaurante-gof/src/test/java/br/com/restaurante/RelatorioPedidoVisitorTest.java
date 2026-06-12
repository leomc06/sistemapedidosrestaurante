package br.com.restaurante;

import br.com.restaurante.domain.*;
import br.com.restaurante.visitor.RelatorioPedidoVisitor;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RelatorioPedidoVisitorTest {

    @Test
    void deveGerarRelatorioDoPedidoComItens() {
        ItemCardapio pizza = new ItemCardapio("Pizza", CategoriaItem.PRATO_PRINCIPAL, new BigDecimal("45.00"));
        Pedido pedido = new Pedido(TipoPedido.DELIVERY);
        pedido.adicionarItem(new ItemPedido(pizza, 2));

        RelatorioPedidoVisitor visitor = new RelatorioPedidoVisitor();
        pedido.aceitar(visitor);

        String relatorio = visitor.getRelatorio();

        assertTrue(relatorio.contains("DELIVERY"));
        assertTrue(relatorio.contains("Pizza"));
        assertTrue(relatorio.contains("90.00"));
    }
}
