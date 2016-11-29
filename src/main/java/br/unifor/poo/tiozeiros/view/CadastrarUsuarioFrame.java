package br.unifor.poo.tiozeiros.view;

import br.unifor.poo.tiozeiros.bo.UsuarioBO;
import br.unifor.poo.tiozeiros.entity.Usuarios;
import br.unifor.poo.tiozeiros.exception.DAOException;
import br.unifor.poo.tiozeiros.seguranca.Criptografia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

/**
 * Created by andre on 29/11/16.
 */




public class CadastrarUsuarioFrame extends AbstractFrame {

    private JPanel contentPane;
    private JTextField txtEmail;
    private JTextField txtNome;
    private JTextField txtSenha;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarUsuarioFrame frame = new CadastrarUsuarioFrame();
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
    public CadastrarUsuarioFrame() {

        UsuarioBO usuarioBO = new UsuarioBO();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        messages = new JLabel("");
        messages.setBounds(5, 260, 300, 14);
        contentPane.add(messages);

        JLabel lblCadastrarNovoUsurio = new JLabel("Cadastrar Novo Usuário");
        lblCadastrarNovoUsurio.setHorizontalAlignment(SwingConstants.CENTER);
        lblCadastrarNovoUsurio.setBounds(137, 12, 175, 15);
        contentPane.add(lblCadastrarNovoUsurio);

        JLabel lblEmail = new JLabel("e-mail");
        lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        lblEmail.setBounds(77, 73, 70, 15);
        contentPane.add(lblEmail);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSenha.setBounds(77, 100, 70, 15);
        contentPane.add(lblSenha);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNome.setBounds(77, 127, 70, 15);
        contentPane.add(lblNome);

        txtEmail = new JTextField();
        txtEmail.setBounds(157, 71, 189, 19);
        contentPane.add(txtEmail);
        txtEmail.setColumns(10);

        txtNome = new JTextField();
        txtNome.setBounds(157, 125, 189, 19);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        txtSenha = new JTextField();
        txtSenha.setBounds(157, 99, 189, 19);
        contentPane.add(txtSenha);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(113, 168, 102, 19);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(validaCamposObrigatorios(txtEmail, txtSenha, txtNome)){
                    Usuarios usuario = new Usuarios();
                    usuario.setNome(txtNome.getText());
                    usuario.setLogin(txtEmail.getText());
                    usuario.setSenha(Criptografia.encripta(txtSenha.getText()));
                    try{
                        usuarioBO.salvar(usuario);
                        login().msgInfo("Usuario cadastrado com sucesso");

                    }catch (DAOException dao){
                        msgError(dao.getMessage());
                    }
                }
            }
        });
        contentPane.add(btnSalvar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(244, 168, 102, 19);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                login();
            }
        });
        contentPane.add(btnCancelar);


    }
}
