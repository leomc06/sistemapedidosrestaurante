package br.com.restaurante.servico;

/**
 * Protótipo simples para regras não funcionais verificáveis em teste.
 */
public class MonitorQualidadeService {

    /**
     * Verifica se uma operação ficou dentro do limite de três segundos.
     *
     * @param tempoEmMilissegundos duração medida.
     * @return verdadeiro se o tempo atende ao requisito.
     */
    public boolean respostaAteTresSegundos(long tempoEmMilissegundos) {
        return tempoEmMilissegundos <= 3000;
    }

    /**
     * Representa a verificação de layout mobile no protótipo sem interface real.
     *
     * @param larguraTela largura simulada da tela.
     * @return verdadeiro quando a largura é compatível com celular.
     */
    public boolean interfaceMobileAceita(int larguraTela) {
        return larguraTela >= 320 && larguraTela <= 480;
    }

    /**
     * Verifica a meta de disponibilidade.
     *
     * @param percentualDisponibilidade percentual medido.
     * @return verdadeiro quando atinge pelo menos 99%.
     */
    public boolean disponibilidadeMinima(double percentualDisponibilidade) {
        return percentualDisponibilidade >= 99.0;
    }
}
