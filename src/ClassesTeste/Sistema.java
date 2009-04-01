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

    public void criarConta(String nome, String password) {
        utilizadores.add(new Utilizador(nome, password));
    }

    public void destruirConta(int i) {
        utilizadores.remove(i);
    }

    public Utilizador getUtilizador(int i) {
        return utilizadores.get(i);
    }

    public int getSize() {
        return utilizadores.size();
    }

    public void validarUtilizador(int i, String nome, String password) {
        getUtilizador(i).validarCredenciais(nome, password);
    }
    
    public int validarCredenciais(String nome, String password) {
        for (int i=0; i<utilizadores.size(); i++)
            if (utilizadores.get(i).getNome().equals(nome) && utilizadores.get(i).getPassword().equals(password))
                return i;

        return -1;
    }
}
