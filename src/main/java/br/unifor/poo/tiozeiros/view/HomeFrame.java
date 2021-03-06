package br.unifor.poo.tiozeiros.view;

import br.unifor.poo.tiozeiros.entity.Equipe;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * Created by andre on 12/11/16.
 */

public class HomeFrame extends AbstractFrame{

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomeFrame frame = new HomeFrame();
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
    public HomeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        messages = new JLabel("");
        messages.setBounds(5, 260, 300, 14);
        contentPane.add(messages);

        JButton btnCadastrarJogador = new JButton("Cadastrar Jogadores");
        btnCadastrarJogador.setBounds(138, 29, 170, 25);
        btnCadastrarJogador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cadJogador();
            }
        });
        contentPane.add(btnCadastrarJogador);

        JButton btnGerarEquipes = new JButton("Gerar Equipes");
        btnGerarEquipes.setBounds(138, 78, 170, 25);
        btnGerarEquipes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gerarEquipes();
            }
        });
        contentPane.add(btnGerarEquipes);


        JButton btnListarJogadores = new JButton("Listar Jogadores Cadastrados");
        btnListarJogadores.setBounds(138, 135, 170, 25);
        btnListarJogadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listarJogadoresCadastrados();
            }
        });
        contentPane.add(btnListarJogadores);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(138, 188, 170, 25);
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                login();
            }
        });
        contentPane.add(btnSair);
    }
}


