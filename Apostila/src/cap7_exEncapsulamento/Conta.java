package cap7_exEncapsulamento;

public class Conta {
    private int numero;
    private String titular;
    private double saldo;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void sacar(double valor){
        this.saldo -= valor;
        descontaTarifa(valor);
    }

    public void descontaTarifa(double valor){
        this.saldo -= (valor * 0.06);
    }

    @Override
    public String toString() {
        return "Conta: " + numero + "\nTitular: " + titular + "\nSaldo atual: " + saldo;
    }
}
