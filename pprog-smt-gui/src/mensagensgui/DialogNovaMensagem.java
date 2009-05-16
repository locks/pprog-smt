
package mensagensgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JDialog;


class DialogNovaMensagem extends JDialog{
    
    private JTextField txtPara;
    private JTextField txtAssunto;
    private JTextPane txtLista;
    JScrollPane scrollTexto;

   public DialogNovaMensagem(FrameEntrada orig, String titulo) {
        super(orig,titulo);
        this.setLocation(orig.getX() + 100, orig.getY() + 100);   //Definição do posicionamento inicial da caixa de diálogo
        this.setResizable(true);
        
        
        JMenuBar menuBar;   // Definição de uma barra de menus
        JMenu menu;     // Definição de um menu
        JMenuItem menuItem;     // Definição de um item de menu
        
        Container c = getContentPane();

        JLabel label;
        JButton botao;
        
        JPanel p1 = new JPanel();
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  //Definição de uma àrea vazia à volta do painel

        JPanel p11 = new JPanel();
        label = new JLabel("Para:  ");
        p11.add(label);
        txtPara = new JTextField(10);
        p11.add(txtPara);
        
        DefaultListModel listModel = new DefaultListModel();    // Criação de uma ListBox
        JList list = new JList(listModel);  // Criação de uma ListBox
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Definir que apenas um item da ListBox pode ser seleccionado de cada vez
        JScrollPane scroll = new JScrollPane(list);     //Criação de uma barra de deslocamento vertical para a ListBox
        p11.add(scroll);
        
        
        botao = new JButton("Enviar Para Todos");
        getRootPane().setDefaultButton(botao);  // Definir o botão de OK como estando predefinido - Caso o utilizador pressione ENTER, o botão é executedo
        botao.addActionListener(new TrataEvento());
        p11.add(botao);
        
        p1.add(p11,BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  //Definição de uma àrea vazia à volta do painel

        JPanel p21 = new JPanel();
        label = new JLabel("Assunto:");
        p21.add(label);
        txtAssunto = new JPasswordField(15);
        p21.add(txtAssunto);
        
        txtLista = new JTextPane();
        scrollTexto = new JScrollPane(txtLista);
        scrollTexto.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollTexto.setPreferredSize(new Dimension(170, 220));

        p21.add(new JSeparator(SwingConstants.VERTICAL));
        p21.add(scrollTexto);
        p2.add(p21,BorderLayout.CENTER);
        
        JPanel p3 = new JPanel();
        p3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        botao = new JButton("Enviar");
        getRootPane().setDefaultButton(botao);  // Definir o botão de OK como estando predefinido - Caso o utilizador pressione ENTER, o botão é executedo
        botao.addActionListener(new TrataEvento());
        p3.add(botao);

        botao = new JButton("Cancelar");
        botao.addActionListener(new TrataEvento());
        p3.add(botao);
        c.add(p3, BorderLayout.SOUTH);
        
        
        
        c.add(p1,BorderLayout.NORTH);
        c.add(p2,BorderLayout.CENTER);
        c.add(p3, BorderLayout.SOUTH);
        pack();     //As dimensões da janela são ajustadas automaticamente ao mínimo necessário que permite mostrar todos os seus componentes
        setMinimumSize(new Dimension(getWidth(), getHeight()));     // Definir como dimensões mínimas da Janela/Frame a actual largura e altura
    
       }

    void showDialog() {
        setVisible(true); 
    }
    
     class TrataEvento implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Enviar")) {   // Caso o evento tenha ocorrido sobre o botão de comando Enviar
            
            }else{   
//               
//          TODO
//              Enviar Mensagem
//              
//
            if (e.getActionCommand().equals("Enviar Para Todos")) {
            } else {    // Caso o evento tenha ocorrido sobre o botão de comando Cancelar
                setVisible(false);  // Esconde a caixa de diálogo
            }
            }
    }
    }
    

}
