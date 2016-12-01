package br.unifor.poo.tiozeiros.view;

import br.unifor.poo.tiozeiros.bo.JogadoresBO;
import br.unifor.poo.tiozeiros.entity.Jogadores;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by andre on 01/12/16.
 */

public class GerarEquipesFrame extends AbstractFrame {

    private JPanel contentPane;
    private Font fontBold = new Font("SansSerif", Font.BOLD, 12);
    private Font fontPlain = new Font("SansSerif", Font.PLAIN, 12);
    private ArrayList<Jogadores> listaJogadoresOrdenados;

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
        JogadoresBO jogadoresBO = new JogadoresBO();
        try {
            listaJogadoresOrdenados = jogadoresBO.listarJogadoresOrdenados();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 562, 405);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel pnE1 = gerarEquipe();
        pnE1.setBounds(134, 62, 134, 113);
        contentPane.add(pnE1);

        JPanel pnE3 = gerarEquipe();
        pnE3.setBounds(134, 206, 134, 113);
        contentPane.add(pnE3);

        JPanel pnE2 = gerarEquipe();
        pnE2.setBounds(305, 62, 134, 113);
        contentPane.add(pnE2);

        JPanel pnE4 = gerarEquipe();
        pnE4.setBounds(305, 206, 134, 113);
        contentPane.add(pnE4);

        JLabel lblEquipesGeradas = new JLabel("Equipes Geradas");
        lblEquipesGeradas.setHorizontalAlignment(SwingConstants.CENTER);
        lblEquipesGeradas.setBounds(142, 12, 274, 28);
        contentPane.add(lblEquipesGeradas);


        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                home();
            }
        });
        btnVoltar.setBounds(215, 331, 141, 25);
        contentPane.add(btnVoltar);

        JLabel lblEquipe = new JLabel("Equipe 1");
        lblEquipe.setFont(fontBold);
        lblEquipe.setBounds(154, 45, 70, 15);
        contentPane.add(lblEquipe);

        JLabel lblEquipe_1 = new JLabel("Equipe 2");
        lblEquipe_1.setBounds(322, 45, 70, 15);
        contentPane.add(lblEquipe_1);

        JLabel lblEquipe_2 = new JLabel("Equipe 3");
        lblEquipe_2.setBounds(154, 187, 70, 15);
        contentPane.add(lblEquipe_2);

        JLabel lblEquipe_3 = new JLabel("Equipe 4");
        lblEquipe_3.setBounds(322, 187, 70, 15);
        contentPane.add(lblEquipe_3);
    }

    private JPanel gerarEquipe() {
        JLabel lblJogador;
        JPanel panel = new JPanel();
        int quantEquipes = listaJogadoresOrdenados.size()/4;
        panel.setLayout(new GridLayout(4, 1));

        if(quantEquipes>=1){
            for(int i = 0; i<4; i++){
                lblJogador = new JLabel(listaJogadoresOrdenados.get(0).getNome() + " " +
                Double.toString(listaJogadoresOrdenados.get(0).calcularMedia()));
                lblJogador.setFont(fontPlain);
                panel.add(lblJogador);
                listaJogadoresOrdenados.remove(0);
            }
        }
        return panel;
    }
}
