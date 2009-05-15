package pprogsmtcli;

import sistema.*;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        SistemaDeUtilizadores sistema = null;

        try {
            sistema = new SistemaDeUtilizadores();

            sistema.criarConta("lolinda");
            
            System.out.println( "caixa do joao:\n" + sistema.getcaixa("joao") );

        } catch ( Exception e ) { System.err.println("Falha na inicialização do sistema: " + e); System.exit(-1); }

        System.out.println( "sistema: \n" + sistema.toString() + "\n:sistema" );
        
        try {
            sistema.descarregarSistema();
        } catch ( Exception e ) { System.err.println("Erro ao descarregar sistema: " + e); System.exit(-1); }
    }

    
    public static void Testes(SistemaDeUtilizadores sistema) {
        sistema.criarConta("lolinda");
        sistema.enviarMensagem("lolinda", "joao", "lol", "pode ser que sim...");
            
   
    }
}
