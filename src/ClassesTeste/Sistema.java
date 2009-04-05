package ClassesTeste;

import java.util.Vector;

public class Sistema {
    private Vector<Utilizador> utilizadores;

    public Sistema() {
        utilizadores = new Vector<Utilizador>();

//        conta de teste
//        criarConta("ricardo");
//        criarConta("joao");
//        criarConta("alberto");
//        System.out.println(utilizadores.lastElement().getPassword());
    }

    public Utilizador criarConta(String nome) {
        try {
            utilizadores.add(new Utilizador(nome));
            return utilizadores.lastElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    public String verCaixaDeMensagens() {
        return "";
    }

    @Override
    public String toString() {
        String listagem_formatada="-Lista dos Utilizadores-\n";
        int indice=1;
        
        for (Utilizador utilizador : utilizadores) {
            listagem_formatada = listagem_formatada + indice + ": " + utilizador.getNome() + "\n";
            indice++;
        }

        System.out.println(listagem_formatada);
        return listagem_formatada;
    }

    public void enviarMensagem(Utilizador to, Utilizador from, String subject, String body) {
        for (Utilizador utilizador : utilizadores)
            if (utilizador.equals(to))
                utilizador.getCaixaDeMensagens().adicionarMensagem(from, subject, body);
    }
}
