package br.unifor.poo.tiozeiros.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * Created by andre on 12/11/16.
 */
public class AbstractFrame extends JFrame {

    protected JLabel messages;

    /*
    * Mensagens padrão de informação, alerta e erro
    * que todas telas poderão ter
    * */
    public void msgInfo(String msg) {
        messages.setText(msg);
        messages.setForeground(Color.BLUE);
        repaint();
    }

    public void msgWarn(String msg){
        messages.setText(msg);
        messages.setForeground(Color.YELLOW);
        repaint();
    }

    public void msgError(String msg){
        messages.setText(msg);
        messages.setForeground(Color.RED);
        repaint();
    }

    public AbstractFrame(){
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e){
                if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                    int selectedOption = JOptionPane.showConfirmDialog(null, "Exit application?", "?:\n", JOptionPane.YES_NO_OPTION);
                    if(selectedOption == JOptionPane.YES_OPTION){
                        System.exit(0);
                    }
                }
            }
        });
    }

    public void mostrarTela(JFrame frame){
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    *Tela de login do usuário
    */

    public AbstractFrame login(){
        LoginFrame frame = new LoginFrame();
        mostrarTela(frame);
        return frame;
    }

    /*
    *Tela de início da aplicação
    */

    public AbstractFrame home() {
        HomeFrame frame = new HomeFrame();
        mostrarTela(frame);
        return frame;
    }


}
