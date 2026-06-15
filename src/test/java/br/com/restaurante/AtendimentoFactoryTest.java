package br.com.restaurante;

import br.com.restaurante.domain.Pedido;
import br.com.restaurante.domain.TipoPedido;
import br.com.restaurante.factory.BalcaoFactory;
import br.com.restaurante.factory.DeliveryFactory;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AtendimentoFactoryTest {

    @Test
    void deveCalcularTaxaZeroParaPedidoBalcao() {
        Pedido pedido = new Pedido(TipoPedido.BALCAO);
        BalcaoFactory factory = new BalcaoFactory();

        assertEquals(BigDecimal.ZERO, factory.criarCalculadoraTaxa().calcularTaxa(pedido));
    }

    @Test
    void deveCalcularTaxaEntregaParaPedidoDelivery() {
        Pedido pedido = new Pedido(TipoPedido.DELIVERY);
        DeliveryFactory factory = new DeliveryFactory();

        assertEquals(new BigDecimal("8.00"), factory.criarCalculadoraTaxa().calcularTaxa(pedido));
    }
}
