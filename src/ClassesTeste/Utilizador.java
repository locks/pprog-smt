package ClassesTeste;

import org.apache.commons.lang.RandomStringUtils;

public class Utilizador {
    private String nome;
    private String password;
    private CaixaDeMensagens mensagens;
    private boolean status;

    public Utilizador() {
        nome      = "<not-specified>";
        setPassword();
        mensagens = new CaixaDeMensagens();
        status    = false;
    }
    
    public Utilizador(String nome) {
        setNome(nome);
        setPassword();
    }

    public void setNome(String nome) {
        this.nome = nome.trim();
    }

    public boolean setPassword(String password) {
        if (password.length()==0)
            return false;
        else
            return true;
    }

    public void setPassword() {
        this.password = RandomStringUtils.randomAlphanumeric(4);
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
        if (nome.equals(this.nome))
            if (password.equals(password))
                return true;

        return false;
    }
}
