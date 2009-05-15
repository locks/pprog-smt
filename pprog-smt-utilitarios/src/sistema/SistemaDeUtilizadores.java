package sistema;

import java.io.*;
import java.util.Vector;

public class SistemaDeUtilizadores implements Serializable {

    private Vector<Utilizador> utilizadores = null;

    public SistemaDeUtilizadores() throws Exception {
        utilizadores = (new File("bd.dat").exists()) ?
            carregarSistema() : new Vector<Utilizador>();
    }

    public Utilizador criarConta(String nome) {
        try {
            utilizadores.add( new Utilizador(nome) );
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return utilizadores.lastElement();
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
        for (Utilizador utilizador : utilizadores) {
            if (utilizador.equals(nome, password))
                return utilizador;
        }

        return null;
    }

    @Override
    public String toString() {
        String listagem = "";

        if ( utilizadores.isEmpty() )
            return "<empty>";

        for ( int i=0; i < utilizadores.size() - 1; i++)
            listagem += utilizadores.elementAt(i).getNome() + "\n";

        return listagem += utilizadores.lastElement().getNome();
    }

    public void enviarMensagem(Utilizador to, String de, String assunto, String corpo) {
        for (Utilizador utilizador : utilizadores)
            if (utilizador.equals(to))
                utilizador.mensagens.adicionarMensagem(de, assunto, corpo);
    }

    public void carregarrSistema() throws Exception {
        if (new File("bd.dat").exists())
            utilizadores = (Vector<Utilizador>) new ObjectInputStream(new FileInputStream("bd.dat")).readObject();
        else {
            new Vector<Utilizador>();

        }
    }
    
    public Vector<Utilizador> carregarSistema() throws Exception {
        return (Vector<Utilizador>) new ObjectInputStream(new FileInputStream("bd.dat")).readObject();
    }
    
    public void descarregarSistema() throws Exception {
        new ObjectOutputStream( new FileOutputStream("bd.dat") ).writeObject( utilizadores );
    }

}
