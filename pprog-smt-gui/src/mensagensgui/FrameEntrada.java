package mensagensgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sistema.SistemaDeUtilizadores;

public class FrameEntrada extends JFrame {

    JScrollPane txtLista;
    private String nome = null;
    private SistemaDeUtilizadores sistema = null;

    public void criarMenuBar(final SistemaDeUtilizadores sistema) {
        this.sistema = sistema;
        JMenuBar  menuBar = new JMenuBar();   // Definição de uma barra de menus
        JMenu     menu;     // Definição de um menu
        JMenuItem menuItem;     // Definição de um item de menu

        menu = new JMenu("Sistema de Mensagens");    // Criação de um menu
        menu.setMnemonic(KeyEvent.VK_S);    // Definição de uma tecla de atalho para o menu
        menuBar.add( menu );      // Adicionar o menu à barra de menus

        menuItem = new JMenuItem("Logout",KeyEvent.VK_L);   // Criação de um item de menu e respectiva tecla de atalho (ALT + P)
        menuItem.addActionListener( new ActionListener() {      // Manipulação do evento, isto é, acções a executar em resposta ao evento de clique ou selecção do item de menu
            public void actionPerformed(ActionEvent e) {
                FrameEntrada.this.setVisible(false);
                new FrameInicial("Sistema de Caixa de Mensagens");
            }
        });
        menu.add(menuItem);     // Adicionar o item de menu ao menu

        menuItem = new JMenuItem("Sair",KeyEvent.VK_S);   // Criação de um item de menu e respectiva tecla de atalho (ALT + P)
        menuItem.addActionListener( new ActionListener() {      // Manipulação do evento, isto é, acções a executar em resposta ao evento de clique ou selecção do item de menu
            public void actionPerformed(ActionEvent e) {
                Object[] opSimNao = {"Sim", "Não"}; // Criação de um vector com os botões de opção para a caixa de diálogo
                if ( JOptionPane.showOptionDialog( FrameEntrada.this, "Deseja fechar a aplicação?", "Sistema de Mensagens", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opSimNao, opSimNao[1] )  ==  0 ) {// Criar uma caixa de diálogo do tipo interrogativa com os botões de opção definidos pelo utilizador, em que o segundo desses botões se encontra pré-seleccionado (corresponde ao indíce um do vector) e verificar se o primeiro desses botões foi o seleccionado (corresponde ao índice zero do vector)
                    dispose();    // Fecha a janela/Frame
                    System.exit(0);
                }
            }
        });
        menu.add(menuItem);     // Adicionar o item de menu ao menu

        menu = new JMenu("Utilizador");    // Criação de um menu
        menu.setMnemonic(KeyEvent.VK_U);    // Definição de uma tecla de atalho para o menu
        menuBar.add(menu);      // Adicionar o menu à barra de menus

        menuItem = new JMenuItem("Editar Dados",KeyEvent.VK_E);   // Criação de um item de menu e respectiva tecla de atalho (ALT + P)
        menuItem.addActionListener( new ActionListener() {      // Manipulação do evento, isto é, acções a executar em resposta ao evento de clique ou selecção do item de menu
            public void actionPerformed(ActionEvent e) {
                DialogEditarPassword editarPassword = new DialogEditarPassword(FrameEntrada.this, "Editar Password", sistema, nome);
                editarPassword.showDialog();
            }
        });
        menu.add(menuItem);     // Adicionar o item de menu ao menu


        menuItem = new JMenuItem("Listar Utilizadores",KeyEvent.VK_L);   // Criação de um item de menu e respectiva tecla de atalho (ALT + P)
        menuItem.addActionListener( new ActionListener() {      // Manipulação do evento, isto é, acções a executar em resposta ao evento de clique ou selecção do item de menu
            public void actionPerformed(ActionEvent e) {
                DialogListarUtilizadores ecraListarUtilizadores = new DialogListarUtilizadores(FrameEntrada.this, "Utilizadores do Sistema", sistema);
                ecraListarUtilizadores.showDialog();     // Invocação do método showDialog para tornar visível a caixa de diálogo
            }
        });
        menu.add(menuItem);     // Adicionar o item de menu ao menu


        menu = new JMenu("Caixa");    // Criação de um menu
        menu.setMnemonic(KeyEvent.VK_C);    // Definição de uma tecla de atalho para o menu
        menuBar.add(menu);      // Adicionar o menu à barra de menus

        menuItem = new JMenuItem("Nova Mensagem",KeyEvent.VK_N);   // Criação de um item de menu e respectiva tecla de atalho (ALT + P)
        menuItem.addActionListener( new ActionListener() {      // Manipulação do evento, isto é, acções a executar em resposta ao evento de clique ou selecção do item de menu
            public void actionPerformed(ActionEvent e) {
                DialogNovaMensagem ecraNovaMensagem = new DialogNovaMensagem(FrameEntrada.this, "Criação de uma nova mensagem", sistema);
                ecraNovaMensagem.showDialog();     // Invocação do método showDialog para tornar visível a caixa de diálogo
            }
        });
        menu.add(menuItem);     // Adicionar o item de menu ao menu


        menuItem = new JMenuItem("Limpar Caixa",KeyEvent.VK_L);   // Criação de um item de menu e respectiva tecla de atalho (ALT + P)
        menuItem.addActionListener( new ActionListener() {      // Manipulação do evento, isto é, acções a executar em resposta ao evento de clique ou selecção do item de menu
            public void actionPerformed(ActionEvent e) {
               Object[] opSimNao = {"Sim", "Não"}; // Criação de um vector com os botões de opção para a caixa de diálogo
                if (JOptionPane.showOptionDialog(FrameEntrada.this,"Deseja Limpar a Caixa de Mensagens?","Sistema de Mensagens",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null, opSimNao, opSimNao[1] )  ==  0 ) { // Criar uma caixa de diálogo do tipo interrogativa com os botões de opção definidos pelo utilizador, em que o segundo desses botões se encontra pré-seleccionado (corresponde ao indíce um do vector) e verificar se o primeiro desses botões foi o seleccionado (corresponde ao índice zero do vector)
                    sistema.apagarMensagens( nome );
                    System.out.println("TODO  Eleminar todas as mensagens do utilizador");
                }
            }
        });
        menu.add(menuItem);     // Adicionar o item de menu ao menu

        menu = new JMenu("Ajuda");    // Criação de um menu
        menu.setMnemonic(KeyEvent.VK_A);    // Definição de uma tecla de atalho para o menu
        menuBar.add(menu);      // Adicionar o menu à barra de menus
        setJMenuBar(menuBar); // Acrescentar a barra de menus à Janela/Frame

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
                FrameInicial.pdf();
                }
        });
        menu.add(menuItem);
        setJMenuBar( menuBar );

    }
    
    public FrameEntrada(FrameInicial aThis, String titulo, SistemaDeUtilizadores sistemaRecebido, String nomeRecebido) {
        super( titulo);   // Invocação do construtor da superclasse JDialog
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        nome    = nomeRecebido;
        
        Container c = getContentPane();
        
        JLabel label;
        JButton botao;
        
        JPanel p1 = new JPanel(new FlowLayout());
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  //Definição de uma àrea vazia à volta do painel        
        
        botao = new JButton("Nova Mensagem");
        getRootPane().setDefaultButton(botao);  // Definir o botão de OK como estando predefinido - Caso o utilizador pressione ENTER, o botão é executedo
        botao.addActionListener(new TrataEvento());
        p1.add(botao);
        
        botao = new JButton("Limpar Caixa");
        botao.addActionListener(new TrataEvento());
        p1.add(botao);
        
        botao = new JButton("Listar Utilizadores");
        botao.addActionListener(new TrataEvento());
        p1.add(botao);
        
        botao = new JButton("Logout");
        botao.addActionListener(new TrataEvento());
        p1.add(botao);
        
        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  //Definição de uma àrea vazia à volta do painel
        DefaultListModel listModel = new DefaultListModel();    // Criação de uma ListBox
        JList list = new JList(listModel);  // Criação de uma ListBox
        
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Definir que apenas um item da ListBox pode ser seleccionado de cada vez
        JScrollPane scroll = new JScrollPane(list);     //Criação de uma barra de deslocamento vertical para a ListBox
        p2.add(scroll);
        
        DefaultListModel listModel1 = new DefaultListModel();    // Criação de uma ListBox
        JList list1 = new JList(listModel1);  // Criação de uma ListBox
        
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Definir que apenas um item da ListBox pode ser seleccionado de cada vez
        JScrollPane scroll1 = new JScrollPane(list1);     //Criação de uma barra de deslocamento vertical para a ListBox
        p2.add(scroll1);
        c.add(p2, BorderLayout.CENTER);
       
        JPanel p3 = new JPanel();
        p3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  //Definição de uma àrea vazia à volta do painel
        botao = new JButton("Apagar Mensagem");
        botao.addActionListener(new TrataEvento());
        p3.add(botao);
        c.add(p3,BorderLayout.SOUTH);
        c.add(p1,BorderLayout.NORTH);
        c.add(p2,BorderLayout.WEST);

        criarMenuBar(sistemaRecebido);

        pack();     //As dimensões da janela são ajustadas automaticamente ao mínimo necessário que permite mostrar todos os seus componentes
        setMinimumSize(new Dimension(getWidth(), getHeight()));     // Definir como dimensões mínimas da Janela/Frame a actual largura e altura
    }

    
    void showDialog() {
        setVisible(true); 
    }

    class TrataEvento implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Nova Mensagem")) {   // Caso o evento tenha ocorrido sobre o botão de comando Nova Mensagem
                DialogNovaMensagem ecraNovaMensagem = new DialogNovaMensagem(FrameEntrada.this, "Criação de uma nova Mensagem", sistema);
                ecraNovaMensagem.showDialog();     // Invocação do método showDialog para tornar visível a caixa de diálogo
            }
            if (e.getActionCommand().equals("Listar Utilizadores")) {   // Caso o evento tenha ocorrido sobre o botão de comando Listar Utilizadores
                DialogListarUtilizadores ecraListarUtilizadores = new DialogListarUtilizadores(FrameEntrada.this, "Utilizadores do Sistema", sistema);
                ecraListarUtilizadores.showDialog();     // Invocação do método showDialog para tornar visível a caixa de diálogo
            }
            if (e.getActionCommand().equals("Logout")) {   // Caso o evento tenha ocorrido sobre o botão de comando Logout
                setVisible(false);
                sistema.descarregarSistema();
                new FrameInicial("Sistema de Caixa de Mensagens");
            }
            if (e.getActionCommand().equals("Limpar Caixa")) {   // Caso o evento tenha ocorrido sobre o botão de comando Limpar Caixa
                Object[] opSimNao = {"Sim", "Não"}; // Criação de um vector com os botões de opção para a caixa de diálogo
                if (JOptionPane.showOptionDialog(FrameEntrada.this,"Deseja Limpar a Caixa de Mensagens?","Sistema de Mensagens",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null, opSimNao, opSimNao[1] )  ==  0 ) // Criar uma caixa de diálogo do tipo interrogativa com os botões de opção definidos pelo utilizador, em que o segundo desses botões se encontra pré-seleccionado (corresponde ao indíce um do vector) e verificar se o primeiro desses botões foi o seleccionado (corresponde ao índice zero do vector)
            
                    System.out.println("TODO  Eleminar todas as mensagens do utilizador");
                            
            }    
        }
        
    }
}
    

