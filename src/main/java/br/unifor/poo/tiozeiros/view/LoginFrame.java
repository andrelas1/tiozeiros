package br.unifor.poo.tiozeiros.view;

import br.unifor.poo.tiozeiros.entity.Usuarios;
import br.unifor.poo.tiozeiros.exception.DAOException;
import br.unifor.poo.tiozeiros.seguranca.Criptografia;
import br.unifor.poo.tiozeiros.seguranca.SegurancaTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.PasswordView;
import javax.swing.text.StringContent;

public class LoginFrame extends AbstractFrame {

    private JPanel contentPane;
    private JTextField txtLogin;
    private JPasswordField pwfSenha;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFrame frame = new LoginFrame();
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
    public LoginFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setBounds(133, 175, 54, 19);
        contentPane.add(lblLogin);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(133, 205, 54, 15);
        contentPane.add(lblSenha);

        txtLogin = new JTextField();
        txtLogin.setBounds(185, 175, 114, 18);
        contentPane.add(txtLogin);
        txtLogin.setColumns(10);

        pwfSenha = new JPasswordField();
        pwfSenha.setBounds(185, 205, 114, 19);
        contentPane.add(pwfSenha);
        pwfSenha.setColumns(10);


        JLabel lblImagemPrincipal = new JLabel("");
        lblImagemPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
        ClassLoader classLoader = getClass().getClassLoader();
        lblImagemPrincipal.setIcon(new ImageIcon(classLoader.getResource("images/tiozeiros_r.png")));
        lblImagemPrincipal.setBounds((450 - 264) / 2, 12, 264, 150);
        contentPane.add(lblImagemPrincipal);

        JButton btnEntrar = new JButton("Entrar");

        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (validaCamposObrigatorios()){
                    Usuarios usuario = new Usuarios();
                    usuario.setLogin(txtLogin.getText());
                    usuario.setSenha(Criptografia.encripta(String.valueOf(pwfSenha.getPassword())));
                    try{
                        if(usuarioBO.logger(usuario)){
                            home().msgAlerts("info", "Olá" + SegurancaTO.getUsuario().getNome());
                        }
                    }catch (DAOException dao){
                        msgAlerts("erro", dao.getMessage());
                    }
                }
            }
        });
        btnEntrar.setBounds((450 - 78) / 2, 235, 78, 19);
        contentPane.add(btnEntrar);
    }

    private boolean validaCamposObrigatorios() {
        if (txtLogin.getText().trim().isEmpty() || pwfSenha.getPassword().toString().trim().isEmpty()) {
            msgAlerts("alerta","Campos Obrigatórios não preenchidos.");
            return false;
        }
        return true;
    }

}
