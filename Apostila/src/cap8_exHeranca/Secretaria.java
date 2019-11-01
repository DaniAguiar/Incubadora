package cap8_exHeranca;

import javax.swing.*;

public class Secretaria extends Funcionario {
    private String ramal = "1020";

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramnal) {
        this.ramal = ramal;
    }

    public void mostraDados(){
        JOptionPane.showMessageDialog(null,
                "Secretária" + mostraFuncionario() +
                        "\nRamal: " + this.getRamal());
    }
}
