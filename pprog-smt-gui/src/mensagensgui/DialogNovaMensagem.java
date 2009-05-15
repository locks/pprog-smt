package mensagensgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JDialog;

class DialogNovaMensagem extends JDialog{
    
    private JTextField txtPara;
    private JTextField txtAssunto;
    JScrollPane txtLista;

   public DialogNovaMensagem(FrameEntrada orig, String titulo) {
        super(orig,titulo);
        this.setLocation(orig.getX() + 100, orig.getY() + 100);   //Definição do posicionamento inicial da caixa de diálogo
        this.setResizable(false);
        
        
        JMenuBar menuBar;   // Definição de uma barra de menus
        JMenu menu;     // Definição de um menu
        JMenuItem menuItem;     // Definição de um item de menu
        
        Container c = getContentPane();

        JLabel label;
        JButton botao;
        
        JPanel p1 = new JPanel(new GridLayout(2, 1));
        p1.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));  //Definição de uma àrea vazia à volta do painel
        
        JPanel p11 = new JPanel();
        label = new JLabel("Para:      ");
        p11.add(label);
        txtPara = new JTextField(15);
        p11.add(txtPara);
        p1.add(p11);
        
//        JPanel p14 = new JPanel(new BorderLayout());
//        p14.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  //Definição de uma àrea vazia à volta do painel
//        DefaultListModel listModel = new DefaultListModel();    // Criação de uma ListBox
//        JList list = new JList(listModel);  // Criação de uma ListBox
//        
//        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Definir que apenas um item da ListBox pode ser seleccionado de cada vez
//        JScrollPane scroll = new JScrollPane(list);     //Criação de uma barra de deslocamento vertical para a ListBox
//        p14.add(scroll, BorderLayout.CENTER);
//        c.add(p14, BorderLayout.CENTER);
        
        JPanel p12 = new JPanel();
        label = new JLabel("Assunto:");
        p12.add(label);
        txtAssunto = new JPasswordField(15);
        p12.add(txtAssunto);
        p1.add(p12);
        c.add(p1, BorderLayout.NORTH);
        
        JTextPane p13 = new JTextPane();
        txtLista = new JScrollPane(p13);
        txtLista.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        txtLista.setPreferredSize(new Dimension(70, 70));
        
        p1.add(txtLista);
        c.add(txtLista,BorderLayout.CENTER);
        
//        JPanel p13 = new JPanel(new BorderLayout());
//        p13.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  //Definição de uma àrea vazia à volta do painel
//        DefaultListModel listModel = new DefaultListModel();    // Criação de uma ListBox
//        JList list = new JList(listModel);  // Criação de uma ListBox
//        
//        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Definir que apenas um item da ListBox pode ser seleccionado de cada vez
//        JScrollPane scroll = new JScrollPane(list);     //Criação de uma barra de deslocamento vertical para a ListBox
//        p13.add(scroll, BorderLayout.CENTER);
//        c.add(p13, BorderLayout.CENTER);

        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        botao = new JButton("Enviar");
        getRootPane().setDefaultButton(botao);  // Definir o botão de OK como estando predefinido - Caso o utilizador pressione ENTER, o botão é executedo
        botao.addActionListener(new TrataEvento());
        p2.add(botao);
        c.add(p2, BorderLayout.SOUTH);
        
        botao = new JButton("Cancelar");
        botao.addActionListener(new TrataEvento());
        p2.add(botao);
        c.add(p2, BorderLayout.SOUTH);
        
        pack();     //As dimensões da janela são ajustadas automaticamente ao mínimo necessário que permite mostrar todos os seus componentes
        setMinimumSize(new Dimension(getWidth(), getHeight()));     // Definir como dimensões mínimas da Janela/Frame a actual largura e altura
         
       }

    void showDialog() {
        setVisible(true); 
    }
    
     class TrataEvento implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Enviar")) {   // Caso o evento tenha ocorrido sobre o botão de comando Enviar
//               
//          TODO
//              Enviar Mensagem
//              
//
            } else {    // Caso o evento tenha ocorrido sobre o botão de comando Cancelar
                setVisible(false);  // Esconde a caixa de diálogo
            }
    }
    }
    

}
