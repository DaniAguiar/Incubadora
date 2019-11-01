package cap10_exClasseAbstrata;

import javax.swing.*;

public class TestaFuncionario {
    public static void main(String[] args) throws InterruptedException {
        Funcionarios f1 = new Gerente();
        Funcionarios f2 = new Telefonista();

        f1.setCodigo(1);
        f2.setCodigo(2);

        preencheDados(f1);
        preencheDados(f2);

        f1.imprimeBonificacao();
        Thread.sleep(1000);
        f2.imprimeBonificacao();
    }

    public static void preencheDados(Funcionarios funcionario){
        funcionario.setNome(JOptionPane.showInputDialog("Informe o nome do funcionario: "));

        funcionario.setSalario(Double.parseDouble(
                JOptionPane.showInputDialog("Informe o Salario para o funcionario: " + funcionario.getNome())
        ));

        funcionario.setBonificaçao(Double.parseDouble(
                JOptionPane.showInputDialog("Informe a bonificação para o funcionario: " + funcionario.getNome())
        ));
    }
}
