package cap9_exPolimorfismo;

public class Gerente extends Funcionario{
    private String usuario = "AndreMendes";
    private String senha = "12345678";

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
