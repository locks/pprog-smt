package Menus;

import java.util.Scanner;

public class ModoTexto {

    private static Scanner input;
    private static int     opcao;

    public ModoTexto() {
        menuInicial();
    }

    private static void menuInicial() {
        System.out.println("SISTEMA DE MENSAGENS DE TEXTO\n");
        System.out.println("1 - Criar conta\n2 - Login\n3 - Sair.\n");
        System.out.print("Opcao: ");

        opcao = Integer.valueOf( input.nextLine().trim() );

        switch (opcao) {
            case 1:
                menucriarconta();
                break;
            case 2:
                menuLogin();
                break;
            case 3:
                sair();
                break;
            default:
                System.out.println("Opcao invalida.");
                menuInicial();
                break;
        }

    }

    private static void menucriarconta() {

    }

    private static void menuLogin() {
        System.out.print("Introduza o nome: ");
        System.out.print("Introduza a palavra-passe: ");
    }

    private static void sair() {
        System.out.println("A sair...");
        System.exit(0);
    }

    public static void main(String[] args) {
        menuInicial();
    }

}
