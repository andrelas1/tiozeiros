package br.unifor.poo.tiozeiros.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by andre on 12/11/16.
 */
public class LoginFrame extends AbstractFrame {
    private JPanel contentPane;
    private JTextField txtLogin;
    private JPasswordField pwField;
    private JLabel lblNewLabel;
    private JButton btnCadastrarManager;

    public void createFrame() {
        setTitle("Tiozeiros Futebol Clube");
//        setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("imagens/logo-tiozeiros.png")));
        setBounds(100, 100, 577, 349);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        messages = new JLabel("");
        messages.setBounds(10, 15, 269, 14);
        contentPane.add(messages);

        txtLogin = new JTextField();
        txtLogin.setBounds(398, 101, 153, 20);
        contentPane.add(txtLogin);
        txtLogin.setColumns(10);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setBounds(342, 135, 46, 14);
        contentPane.add(lblLogin);

        pwField = new JPasswordField();
        pwField.setBounds(398, 132, 153, 20);
        contentPane.add(pwField);

        JButton btnEntrar = new JButton("Entrar");
        //setar ActionListener
        btnEntrar.setBounds(352, 169, 76, 23);
        contentPane.add(btnEntrar);

        lblNewLabel = new JLabel("");
 //       lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("imagens/tiozeiros.gif"))); //Imagen inicial da aplicação
        lblNewLabel.setBounds(10, 29, 336, 257);
        contentPane.add(lblNewLabel);

        btnCadastrarManager = new JButton("Cadastrar-se");
        //setar ActionListener
        btnCadastrarManager.setBounds(438, 169, 101, 23);
        contentPane.add(btnCadastrarManager);

        login();

    }

    private boolean validaCamposObrigatorios() {
        if (txtLogin.getText().trim().isEmpty() || pwField.getPassword().toString().trim().isEmpty()) {
            msgAlerts("erro", "Campos Obrigatórios não preenchidos.");
            return false;
        }
        return true;
    }
}
