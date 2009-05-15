package mensagensgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DialogLogin extends JDialog {
//    private comunicacao comunicacoes;
    private JTextField txtUtilizador;
    private JTextField txtPass;
    
    JPanel p13 = new JPanel();
    JPanel p14 = new JPanel();
    

    public DialogLogin(Frame orig, String titulo) {
        super(orig, titulo, true);   // Invocação do construtor da superclasse JDialog
        this.setLocation(orig.getX() + 100, orig.getY() + 100);   //Definição do posicionamento inicial da caixa de diálogo
        Container c = getContentPane();

        JLabel label;
        JButton botao;
        JPanel p1 = new JPanel(new GridLayout(2, 1));
        p1.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));  //Definição de uma àrea vazia à volta do painel
        
        JPanel p11 = new JPanel();
        label = new JLabel("Nome:");
        p11.add(label);
        txtUtilizador = new JTextField(20);
        p11.add(txtUtilizador);
        p1.add(p11);
        
        JPanel p12 = new JPanel();
        label = new JLabel("Password:");
        p12.add(label);
        txtPass = new JTextField(20);
        p12.add(txtPass);
        p1.add(p12);
        c.add(p1, BorderLayout.NORTH);
        
        label = new JLabel("Login Efectuado com Sucesso!");
        p13.add(label);
        p13.setVisible(false);
        c.add(p1, BorderLayout.NORTH);
        
        label = new JLabel("Erro! Dados Incorrectos");
        p14.add(label);
        p14.setVisible(false);
        c.add(p1, BorderLayout.NORTH);

        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        botao = new JButton("Login");
        getRootPane().setDefaultButton(botao);  // Definir o botão de OK como estando predefinido - Caso o utilizador pressione ENTER, o botão é executedo
        botao.addActionListener(new TrataEvento());
        p2.add(botao);

        botao = new JButton("Cancelar");
        botao.addActionListener(new TrataEvento());
        p2.add(botao);
        c.add(p2, BorderLayout.CENTER);

        pack();     //As dimensões da janela são ajustadas automaticamente ao mínimo necessário que permite mostrar todos os seus componentes
        setMinimumSize(new Dimension(getWidth(), getHeight()));     // Definir como dimensões mínimas da Janela/Frame a actual largura e altura
    }

    void showDialog() {
        setVisible(true);    
    }
    
    class TrataEvento implements ActionListener {

        public void actionPerformed(ActionEvent e) {            
        
                if (e.getActionCommand().equals("Login")) {   // Caso o evento tenha ocorrido sobre o botão de comando Login
                p14.setVisible(true);
//                try {
//                    try {
//                        comunicacoes.envia(txtUtilizador.getText().trim()+"\n"+txtPass.getText().trim());
//                    } catch (Exception ex) {
//                        System.err.println("Erro de Comunicaçao!");
//                    }
//                    if (comunicacoes.recebe().equals(null)) {
//                        p14.setVisible(true);
//                    } else {
//                        p13.setVisible(true);
//                    }
//
//                } catch (IOException ex) {
//                    System.err.println("Erro de Comunicaçao!");
//                }

            } else {    // Caso o evento tenha ocorrido sobre o botão de comando Cancelar
                setVisible(false);  // Esconde a caixa de diálogo
        }
        
    }  
}
}

