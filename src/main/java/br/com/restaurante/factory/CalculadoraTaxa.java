package br.com.restaurante.factory;

import br.com.restaurante.dominio.Pedido;
import java.math.BigDecimal;

/**
 * Produto da Abstract Factory responsável por calcular taxas do atendimento.
 */
public interface CalculadoraTaxa {

    /**
     * Calcula a taxa do pedido.
     *
     * @param pedido pedido analisado.
     * @return valor da taxa.
     */
    BigDecimal calcular(Pedido pedido);
}
