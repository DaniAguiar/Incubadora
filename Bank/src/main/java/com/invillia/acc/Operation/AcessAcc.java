package com.invillia.acc.Operation;

import com.invillia.acc.AccDAO;
import com.invillia.acc.Acount;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

public class AcessAcc {
    public static void main() {

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bank");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final AccDAO accDAO = new AccDAO(entityManager);

        String option;

        do{
            option = JOptionPane.showInputDialog("Escolha uma opção:\n" +
                    "(1).Listar uma Conta específica\n" +
                    "(2).Escolher uma conta para operar\n" +
                    "(3).Remover uma conta\n"+
                    "(0).Sair");

            switch (option){
                case "1": listData();
                    break;
                case "2": acess();
                    break;
                case "3": long id = Integer.parseInt(JOptionPane.showInputDialog("" +
                        "Informe o Código da conta a ser deletada: "));

                        accDAO.deleteById(id);

                    break;
                default: option = "0";
            }
        }while(option != "0");
    }

    public static void listData(){
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bank");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final AccDAO accDAO = new AccDAO(entityManager);

        long id = Long.parseLong(JOptionPane.showInputDialog("Informe o Código da conta para listar: "));
        final com.invillia.acc.Acount acount = accDAO.findById(id);
        JOptionPane.showMessageDialog(null, acount);
    }

    public static void acess(){
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bank");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final AccDAO accDAO = new AccDAO(entityManager);

        long id = Long.parseLong(JOptionPane.showInputDialog("Informe o codigo da conta para Operar: "));
        final com.invillia.acc.Acount acount = accDAO.findById(id);

        String option;
        double value;

        do{
            option = JOptionPane.showInputDialog("Escolha uma opção:\n" +
                    "(1).Sacar\n" +
                    "(2).Depositar\n" +
                    "(0).Sair");

            switch (option){
                case "1":
                            value = Double.parseDouble(JOptionPane.showInputDialog("Valor de saque: "));
                            acount.setAccBalance(acount.Withdrawn(value));
                            accDAO.update(acount);
                    break;
                case "2":
                            value = Double.parseDouble(JOptionPane.showInputDialog("Valor de depósito: "));
                            acount.setAccBalance(acount.Deposit(value));
                            accDAO.update(acount);
                    break;
                default: option = "0";
            }
        }while(option != "0");
    }
}
