package br.unifor.poo.tiozeiros.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Spliterators;

/**
 * Created by andre on 12/11/16.
 */
public class AbstractFrame extends JFrame {

    protected JLabel messages;

    protected static final Integer MAX_WIDTH = 640;
    protected static final Integer MAX_HEIGHT = 480;
    protected Color backgroundColor = new Color(7, 189, 62);

    /*
    * Mensagens padrão de informação, alerta e erro
    * que todas telas poderão ter
    * */

    public void msgAlerts(String tipo, String msg) {
        messages.setText(msg);
        switch (tipo) {
            case "info":
                messages.setForeground(Color.BLUE);
                break;
            case "alerta":
                messages.setForeground(Color.YELLOW);
                break;
            case "erro":
                messages.setForeground(Color.RED);
                break;
        }
        repaint();
    }


    public AbstractFrame() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                    int selectedOption = JOptionPane.showConfirmDialog(null, "Exit application?", "Sistema Informa:", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                }
            }
        });
    }

    public void mostrarTela(JFrame frame) {
        try {
            frame.setSize(MAX_WIDTH, MAX_HEIGHT);
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected JPanel gerarContentPane(){

        JPanel contentPane = new JPanel();
        setTitle("Tiozeiros Futebol Clube");
        setBounds(100, 100, 577, 349);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(backgroundColor);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        messages = new JLabel("");
        messages.setBounds(10, 45, MAX_WIDTH, 14);
        contentPane.add(messages);

        return contentPane;
    }

    /*
    *Tela de início da aplicação
    * funcionalidades na tela: iniciar partida, registrar gol, terminar partida.
    */

    public AbstractFrame home() {
        HomeFrame frame = new HomeFrame();
        mostrarTela(frame);
        return frame;
    }

    /*
    *Tela de geração das equipes
    * o usuario tera a opção de escolher o número de equipes
    * para gerar as equipes.
    * Após isso, o usuário é levado para a tela de escolha de jogadores
    *
    */

    public AbstractFrame telaGerarEquipe() {
        EquipeFrame frame = new EquipeFrame();
        mostrarTela(frame);
        return frame;
    }

    /*
    *Tela de escolha dos jogadores cadastrados
    * O usuário deverá escolher o número de jogadores de acordo
    * com a quantidade de equipes escolhida.
    * Para cada equipe escolhida, são necessários quatro jogadores.
    * A tela terá a funcionalidade de registrar novo jogador.
    */

    public AbstractFrame telaEscolhaJogadores() {
        JogadoresFrame frame = new JogadoresFrame();
        mostrarTela(frame);
        return frame;
    }

    /*
    *Tela de registro do jogador
    * o usuário terá que informar
    * o nome, chute, passe, velocidade e marcação.
    */

    public AbstractFrame telaRegistroJogador() {
        JogadorFrame frame = new JogadorFrame();
        mostrarTela(frame);
        return frame;
    }


}
