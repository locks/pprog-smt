package mensagensgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;

public class DialogCriaConta extends JDialog {

    private JTextField txtUtilizador;
    private String nome;
    private String pass;

    JPanel p12 = new JPanel();
    JPanel p13 = new JPanel();
    
    public DialogCriaConta(Frame orig, String titulo) {
        
        super(orig, titulo, true);   // Invocação do construtor da superclasse JDialog
        this.setLocation(orig.getX() + 100, orig.getY() + 100);   //Definição do posicionamento inicial da caixa de diálogo
        this.setResizable(false);
        
        Container c = getContentPane();
       
        JButton botao;
        
        JPanel p1 = new JPanel( new GridLayout(2, 1) );
        p1.setBorder(BorderFactory.createEmptyBorder(40, 10, 10, 10));  //Definição de uma àrea vazia à volta do painel
        
        JPanel p11 = new JPanel();
        p11.add( new JLabel("Nome de Utilizador: "));
        txtUtilizador = new JTextField(10);
        p11.add(txtUtilizador);
        p1.add(p11);
        c.add(p1, BorderLayout.NORTH);

        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        botao = new JButton();
        getRootPane().setDefaultButton( botao );  // Definir o botão de OK como estando predefinido - Caso o utilizador pressione ENTER, o botão é executedo
        botao.addActionListener(new TrataEvento());
        p2.add(botao);

        botao = new JButton("Cancelar");
        new JButton( "cancelar" ).addActionListener( new TrataEvento() );
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
            if (e.getActionCommand().equals("Criar Conta")) {   // Caso o evento tenha ocorrido sobre o botão de comando Criar Conta
//               
//          TODO
//              Caso Conta ja exista!
//              JOptionPane.showMessageDialog(null,"Conta já existente.Por favor escolha outro nome","Erro",JOptionPane.ERROR_MESSAGE);
//               
//              Caso Conta nao exista!
//              JOptionPane.showMessageDialog(frame,"Conta +nome+ criada.\nPassword: +pass ","Message");
//
            } else {    // Caso o evento tenha ocorrido sobre o botão de comando Cancelar
                setVisible(false);  // Esconde a caixa de diálogo
            }
        }
        
    }  

    
        
        
}


