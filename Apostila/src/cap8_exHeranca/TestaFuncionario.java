package cap8_exHeranca;

import javax.swing.*;

public class TestaFuncionario {
    public static void main(String[] args) {
        String opcao;

        Gerente gerente = new Gerente();
        Telefonista telefonista = new Telefonista();
        Secretaria secretaria = new Secretaria();

        gerente.setNome("Antonio Baldan");
        gerente.setBonificacao(500.0);
        gerente.setSalario(5000.0);

        telefonista.setNome("Juliana");
        telefonista.setBonificacao(200.0);
        telefonista.setSalario(2000.0);

        secretaria.setNome("Maria");
        secretaria.setBonificacao(300.0);
        secretaria.setSalario(2500.0);

        do{
            opcao = JOptionPane.showInputDialog("Mostrar Informações de:\n" +
                    "(1).Gerente\n" +
                    "(2).Secretária\n" +
                    "(3).Telefonista" +
                    "\nAperte qualquer outra tecla para sair");

            switch (opcao){
                case "1": gerente.mostraDados();
                        break;
                case "2": secretaria.mostraDados();
                        break;
                case "3": telefonista.mostraDados();
                        break;
                default: opcao = "0";
                        break;
            }
        }while(opcao != "0");

    }
}
