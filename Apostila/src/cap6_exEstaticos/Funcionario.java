package cap6_exEstaticos;

import javax.swing.*;

public class Funcionario {
    String nome;
    static double valeRefeicao;

    static void reajustarValeRefeicao(double taxa){
        Funcionario.valeRefeicao =+ (Funcionario.valeRefeicao * (1.0 + taxa));
        JOptionPane.showMessageDialog(null,
                "Novo Vale Refeição: R$" + Funcionario.valeRefeicao);
    }
}
