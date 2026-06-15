package br.com.restaurante.factory;

import java.math.BigDecimal;

/**
 * Fábrica para atendimento delivery, com taxa fixa de entrega.
 */
public class DeliveryFactory implements AtendimentoFactory {

    @Override
    public CalculadoraTaxa criarCalculadoraTaxa() {
        return pedido -> new BigDecimal("8.00");
    }
}
