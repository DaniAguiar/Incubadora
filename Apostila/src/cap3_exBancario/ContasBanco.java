package cap3_exBancario;

import javax.swing.*;

public class ContasBanco{
    int numero;
    double limite;
    double saldo;

    void depositar(double valor){
        this.saldo +=valor;
    }

    void sacar(double valor){
        if(this.limite<=valor)
            this.saldo -= valor;
        else JOptionPane.showMessageDialog(null, "O saque não pode ultrapassar o limite");
    }

    void imprimirExtrato(){
         JOptionPane.showMessageDialog(null,"Imprimindo Extrato:\nSaldo Atual: R$" + this.saldo);
    }

}
