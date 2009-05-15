package pprogsmtcli;

import sistema.*;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        SistemaDeUtilizadores sistema = null;

        try {
            sistema = new SistemaDeUtilizadores();
//            sistema.criarConta("joao");
//            sistema.criarConta("lolinda");
        } catch ( Exception e ) { System.err.println("Falha na inicialização do sistema: " + e); System.exit(-1); }

        System.out.println( sistema.toString() );
        
        try {
            sistema.descarregarSistema();
        } catch ( Exception e ) { System.err.println("Erro ao descarregar sistema: " + e); System.exit(-1); }
    }

}
