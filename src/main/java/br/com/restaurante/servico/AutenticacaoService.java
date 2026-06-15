package br.com.restaurante.servico;

import br.com.restaurante.dominio.Funcionario;
import java.util.HashMap;
import java.util.Map;

/**
 * Autentica funcionários para acesso aos painéis internos.
 */
public class AutenticacaoService {

    private final Map<String, Funcionario> funcionarios = new HashMap<>();

    /**
     * Cadastra um funcionário autorizado.
     *
     * @param funcionario funcionário autorizado.
     */
    public void cadastrar(Funcionario funcionario) {
        funcionarios.put(funcionario.getLogin(), funcionario);
    }

    /**
     * Valida login e senha.
     *
     * @param login login informado.
     * @param senha senha informada.
     * @return verdadeiro quando as credenciais conferem.
     */
    public boolean autenticar(String login, String senha) {
        Funcionario funcionario = funcionarios.get(login);
        return funcionario != null && funcionario.getSenha().equals(senha);
    }
}
