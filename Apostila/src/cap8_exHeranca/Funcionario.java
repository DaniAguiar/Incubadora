package cap8_exHeranca;

import javax.swing.*;

public class Funcionario {
    private String nome;
    private double salario;
    private double bonificacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(double bonificacao) {
        this.bonificacao = bonificacao;
    }

    public String mostraFuncionario(){
        return "\nNome: " + this.getNome() +
                "\nSalário: " + this.getSalario() +
                "\nBonificação: " +  this.getBonificacao();
    }
}
