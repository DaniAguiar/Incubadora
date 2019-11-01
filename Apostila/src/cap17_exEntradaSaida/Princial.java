package cap17_exEntradaSaida;

import java.io.IOException;

public class Princial {
    public static void main(String args[]) throws IOException {
        String origem = "/home/incubadora/Área de Trabalho/file.txt";
        String destino = "/home/incubadora/Área de Trabalho/destino.txt";

        ManipulandoArquivo.escritor(origem);
        ManipulandoArquivo.leitor(origem);

        ManipulandoArquivo.gravandoDestino(origem, destino);

    }
}
