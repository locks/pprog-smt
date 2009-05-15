package pprogsmtcli;

import sistema.*;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        SistemaDeUtilizadores sistema = null;

        
        try {
            sistema = new SistemaDeUtilizadores();
        } catch ( Exception e ) { System.err.println("Não foi possível inicializar o sistema."); System.exit(-1); }

        System.out.println( sistema.toString() );

        System.exit(0);
        
        try {
            sistema.descarregarSistema();
        } catch ( Exception e ) { System.err.println("Erro ao descarregar sistema: " + e); System.exit(-1); }

        System.out.println("\n--PARTE 2: carregar ficheiro--\n");
        sistema = null;

        try {
            sistema = new SistemaDeUtilizadores();
            sistema.carregarSistema();
        } catch ( Exception e ) {}

        System.out.println( sistema.toString() );

    }

}
