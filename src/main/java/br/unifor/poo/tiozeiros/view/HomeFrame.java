package br.unifor.poo.tiozeiros.view;

import br.unifor.poo.tiozeiros.entity.Equipe;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


/**
 * Created by andre on 12/11/16.
 */

public class HomeFrame extends AbstractFrame{

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomeFrame frame = new HomeFrame();
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
    public HomeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        messages = new JLabel("");
        messages.setBounds(5, 260, 300, 14);
        contentPane.add(messages);

        JLabel lblNewLabel = new JLabel("Logado com Sucesso!!");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(116, 77, 207, 70);
        contentPane.add(lblNewLabel);
    }
}


