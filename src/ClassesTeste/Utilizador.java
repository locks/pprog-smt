package ClassesTeste;

public class Utilizador {
    String nome;
    String password;

    public Utilizador(String nome, String password) {
        this.nome     = nome;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }
}
