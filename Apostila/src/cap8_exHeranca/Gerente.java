package cap8_exHeranca;

import javax.swing.*;

public class Gerente extends Funcionario{
    private String usuario = "gerencia14";
    private String senha = "senhamaster";

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

    public void mostraDados(){
        JOptionPane.showMessageDialog(null,
                "Gerente" + mostraFuncionario() +
                        "\nUsuário: " + this.getUsuario() +
                        "\nSenha: " + this.getSenha());
    }
}
