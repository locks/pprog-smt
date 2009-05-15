package pprogsmtcli;

import sistema.*;
import java.util.Scanner;

public class Texto {

/*
    private static Scanner input;
    private Sessao sessao;

    public static void iniciar() {
        Texto consola = new Texto();
        consola.menuInicial();
    }

    public Texto() {
        super();
        input = new Scanner(System.in);
    }

    public void menuInicial() {

        System.out.println("    SISTEMA DE MENSAGENS DE TEXTO\n");
        System.out.println("1 - Criar conta\n2 - Login\n3 - Sair.\n");
        System.out.print("Opcao: ");

        int opcao = Integer.valueOf( input.nextLine().trim() );

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
        String nome = null;

        do {
            System.out.print("Introduza o nome desejado: ");
            nome = input.nextLine().trim();

            if ( sessao.existeUtilizador(nome) )
                System.out.println(nome + " já existe.");
        } while (nome!=null);

        sessao = criarConta(nome);
        System.out.println("conta criada.\n" +
                "nome: " + sessao.getNome() + "\n" +
                "password: " + sessao.getPassword());
        menuInicial();
    }

    private void loginUtilizador() {
        System.out.println("--LOGIN--\n");
        System.out.print("Nome de Utilizador: ");
        String nome = input.nextLine();
        System.out.print("Password do Utilizador: ");
        String password = input.nextLine();

        sessao = validarCredenciais(nome, password);

        if (sessao == null) {
            System.out.println("credenciais invalidas.");
            sessao = null;
            System.out.print("Deseja Sair (s/n)? ");

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
        System.out.println("--Bem-vindo " + sessao.getNome() + "--\n");
        System.out.println("1 - Editar conta\n2 - Caixa de mensagens\n3 - Listar utilizadores\n4 - Sair");
        System.out.print("Opção: ");
        int opcao = Integer.parseInt(input.nextLine());

        switch (opcao) {
            case 1:
                menuEditarConta();
                break;

            case 2:
                menuCaixaDeMensagens();
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
        System.out.print("Nome actual: " + sessao.getNome() + "\n");
        System.out.print("Escreva o nome pretendido: ");
        try {
            utilizadorSessao.setNome(input.nextLine().trim());
        } catch (Exception e) {
            editarNomeUtilizador();
        }

    }

    private void editarPasswordUtilizador() {
        System.out.print("Password actual: " + sessao.getPassword() + "\n");
        try {
            System.out.println("Escreva a password pretendida: ");
            sessao.setPassword(input.nextLine().trim());
            System.out.println("Repita a password pretendida: ");

            if (sessao.getPassword().equals(input.nextLine().trim()));
        } catch (Exception e) {
            editarPasswordUtilizador();
        }

    }

    private void menuCaixaDeMensagens() {
        System.out.println("--Caixa de Mensagens--" + "\n\n" +
                "1- Enviar mensagem" + "\n" +
                "2- Ver mensagens\n");
        System.out.print("Opção: ");
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
        Utilizador utilizador = null;
        do {
            System.out.print("Destinatário: ");
//            utilizador = existeUtilizador(input.nextLine().trim());

            if (utilizador == null) {
                System.out.println("Erro, Nome nao Existente!");
            }

        } while (utilizador == null);

        System.out.print("Assunto: ");
        String subject = input.nextLine();
        System.out.print("Mensagem: \n  ");
        String body = input.nextLine();

        enviarMensagem(utilizador, sessao, subject, body);
        menuCaixaDeMensagens();

    }

    private void verMensagens() {
        System.out.println("    CAIXA DE MENSAGENS\n");
        System.out.println(sessao.getCaixaDeMensagens());
    }

    public void listarUtilizadores() {
        System.out.println(super.toString());
        sessaoAutenticada();

    }

 */
}
