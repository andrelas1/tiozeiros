package br.unifor.poo.tiozeiros.view;

import br.unifor.poo.tiozeiros.entity.Jogador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by andre on 12/11/16.
 */
public class EquipeFrame extends AbstractFrame {

    private JPanel contentPane;

    public void createFrame() {

        /**************************************
         CONTAINER
         ***************************************/

        EquipeFrame frame = new EquipeFrame();
        contentPane = gerarContentPane();

        JLabel lblTitulo = gerarTitulo("Equipes");
        lblTitulo.setBounds((MAX_WIDTH - 120) / 2, 20, 120, 60);
        contentPane.add(lblTitulo);

        /**************************************
         BARRA DE MENU
         ***************************************/

        contentPane.add(gerarMenuBar());


        /**************************************
         TELA DE EQUIPES: MÁXIMO QUATRO EQUIPES
         ***************************************/

        EquipesGeradas equipes = new EquipesGeradas();
        equipes.setBounds(80, (int) lblTitulo.getBounds().getY()+60, 480, 320);
        contentPane.add(equipes);

        frame.add(contentPane);
        mostrarTela(frame);

    }

}

class EquipesGeradas extends JPanel {
    private Integer numeroEquipes = 4;
    private ArrayList<JPanel> equipesGeradas = new ArrayList<>();
    private Font pFont = new Font("Serif", Font.PLAIN, 12);

    public EquipesGeradas() {
        setLayout(new GridLayout(2, 2));
        setSize(480, 320);
        gerarEquipes(3);
    }

    public void gerarEquipes(Integer n) {
        for (int c = 0; c < n; c++) {
            JPanel equipe = new JPanel();
            equipe.setLayout(new GridLayout(5, 1));
            equipe.setSize(120, 80);
            JLabel lblNomeEquipe = new JLabel("Equipe " + (c + 1));
            lblNomeEquipe.setFont(new Font("Serif", Font.BOLD, 14));
            lblNomeEquipe.setHorizontalAlignment(JLabel.CENTER);
            JLabel j1;
            JLabel j2;
            JLabel j3;
            JLabel j4;
            if (c == 0) {
                j1 = new JLabel(new Jogador("AndreL").getNome());
                j2 = new JLabel(new Jogador("Diogo").getNome());
                j3 = new JLabel(new Jogador("Daniel").getNome());
                j4 = new JLabel(new Jogador("Davi").getNome());
            } else if (c == 1) {
                j1 = new JLabel(new Jogador("Matheus").getNome());
                j2 = new JLabel(new Jogador("Ivan").getNome());
                j3 = new JLabel(new Jogador("André Vieira").getNome());
                j4 = new JLabel(new Jogador("Preá").getNome());
            } else if (c == 2) {
                j1 = new JLabel(new Jogador("Lucas Rozzoline").getNome());
                j2 = new JLabel(new Jogador("Weriklys").getNome());
                j3 = new JLabel(new Jogador("Raimundão").getNome());
                j4 = new JLabel(new Jogador("João André").getNome());
            } else if (c == 3) {
                j1 = new JLabel(new Jogador("Igor").getNome());
                j2 = new JLabel(new Jogador("PV").getNome());
                j3 = new JLabel(new Jogador("Cabo Verde").getNome());
                j4 = new JLabel(new Jogador("Elias").getNome());
            } else {
                break;
            }
            j1.setHorizontalAlignment(JLabel.CENTER);
            j2.setHorizontalAlignment(JLabel.CENTER);
            j3.setHorizontalAlignment(JLabel.CENTER);
            j4.setHorizontalAlignment(JLabel.CENTER);
            j1.setFont(pFont);
            j2.setFont(pFont);
            j3.setFont(pFont);
            j4.setFont(pFont);
            equipesGeradas.add(equipe);
            equipe.add(lblNomeEquipe);
            equipe.add(j1);
            equipe.add(j2);
            equipe.add(j3);
            equipe.add(j4);
            add(equipe);
        }

    }
}
