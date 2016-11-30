package br.unifor.poo.tiozeiros.view;

import br.unifor.poo.tiozeiros.entity.Jogadores;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * Created by andre on 12/11/16.
 */
public class AbstractFrame extends JFrame {

    protected JLabel messages;

    protected static final Integer MAX_WIDTH = 640;
    protected static final Integer MAX_HEIGHT = 480;
    protected Color backgroundColor = new Color(7, 189, 62);
    protected Font titleFont = new Font("Serif", Font.BOLD, 14);
    protected Font paragraphFont = new Font("Serif", Font.PLAIN, 12);
    protected int x = (MAX_WIDTH - 380) / 2;
    protected int y = ((MAX_HEIGHT - 150) / 2) - 80;

    /*
    * Mensagens padrão de informação, alerta e erro
    * que todas telas poderão ter
    * */

    public void msgInfo(String msg) {
        messages.setText(msg);
        messages.setForeground(Color.BLUE);
        repaint();
    }

    public void msgWarn(String msg) {
        messages.setText(msg);
        messages.setForeground(Color.YELLOW);
        repaint();
    }

    public void msgError(String msg) {
        messages.setText(msg);
        messages.setForeground(Color.RED);
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

    public AbstractFrame home() {
        HomeFrame frame = new HomeFrame();
        try {
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frame;
    }


    protected AbstractFrame cadUsuario() {
        CadastrarUsuarioFrame frame = new CadastrarUsuarioFrame();
        try {
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return frame;
    }

    protected AbstractFrame login() {
        LoginFrame frame = new LoginFrame();
        try {
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frame;
    }

    protected AbstractFrame listarJogadoresCadastrados() {
        JogadoresCadastradosFrame frame = new JogadoresCadastradosFrame();
        try {
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frame;
    }

    protected AbstractFrame editarJogador(Jogadores jogador) {
        EditarJogadorFrame frame = new EditarJogadorFrame(jogador);
        try {
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frame;
    }

    protected AbstractFrame cadJogador() {
        CadastrarJogadorFrame frame = new CadastrarJogadorFrame();
        try {
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frame;
    }

    protected boolean validaCamposObrigatorios(JTextField txtLogin, JPasswordField pwfSenha) {
        if (txtLogin.getText().trim().isEmpty() || pwfSenha.getPassword().toString().trim().isEmpty()) {
            msgWarn("Campos Obrigatórios não preenchidos.");
            return false;
        }
        return true;
    }

    protected boolean validaCamposObrigatorios(JTextField txtEmail, JTextField txtSenha, JTextField txtNome) {
        if (txtEmail.getText().trim().isEmpty() || txtSenha.getText().trim().isEmpty() || txtNome.getText().trim().isEmpty()) {

            msgWarn("Campos Obrigatórios não preenchidos.");
            return false;
        } else {
            return true;
        }

    }


}
