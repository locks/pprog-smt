package sistema;

import java.io.Serializable;
import org.apache.commons.lang.RandomStringUtils;

public class Utilizador implements Serializable {

    private   String nome, password;
    protected CaixaDeMensagens mensagens;

    public Utilizador(String nome) {
        this.nome = nome;
        setPassword();
        mensagens = new CaixaDeMensagens();
    }

    public Utilizador(String nome, String password) {
        this.nome     = nome;
        this.password = password;
        mensagens = null;
    }

    public void setPassword() {
        this.password = RandomStringUtils.randomAlphanumeric(4);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }

    public String getCaixaDeMensagens() {
        return mensagens.toString();
    }

    public boolean equals(String nome) {
        return getNome().equals(nome) ?
            true : false;
    }

    public boolean equals(String nome, String password) {
        return equals(nome) && getPassword().equals(password) ?
            true : false;
    }

    @Override
    public String toString() {
        return nome;
    }

}
