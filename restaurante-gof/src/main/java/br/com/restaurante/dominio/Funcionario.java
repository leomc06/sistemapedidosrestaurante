package br.com.restaurante.dominio;

/**
 * Funcionário autorizado a acessar painéis internos.
 */
public class Funcionario {

    private final String login;
    private final String senha;
    private final PerfilFuncionario perfil;

    /**
     * Cria um funcionário.
     *
     * @param login login de acesso.
     * @param senha senha de acesso.
     * @param perfil perfil operacional.
     */
    public Funcionario(String login, String senha, PerfilFuncionario perfil) {
        if (login == null || login.isBlank() || senha == null || senha.isBlank() || perfil == null) {
            throw new IllegalArgumentException("Login, senha e perfil são obrigatórios.");
        }
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public PerfilFuncionario getPerfil() {
        return perfil;
    }
}
