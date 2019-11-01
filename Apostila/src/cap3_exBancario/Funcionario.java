package cap3_exBancario;

import javax.swing.*;

public class Funcionario{
    String nome;
    double salario;

    Funcionario(double salarioInicial){
        this.salario = salarioInicial;
    }

    void mostrarDados(){
        JOptionPane.showMessageDialog(
                null, "Dados Atuais:\nNome: " + this.nome + "\nSalário: " + this.salario);
    }

}
