package mensagensgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sistema.SistemaDeUtilizadores;

public class DialogEditarPassword extends JDialog {

    private JTextField passwordUtilizador;
    private SistemaDeUtilizadores sistema;
    private String nome;

    JPanel p12 = new JPanel();
    JPanel p13 = new JPanel();

    public DialogEditarPassword(Frame origem, String titulo, SistemaDeUtilizadores sistema, String nome) {
        super(origem, titulo, true);   // Invocação do construtor da superclasse JDialog
        setLocation(origem.getX() + 100, origem.getY() + 100);   //Definição do posicionamento inicial da caixa de diálogo
        setResizable(false);

        this.sistema = sistema;
        this.nome    = nome;

        Container c = getContentPane();

        JLabel label;
        JButton botao;

        JPanel p1 = new JPanel();
        p1.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));  //Definição de uma àrea vazia à volta do painel

        JPanel p11 = new JPanel();
        label = new JLabel("Nova password:  ");
        p11.add(label);
        passwordUtilizador = new JTextField(10);
        p11.add(passwordUtilizador);
        p1.add(p11);
        c.add(p1, BorderLayout.NORTH);

        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        botao = new JButton("Mudar password");
        getRootPane().setDefaultButton(botao);  // Definir o botão de OK como estando predefinido - Caso o utilizador pressione ENTER, o botão é executedo
        botao.addActionListener(new TrataEvento());
        p2.add(botao);

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
            if (e.getActionCommand().equals("Mudar password")) {   // Caso o evento tenha ocorrido sobre o botão de comando Criar Conta
                if ( passwordUtilizador.getText().equals("") )
                    JOptionPane.showMessageDialog(null, "Password inválida.\nIntroduza de novo");
                else {
                    sistema.alterarPassword(nome, passwordUtilizador.getText());
                    JOptionPane.showMessageDialog(null, "Password alterada com sucesso.\nNova password: " + passwordUtilizador.getText());
                    sistema.descarregarSistema();
                    setVisible(false);
                }
            } else    // Caso o evento tenha ocorrido sobre o botão de comando Cancelar
                setVisible(false);  // Esconde a caixa de diálogo
        }

    }

}
