package br.com.restaurante;

import br.com.restaurante.domain.CategoriaItem;
import br.com.restaurante.domain.ItemCardapio;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemCardapioTest {

    @Test
    void deveCriarItemCardapioValido() {
        ItemCardapio item = new ItemCardapio("Pizza", CategoriaItem.PRATO_PRINCIPAL, new BigDecimal("45.00"));

        assertEquals("Pizza", item.getNome());
        assertEquals(CategoriaItem.PRATO_PRINCIPAL, item.getCategoria());
        assertEquals(new BigDecimal("45.00"), item.getPreco());
    }

    @Test
    void deveLancarExcecaoQuandoNomeForVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> new ItemCardapio("", CategoriaItem.BEBIDA, new BigDecimal("8.00")));
    }

    @Test
    void deveLancarExcecaoQuandoPrecoForZero() {
        assertThrows(IllegalArgumentException.class,
                () -> new ItemCardapio("Suco", CategoriaItem.BEBIDA, BigDecimal.ZERO));
    }
}
