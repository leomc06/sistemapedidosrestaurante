package br.com.restaurante.servico;

import br.com.restaurante.dominio.ItemCardapio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Mantém o cardápio usado pelo cliente e pelo gerente.
 */
public class CardapioService {

    private final List<ItemCardapio> itens = new ArrayList<>();

    /**
     * Adiciona um item ao cardápio.
     *
     * @param item item cadastrado pelo gerente.
     */
    public void adicionar(ItemCardapio item) {
        if (item == null) {
            throw new IllegalArgumentException("O item é obrigatório.");
        }
        itens.add(item);
    }

    /**
     * Lista somente itens disponíveis ao cliente.
     *
     * @return itens disponíveis.
     */
    public List<ItemCardapio> listarDisponiveis() {
        return itens.stream().filter(ItemCardapio::isDisponivel).toList();
    }

    /**
     * Lista todos os itens para manutenção do gerente.
     *
     * @return cópia imutável do cardápio.
     */
    public List<ItemCardapio> listarTodos() {
        return Collections.unmodifiableList(itens);
    }

    /**
     * Remove um item pelo nome.
     *
     * @param nome nome do item removido.
     */
    public void remover(String nome) {
        itens.removeIf(item -> item.getNome().equalsIgnoreCase(nome));
    }
}
