package br.com.restaurante.servico;

import br.com.restaurante.dominio.Mesa;
import br.com.restaurante.dominio.Pedido;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Monta a visão usada pelo garçom para acompanhar mesas.
 */
public class GarcomService {

    /**
     * Agrupa pedidos por número de mesa.
     *
     * @param mesas mesas acompanhadas.
     * @return mapa de mesa para pedidos.
     */
    public Map<Integer, List<Pedido>> visualizarPedidosPorMesa(List<Mesa> mesas) {
        return mesas.stream().collect(Collectors.toMap(Mesa::getNumero, Mesa::getPedidos));
    }
}
