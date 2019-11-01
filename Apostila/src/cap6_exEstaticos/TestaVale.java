package cap6_exEstaticos;

import javax.swing.*;

public class TestaVale {
    public static void main(String[] args) {
        Funcionario f = new Funcionario();
        double taxa;

        Funcionario.valeRefeicao = 15;
        f.nome = JOptionPane.showInputDialog("Vale Refeição atual: R$"+ Funcionario.valeRefeicao +"\nInforme o nome do Funcionario: ");

        taxa = Double.parseDouble(JOptionPane.showInputDialog("Informe a taxa de reajuste no Vale Refeição: "));

        Funcionario.reajustarValeRefeicao(taxa);
    }
}
