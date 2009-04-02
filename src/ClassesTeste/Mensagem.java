package ClassesTeste;

import java.util.Vector;

public class Mensagem {
    private Utilizador   from;
    private Vector<Utilizador> to;
    private String       subject, body;

    public Mensagem(Utilizador from, Vector<Utilizador> to, String subject, String body) {
        this.from    = from;
        this.to      = to;
        this.subject = subject;
        this.body    = body;
    }
}
