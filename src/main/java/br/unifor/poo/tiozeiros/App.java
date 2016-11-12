package br.unifor.poo.tiozeiros;

import br.unifor.poo.tiozeiros.entity.Equipe;
import br.unifor.poo.tiozeiros.entity.Jogador;
import br.unifor.poo.tiozeiros.entity.Partida;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadFactory;

/**
 * Created by andre on 12/11/16.
 */
public class App {

    public static void main(String[] args) {
        Partida partida = new Partida();

        Scanner scan = new Scanner(System.in);
        System.out.println("Tempo em minutos");
        partida.iniciarPartida(scan.nextInt());

    }
}
