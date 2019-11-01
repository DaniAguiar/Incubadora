package cap3_exBancario;

import javax.swing.*;

public class Impressora{
    String mensagem;

    String insereDados(String mensagem){
        return JOptionPane.showInputDialog(mensagem);
    }

    void mostraDados(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
