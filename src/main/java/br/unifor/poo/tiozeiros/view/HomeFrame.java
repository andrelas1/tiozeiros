package br.unifor.poo.tiozeiros.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by andre on 12/11/16.
 */
public class HomeFrame extends AbstractFrame {

    private JPanel contentPane;


    public void createFrame() {
        HomeFrame frame = new HomeFrame();
        setTitle("Tiozeiros Futebol Clube");
        setBounds(100, 100, 577, 349);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        messages = new JLabel("");
        messages.setBounds(10, 45, 269, 14);
        contentPane.add(messages);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 640, 28);
        contentPane.add(menuBar);

        JMenu mnEquipes = new JMenu("Equipe");

        menuBar.add(mnEquipes);

        JMenuItem mtmEscolherEquipes = new JMenuItem("Escolher Equipes");

        /*
        Inserir ActionListener para escolha de equipes
        */

        mnEquipes.add(mtmEscolherEquipes);

        JMenu mnJogador = new JMenu("Jogador");
        menuBar.add(mnJogador);

        JMenuItem mtmCadastrarJogador = new JMenuItem("Cadastrar Jogador");

        /*
        Inserir ActionListener para cadastro de jogador
        */

        mnJogador.add(mtmCadastrarJogador);

        JMenu mnHistorico = new JMenu("Histórico");
        menuBar.add(mnHistorico);

        JMenuItem mtmVisualizarHistórico = new JMenuItem("Visualizar Histórico");

        /*
        Inserir ActionListener para visualizar histórico
        */

        mnHistorico.add(mtmVisualizarHistórico);

        frame.add(contentPane);
        mostrarTela(frame);
    }


}
