package br.unifor.poo.tiozeiros.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by andre on 12/11/16.
 */
public class JogadoresCadastrados extends AbstractFrame {
    private JPanel contentPane;

    public void createFrame() {
        /**************************************
         CONTAINER
         ***************************************/

        JogadoresCadastrados frame = new JogadoresCadastrados();
        contentPane = gerarContentPane();

        JLabel lblTitulo = gerarTitulo("Jogadores Cadastrados");
        lblTitulo.setBounds((MAX_WIDTH - 120) / 2, 20, 120, 60);
        contentPane.add(lblTitulo);

        /**************************************
         BARRA DE MENU
         ***************************************/

        contentPane.add(gerarMenuBar());

        /**************************************
         LISTA DE JOGADORES CADASTRADOS
         ***************************************/


    }

}

class ListaJogadores extends JPanel {
    private JPanel listaJogadores = new JPanel();
    ArrayList<JButton> btnJogadores = new ArrayList<>();

    public ListaJogadores() {
        listaJogadores.setLayout(new GridLayout(30, 2));
        //for()
    }
}
