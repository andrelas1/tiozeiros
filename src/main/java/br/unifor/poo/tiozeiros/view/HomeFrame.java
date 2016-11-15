package br.unifor.poo.tiozeiros.view;

import br.unifor.poo.tiozeiros.entity.Equipe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by andre on 12/11/16.
 */
public class HomeFrame extends AbstractFrame {

    private JPanel contentPane;


    public void createFrame() {

        /**************************************
         JANELA CONTAINER
         ***************************************/
        HomeFrame frame = new HomeFrame();
        contentPane = gerarContentPane();


        /**************************************
         BARRA DE MENU
         ***************************************/

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

        /**************************************
         TIMER
         ***************************************/

        TimerPane timer = new TimerPane();
        int x = (MAX_WIDTH - 380) / 2;
        int y = (MAX_HEIGHT - 150) / 2;
        timer.setBounds(x, y, 380, 150);
        contentPane.add(timer);

        /**************************************
         BOTÕES DE INICIAR E PAUSAR
         ***************************************/

        JButton btnIniciar = new JButton("Iniciar");
        JButton btnPausar = new JButton("Pausar");


        btnIniciar.setBounds(x, y - 60, 100, 28);
        /*
        Inserir ActionListener do botão
        */
        contentPane.add(btnIniciar);

        btnPausar.setBounds(410, y - 60, 100, 28);
        /*
        Inserir ActionListener do botão
        */
        contentPane.add(btnPausar);

        /**************************************
         PLACAR E OPÇÃO DE FINALIZAR
         ***************************************/
        EquipePane equipe1 = new EquipePane("Time 1");
        EquipePane equipe2 = new EquipePane("Time 2");
        equipe1.setBounds(x + 50, y + 170, 100, 28);
        equipe2.setBounds(360, y + 170, 100, 28);
        equipe1.setBackground(Color.WHITE);
        contentPane.add(equipe1);
        contentPane.add(equipe2);

        JLabel placar1 = new JLabel("0");
        JLabel separadorPlacar = new JLabel("x");
        JLabel placar2 = new JLabel("0");

        placar1.setBounds(x + 50 + 100 + 15, y + 170, 28, 28);
        contentPane.add(placar1);
        separadorPlacar.setBounds((int) placar1.getBounds().getX() + 20, (int) placar1.getBounds().getY(), 28, 28);
        contentPane.add(separadorPlacar);
        placar2.setBounds((int) separadorPlacar.getBounds().getX() + 20, (int) separadorPlacar.getBounds().getY(), 28, 28);
        contentPane.add(placar2);

        JButton btnFinalizar = new JButton("Finalizar");
        btnFinalizar.setBounds((MAX_WIDTH-120)/2, (int) separadorPlacar.getBounds().getY()+60, 120, 40);
        contentPane.add(btnFinalizar);

        frame.add(contentPane);

        mostrarTela(frame);

    }

}

class TimerPane extends JPanel {

    Font clockFont = new Font("Tahoma", Font.PLAIN, 102);

    private JLabel minutos;
    private JLabel segundos;


    public TimerPane() {
        setLayout(new GridBagLayout());
        minutos = new JLabel("00");
        minutos.setFont(clockFont);
        segundos = new JLabel("00");
        segundos.setFont(clockFont);
        JLabel separador = new JLabel(":");
        separador.setFont(clockFont);

        add(minutos);
        add(separador);
        add(segundos);

    }

}

class EquipePane extends JPanel {
    private JLabel nomeEquipe;

    public EquipePane(String nome) {
        nomeEquipe = new JLabel(nome);
        setLayout(new GridBagLayout());
        add(nomeEquipe);
    }
}

