package ClassesTeste;

/**
 * 
 * @author i060516
 */
public class Utilizador {
    String nome;
    String password;

    /**
     * 
     */
    public Utilizador() {
        nome = "";
        password = "";
    }
    /**
     *
     * @param nome
     * @param password
     */
    public Utilizador(String nome, String password) {
        this.nome     = nome;
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
}
