package Servidor;

import java.net.*;

public class Servidor {

    private static int porto = 8888;
    private ServerSocket portoServidor;
    private Socket portocliente;
    private comunicacao comunicacao;

    public Servidor() throws Exception {
            portoServidor = new ServerSocket(porto);
    }
    
    public void start() throws Exception {
        new Servidor();
        
        try {
            portoServidor = new ServerSocket(porto);
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Porta ocupada: " + porto);
        }

        System.out.println("Servidor activo.");
    }

    private void Treta() throws Exception {
        ServerSocket server = new ServerSocket(porto);
        System.out.println("Servidor - À espera que clientes se liguem ...");

        Socket s = server.accept();
    
        String linha = comunicacao.recebe();
        System.out.println("Servidor - Recebido: " + linha);

        comunicacao.envia("Olá Cliente \n");

        s.close();
    }

    public static void main(String[] args) throws Exception {
        Ficheiro ficheiro = new Ficheiro();
        ficheiro.ligar();
        ficheiro.escreverDados();
        ficheiro.lerDados();
        ficheiro.desligar();
    }

    public static void setPorto(int porto) {
        Servidor.porto = porto;
    }
    
    public static int getPorto() {
        return porto;
    }
}