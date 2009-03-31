package ClassesTeste;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 
 * @author i060516
 */
public class Utilizador {
    String nome;
    String password;
    CaixaDeMensagens mensagens;
    
    /**
     *
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
    public static String gerarPassword() {
        return RandomStringUtils.randomAlphanumeric(4);
    }
}
