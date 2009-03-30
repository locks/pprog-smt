package pprogsmt;

import java.sql.*;
import ClassesTeste.*;

public class Main {

    /**
     *
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(final String[] args) throws Exception {
        Sistema sistema = new Sistema();
        sistema.criarConta("Joao","1234lol");
        sistema.criarConta("Tiago","");
        sistema.criarConta("Ricardo", "lolol");

        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");

        Statement stat = conn.createStatement();
        stat.executeUpdate("drop table if exists Utilizador;");
        stat.executeUpdate("create table Utilizador (nome, password);");
        PreparedStatement prep = conn.prepareStatement("insert into Utilizador values (?, ?);");

        for (int i=0; i<sistema.getSize(); i++) {
            prep.setString(1, sistema.getUtilizador(i).getNome());
            prep.setString(2, sistema.getUtilizador(i).getPassword());
            prep.addBatch();
        }

        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);

        ResultSet rs = stat.executeQuery("select * from Utilizador;");
        while (rs.next()) {
            System.out.println("nome: " + rs.getString("nome"));
            System.out.println("password = " + rs.getString("password"));
        }
        rs.close();
        conn.close();

        String lol = "lol";
        lol.charAt(2);

    }
}
