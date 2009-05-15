package sistema;

import java.io.*;
import java.util.Vector;

public class SistemaDeUtilizadores implements Serializable {

    private Vector<Utilizador> utilizadores = null;

    public SistemaDeUtilizadores() throws Exception {
        utilizadores = new Vector<Utilizador>();
        carregarSistema();
    }

    public Utilizador criarConta(String nome) {
        try {
            utilizadores.add( new Utilizador(nome) );
            return utilizadores.lastElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public void criarConta(Utilizador utilizador) {
        utilizadores.add(utilizador);
    }

    public void destruirConta(Utilizador utilizador) {
        utilizadores.remove(utilizador);
    }

    public boolean existeUtilizador(String nome) {
        for (Utilizador utilizador : utilizadores)
            if (utilizador.getNome().equals(nome))
                return true;

        return false;
    }

    public Utilizador validarCredenciais(String nome, String password) {
        for (Utilizador utilizador : utilizadores)
            if (utilizador.equals(nome, password))
                return utilizador;

        return null;
    }

    @Override
    public String toString() {
        String listagem = "";

        for ( int i=0; i < utilizadores.size() - 1; i++)
            listagem += utilizadores.elementAt(i) + "\n";

        listagem += utilizadores.lastElement();
        
//        for (Utilizador utilizador : utilizadores) {
//            listagem += utilizador.equals( utilizadores.firstElement() ) ?
//                "" + utilizador.toString() : "\n" + utilizador.toString() ;
//        }

        return listagem;
    }

    public void enviarMensagem(Utilizador to, Utilizador from, String subject, String body) {
        for (Utilizador utilizador : utilizadores)
            if (utilizador.equals(to))
                utilizador.mensagens.adicionarMensagem(from.getIdentificador(), subject, body);
    }

    public void carregarSistema() throws Exception {
        utilizadores = (Vector) new ObjectInputStream( new FileInputStream("bd.dat") ).readObject();
    }

    public void descarregarSistema() throws Exception {
        new ObjectOutputStream( new FileOutputStream("bd.dat") ).writeObject( utilizadores );
    }

}
