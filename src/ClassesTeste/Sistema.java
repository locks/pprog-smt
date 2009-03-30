package ClassesTeste;

import java.util.ArrayList;

/**
 *
 * @author i060516
 */
public class Sistema {
    private ArrayList<Utilizador> utilizadores;

    /**
     *
     */
    public Sistema() {
        utilizadores = new ArrayList<Utilizador>();
    }

    /**
     * Adiciona uma nova conta utilizador.
     * @param nome
     * @param password
     */
    public void criarConta(String nome, String password) {
        utilizadores.add(new Utilizador(nome, password));
    }

    /**
     *
     * @param i
     */
    public void destruirConta(int i) {
        utilizadores.remove(i);
    }

    /**
     *
     * @param i
     * @return
     */
    public Utilizador getUtilizador(int i) {
        return utilizadores.get(i);
    }

    /**
     *
     * @return
     */
    public int getSize() {
        return utilizadores.size();
    }

    /**
     *
     * @param i
     * @param nome
     * @param password
     */
    public void validarUtilizador(int i, String nome, String password) {
        getUtilizador(i).validarCredenciais(nome, password);
    }
}
