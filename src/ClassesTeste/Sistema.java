package ClassesTeste;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Utilizador> utilizadores;

    public Sistema() {
        utilizadores = new ArrayList<Utilizador>();
    }

    public void criarConta(String nome) {
        try {
            utilizadores.add(new Utilizador(nome));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destruirConta(Utilizador utilizador) {
        utilizadores.remove(utilizador);
    }

    public boolean existeNomeUtilizador(String nome) {
        for (Utilizador utilizador : utilizadores)
            if (utilizador.getNome().equals(nome))
                return false;

        return true;
    }

//    public Utilizador getUtilizador(int i) {
//        return utilizadores.get(i);
//    }
    

   public Utilizador validarCredenciais(String nome, String password) {
       for (Utilizador utilizador : utilizadores)
           if (utilizador.getNome().equals(nome) && utilizador.getPassword().equals(password))
               return utilizador;
       return null;
   }
}
