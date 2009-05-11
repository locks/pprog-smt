package Servidor;

import java.io.*;
import java.net.*;

public class Comunicacao {
    
    private BufferedReader recebe;
    private BufferedWriter envia;
    private Socket         canal;

    public Comunicacao(Socket canal) throws Exception {
        setSocket(canal);
        recebe = new BufferedReader(new InputStreamReader(canal.getInputStream()));
        envia  = new BufferedWriter(new OutputStreamWriter(canal.getOutputStream()));
    }

    public void setSocket(Socket canal) {
        this.canal = canal;
    }

    public String recebe() throws IOException {
        return recebe.readLine();
    }
    
    public void envia(String comunicacao) throws Exception {
        envia.write(comunicacao);
        envia.flush();
    }

}
