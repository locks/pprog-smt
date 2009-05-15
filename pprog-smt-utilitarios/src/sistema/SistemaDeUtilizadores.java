package sistema;

import java.io.*;
import java.util.Vector;

public class SistemaDeUtilizadores implements Serializable {

    private static final String bd = "bd.dat";
    private Vector<Utilizador> utilizadores = null;

    public SistemaDeUtilizadores() {
        utilizadores = carregarSistema();
    }

    public String criarConta(String nome) {
        System.out.println("criar conta: ");
        
        if ( existeNome(nome) )
            return "NOME NOME NOME já existente.";
        else {
            utilizadores.add( new Utilizador(nome) );
            System.out.println("criado.");
            return utilizadores.lastElement().getPassword();
        }
    }
    
    public void destruirConta(Utilizador utilizador) {
        utilizadores.remove(utilizador);
    }

    public boolean existeNome(String nome) {
        System.out.print("existeNome: ");
        for ( Utilizador utilizador : utilizadores )
            if ( utilizador.getNome().equals(nome) ) {
                System.out.println("yep");
                return true;
            }
        System.out.println("nop");
        return false;
    }

    public boolean validarCredenciais(String nome, String password) throws Exception {
        return utilizadores.contains( new Utilizador(nome, password) ) ?
            true : false;
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

    public void enviarMensagem(String de, String para, String assunto, String corpo) {
        for (Utilizador utilizador : utilizadores)
            if ( utilizador.equals(para) )
                utilizador.mensagens.adicionarMensagem(de, assunto, corpo);
    }

    public String getcaixa(String nome) {
        for (Utilizador utilizador : utilizadores)
            if ( utilizador.equals(nome) )
                return utilizador.getCaixaDeMensagens();
                
        return "";
    }

    public Vector<Utilizador> carregarSistema() {
        if ( !new File(bd).exists() ) {
            System.err.println("Base de dados inexistente.");
            return new Vector<Utilizador>();
        }

        try {
            return (Vector<Utilizador>) new ObjectInputStream( new FileInputStream(bd) ).readObject();
        } catch ( Exception e ) {
            System.err.println("Erro: " + e);
            new File(bd).delete();
            return new Vector<Utilizador>();
        }
    }
    
    public void descarregarSistema() throws Exception {
        ObjectOutputStream ficheiro = new ObjectOutputStream( new FileOutputStream(bd) );
        ficheiro.writeObject( utilizadores );
        ficheiro.close();
    }

}
