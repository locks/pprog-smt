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
        this.nome = nome;
        
        if (password.isEmpty())
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
