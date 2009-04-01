package ClassesTeste;

import java.util.Vector;

public class Sistema {
    private Vector<Utilizador> utilizadores;

    public Sistema() {
        utilizadores = new Vector<Utilizador>();
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
           if (utilizador.isUtilizadorValido(nome, password))
               return utilizador;
       return null;
   }
}
