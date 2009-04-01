package ClassesTeste;

import AplicacaoExceptions.ValorInvalido;
import org.apache.commons.lang.RandomStringUtils;

public class Utilizador {
    private String nome;
    private String password;
    private CaixaDeMensagens mensagens;
    private boolean status;

    public Utilizador() {
        nome      = null;
        setPassword();
        mensagens = new CaixaDeMensagens();
        status    = false;
    }
    
    public Utilizador(String nome) {
        try {
            setNome(nome);
        } catch (ValorInvalido e) {
            e.printStackTrace();
        }
        setPassword();
    }

    public void setNome(String nome) throws ValorInvalido {
        if (nome.length()==0) throw new ValorInvalido("nome");
        else
            this.nome = nome;
    }

    public void setPassword() {
        this.password = RandomStringUtils.randomAlphanumeric(4);
    }

    public boolean setPassword(String password) {
        if (password.length()==0)
            return false;
        else
            return true;
    }

     public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }

    public boolean getStatus() {
        return status;
    }

    public boolean validarCredenciais(String nome, String password) {
        if (nome.equals(this.nome) && password.equals(this.password))
            return true;

        return false;
    }
}
