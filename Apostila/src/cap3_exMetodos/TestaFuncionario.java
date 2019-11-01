package cap3_exMetodos;

import javax.swing.*;

public class TestaFuncionario {
    public static void main(String[] args) {
        Funcionario f = new Funcionario();
        f.nome = chamaPainel("Nome do funcionário: ");
        f.salario = Double.parseDouble(chamaPainel("Informe o salario deste: "));

        f.aumentaSalario(Double.parseDouble(chamaPainel("Informe a quantidade à ser aumentada no salario")));

        f.consultarDadosFuncionario();
    }

    static String chamaPainel(String mensagem){
        return JOptionPane.showInputDialog(mensagem);
    }
}
