package br.unifor.poo.tiozeiros;

import br.unifor.poo.tiozeiros.entity.Equipe;
import br.unifor.poo.tiozeiros.entity.Jogador;
import br.unifor.poo.tiozeiros.entity.Partida;
import br.unifor.poo.tiozeiros.view.LoginFrame;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadFactory;

/**
 * Created by andre on 12/11/16.
 */
public class App {

    public static void main(String[] args) {
        LoginFrame frame = new LoginFrame();
        frame.createFrame();

    }
}
