package pprogsmt;

import ClassesTeste.Sistema;
import java.util.Scanner;

public class InterfaceTexto extends Sistema {

    private static Scanner input;
    private int indice;

    public InterfaceTexto() {
        super();
        input = new Scanner(System.in);

        //conta teste
        super.criarConta("teste");
    }

    public void ecraInicial() {
        int opcao=0;
        System.out.println("    SISTEMA DE MENSAGENS DE TEXTO\n");
        System.out.println("1 - Criar conta\n2 - Login\n3 - Sair.\n");
        System.out.print("Opcao: ");
        
        try {
            opcao = Integer.valueOf(input.nextLine().trim());
        } catch(Exception e) {

        }
        
        switch (opcao) {
            case 1:
                criarConta();
                break;
            case 2:
                loginUtilizador();
                break;
            case 3: {
                System.out.println("A sair...");
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Opcao invalida.");
                ecraInicial();
                break;
            }
        }
    }

    public void criarConta() {
        boolean flag = false;
        System.out.print("Introduza o nome desejado: ");
        
        String nome = input.nextLine().trim();

        if (super.existeUtilizador(nome))
            System.out.println("Nome já existente.");
        else
            super.criarConta(nome);

    }

    public void loginUtilizador() {
        input = new Scanner(System.in);

        System.out.println("--LOGIN--");
        System.out.print("Nome de Utilizador: ");
        String nome = input.nextLine();
        System.out.print("Password do Utilizador: ");
        String password = input.nextLine();

        int i = super.validarCredenciais(nome, password);
        if (i == -1) {
            System.out.println("credenciais invalidas.");
            loginUtilizador();
        } else {
            indice = i;
            System.out.println("Login efectuado com sucesso.");
            sessaoAutenticada();
        }
    }

    public void sessaoAutenticada() {
        System.out.println("1 - Editar conta\n2 - Ver caixa de mensagens");
        int opcao = Integer.parseInt(input.nextLine());

        switch (opcao) {
            case 1:
                editarConta();
                break;
            case 2:
                verCaixaDeMensagens();
                break;
            default: {
                System.out.println("Opcao invalida.");
                sessaoAutenticada();
                break;
            }
        }
    }

    public void editarConta() {
        System.out.println("1 - Alterar Nome\n2 - Alterar Password");

        int opcao = Integer.parseInt(input.nextLine());
        String nome = null;
        String pass = null;
        switch (opcao){
            case 1:
                {
                    System.out.println("Nome Actual" + super.getUtilizador(indice).getNome());
                    System.out.println("Escreva o Novo Nome");
                    do{
                    nome = input.nextLine().trim();
                    } while(nome.equals(""));
                    super.getUtilizador(indice).setNome(nome);
                 }

            case 2:
                {
                    System.out.println("Password Actual" + super.getUtilizador(indice).getPassword());
                    System.out.println("Escreva a Nova Pasword");
                    do {
                        pass = input.nextLine().trim();
                    } while (pass.equals(""));
                    super.getUtilizador(indice).setPassword(pass);
                }

        }
    }

    public void verCaixaDeMensagens() {
    }
}
