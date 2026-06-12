package br.com.restaurante.visitor;

/**
 * Define que uma classe pode receber um visitante.
 */
public interface ElementoPedido {

    /**
     * Aceita a visita de um visitor.
     *
     * @param visitor visitor que executara uma operacao.
     */
    void aceitar(PedidoVisitor visitor);
}