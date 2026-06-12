package br.com.restaurante.factory;

/**
 * Abstract Factory responsavel por criar familias de objetos
 * relacionadas ao tipo de atendimento do restaurante.
 */
public interface AtendimentoFactory {

    /**
     * Cria a calculadora de taxa adequada ao atendimento.
     *
     * @return calculadora de taxa.
     */
    CalculadoraTaxaPedido criarCalculadoraTaxa();

    /**
     * Cria o gerador de resumo adequado ao atendimento.
     *
     * @return gerador de resumo.
     */
    ResumoPedido criarResumoPedido();
}