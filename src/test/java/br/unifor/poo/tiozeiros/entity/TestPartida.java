package br.unifor.poo.tiozeiros.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

/**
 * Created by andre on 12/11/16.
 */
public class TestPartida {

    @Test
    public void testTempoDePartida(){
        Equipe e1 = new Equipe();
        Equipe e2 = new Equipe();
        Timer tempo = new Timer();
        Partida partida = new Partida(e1, e2, tempo);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            }
        };



    }

}
