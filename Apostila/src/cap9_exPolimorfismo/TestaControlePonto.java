package cap9_exPolimorfismo;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestaControlePonto {
    public static void main(String[] args) throws InterruptedException {
        Gerente gerente = new Gerente();
        Telefonista telefonista = new Telefonista();
        int quantidadeCargos  = 2;

        Funcionario funcionario1 = gerente;
        Funcionario funcionario2 = telefonista;

        funcionario1.setCodigo("333");
        funcionario2.setCodigo(("666"));

        registraEntrada(funcionario1);
        registraEntrada(funcionario2);

        Thread.sleep(1000);

        registraSaida(funcionario1);
        registraSaida(funcionario2);
    }

    public static void registraEntrada(Funcionario funcionario) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
        Date agora = new Date ();
        System.out.println("ENTRADA:" + funcionario.getCodigo());
        System.out.println("DATA:" + sdf.format(agora));
    }

    public static void registraSaida(Funcionario funcionario) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
        Date agora = new Date ();
        System.out.println("SAÍDA: " + funcionario.getCodigo());
        System.out.println("DATA: " + sdf.format(agora));
    }
}
