import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

import javax.swing.*;
import java.util.List;

public class Valida {

    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome(JOptionPane.showInputDialog("****Programa de Validação de CPF****\n" +
                "Informe o nome do Titular a ser verificado: "));
        p.setCpf(JOptionPane.showInputDialog("Informe o CPF para verificação: "));

        valida(p.getCpf());
    }

    public static valida(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);

        if(erros.size() > 0){
            System.out.println(erros);
        }
        else{

        }
    }

}
