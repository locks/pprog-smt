package ClassesTeste;

import java.util.ArrayList;

public class Mensagem {
    private Utilizador   from;
    private ArrayList<Utilizador> to;
    private String       subject, body;

    public Mensagem() {
        from    = null;
        to      = null;
        subject = null;
        body    = null;
    }

    public Mensagem(Utilizador from, ArrayList<Utilizador> to, String subject, String body) {
        this.from    = from;
        this.to      = to;
        this.subject = subject;
        this.body    = body;
    }
}
