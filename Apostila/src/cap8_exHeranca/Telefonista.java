package cap8_exHeranca;

import javax.swing.*;

public class Telefonista extends Funcionario {

    private String estacaodeTrabalho = "Sede";

    public String getEstacaodeTrabalho() {
        return estacaodeTrabalho;
    }

    public void setEstacaodeTrabalho(String estacaodeTrabalho) {
        this.estacaodeTrabalho = estacaodeTrabalho;
    }

    public void mostraDados(){
        JOptionPane.showMessageDialog(null,
                "Telefonista" + mostraFuncionario() +
                        "\nEstação de Trabalho: " + this.getEstacaodeTrabalho());
    }

}
