package ClassesTeste;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Utilizador> utilizadores;

    /**
     *
     */
    public Sistema() {
        utilizadores = new ArrayList<Utilizador>();
    }

    /**
     *
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
    
    public int validarCredenciais(String nome, String password) {
        for (int i=0; i<utilizadores.size(); i++)
            if (utilizadores.get(i).getNome().equals(nome) && utilizadores.get(i).getPassword().equals(password))
                return i;

        return -1;
    }
}
