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

    public void removerMensagem(int i) {
        mensagens.remove(i);
    }

    @Override
    public String toString() {
        String mensagensAcumuladas = "";
        int indice=1;
        
        for (Mensagem mensagem : mensagens) {
            mensagensAcumuladas.concat(indice + ": " + mensagem.toStringHeader() + "\n");
            indice++;
        }

        return mensagensAcumuladas;
    }

    public String verMensagem(int i) {
        return mensagens.get(i).toStringHeader() + "\n" +
                mensagens.get(i).toStringBody();
    }
}
