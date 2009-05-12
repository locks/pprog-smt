package Servidor;

import Utilitarios.*;
import java.net.Socket;

public class Servico extends Thread {

    private Comunicacao comunicacoes = null;

    public Servico(Socket porto) {
        super("ServidorThread");
        comunicacoes.setSocket(porto);
    }

    @Override
    public void run() {
        try {
            if (comunicacoes.recebe().contains("\n")) {
                //existeNomeUtilizador();
            } else {
                //criarconta, devolver nome e pass
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }


}
