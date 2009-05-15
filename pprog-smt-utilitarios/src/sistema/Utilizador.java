package sistema;

import excepcoes.ValorInvalido;
import java.io.Serializable;
import org.apache.commons.lang.RandomStringUtils;

public class Utilizador implements Serializable {

    private   String nome, password;
    protected CaixaDeMensagens mensagens;

    public Utilizador(String nome) throws ValorInvalido {
        setNome(nome);
        setPassword();
        mensagens = new CaixaDeMensagens();
    }

    
    public void setNome(String nome) throws ValorInvalido {
        if (nome.length()==0)
            throw new ValorInvalido("nome");
        else
            this.nome = nome;
    }

    public void setPassword() {
        this.password = "MERDA";
//        RandomStringUtils.randomAlphanumeric(4);
    }

    public void setPassword(String password) throws ValorInvalido {
        if (password.length()==0)
            throw new ValorInvalido("password");
        else
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

    public boolean equals(String nome, String password) {
        return getNome().equals(nome) && getPassword().equals(password) ?
            true : false;
    }

    @Override
    public String toString() {
        return nome;
    }

}
