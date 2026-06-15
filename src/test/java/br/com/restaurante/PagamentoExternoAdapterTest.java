package br.com.restaurante;

import br.com.restaurante.adapter.PagamentoExternoAdapter;
import br.com.restaurante.adapter.SistemaPagamentoExterno;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PagamentoExternoAdapterTest {

    @Test
    void deveAprovarPagamentoUsandoStub() {
        SistemaPagamentoExterno stub = new SistemaPagamentoExterno() {
            @Override
            public String autorizarCobranca(int valorEmCentavos) {
                return "APROVADO";
            }
        };

        PagamentoExternoAdapter adapter = new PagamentoExternoAdapter(stub);

        assertTrue(adapter.pagar(new BigDecimal("50.00")));
    }

    @Test
    void deveNegarPagamentoUsandoStub() {
        SistemaPagamentoExterno stub = new SistemaPagamentoExterno() {
            @Override
            public String autorizarCobranca(int valorEmCentavos) {
                return "NEGADO";
            }
        };

        PagamentoExternoAdapter adapter = new PagamentoExternoAdapter(stub);

        assertFalse(adapter.pagar(new BigDecimal("50.00")));
    }

    @Test
    void deveConverterValorParaCentavosUsandoMockito() {
        SistemaPagamentoExterno mock = mock(SistemaPagamentoExterno.class);
        when(mock.autorizarCobranca(4550)).thenReturn("APROVADO");

        PagamentoExternoAdapter adapter = new PagamentoExternoAdapter(mock);

        assertTrue(adapter.pagar(new BigDecimal("45.50")));
        verify(mock).autorizarCobranca(4550);
    }
}
