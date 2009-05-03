package Servidor;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args ) throws IOException {
        final int PORTO = 8888;
        ServerSocket server = new ServerSocket(PORTO);
        System.out.println("Servidor - À espera que clientes se liguem ...");

        Socket s = server.accept();

        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

        String linha = reader.readLine();
        System.out.println("Servidor - Recebido: " + linha);

        writer.write("Olá Cliente \n");
        writer.flush();

        s.close();
    }
}