package ClassesTeste;

import java.util.Vector;

public class CaixaDeMensagens {
    Vector<Mensagem> mensagens;

    public CaixaDeMensagens() {
        mensagens = new Vector<Mensagem>();
    }

    public void adicionarMensagem(Utilizador from, String subject, String body) {
        mensagens.add(new Mensagem(from, subject, body));
    }

    public Vector<Mensagem> getMensagens() {
        return mensagens;
    }

    @Override
    public String toString() {
        String string = "lolol\nlolol";
        string.split("\n");
        return "";
    }
}
