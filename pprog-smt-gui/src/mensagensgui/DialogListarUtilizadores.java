package mensagensgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sistema.SistemaDeUtilizadores;

class DialogListarUtilizadores extends JDialog {

    public static JScrollPane lista(SistemaDeUtilizadores sistema) {
        JList listaTEMP = new JList();
        listaTEMP.setListData( sistema.listaDeUtilizadores() );
        listaTEMP.setSelectionMode( ListSelectionModel.SINGLE_SELECTION);

        return new JScrollPane( listaTEMP );
    }
    
    public DialogListarUtilizadores(FrameEntrada origem, String titulo, SistemaDeUtilizadores sistema) {
        super(origem, titulo, true);   // Invocação do construtor da superclasse JDialog
        setLocation(origem.getX() + 100, origem.getY() + 100);   //Definição do posicionamento inicial da caixa de diálogo
 
        Container c = getContentPane();

        JPanel p1 = new JPanel(new BorderLayout());
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  //Definição de uma àrea vazia à volta do painel

//        lista.setListData( sistema.listaDeUtilizadores() );
//        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Definir que apenas um item da ListBox pode ser seleccionado de cada vez
//
//        JScrollPane scroll = new JScrollPane(lista);     //Criação de uma barra de deslocamento vertical para a ListBox

        p1.add( DialogListarUtilizadores.lista(sistema), BorderLayout.CENTER);
        c.add(p1, BorderLayout.CENTER);

        JPanel p2 = new JPanel();
        p2.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        JButton botao = new JButton("OK");
        getRootPane().setDefaultButton(botao);  // Definir o botão de OK como estando predefinido - Caso o utilizador pressione ENTER, o botão é executedo
        botao.addActionListener(new TrataEvento());
        p2.add(botao);
        c.add(p2, BorderLayout.SOUTH);

        pack(); //As dimensões da janela são ajustadas automaticamente ao mínimo necessário que permite mostrar todos os seus componentes
        setMinimumSize(new Dimension(getWidth(), getHeight())); // Definir como dimensões mínimas da Janela/Frame a actual largura e altura
    }

    class TrataEvento implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);  // Esconde a caixa de diálogo
        }
    }

    public void showDialog() {
        setVisible(true);   // Mostra a caixa de diálogo
    }

}
