package Servidor;

import java.io.*;
import java.net.*;

public class comunicacao {
    
    private BufferedReader recebe;
    private BufferedWriter envia;
    private Socket         canal;

    public comunicacao(Socket canal) throws Exception {
        this.canal = canal;
        
        recebe = new BufferedReader(new InputStreamReader(canal.getInputStream()));
        envia  = new BufferedWriter(new OutputStreamWriter(canal.getOutputStream()));
    }

    public String recebe() throws IOException {
        return recebe.readLine();
    }
    
    public void envia(String comunicacao) throws Exception {
        envia.write(comunicacao);
        envia.flush();
    }

}
