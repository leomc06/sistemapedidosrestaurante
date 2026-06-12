package br.com.restaurante.adapter;

/**
 * Simula uma biblioteca externa de pagamento com interface incompativel
 * com o restante do sistema.
 */
public class SistemaPagamentoExterno {

    /**
     * Autoriza uma cobranca usando valor em centavos.
     *
     * @param valorEmCentavos valor da cobranca em centavos.
     * @return codigo de autorizacao.
     */
    public String autorizarCobranca(int valorEmCentavos) {
        if (valorEmCentavos <= 0) {
            return "NEGADO";
        }

        return "APROVADO";
    }
}