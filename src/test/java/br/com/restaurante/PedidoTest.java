package br.com.restaurante;

import br.com.restaurante.domain.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private ItemCardapio criarPizza() {
        return new ItemCardapio("Pizza", CategoriaItem.PRATO_PRINCIPAL, new BigDecimal("45.00"));
    }

    @Test
    void deveCalcularSubtotalDoItemPedido() {
        ItemPedido itemPedido = new ItemPedido(criarPizza(), 2);

        assertEquals(new BigDecimal("90.00"), itemPedido.calcularSubtotal());
    }

    @Test
    void deveLancarExcecaoQuandoQuantidadeForInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new ItemPedido(criarPizza(), 0));
    }

    @Test
    void deveCriarPedidoComStatusAberto() {
        Pedido pedido = new Pedido(TipoPedido.BALCAO);

        assertEquals(StatusPedido.ABERTO, pedido.getStatus());
    }

    @Test
    void deveAdicionarItemAoPedido() {
        Pedido pedido = new Pedido(TipoPedido.BALCAO);

        pedido.adicionarItem(new ItemPedido(criarPizza(), 1));

        assertEquals(1, pedido.getItens().size());
    }

    @Test
    void deveCalcularTotalDoPedido() {
        Pedido pedido = new Pedido(TipoPedido.BALCAO);
        pedido.adicionarItem(new ItemPedido(criarPizza(), 2));

        assertEquals(new BigDecimal("90.00"), pedido.calcularTotal());
    }

    @Test
    void deveLancarExcecaoAoFecharPedidoSemItens() {
        Pedido pedido = new Pedido(TipoPedido.BALCAO);

        assertThrows(IllegalStateException.class, pedido::fechar);
    }

    @Test
    void deveLancarExcecaoAoAdicionarItemEmPedidoFechado() {
        Pedido pedido = new Pedido(TipoPedido.BALCAO);
        pedido.adicionarItem(new ItemPedido(criarPizza(), 1));
        pedido.fechar();

        assertThrows(IllegalStateException.class,
                () -> pedido.adicionarItem(new ItemPedido(criarPizza(), 1)));
    }
}
