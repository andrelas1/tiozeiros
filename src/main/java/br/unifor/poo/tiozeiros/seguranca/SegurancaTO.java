package br.unifor.poo.tiozeiros.seguranca;

import br.unifor.poo.tiozeiros.entity.Usuarios;

/**
 * Created by andre on 28/11/16.
 */

public class SegurancaTO {

    private static Usuarios usuario;

    /**
     * @return the usuario
     */
    public static Usuarios getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public static void setUsuario(Usuarios usuario) {
        SegurancaTO.usuario = usuario;
    }


}