package ClassesTeste;

import java.util.ArrayList;

/**
 *
 * @author i060516
 */
public class Sistema {
    private ArrayList<Utilizador> utilizadores;
    
    public Sistema() {
        utilizadores = new ArrayList();
    }

    public void criarConta(String nome, String password) {
        utilizadores.add(new Utilizador(nome, password));
    }

    public void destruirConta() {
    }

    public Utilizador getUtilizador(int i) {
        return utilizadores.get(i);
    }
    public int getSize() {
        return utilizadores.size();
    }
    public void validarCredenciais() {}

}
