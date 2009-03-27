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
        Utilizador utilizador = new Utilizador("joao", "1234lol");

        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        Statement stat = conn.createStatement();
        stat.executeUpdate("drop table if exists Utilizador;");
        stat.executeUpdate("create table Utilizador (nome, password);");
        PreparedStatement prep = conn.prepareStatement(
                "insert into Utilizador values (?, ?);");

        prep.setString(1, utilizador.getNome());
        prep.setString(2, utilizador.getPassword());
        prep.addBatch();

        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);

        ResultSet rs = stat.executeQuery("select * from Utilizador;");
        while (rs.next()) {
            System.out.println("nome = " + rs.getString("nome"));
            System.out.println("password = " + rs.getString("password"));
        }
        rs.close();
        conn.close();

    }
}
