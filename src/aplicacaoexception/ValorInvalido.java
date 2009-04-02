package aplicacaoexception;

public class ValorInvalido extends Exception {
    public ValorInvalido() {
        super("Valor introduzido é inválido.");
    }

    public ValorInvalido(String msg) {
        super("Valor introduzido é inválido: " + msg);
    }


}
