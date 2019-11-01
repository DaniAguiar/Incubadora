package cap17_exEntradaSaida;

import java.io.*;
import java.util.Scanner;

public class ManipulandoArquivo {
    public static void escritor(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "";
        Scanner in = new Scanner(System.in);
        System.out.print("Escreva algo (arquivo de origem): ");
        linha = in.nextLine();
        buffWrite.append(linha + "\n");
        buffWrite.close();
    }

    public static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }

    public static void gravandoDestino(String origem, String destino) throws IOException {
        BufferedWriter buffWriteDestino = new BufferedWriter(new FileWriter(destino));
        Scanner scanner = new Scanner ( origem ) ;
        String linha = "";

        // Lê a Origem
        BufferedReader buffReadOrigem = new BufferedReader(new FileReader(origem));

        System.out.print("\nGravando palavaras no arquivo de destino");

        while (scanner.hasNextLine ()){
            linha = scanner.nextLine();
            System.out.println(linha);
            linha = buffReadOrigem.readLine();
            buffWriteDestino.append(linha + "\n");
        }
        buffReadOrigem.close();

        buffWriteDestino.close();
    }
}
