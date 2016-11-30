package br.unifor.poo.tiozeiros.view;


import br.unifor.poo.tiozeiros.bo.JogadoresBO;
import br.unifor.poo.tiozeiros.entity.Jogadores;
import br.unifor.poo.tiozeiros.exception.DAOException;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by andre on 29/11/16.
 */

public class JogadoresCadastradosFrame extends AbstractFrame {

    private JPanel contentPane;
    protected JogadoresBO jogadoresBO;
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
        btnDeletar.setBounds(159, 354, 117, 25);
        btnDeletar.addActionListener(new ActionListener() {
            int jogadoresRemovidos = 0;

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (JCheckBox jcb : checkBoxesJogadores) {
                    if (jcb.isSelected()) {
                        String[] split = jcb.getText().split("\\s+");
                        try {
                            jogadoresBO.deletarPorNome(split[0]);
                            jogadoresRemovidos++;
                        } catch (DAOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                home().msgInfo("Foram removidos " + jogadoresRemovidos + " registros");
            }
        });
        contentPane.add(btnDeletar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(298, 354, 117, 25);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                home();
            }
        });
        contentPane.add(btnVoltar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(12, 354, 117, 25);
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Jogadores jogador;
                int jogadoresSelecionados = 0;
                JCheckBox jogadorEditar = null;
                for (JCheckBox jcb : checkBoxesJogadores) {
                    if (jcb.isSelected()) {
                        jogadoresSelecionados++;
                        jogadorEditar = jcb;
                    }
                }
                if (jogadorEditar!=null && jogadoresSelecionados == 1) {
                    String[] split = jogadorEditar.getText().split("\\s+");
                    try {
                        jogador = jogadoresBO.buscarPorNome(split[0]);
                        editarJogador(jogador);
                    } catch (DAOException e) {
                        e.printStackTrace();
                    }
                }else{
                    home().msgError("Não é possível editar mais de um jogador de uma vez");
                }
            }
        });
        contentPane.add(btnEditar);

        JButton btnGerarEquipes = new JButton("Gerar Equipes");
        btnGerarEquipes.setBounds(434, 354, 117, 25);
        contentPane.add(btnGerarEquipes);
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