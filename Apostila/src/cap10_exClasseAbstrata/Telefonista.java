package cap10_exClasseAbstrata;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Telefonista extends Funcionarios{
    private int ramal = 1020;

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }

    @Override
    public void imprimeBonificacao() {
        System.out.println("\nExtrato de Bonificação: Telefonista");
        SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy  HH:mm:ss");
        Date agora = new Date();
        System.out.println("DATA: " + sdf.format(agora));
        System.out.println("CODIGO: " + this.getCodigo());
        System.out.println("NOME: " + this.getNome());
        System.out.println("RAMAL: " + this.getRamal());
        System.out.println("SALÁRIO: " + this.getSalario());
        System.out.println("BONIFICAÇÃO: " + this.getBonificaçao());
    }
}
