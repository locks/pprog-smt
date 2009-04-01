/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AplicacaoExceptions;

/**
 *
 * @author locks
 */
public class ValorInvalido extends Exception {
    public ValorInvalido() {
        super("Valor introduzido é inválido.");
    }

    public ValorInvalido(String msg) {
        super("Valor introduzido é inválido: " + msg);
    }


}
