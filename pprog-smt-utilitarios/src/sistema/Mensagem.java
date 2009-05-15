package sistema;

import java.io.Serializable;

public class Mensagem implements Serializable {

    private int    remetente;
    private String assunto, corpo;

    public Mensagem(int de, String assunto, String corpo) {
        this.remetente = de;
        this.assunto   = assunto;
        this.corpo     = corpo;
    }

    public String getSubject() {
        return assunto;
    }

    public String getcorpo() {
        return corpo;
    }

    public String toStringHeader() {
        return remetente + "\n" + assunto;
    }

    public String toStringBody() {
        return "mensagem: " + corpo;
    }

    @Override
    public String toString() {
        return remetente    +"\n"+
                assunto      +"\n"+
                corpo;
    }
    
}
