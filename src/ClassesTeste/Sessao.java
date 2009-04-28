package ClassesTeste;

public class Sessao {

    SistemaDeUtilizadores sistema;
    Utilizador utilizadorSessao;

    public Sessao() {
        sistema = new SistemaDeUtilizadores();
        utilizadorSessao = null;
    }
    
    public void inicializar() {
        new Sessao();
        System.out.println(sistema.toString());
    }

    public static void main(String[] args) {
        Sessao sessao = new Sessao();
    }

}
