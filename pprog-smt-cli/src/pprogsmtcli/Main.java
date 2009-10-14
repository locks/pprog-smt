package pprogsmtcli;

import sistema.*;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        SistemaDeUtilizadores sistema = SistemaDeUtilizadores.carregarSistema();
        try {
                sistema.descarregarSistema();
            } catch ( Exception e ) { System.err.println("Descarregar sistema: " + e); }

            System.out.println( sistema.criarConta("et") );
            
            System.out.println( "caixa do tiago:\n" + sistema.getcaixa("tiaguinhonhonho") );

        System.out.println( "--sistema\n" + sistema.toString() + "\n--sistema" );
        
        try {
            sistema.descarregarSistema();
        } catch ( Exception e ) { System.err.println("Erro ao descarregar sistema: " + e); System.exit(-1); }
    }

    
    public static void Testes(SistemaDeUtilizadores sistema) {
        sistema.criarConta("ricarto");
        sistema.enviarMensagem("lolinda", "ricardo", "lol", "pode ser que sim...");
            
   
    }
}
