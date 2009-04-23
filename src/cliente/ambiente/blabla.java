/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.ambiente;

import ClassesTeste.Sistema;
import java.util.Scanner;

/**
 *
 * @author locks
 */
public class blabla {

    private Sistema sistema;
    private static Scanner input;

    public blabla() {
        sistema = new Sistema();
        input = new Scanner(System.in);
    }

    public static void menuInicial() {
        int opcao = 0;

        System.out.println("    SISTEMA DE MENSAGENS DE TEXTO\n");
        System.out.println("1 - Criar conta\n2 - Login\n3 - Sair.\n");
        System.out.print("Opcao: ");

        try {
            opcao = Integer.valueOf(input.nextLine().trim());
        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }

        switch (opcao) {
            case 1:
                ecraCriarConta();
                break;
            case 2:
                loginUtilizador();
                break;
            case 3:
                System.out.println("A sair...");
                System.exit(0);
                break;
            default:
                System.out.println("Opcao invalida.");
                menuInicial();
                break;
        }
    }

    private static void ecraCriarConta() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static void loginUtilizador() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
