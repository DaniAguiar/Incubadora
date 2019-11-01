package com.invillia.acc;

import com.invillia.acc.Operation.AcessAcc;
import com.invillia.acc.Operation.InsertData;
import com.invillia.acc.Operation.ListData;

import javax.swing.*;

public class Program {
    public static void main(String[] args) {

        System.out.println("-------------------------------------------------------------------------------");

        String option = "";

        do{
            option = JOptionPane.showInputDialog("---------------Bank---------------\n " +
                    "Escolha uma opção:\n" +
                    "(1).Registrar uma conta\n" +
                    "(2).Listar contas existentes\n" +
                    "(3).Escolher uma conta para operar\n" +
                    "(0).Sair");

           switch (option){
               case "1": InsertData.main();
                        break;
               case "2": ListData.main();
                        break;
               case "3": AcessAcc.main();
                        break;
               default: option = "0";
           }
        }while(option != "0");

    }
}
