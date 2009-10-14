package sistema;

import java.io.*;
import java.util.Vector;

public class SistemaDeUtilizadores implements Serializable {

    private static final String bd = "bd.dat";
    private static Vector<Utilizador> utilizadores = null;

    private SistemaDeUtilizadores() {
        utilizadores = new Vector<Utilizador>();
    }
    
    private SistemaDeUtilizadores(Vector<Utilizador> utilizadores) {
        SistemaDeUtilizadores.utilizadores = utilizadores;
    }

    public void apagarMensagens(String nome) {
        for ( Utilizador utilizador : utilizadores )
            if ( utilizador.equals(nome) )
                utilizador.emptycaixaDeMensagens();
    }

    public String criarConta(String nome) {
        if ( existeNome(nome) )
            return "";
        else {
            utilizadores.add( new Utilizador(nome) );
            return utilizadores.lastElement().getPassword();
        }
    }
    
    public void destruirConta(Utilizador utilizador) {
        utilizadores.remove(utilizador);
    }

    public boolean existeNome(String nome) {
        System.out.print("existeNome: ");
        for ( Utilizador utilizador : utilizadores )
            if ( utilizador.equals(nome) ) {
                System.out.println("yep");
                return true;
            }
        System.out.println("nop");
        return false;
    }

    public boolean validarCredenciais(String nome, String password) {
        for ( Utilizador utilizador : utilizadores )
            if (utilizador.equals(nome, password))
                return true;

        return false;
    }

    public void alterarPassword(String nome, String password) {
        for ( Utilizador utilizador : utilizadores )
            if (utilizador.equals(nome)) {
                utilizador.setPassword(password);
                System.out.println( "pass nova: " + utilizador.getPassword() );
            }
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

    public Vector<String> listaDeUtilizadores() {
        Vector<String> lista = new Vector<String>();
        for ( Utilizador utilizador : utilizadores )
            lista.add( utilizador.toString() );

        return lista;
    }

    public void enviarMensagem(String de, String para, String assunto, String corpo) {
        for (Utilizador utilizador : utilizadores)
            if ( utilizador.equals(para) ) { System.out.println("FODA-SE"); }
//                utilizador.mensagens.adicionarMensagem(de, assunto, corpo);
    }

    public String getcaixa(String nome) {
        for (Utilizador utilizador : utilizadores)
            if ( utilizador.equals(nome) )
                return utilizador.getCaixaDeMensagens();
                
        return "";
    }

    public static SistemaDeUtilizadores carregarSistema() {
        File ficheiro = new File(bd);
        
        if ( !ficheiro.exists() ) {
            System.err.println("Base de dados inexistente.");
            return new SistemaDeUtilizadores();
        }

        System.out.println("hm");
        
        try {
            return new SistemaDeUtilizadores(
                    (Vector<Utilizador>) new ObjectInputStream( new FileInputStream(bd) ).readObject()
            );
        } catch ( Exception e ) {
            System.err.println("Erro: " + e);
            ficheiro.delete();
            return new SistemaDeUtilizadores();
        }
    }

    public static SistemaDeUtilizadores carregarSistema(SistemaDeUtilizadores sistema) {
        return sistema;
    }
    
    public void descarregarSistema() {
       try {
            new ObjectOutputStream( new FileOutputStream(bd) ).writeObject( utilizadores );
        } catch ( Exception e ) { System.err.println("Escrita não é possível: " + e); }
    }

}
