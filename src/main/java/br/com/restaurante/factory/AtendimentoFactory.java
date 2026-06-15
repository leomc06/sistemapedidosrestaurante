package br.com.restaurante.factory;

/**
 * Abstract Factory para criar objetos ligados a um tipo de atendimento.
 */
public interface AtendimentoFactory {

    /**
     * Cria a calculadora de taxa adequada ao atendimento.
     *
     * @return calculadora de taxa.
     */
    CalculadoraTaxa criarCalculadoraTaxa();
}
