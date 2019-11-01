package cap4_exArray;

import javax.swing.*;

public class ManipulandoArray {
    public static void main(String[] args) {
        double soma = 0.0;
        double media = 0.0;
        int maior = 0;
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o tamanho do vetor a ser preenchido: "));

        int[] numeros = new int[quantidade];

        for(int i=0; i < quantidade; i++){
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog(
                    "Informe o numero na posição " + i + " da Array: "));

            soma += numeros[i];

            if(maior < numeros[i])
                maior = numeros[i];
        }
        media = soma/quantidade;

        JOptionPane.showMessageDialog(null,
                "Media dos valores inseridos: " + media + "\nMaior valor inserido: " + maior);
    }
}
