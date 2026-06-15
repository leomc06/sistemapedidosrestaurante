package br.com.restaurante.factory;

import java.math.BigDecimal;

/**
 * Fábrica para atendimento no balcão, sem taxa adicional.
 */
public class BalcaoFactory implements AtendimentoFactory {

    @Override
    public CalculadoraTaxa criarCalculadoraTaxa() {
        return pedido -> BigDecimal.ZERO;
    }
}
