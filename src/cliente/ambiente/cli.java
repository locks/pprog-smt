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

    public void menuInicial() {
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

    private void ecraCriarConta() {
        System.out.print("Introduza o nome desejado: ");
        String nome = input.nextLine().trim();

        if (existeNomeUtilizador(nome) == null) {
            utilizadorSessao = criarConta(nome);
            System.out.println("conta criada.\n" +
                    "nome: " + utilizadorSessao.getNome() + "\n" +
                    "password: " + utilizadorSessao.getPassword());
            menuInicial();
        } else {
            System.out.println(nome + " já existe, escolha outro.");
            ecraCriarConta();
        }
    }

    private void loginUtilizador() {
        input = new Scanner(System.in);

        System.out.println("--LOGIN--");
        System.out.print("Nome de Utilizador: ");
        String nome = input.nextLine();
        System.out.print("Password do Utilizador: ");
        String password = input.nextLine();

        utilizadorSessao = validarCredenciais(nome, password);

        if (utilizadorSessao == null) {
            System.out.println("credenciais invalidas.");
            utilizadorSessao = null;
            System.out.print("Deseja Sair (s/n)?");
            if (input.nextLine().equalsIgnoreCase("s")) {
                System.exit(0);
            } else {
                loginUtilizador();
            }
        } else {
            System.out.println("Login efectuado com sucesso.\n");
            sessaoAutenticada();
        }
    }

    private void sessaoAutenticada() {
        System.out.println("--SISTEMA CAIXA DE MENSAGENS DE TEXTO--");
        System.out.println("1 - Editar conta\n2 - Caixa de mensagens\n3 - Listar utilizadores\n4 - Sair");
        int opcao = Integer.parseInt(input.nextLine());

        switch (opcao) {
            case 1:
                menuEditarConta();
                break;
            case 2:
                verCaixaDeMensagens();
                break;
            case 3:
                listarUtilizadores();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Opcao invalida.");
                sessaoAutenticada();
                break;
        }
    }

    private void menuEditarConta() {
        System.out.println("--EDITAR CONTA--" + "\n" +
                "1 - Editar nome" + "\n" +
                "2 - Editar password");

        int opcao = Integer.parseInt(input.nextLine());
        switch (opcao) {
            case 1:
                editarNomeUtilizador();
                sessaoAutenticada();
                break;
            case 2:
                editarPasswordUtilizador();
                sessaoAutenticada();
                break;
            default:
                System.out.println("Opcao invalida.");
                menuEditarConta();
                break;
        }
    }

    private void editarNomeUtilizador() {
        System.out.print("Nome actual: " + utilizadorSessao.getNome() + "\n");
        System.out.print("Escreva o nome pretendido: ");
        try {
            utilizadorSessao.setNome(input.nextLine().trim());
        } catch (Exception e) {
            editarNomeUtilizador();
        }
    }

    private void editarPasswordUtilizador() {
        System.out.print("Password actual: " + utilizadorSessao.getPassword() + "\n");
        try {
            System.out.println("Escreva a password pretendida: ");
            utilizadorSessao.setPassword(input.nextLine().trim());
            System.out.println("Repita a password pretendida: ");

            if (utilizadorSessao.getPassword().equals(input.nextLine().trim()));
        } catch (Exception e) {
            editarPasswordUtilizador();
        }
    }

    private void menuCaixaDeMensagens() {
        System.out.println("--CAIXA DE MENSAGENS--" + "\n" +
                "1- Enviar mensagem" + "\n" +
                "2- Ver mensagens");
        int opcao = Integer.parseInt(input.nextLine().trim());
        switch (opcao) {
            case 1:
                comporMensagem();
                break;
            case 2:
                verMensagens();
                break;
            case 3:
                break;
            default:
                System.out.println("Opcao invalida");
                menuCaixaDeMensagens();
                break;
        }
    }

    private void comporMensagem() {
        System.out.print("Destinatário: ");
        Utilizador to = existeNomeUtilizador(input.nextLine().trim());
        if (to == null) {
            System.out.println("Erro, Nome nao Existente!");
            comporMensagem();
        }

        System.out.print("Assunto: ");
        String subject = input.nextLine();
        System.out.print("Mensagem: \n  ");
        String body = input.nextLine();

        enviarMensagem(to, utilizadorSessao, subject, body);
        menuCaixaDeMensagens();
    }

    private void verMensagens() {
        System.out.println("--cAIXA DE MENSAGENS--\n");
        super.verCaixaDeMensagens();
        System.out.println(utilizadorSessao.getCaixaDeMensagens().toString());
    }

    public void listarUtilizadores() {
        System.out.println(super.toString());
        sessaoAutenticada();
    }
}
