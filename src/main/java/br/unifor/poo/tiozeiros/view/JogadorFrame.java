package br.unifor.poo.tiozeiros.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by andre on 12/11/16.
 */
public class JogadorFrame extends AbstractFrame {
    private JPanel contentPane;

    public JogadorFrame(){
        /**************************************
         CONTAINER
         ***************************************/

        JogadorFrame frame = new JogadorFrame();
        contentPane = gerarContentPane();

        JLabel lblTitulo = new JLabel("Editar Jogador");
        lblTitulo.setFont(new Font("Serif",Font.BOLD, 22));
        lblTitulo.setBounds((MAX_WIDTH - 120) / 2, 0, 120, 60);
        contentPane.add(lblTitulo);

        /**************************************
         BARRA DE MENU
         ***************************************/

        contentPane.add(gerarMenuBar());
    }

}
