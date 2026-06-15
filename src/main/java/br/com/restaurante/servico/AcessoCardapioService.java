package br.com.restaurante.servico;

import br.com.restaurante.dominio.ItemCardapio;
import br.com.restaurante.dominio.Mesa;
import java.util.List;

/**
 * Simula o acesso ao cardápio por QR Code da mesa.
 */
public class AcessoCardapioService {

    private final CardapioService cardapioService;

    /**
     * Cria o serviço de acesso.
     *
     * @param cardapioService serviço de cardápio.
     */
    public AcessoCardapioService(CardapioService cardapioService) {
        this.cardapioService = cardapioService;
    }

    /**
     * Lê um QR Code no formato MESA-1 e devolve o cardápio.
     *
     * @param codigoQr código fixado na mesa.
     * @param mesa mesa esperada.
     * @return itens disponíveis.
     */
    public List<ItemCardapio> acessarPorQrCode(String codigoQr, Mesa mesa) {
        String esperado = "MESA-" + mesa.getNumero();
        if (!esperado.equalsIgnoreCase(codigoQr)) {
            throw new IllegalArgumentException("QR Code inválido para a mesa.");
        }
        return cardapioService.listarDisponiveis();
    }
}
