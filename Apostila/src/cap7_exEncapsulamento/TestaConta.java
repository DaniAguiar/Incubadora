package cap7_exEncapsulamento;

import javax.swing.*;

public class TestaConta {
    public static void main(String[] args) {
        Conta c = new Conta();
        String opcao;

        c.setNumero(Integer.parseInt(insereDados("Informe o número da conta: ")));
        c.setTitular(insereDados("Informe o nome do Titular: "));
        c.setSaldo(Double.parseDouble(insereDados("Informe seu saldo inicial: ")));

        do{
            opcao = insereDados(
                    "Realizar Operações:\n(1).Depositar\n(2).Sacar\n(3).Imprimir Extrato" +
                            "\nAperte Qualquer outra tecla para sair: ");

            switch (opcao){
                case "1": c.depositar(Double.parseDouble(insereDados(
                        "Informe o Valor a ser depositado: ")));
                    break;
                case "2": c.sacar(Double.parseDouble(insereDados(
                        "Informe o valor a ser sacado (será cobrado taxa de 6% do valor): ")));
                    break;
                case "3": JOptionPane.showMessageDialog(null, c.toString());
                    break;
                default: opcao = "0";
                    break;
            }
        }while(opcao != "0");
    }

     static String insereDados(String mensagem){
        return JOptionPane.showInputDialog(mensagem);
    }

}
