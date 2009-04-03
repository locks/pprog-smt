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

    @Override
    public String toString() {
        String mensagensAcumuladas = "";
        
        for (Mensagem mensagem : mensagens)
            mensagensAcumuladas.concat(mensagem.toStringHeader() + "\n");

        return mensagensAcumuladas;
    }

    public String verMensagem(int i) {
        return mensagens.get(i).toStringHeader() + "\n" + mensagens.get(i).toStringBody();
    }
}
