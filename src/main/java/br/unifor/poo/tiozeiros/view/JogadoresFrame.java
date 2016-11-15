package br.unifor.poo.tiozeiros.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by andre on 12/11/16.
 */
public class JogadoresFrame extends AbstractFrame {

    private JPanel contentPane;


    public void createFrame() {

        /**************************************
         CONTAINER
         ***************************************/

        JogadoresFrame frame = new JogadoresFrame();
        contentPane = gerarContentPane();

        JLabel lblTitulo = new JLabel("Cadastro de Novo Jogador");
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 22));
        lblTitulo.setBounds((MAX_WIDTH-310)/2, 20, 330, 60);
        contentPane.add(lblTitulo);

        /**************************************
         BARRA DE MENU
         ***************************************/

        contentPane.add(gerarMenuBar());

        /**************************************
         DADOS PESSOAIS
         ***************************************/


        JLabel lblNome = new JLabel("Nome");
        lblNome.setFont(titleFont);
        lblNome.setBounds(x, y, 100, 28);
        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setFont(titleFont);
        lblTelefone.setBounds(x, y+40, 100, 28);
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
        lblHabilidades.setBounds(x, (int) jtTelefone.getBounds().getY() + 60, 100, 28);
        contentPane.add(lblHabilidades);

        JLabel lblSeparator = new JLabel("-------------------------------------------------");
        lblSeparator.setBounds(x, (int) jtTelefone.getBounds().getY() + 80, MAX_WIDTH, 20);
        lblSeparator.setFont(new Font("Serif", Font.BOLD, 20));
        contentPane.add(lblSeparator);

        JLabel lblFinalização = new JLabel("Finalização");
        lblFinalização.setBounds((int) lblSeparator.getBounds().getX(), (int) lblSeparator.getBounds().getY() + 30, 100, 28);
        lblFinalização.setFont(paragraphFont);
        contentPane.add(lblFinalização);

        JLabel lblPasse = new JLabel("Passe");
        lblPasse.setBounds((int) lblSeparator.getBounds().getX(), (int) lblFinalização.getBounds().getY() + 50, 100, 28);
        lblPasse.setFont(paragraphFont);
        contentPane.add(lblPasse);

        JLabel lblVelocidade = new JLabel("Velocidade");
        lblVelocidade.setBounds((int) lblSeparator.getBounds().getX(), (int) lblPasse.getBounds().getY() + 50, 100, 28);
        lblVelocidade.setFont(paragraphFont);
        contentPane.add(lblVelocidade);

        JLabel lblMarcação = new JLabel("Finalização");
        lblMarcação.setBounds((int) lblSeparator.getBounds().getX(), (int) lblVelocidade.getBounds().getY() + 50, 100, 28);
        lblMarcação.setFont(paragraphFont);
        contentPane.add(lblMarcação);

        /**************************************
         HABILIDADES - NÍVEL
         ***************************************/
        NivelHabilidades habilidadesFinalização = new NivelHabilidades();
        habilidadesFinalização.setBounds((int) lblFinalização.getBounds().getX() + 90, (int) lblFinalização.getBounds().getY(), 300, 40);
        contentPane.add(habilidadesFinalização);

        NivelHabilidades habilidadesPasse = new NivelHabilidades();
        habilidadesPasse.setBounds((int) lblPasse.getBounds().getX() + 90, (int) lblPasse.getBounds().getY(), 300, 40);
        contentPane.add(habilidadesPasse);

        NivelHabilidades habilidadesVelocidade = new NivelHabilidades();
        habilidadesVelocidade.setBounds((int) lblVelocidade.getBounds().getX() + 90, (int) lblVelocidade.getBounds().getY(), 300, 40);
        contentPane.add(habilidadesVelocidade);

        NivelHabilidades habilidadesMarcação = new NivelHabilidades();
        habilidadesMarcação.setBounds((int) lblMarcação.getBounds().getX() + 90, (int) lblMarcação.getBounds().getY(), 300, 40);
        contentPane.add(habilidadesMarcação);

        frame.add(contentPane);
        mostrarTela(frame);

    }

}

class NivelHabilidades extends JPanel {
    protected ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
    protected ArrayList<JLabel> labels = new ArrayList<>();
    protected Integer niveis;

    public NivelHabilidades() {
        setLayout(new GridLayout(2, 1));
        add(criarCheckBoxes(10));
        add(criarLabels());
        setBackground(new Color(7, 189, 62));
    }

    public JPanel criarCheckBoxes(int n) {
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new GridLayout(1, 10));
        niveis = n;
        checkBoxPanel.setSize(300, 20);
        for (int c = 0; c < n; c++) {
            JCheckBox box = new JCheckBox();
            box.setSize(16, 16);
            box.setBackground(new Color(7, 189, 62));
            checkBoxes.add(box);
            checkBoxPanel.add(checkBoxes.get(c));
        }
        return checkBoxPanel;
    }

    public JPanel criarLabels() {
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(1, 10));
        labelPanel.setSize(300, 10);
        labelPanel.setBackground(new Color(7,189,62));
        for (int x = 1; x <= niveis; x++) {
            JLabel label;
            if (x >= 10) {
                label = new JLabel(" " + Integer.toString(x));
            } else {
                label = new JLabel("  " + Integer.toString(x));
            }
            label.setSize(10, 10);
            label.setBackground(new Color(7, 189, 62));
            labels.add(label);
            labelPanel.add(label);
        }
        return labelPanel;
    }
}
