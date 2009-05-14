package sistema;

public class Mensagem {

    private int    identificador, remetente;
    private String assunto, corpo;

    public Mensagem(int de, String assunto, String corpo) {
        setIdentificador();
        this.remetente = de;
        this.assunto   = assunto;
        this.corpo     = corpo;
    }

    public void setIdentificador() {
        //TODO
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
        return identificador +"\n"+
                remetente    +"\n"+
                assunto      +"\n"+
                corpo;
    }
    
}
