package sistema;

import excepcoes.ValorInvalido;
import org.apache.commons.lang.RandomStringUtils;

public class Utilizador {

    private int    identificador;
    private String nome, password;
    protected CaixaDeMensagens mensagens;

    public Utilizador(String nome) throws ValorInvalido {
        setIdentificador();
        setNome(nome);
        setPassword();
        mensagens = new CaixaDeMensagens();
    }

    public void setIdentificador() {
        //TODO
    }
    
    public void setNome(String nome) throws ValorInvalido {
        if (nome.length()==0)
            throw new ValorInvalido("nome");
        else
            this.nome = nome;
    }

    public void setPassword() {
        this.password = RandomStringUtils.randomAlphanumeric(4);
    }

    public void setPassword(String password) throws ValorInvalido {
        if (password.length()==0)
            throw new ValorInvalido("password");
        else
            this.password = password;
    }

    public int getIdentificador() {
        return identificador;
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
        if (nome.equals(this.nome) && password.equals(this.password))
            return true;

        return false;
    }

}
