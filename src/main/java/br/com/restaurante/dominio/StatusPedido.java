package br.com.restaurante.dominio;

/**
 * Estados possíveis de um pedido dentro do restaurante.
 */
public enum StatusPedido {
    ABERTO,
    CONFIRMADO,
    EM_PREPARO,
    PRONTO,
    ENTREGUE,
    FECHADO,
    CANCELADO
}
