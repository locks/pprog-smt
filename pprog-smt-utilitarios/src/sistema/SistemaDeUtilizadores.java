package sistema;

import java.io.*;
import java.util.Vector;

public class SistemaDeUtilizadores implements Serializable {

    private static final String bd = "bd.dat";
    private Vector<Utilizador> utilizadores = null;

    private SistemaDeUtilizadores() {
        utilizadores = new Vector<Utilizador>();
    }
    private SistemaDeUtilizadores(Vector<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
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

    public boolean validarCredenciais(String nome, String password) {
//        return utilizadores.contains( new Utilizador(nome, password) ) ?
//            true : false;
        return (nome.equals("teste")&&password.equals("teste")) ?
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
    
    public void descarregarSistema() {
        ObjectOutputStream ficheiro = null;
        
       try {
            ficheiro.writeObject( new FileOutputStream(bd) );
            ficheiro.close();
        } catch ( Exception e ) { System.err.println("Escrita não é possível: " + e); }
    }

}
