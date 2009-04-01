package ClassesTeste;

import AplicacaoExceptions.ValorInvalido;
import org.apache.commons.lang.RandomStringUtils;

public class Utilizador {
    private String nome;
    private String password;
    private CaixaDeMensagens mensagens;

    public Utilizador() {
        nome      = null;
        setPassword();
        mensagens = new CaixaDeMensagens();
    }
    
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
        this.password = RandomStringUtils.randomAlphanumeric(4);
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

    public boolean isUtilizadorValido(String nome, String password) {
        if (nome.equals(this.nome) && password.equals(this.password))
            return true;

        return false;
    }
}
