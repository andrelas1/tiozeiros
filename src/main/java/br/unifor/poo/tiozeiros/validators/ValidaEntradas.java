package br.unifor.poo.tiozeiros.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andre on 22/11/16.
 */
public class ValidaEntradas {
    private String padraoEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern = Pattern.compile(padraoEmail, Pattern.CASE_INSENSITIVE);
    private Matcher matcher;

    public boolean validarPadraoEmail(String email) {
        matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarTamanhoSenha(String senha){
        if(senha.length()==6){
            return true;
        }else{
            return false;
        }
    }




}
