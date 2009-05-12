package Utilitarios;

import java.io.*;
import java.net.*;

public class Comunicacao {
    
    private BufferedReader recebe;
    private BufferedWriter envia;
    private String         comunicacao;
    private Socket         canal;

    public Comunicacao(Socket canal) throws Exception {
        setSocket(canal);
        recebe = new BufferedReader(new InputStreamReader(canal.getInputStream()));
        envia  = new BufferedWriter(new OutputStreamWriter(canal.getOutputStream()));
    }

    public void setSocket(Socket canal) {
        this.canal = canal;
    }

    public String recebe() {
        try {
            return recebe.readLine();
        } catch (Exception e) {
            System.err.println(e);
        }

        return null;
    }

    public String ler() {
         return comunicacao;
    }
    
    public void envia(String comunicacao) throws Exception {
        try {
            envia.write(comunicacao);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            envia.flush();
        }
    }

}
