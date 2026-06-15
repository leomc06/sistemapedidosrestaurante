package br.com.restaurante.adapter;

/**
 * Dependência externa simulada para autorizar cobranças.
 */
public interface SistemaPagamentoExterno {

    /**
     * Autoriza uma cobrança usando centavos.
     *
     * @param valorEmCentavos valor convertido.
     * @return texto retornado pelo serviço externo.
     */
    String autorizarCobranca(int valorEmCentavos);
}
