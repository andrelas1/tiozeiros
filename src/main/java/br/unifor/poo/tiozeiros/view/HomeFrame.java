package br.unifor.poo.tiozeiros.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by andre on 12/11/16.
 */
public class HomeFrame extends AbstractFrame {

    private JPanel contentPane;



    public void createFrame(){
        HomeFrame frame = new HomeFrame();
        setTitle("Tiozeiros Futebol Clube");
        setBounds(100, 100, 577, 349);
        contentPane = new JPanel();


        frame.add(contentPane);
        mostrarTela(frame);
    }


}
