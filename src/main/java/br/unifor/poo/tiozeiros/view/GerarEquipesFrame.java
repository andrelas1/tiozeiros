package br.unifor.poo.tiozeiros.view;

import br.unifor.poo.tiozeiros.bo.JogadoresBO;
import br.unifor.poo.tiozeiros.entity.Jogadores;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by andre on 01/12/16.
 */

public class GerarEquipesFrame extends AbstractFrame {

    private JPanel contentPane;
    private JogadoresBO jogadoresBO;
    private JPanel panelEquipe12;
    private JPanel panelEquipe34;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GerarEquipesFrame frame = new GerarEquipesFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public GerarEquipesFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 562, 405);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelEquipe12 = new JPanel();
        panelEquipe12.setBounds(127, 53, 319, 127);
        contentPane.add(panelEquipe12);
        panelEquipe12.setLayout(new GridLayout(4, 2));

        panelEquipe34 = new JPanel();
        panelEquipe34.setBounds(127, 192, 319, 127);
        contentPane.add(panelEquipe34);
        panelEquipe34.setLayout(new GridLayout(4, 2));

        JLabel lblEquipesGeradas = new JLabel("Equipes Geradas");
        lblEquipesGeradas.setHorizontalAlignment(SwingConstants.CENTER);
        lblEquipesGeradas.setBounds(142, 12, 274, 28);
        contentPane.add(lblEquipesGeradas);

        JButton btnGerarEquipes = new JButton("Gerar Equipes");
        btnGerarEquipes.setBounds(127, 331, 141, 25);
        btnGerarEquipes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        contentPane.add(btnGerarEquipes);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                home();
            }
        });
        btnVoltar.setBounds(298, 331, 141, 25);
        contentPane.add(btnVoltar);
    }

    private void listarJogadores() {
        ArrayList<Object> jogadores;
        Jogadores jogador;
        try {
            jogadores = jogadoresBO.listarJogadores();
            for (Object obj : jogadores) {
                jogador = (Jogadores) obj;
                JCheckBox j = new JCheckBox(jogador.getNome() + " " + Double.toString(jogador.calcularMedia()));
                panel.add(j);
                checkBoxesJogadores.add(j);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
