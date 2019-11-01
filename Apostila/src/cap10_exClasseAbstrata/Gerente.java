package cap10_exClasseAbstrata;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Gerente extends Funcionarios {
    private String usuario = "rafinha.12";
    private String senha = "1234567";

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

    public void imprimeBonificacao(){
        System.out.println("Extrato de Bonificação: Gerente");
        SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy  HH:mm:ss");
        Date agora = new Date();
        System.out.println("DATA: " + sdf.format(agora));
        System.out.println("NOME: " + this.getNome());
        System.out.println("CODIGO: " + this.getCodigo());
        System.out.println("USUARIO: " + this.getUsuario());
        System.out.println("SALÁRIO: " + this.getSalario());
        System.out.println("BONIFICAÇÃO: " + this.getBonificaçao());
    }

}
