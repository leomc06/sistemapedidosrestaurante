package br.com.restaurante.factory;

import br.com.restaurante.domain.Pedido;
import java.math.BigDecimal;

/**
 * Define o contrato para calculo de taxas de um pedido.
 */
public interface CalculadoraTaxaPedido {

    /**
     * Calcula a taxa aplicada ao pedido.
     *
     * @param pedido pedido utilizado no calculo.
     * @return valor da taxa.
     */
    BigDecimal calcularTaxa(Pedido pedido);
}