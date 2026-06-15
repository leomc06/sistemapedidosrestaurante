package br.com.restaurante.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Mesa física do restaurante, acessada por QR Code.
 */
public class Mesa {

    private final int numero;
    private final List<Pedido> pedidos = new ArrayList<>();
    private boolean bloqueada;

    /**
     * Cria uma mesa.
     *
     * @param numero número da mesa.
     */
    public Mesa(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("O número da mesa deve ser maior que zero.");
        }
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(pedidos);
    }

    /**
     * Registra um pedido na mesa.
     *
     * @param pedido pedido confirmado.
     */
    public void registrarPedido(Pedido pedido) {
        if (bloqueada) {
            throw new IllegalStateException("A mesa está bloqueada.");
        }
        pedidos.add(pedido);
    }

    /**
     * Bloqueia a mesa após o fechamento da conta.
     */
    public void bloquear() {
        this.bloqueada = true;
    }

    /**
     * Libera a mesa manualmente para novos clientes.
     */
    public void liberar() {
        pedidos.clear();
        this.bloqueada = false;
    }
}
