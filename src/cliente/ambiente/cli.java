package cliente.ambiente;

import ClassesTeste.*;
import java.util.Scanner;

public class cli extends Sistema {
    private static Scanner input;
    private Utilizador utilizadorSessao;

    public cli() {
        super();
        input = new Scanner(System.in);
    }

    public void ecraInicial() {
        int opcao=0;

        System.out.println("    SISTEMA DE MENSAGENS DE TEXTO\n");
        System.out.println("1 - Criar conta\n2 - Login\n3 - Sair.\n");
        System.out.print("Opcao: ");
        
        try {
            opcao = Integer.valueOf(input.nextLine().trim());
        } catch(Exception e) {
            System.err.println("Erro: " + e);
        }
        
        switch (opcao) {
            case 1:
                criarConta();
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
                ecraInicial();
                break;
        }
    }

    private void criarConta() {
        System.out.print("Introduza o nome desejado: ");
        
        String nome = input.nextLine().trim();

        if (super.existeNomeUtilizador(nome))
            System.out.println("Nome já existente.");
        else
            super.criarConta(nome);
    }

    private void loginUtilizador() {
        input = new Scanner(System.in);

        System.out.println("--LOGIN--");
        System.out.print("Nome de Utilizador: ");
        String nome = input.nextLine();
        System.out.print("Password do Utilizador: ");
        String password = input.nextLine();

        if (super.validarCredenciais(nome, password)==null) {
            System.out.println("credenciais invalidas.");
            loginUtilizador();
        } else {
            System.out.println("Login efectuado com sucesso.\n");
            sessaoAutenticada();
        }
    }

    private void sessaoAutenticada() {
        System.out.println("1 - Editar conta\n2 - Caixa de mensagens");
        int opcao = Integer.parseInt(input.nextLine());

        switch (opcao) {
            case 1:
                editarConta();
                break;
            case 2:
                verCaixaDeMensagens();
                break;
            default:
                System.out.println("Opcao invalida.");
                sessaoAutenticada();
                break;
        }
    }

    private void editarConta() {
        System.out.println("--EDITAR CONTA--" + "\n" +
                "1 - Editar nome" + "\n" +
                "2 - Editar password");

        int opcao = Integer.parseInt(input.nextLine());
        switch (opcao){
            case 1:
                editarNomeUtilizador();
                break;
             case 2:
                editarPasswordUtilizador();
                break;
            default:
                System.out.println("Opcao invalida.");
                editarConta();
                break;
        }
    }

    private void editarNomeUtilizador() {
        System.out.println("Nome Actual" + utilizadorSessao.getNome());
        System.out.println("Escreva o nome pretendido:");
        try {
            utilizadorSessao.setNome(input.nextLine().trim());
        } catch (Exception e) { editarNomeUtilizador(); }
    }
    
    private void editarPasswordUtilizador() {
        System.out.println("Password Actual" + utilizadorSessao.getPassword());
        System.out.println("Escreva a password pretendida:");
        try {
            utilizadorSessao.setPassword(input.nextLine().trim());
        } catch (Exception e) { editarPasswordUtilizador(); }
 }

    private void verCaixaDeMensagens() {
        System.out.println("--CAIXA DE MENSAGENS--" + "\n" +
                "1- Enviar mensagem" + "\n" +
                "2- Ver mensagens");
        int opcao = Integer.parseInt(input.nextLine());
        switch (opcao) {
            case 1:
                enviarMensagem();
                break;
            case 2:
                verMensagens();
                break;
            case 3:
                break;
            default:
                System.out.println("Opcao invalida");
                verCaixaDeMensagens();
                break;
        }
    }

    private void enviarMensagem() {}
    private void verMensagens() {}
}
