package Servidor;

public class Servidor {

    public static void main(String[] args) throws Exception {
        Ficheiro ficheiro = new Ficheiro();
        ficheiro.ligar();
        ficheiro.escreverDados();
        ficheiro.lerDados();
        ficheiro.desligar();
    }
}