
package mensagensgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JDialog;
import sistema.SistemaDeUtilizadores;

class DialogNovaMensagem extends JDialog{
    
    private JTextField  txtPara;
    private JTextField  txtAssunto;
    private JTextPane   txtLista;
    private JScrollPane scrollTexto;
    private JScrollPane listaUtilizadores = null;
    private SistemaDeUtilizadores sistema;

   public DialogNovaMensagem(FrameEntrada orig, String titulo, SistemaDeUtilizadores sistema) {
        super(orig,titulo);
        setLocation(orig.getX() + 100, orig.getY() + 100);   //Definição do posicionamento inicial da caixa de diálogo
        setResizable(true);

        Container c = getContentPane();
        listaUtilizadores = DialogListarUtilizadores.lista( sistema );
        this.sistema = sistema;

        JLabel label;
        JButton botao;
        
        JPanel p1 = new JPanel();
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  //Definição de uma àrea vazia à volta do painel

        JPanel p11 = new JPanel();
        label = new JLabel("Para:  ");
        p11.add(label);
        txtPara = new JTextField(10);
        p11.add(txtPara);

        // adiciona scrollpane com... a lista de utilizadores
//        p11.add( listaUtilizadores );
        
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
            
            } else {
                sistema.enviarMensagem("lolely.", "Ricardo", "teste", "tteessttee");
                setVisible(false);
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
