package Servidor;

import java.net.*;

public class Servidor {

    private static int   porto = 8888;
    private ServerSocket portoServidor;
    private Socket       portocliente;
    private Comunicacao  mensagem;

    public Servidor() throws Exception {
        portoServidor = new ServerSocket(porto);
    }

    public Servidor(int porto) throws Exception {
        portoServidor = new ServerSocket(porto);
    }

    public static void setPorto(int porto) {
        Servidor.porto = porto;
    }

    public void setPortocliente(Socket portocliente) {
        this.portocliente = portocliente;
    }
    
    public void start() {
        try {
            new Servidor();
            System.out.println("Servidor activo.");
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Porta ocupada: " + porto);
        }

    }

    private void Treta() throws Exception {
        ServerSocket server = new ServerSocket(porto);
        System.out.println("Servidor - À espera que clientes se liguem ...");

        Socket s = server.accept();
    
        System.out.println("Servidor - Recebido: " + mensagem.recebe());
        mensagem.envia("Olá Cliente\n");

        s.close();
    }

    public static void main(String[] args) throws Exception {
        Ficheiro ficheiro = new Ficheiro();
        ficheiro.ligar();
        ficheiro.escreverDados();
        ficheiro.lerDados();
        ficheiro.desligar();
    }


}