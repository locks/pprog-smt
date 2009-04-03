package ClassesTeste;

public class Mensagem {
    private Utilizador from;
    private String     subject, body;

    public Mensagem(Utilizador from, String subject, String body) {
        this.from    = from;
        this.subject = subject;
        this.body    = body;
    }

    public String getNomeFrom() {
        return from.getNome();
    }

    public String getSubject() {
        return subject;
    }

    public String toStringHeader() {
        return "de: " + from + "\n" + "assunto: " + subject;
    }

    public String toStringBody() {
        return "mensagem: " + body;
    }
}
