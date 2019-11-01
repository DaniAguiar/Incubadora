package com.invillia.acc.Operation;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import com.invillia.acc.AccDAO;
import com.invillia.acc.Acount;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.util.List;

public class InsertData {
    public static void main() {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bank");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        final AccDAO accDAO = new AccDAO(entityManager);

        int number = Integer.parseInt(insertInfo("Informe o numero da conta: "));
        double balance = Double.parseDouble(insertInfo("Informe o saldo inicial da conta: "));
        double limit = Double.parseDouble(insertInfo("Informe o Limite (cheque especial)"));
        String name = insertInfo("Informe o nome do Titular: ");
        String cpf = insertInfo("CPF: ");

        validarCpf(cpf);

        double maxlimit = limit;

        accDAO.insert( new Acount(
                number,
                balance,
                limit,
                name,
                cpf,
                maxlimit
        ));
    }
    public static String insertInfo(String mensagem){
        return JOptionPane.showInputDialog(mensagem);
    }
    public static void validarCpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);

        if(erros.size() > 0){
            System.out.println(erros);
            JOptionPane.showMessageDialog(null, "CPF INCORRETO!\nEncerrando inserção...");
            System.exit(0);
        }
        else{
            System.out.println("CPF Aceito");
        }
    }

}
