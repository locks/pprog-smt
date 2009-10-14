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

    public void setPassword() {
        this.password = RandomStringUtils.randomAlphanumeric(4);
        System.out.println("pass criada: " + password);
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

    public void emptycaixaDeMensagens() {
        mensagens = new CaixaDeMensagens();
    }
    
    public boolean equals(String nome) {
        return getNome().equals(nome) ?
            true : false;
    }
 
    public boolean equals(String nome, String password) {
        return (equals(nome) && getPassword().equals(password)) ?
            true : false;
    }

    @Override
    public String toString() {
        return nome;
    }

}
