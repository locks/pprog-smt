package Servidor;

import transaccoes.Ficheiro;
import transaccoes.Comunicacao;
import java.net.*;

public class Servidor {
    
    private static final boolean listening = true;
    private static int   porto = 8888;
    
    private ServerSocket portoServidor;
    private Socket       portocliente;
    private Comunicacao  comunicacoes;

    public Servidor() throws Exception {
        portoServidor = new ServerSocket(porto);
    }

    public Servidor(int porto) throws Exception {
        portoServidor = new ServerSocket(porto);
    }

    public ServerSocket getPortoServidor() {
        return portoServidor;
    }

    public void setPortocliente(Socket portocliente) {
        this.portocliente = portocliente;
    }
    
//    public void start() {
//        try {
//            new Servidor();
//            System.out.println("Servidor activo.");
//        } catch (Exception e) {
//            System.err.println(e);
//            System.out.println("Porta ocupada: " + porto);
//        }
//
//    }

    public void ligar() throws Exception {
        portoServidor = new ServerSocket(porto);
    }

    public void aceitarcliente() throws Exception {
                while (listening) {
            new Servico( getPortoServidor().accept() ).start();
        }

    }

    public void desligar() throws Exception {
        portoServidor.close();
    }

    private void Treta() throws Exception {
        ServerSocket server = new ServerSocket(porto);
        System.out.println("Servidor - À espera que clientes se liguem ...");

        Socket s = server.accept();
    
        System.out.println("Servidor - Recebido: " + comunicacoes.recebe());
        comunicacoes.envia("Olá Cliente\n");

        s.close();
    }

    public static void main(String[] args) throws Exception {
        Servidor servidor = new Servidor();
 
        Ficheiro ficheiro = new Ficheiro();
        ficheiro.ligar();
        ficheiro.escreverDados();
        ficheiro.lerDados();
        ficheiro.desligar();

        servidor.ligar();
        servidor.aceitarcliente();
        servidor.desligar();
    }


}