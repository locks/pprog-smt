package ClassesTeste;

import java.util.ArrayList;

public class Mensagem {
    private Utilizador   from;
    private ArrayList<Utilizador> to;
    private String       subject, body;

    /**
     *
     */
    public Mensagem() {
        from    = new Utilizador();
        to      = new ArrayList<Utilizador>();
        subject = "<empty>";
        body    = "<empty>";
    }

    /**
     * 
     * @param from
     * @param to
     * @param subject
     * @param body
     */
    public Mensagem(Utilizador from, ArrayList<Utilizador> to, String subject, String body) {
        this.from    = from;
        this.to      = to;
        this.subject = subject;
        this.body    = body;
    }
}
