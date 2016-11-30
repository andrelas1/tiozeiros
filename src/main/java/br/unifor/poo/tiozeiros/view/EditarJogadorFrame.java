package br.unifor.poo.tiozeiros.view;

import br.unifor.poo.tiozeiros.entity.Jogadores;
import br.unifor.poo.tiozeiros.exception.DAOException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by andre on 30/11/16.
 */
public class EditarJogadorFrame extends CadastrarJogadorFrame{
    public EditarJogadorFrame(Jogadores jogador){
        super();
        txtNome.setText(jogador.getNome());
        txtNome.setEditable(false);
        lblCadastrarNovoJogador.setText("Editar jogador");
        pnFinalizacao.setNivel(jogador.getChute());
        pnPasse.setNivel(jogador.getPasse());
        pnMarcação.setNivel(jogador.getMarcação());
        pnVelocidade.setNivel(jogador.getVelocidade());

        ActionListener[] ac = btnSalvar.getActionListeners();
        btnSalvar.removeActionListener(ac[0]);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(validaCamposObrigatorios(txtNome.getText(), pnFinalizacao, pnPasse, pnMarcação, pnVelocidade)){
                    jogador.setChute(pnFinalizacao.getNivel());
                    jogador.setPasse(pnPasse.getNivel());
                    jogador.setMarcação(pnMarcação.getNivel());
                    jogador.setVelocidade(pnVelocidade.getNivel());
                    try{
                        jogadoresBO.atualizar(jogador);
                        home().msgInfo("Jogador atualizado");
                    }catch (DAOException dao){
                        msgError(dao.getMessage());
                    }
                }
            }
        });
    }
}
