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

        /**************************************
         JANELA CONTAINER
         ***************************************/

        LoginFrame loginFrame = new LoginFrame();
        setTitle("Tiozeiros Futebol Clube");
        /*setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("imagens/unifor.gif")));*/
        contentPane = gerarContentPane();

        /**************************************
         CAMPOS DE LOGIN E SENHA
         ***************************************/

        txtLogin = new JTextField();
        txtLogin.setBounds(398, 101, 153, 20);
        contentPane.add(txtLogin);
        txtLogin.setColumns(10);

        JLabel lblLogin = new JLabel("Login:");
        lblLogin.setFont(lblLogin.getFont().deriveFont(11.0f));
        lblLogin.setBounds(342, 104, 46, 14);
        contentPane.add(lblLogin);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(342, 135, 46, 14);
        lblSenha.setFont(lblSenha.getFont().deriveFont(11.0f));
        contentPane.add(lblSenha);

        pwField = new JPasswordField();
        pwField.setBounds(398, 132, 153, 20);
        contentPane.add(pwField);

        /**************************************
         ENTRAR E IMAGEM DE INÍCIO
         ***************************************/

        JButton btnEntrar = new JButton("Entrar");
        //setar ActionListener
        btnEntrar.setBounds(352, 169, 76, 23);
        btnEntrar.setFont(btnEntrar.getFont().deriveFont(11.0f));
        contentPane.add(btnEntrar);

        lblNewLabel = new JLabel("");
        ClassLoader a = getClass().getClassLoader();
        lblNewLabel.setIcon(new ImageIcon(a.getResource("images/tiozeiros.jpeg"))); //Imagem inicial da aplicação
        lblNewLabel.setBounds(10, 29, 336, 257);
        contentPane.add(lblNewLabel);

        /**************************************
         BOTÃO DE CADASTRAR
         ***************************************/

        btnCadastrarManager = new JButton("Cadastrar-se");
        //setar ActionListener
        btnCadastrarManager.setBounds(438, 169, 101, 23);
        btnCadastrarManager.setFont(btnCadastrarManager.getFont().deriveFont(11.0f));
        contentPane.add(btnCadastrarManager);
        loginFrame.add(contentPane);

        mostrarTela(loginFrame);

    }

    private boolean validaCamposObrigatorios() {
        if (txtLogin.getText().trim().isEmpty() || pwField.getPassword().toString().trim().isEmpty()) {
            msgAlerts("erro", "Campos Obrigatórios não preenchidos.");
            return false;
        }
        return true;
    }
}
