package transaccoes;

import java.sql.*;

public class Ficheiro {

    private Connection conn;
    private Statement  stat;

    public Ficheiro() throws Exception {
        Class.forName("org.sqlite.JDBC");
    }

    public void ligar() throws Exception {
        conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        stat = conn.createStatement();
     }

    public void desligar() throws Exception {
        conn.close();
    }

    public void escreverDados() throws Exception {
        stat.executeUpdate("drop table if exists people;");
        stat.executeUpdate("create table people (name, occupation);");
        PreparedStatement prep = conn.prepareStatement(
                "insert into people values (?, ?);");

        prep.setString(1, "Gandhi");
        prep.setString(2, "politics");
        prep.addBatch();
        prep.setString(1, "Turing");
        prep.setString(2, "computers");
        prep.addBatch();
        prep.setString(1, "Wittgenstein");
        prep.setString(2, "smartypants");
        prep.addBatch();

        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.commit();
    }

    public void lerDados() throws Exception {
        ResultSet rs = stat.executeQuery("select * from people;");
        while (rs.next()) {
            System.out.println("name = " + rs.getString("name"));
            System.out.println("job = " + rs.getString("occupation"));
        }
        rs.close();
    }
}
