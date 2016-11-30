package br.unifor.poo.tiozeiros.view;


import br.unifor.poo.tiozeiros.bo.JogadoresBO;
import br.unifor.poo.tiozeiros.entity.Jogadores;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by andre on 29/11/16.
 */

public class JogadoresCadastradosFrame extends AbstractFrame {

    private JPanel contentPane;
    JogadoresBO jogadoresBO;
    private JPanel panel;
    private ArrayList<JCheckBox> checkBoxesJogadores = new ArrayList<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JogadoresCadastradosFrame frame = new JogadoresCadastradosFrame();
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
    public JogadoresCadastradosFrame() {
        jogadoresBO = new JogadoresBO();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 565, 416);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        messages = new JLabel("");
        messages.setBounds(5, 260, 300, 14);
        contentPane.add(messages);

        JLabel lblJogadoresCadastrados = new JLabel("Jogadores Cadastrados");
        lblJogadoresCadastrados.setHorizontalAlignment(SwingConstants.CENTER);
        lblJogadoresCadastrados.setBounds(183, 20, 182, 15);
        contentPane.add(lblJogadoresCadastrados);

        panel = new JPanel();
        panel.setBounds(125, 40, 400, 300);
        listarJogadores();
        contentPane.add(panel);
        panel.setLayout(new GridLayout(10, 2));


        JButton btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(131, 350, 117, 25);
        contentPane.add(btnDeletar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(305, 350, 117, 25);
        contentPane.add(btnVoltar);
    }

    private void listarJogadores() {
        ArrayList<Object> jogadores = new ArrayList<>();
        Jogadores jogador;
        try {
            jogadores = jogadoresBO.listarJogadores();
            for(Object obj : jogadores){
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