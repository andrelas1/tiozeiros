package br.unifor.poo.tiozeiros.view;

import br.unifor.poo.tiozeiros.bo.JogadorBO;
import br.unifor.poo.tiozeiros.entity.Jogadores;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by andre on 29/11/16.
 */

public class CadastrarJogadorFrame extends AbstractFrame {

    private JPanel contentPane;
    private JTextField txtNome;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarJogadorFrame frame = new CadastrarJogadorFrame();
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
    public CadastrarJogadorFrame() {

        JogadorBO jogadorBO = new JogadorBO();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        messages = new JLabel("");
        messages.setBounds(5, 260, 300, 14);
        contentPane.add(messages);

        JLabel lblCadastrarNovoJogador = new JLabel("Cadastrar Novo Jogadores");
        lblCadastrarNovoJogador.setBounds(163, 16, 183, 15);
        contentPane.add(lblCadastrarNovoJogador);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNome.setBounds(85, 75, 70, 15);
        contentPane.add(lblNome);

        JLabel lblFinalizacao = new JLabel("Finalização");
        lblFinalizacao.setHorizontalAlignment(SwingConstants.RIGHT);
        lblFinalizacao.setBounds(62, 106, 93, 15);
        contentPane.add(lblFinalizacao);

        JLabel lblPasse = new JLabel("Passe");
        lblPasse.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPasse.setBounds(62, 138, 93, 15);
        contentPane.add(lblPasse);

        JLabel lblMarcacao = new JLabel("Marcação");
        lblMarcacao.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMarcacao.setBounds(62, 176, 93, 15);
        contentPane.add(lblMarcacao);

        JLabel lblVelocidade = new JLabel("Velocidade");
        lblVelocidade.setHorizontalAlignment(SwingConstants.RIGHT);
        lblVelocidade.setBounds(62, 212, 93, 15);
        contentPane.add(lblVelocidade);

        txtNome = new JTextField();
        txtNome.setBounds(163, 77, 191, 19);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        NivelHabilidades pnFinalizacao = new NivelHabilidades();
        pnFinalizacao.setBounds(163, 102, 250, 25);
        contentPane.add(pnFinalizacao);

        NivelHabilidades pnPasse = new NivelHabilidades();
        pnPasse.setBounds(163, 134, 250, 25);
        contentPane.add(pnPasse);

        NivelHabilidades pnMarcação = new NivelHabilidades();
        pnMarcação.setBounds(163, 171, 250, 25);
        contentPane.add(pnMarcação);

        NivelHabilidades pnVelocidade = new NivelHabilidades();
        pnVelocidade.setBounds(163, 208, 250, 25);
        contentPane.add(pnVelocidade);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(124, 243, 110, 19);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(validaCamposObrigatorios(txtNome.getText(), pnFinalizacao.)){
                    Jogadores jogador = new Jogadores();
                    jogador.setNome(txtNome.getText());
                }


            }
        });
        contentPane.add(btnSalvar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(255, 243, 110, 19);
        contentPane.add(btnCancelar);
    }

    public Boolean validaCamposObrigatorios(String nome, JRadioButton fin, JRadioButton pas, JRadioButton marc, JRadioButton vel){
        if(!(nome.trim().isEmpty()) || fin.isSelected() || pas.isSelected() || marc.isSelected() || vel.isSelected()){
            return true;
        }else{
            msgError("Campos Obrigatórios Não Preenchidos");
            return false;
        }
    }

}

class NivelHabilidades extends JPanel {
    public ArrayList<JRadioButton> checkBoxes = new ArrayList<>();
    private ArrayList<JLabel> labels = new ArrayList<>();
    private Integer niveis;
    private ButtonGroup group = new ButtonGroup();


    public NivelHabilidades() {
        setLayout(new GridLayout(2, 1));
        add(criarCheckBoxes(10));
        add(criarLabels());
    }

    public JPanel criarCheckBoxes(int n) {
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new GridLayout(1, 10));
        niveis = n;
        checkBoxPanel.setSize(300, 20);
        for (int c = 0; c < n; c++) {
            JRadioButton box = new JRadioButton();
            box.setSize(16, 16);
            group.add(box);
            checkBoxes.add(box);
            checkBoxPanel.add(checkBoxes.get(c));
        }
        return checkBoxPanel;
    }

    public JPanel criarLabels() {
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(1, 10));
        labelPanel.setSize(300, 10);
        for (int x = 1; x <= niveis; x++) {
            JLabel label;
            if (x >= 10) {
                label = new JLabel(" " + Integer.toString(x));
            } else {
                label = new JLabel(" " + Integer.toString(x));
            }
            label.setSize(10, 10);
            labels.add(label);
            labelPanel.add(label);
        }
        return labelPanel;
    }

    public ArrayList<JRadioButton> getCheckBoxes() {
        return checkBoxes;
    }
}


