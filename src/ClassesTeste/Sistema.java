package ClassesTeste;

import java.util.Vector;

public class Sistema {

    private Vector<Utilizador> utilizadores;

    public Sistema() {
        utilizadores = new Vector<Utilizador>();
    }

    public void criarConta(String nome) {
        try {
            utilizadores.add(new Utilizador(nome));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void criarConta(Utilizador utilizador) {
        utilizadores.add(utilizador);
    }

    public void destruirConta(Utilizador utilizador) {
        utilizadores.remove(utilizador);
    }

    public Utilizador existeNomeUtilizador(String nome) {
        for (Utilizador utilizador : utilizadores)
            if (utilizador.getNome().equals(nome))
                return utilizador;

        return null;
    }

    public Utilizador validarCredenciais(String nome, String password) {
        for (Utilizador utilizador : utilizadores)
            if (utilizador.equals(nome, password))
                return utilizador;

        return null;
    }

    public void enviarMensagem(Utilizador to, Utilizador from, String subject, String body) {
        for (Utilizador utilizador : utilizadores) {
            if (utilizador.equals(to)) {
                utilizador.getCaixaDeMensagens().adicionarMensagem(from, subject, body);
            }
        }
    }
}
