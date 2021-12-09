package dev.fpsaraiva.apiclientes.exception;

public class UsuarioCadastradoException extends RuntimeException {

    public UsuarioCadastradoException(String login) {
        super("Usuário já cadastrado para o login " + login);
    }
}
