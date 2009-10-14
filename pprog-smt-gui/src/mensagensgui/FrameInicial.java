package mensagensgui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import sistema.*;

public class FrameInicial extends JFrame{
    
    private JTextField txtUtilizador;
    private JTextField txtPass;
    private SistemaDeUtilizadores sistema = null;
    
//    JPanel p14;

    public void criarMenu() {
        JMenuBar  menuBar = new JMenuBar();   // Definição de uma barra de menus
        JMenu     menu;     // Definição de um menu
        JMenuItem menuItem;     // Definição de um item de menu

        menu = new JMenu("Sistema de Mensagens");    // Criação de um menu
        menu.setMnemonic(KeyEvent.VK_S);    // Definição de uma tecla de atalho para o menu
        menuBar.add(menu);      // Adicionar o menu à barra de menus

        menuItem = new JMenuItem("Criar Conta",KeyEvent.VK_C);   // Criação de um item de menu e respectiva tecla de atalho (ALT + P)
        menuItem.addActionListener( new ActionListener() {      // Manipulação do evento, isto é, acções a executar em resposta ao evento de clique ou selecção do item de menu
            public void actionPerformed(ActionEvent e) {
                DialogCriaConta ecraCriarConta = new DialogCriaConta(FrameInicial.this, "Criação de uma nova Conta", sistema);
                ecraCriarConta.showDialog();     // Invocação do método showDialog para tornar visível a caixa de diálogo
            }
        });
        menu.add(menuItem);     // Adicionar o item de menu ao menu

        menuItem = new JMenuItem("Sair",KeyEvent.VK_S);
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] opSimNao = {"Sim", "Não"}; // Criação de um vector com os botões de opção para a caixa de diálogo
                if (JOptionPane.showOptionDialog( FrameInicial.this, "Deseja fechar a aplicação?", "Sistema de Mensagens", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1]  )  ==  0 ) { // Criar uma caixa de diálogo do tipo interrogativa com os botões de opção definidos pelo utilizador, em que o segundo desses botões se encontra pré-seleccionado (corresponde ao indíce um do vector) e verificar se o primeiro desses botões foi o seleccionado (corresponde ao índice zero do vector)
                    sistema.descarregarSistema();
                    dispose();    // Fecha a janela/Frame
                }
            }
        });
        menu.add(menuItem);

        menu = new JMenu("Ajuda");    // Criação de um menu
        menu.setMnemonic(KeyEvent.VK_A);    // Definição de uma tecla de atalho para o menu
        menuBar.add(menu);      // Adicionar o menu à barra de menus

        menuItem = new JMenuItem("Sobre",KeyEvent.VK_S);   // Criação de um item de menu e respectiva tecla de atalho (ALT + P)
        menuItem.addActionListener( new ActionListener() {      // Manipulação do evento, isto é, acções a executar em resposta ao evento de clique ou selecção do item de menu
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sistema de Mensagens de Texto\n" +
                        "Versão 127.0.0.1\n\n" +
                        "Elaborado por:\n" +
                        "1060516 - Ricardo Mendes\n" +
                        "1060528 - Tiago Valente");
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Manual do Utilizador",KeyEvent.VK_M);
        menuItem.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pdf();
            }
        });
        menu.add(menuItem);
        setJMenuBar(menuBar);
    }

    public FrameInicial(String titulo){
        super(titulo);
        setResizable(false);
        setSize(300,200);   // Definição das dimensões iniciais da Janela/Frame
        setMinimumSize(new Dimension(300,200));     // Definição das dimensões mínimas da Janela/Frame
        setLocation(200,200);   // Definição do posicionamento inicial da Janela/Frame
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        sistema = SistemaDeUtilizadores.carregarSistema();
        sistema.descarregarSistema();
        System.out.println( "sistema: " + sistema );
        
        Container c = getContentPane();

        JLabel label;
        JButton botao;
        
        JPanel p1 = new JPanel(new GridLayout(2, 1));
        p1.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));  //Definição de uma àrea vazia à volta do painel
        
        JPanel p11 = new JPanel();
        label = new JLabel("Nome:        ");
        p11.add(label);
        txtUtilizador = new JTextField(15);
        p11.add(txtUtilizador);
        p1.add(p11);
        
        JPanel p12 = new JPanel();
        label = new JLabel("Password:");
        p12.add(label);
        txtPass = new JPasswordField(15);
        p12.add(txtPass);
        p1.add(p12);
        c.add(p1, BorderLayout.NORTH);
        

        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        botao = new JButton("Login");
        getRootPane().setDefaultButton(botao);  // Definir o botão de OK como estando predefinido - Caso o utilizador pressione ENTER, o botão é executedo
        botao.addActionListener(new TrataEvento());
        p2.add(botao);
        c.add(p2, BorderLayout.SOUTH);

        criarMenu();

        pack();     //As dimensões da janela são ajustadas automaticamente ao mínimo necessário que permite mostrar todos os seus componentes
        setMinimumSize(new Dimension(getWidth(), getHeight()));     // Definir como dimensões mínimas da Janela/Frame a actual largura e altura
    }

    class TrataEvento implements ActionListener {

        public void actionPerformed(ActionEvent e) {            
          if (e.getActionCommand().equals("Login")) {   // Caso o evento tenha ocorrido sobre o botão de comando Criar Conta
          System.out.println( txtUtilizador.getText() + txtPass.getText() );
          
            if ( sistema.validarCredenciais(txtUtilizador.getText().trim() , txtPass.getText().trim()) ) {
                FrameEntrada ecraEntrada = new FrameEntrada(FrameInicial.this, "Caixa de Entrada", sistema, txtUtilizador.getText());
                FrameInicial.this.setVisible(false);
                ecraEntrada.showDialog();     // Invocação do método showDialog para tornar visível a caixa de diálogo
            } else
                JOptionPane.showMessageDialog(null,
                        "Login Incorrecto.\nIntroduza Novamente os Dados",
                        "Login Incorrecto",
                        JOptionPane.WARNING_MESSAGE);
          }
        }
        
    }
    
    public static void pdf() {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "teste.pdf");   //open the file chart.pdf
        } catch (Exception e) { System.out.println("Erro ao Abrir Manual" + e ); }
    }
}
    