package br.unifor.poo.tiozeiros.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by andre on 12/11/16.
 */
public class JogadoresFrame extends AbstractFrame {

    private JPanel contentPane;
    private Font titleFont = new Font("Serif", Font.BOLD, 14);
    private Font paragraphFont = new Font("Serif", Font.PLAIN, 12);

    public void createFrame() {

        /**************************************
         CONTAINER
         ***************************************/

        JogadoresFrame frame = new JogadoresFrame();
        contentPane = gerarContentPane();

        /**************************************
         DADOS PESSOAIS
         ***************************************/
        int x = (MAX_WIDTH - 380) / 2;
        int y = (MAX_HEIGHT - 150) / 2;

        JLabel lblNome = new JLabel("Nome");
        lblNome.setFont(titleFont);
        lblNome.setBounds(x, y - 80, 100, 28);
        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setFont(titleFont);
        lblTelefone.setBounds(x, y - 40, 100, 28);
        contentPane.add(lblNome);
        contentPane.add(lblTelefone);

        JTextField jtNome = new JTextField("inserir nome do jogador");
        JTextField jtTelefone = new JTextField("inserir telefone do jogador");
        jtNome.setBounds((int) lblNome.getBounds().getX() + 80, (int) lblNome.getBounds().getY(), 300, 28);
        jtTelefone.setBounds((int) lblNome.getBounds().getX() + 80, (int) lblTelefone.getBounds().getY(), 300, 28);
        contentPane.add(jtNome);
        contentPane.add(jtTelefone);

        /**************************************
         HABILIDADES - CAMPOS
         ***************************************/

        JLabel lblHabilidades = new JLabel("Habilidades");
        lblHabilidades.setFont(titleFont);
        lblHabilidades.setBounds(x, (int) jtTelefone.getBounds().getY()+60, 100, 28);
        contentPane.add(lblHabilidades);

        JLabel lblSeparator = new JLabel("-------------------------------------------------");
        lblSeparator.setBounds(x, (int) jtTelefone.getBounds().getY()+80, MAX_WIDTH, 20);
        lblSeparator.setFont(new Font("Serif", Font.BOLD, 20));
        contentPane.add(lblSeparator);

        JLabel lblFinalização = new JLabel("Finalização");
        lblFinalização.setBounds((int) lblSeparator.getBounds().getX(), (int) lblSeparator.getBounds().getY()+30, 100, 28);
        lblFinalização.setFont(paragraphFont);
        contentPane.add(lblFinalização);

        JLabel lblPasse = new JLabel("Passe");
        lblPasse.setBounds((int) lblSeparator.getBounds().getX(), (int) lblSeparator.getBounds().getY()+60, 100, 28);
        lblPasse.setFont(paragraphFont);
        contentPane.add(lblPasse);

        JLabel lblVelocidade = new JLabel("Velocidade");
        lblVelocidade.setBounds((int) lblSeparator.getBounds().getX(), (int) lblSeparator.getBounds().getY()+90, 100, 28);
        lblVelocidade.setFont(paragraphFont);
        contentPane.add(lblVelocidade);

        JLabel lblMarcação = new JLabel("Finalização");
        lblMarcação.setBounds((int) lblSeparator.getBounds().getX(), (int) lblSeparator.getBounds().getY()+120, 100, 28);
        lblMarcação.setFont(paragraphFont);
        contentPane.add(lblMarcação);

        /**************************************
         HABILIDADES - NÍVEL
         ***************************************/



        frame.add(contentPane);
        mostrarTela(frame);

    }

}
