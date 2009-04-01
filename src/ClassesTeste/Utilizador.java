package ClassesTeste;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 
 * @author i060516
 */
public class Utilizador {
    private String nome;
    private String password;
    private CaixaDeMensagens mensagens;
    private boolean status;

    /**
     *
     */
    public Utilizador() {
        nome      = "<not-specified>";
        password  = gerarPassword();
        mensagens = new CaixaDeMensagens();
        status    = false;
    }
    
    /**
     * Cria um objecto com os parâmetros recebidos
     * @param nome
     * @param password
     */
    public Utilizador(String nome, String password) {
        setNome(nome);
        setPassword(password);
    }

    public void setNome(String nome) {
        this.nome = nome.trim();
    }
    public void setPassword(String password) {
        if (password.trim().equals(""))
                this.password = gerarPassword();
        else
            this.password = password;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Gerar uma password aleatoriamente.
     * @return
     */
    public static String gerarPassword() {
        return RandomStringUtils.randomAlphanumeric(4);
    }

    /**
     * 
     * @param nome
     * @param password
     * @return
     */
    public boolean validarCredenciais(String nome, String password) {
        if (nome.equals(this.nome))
            if (password.equals(password))
                return true;

        return false;
    }
}
