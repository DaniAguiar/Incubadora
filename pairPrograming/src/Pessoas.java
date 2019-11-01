import javax.swing.*;
import java.io.*;

public class Pessoas {

    //Gerar arquivo
    public static void gerarArquivo(String nome, String time) throws IOException {
        File root = new File("Arquivos");
        if (!root.exists()) {
            root.mkdirs();
        }

        File gpxfile = new File(root, "Pessoas");
        StringBuilder pessoas = new StringBuilder();

        if (gpxfile.exists()) {
            pessoas.append(leituraArquivo());
            pessoas.append("Nome:" + nome + " - Time:" + time);
            pessoas.append("\n");
        }

        FileWriter writer = new FileWriter(gpxfile);

        writer.append(pessoas);
        writer.flush();
        writer.close();
    }

    //Ler arquivo
    public static String leituraArquivo() throws IOException {
        File file = new File("Arquivos", "Pessoas");
        StringBuilder pessoas = new StringBuilder();


        BufferedReader br = new BufferedReader(new FileReader(file));
        String linha;

        while ((linha = br.readLine()) != null) {
            pessoas.append(linha);
            pessoas.append('\n');
        }
        br.close();

        return pessoas.toString();
    }

    // CRUD
    public static void adicionarPessoa(String nome, String time) throws IOException {
        if (nome.length() > 3 && time.length() > 3) {
            gerarArquivo(nome, time);
            JOptionPane.showMessageDialog(
                    null,
                    "Pessoa adicionada!");
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "O nome e o time devem conter mais que 3 caracteres");
        }
    }

    public static void removerPessoa() throws IOException {
        String linhaDelete = JOptionPane.showInputDialog("Informe o nome da Pessoa a ser Removido: ");
        System.out.println("Contato a ser deletado:" + linhaDelete);

        try {
            File folder = new File("Arquivos");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            File tempFile = new File(folder, "Pessoas");
            StringBuilder st = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(tempFile));
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.trim().toLowerCase().contentEquals(linhaDelete.trim().toLowerCase())) {
                    st.append(line);
                    st.append("\n");
                }
            }
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            pw.append(st);
            pw.close();
            pw.flush();
        } catch (FileNotFoundException arq) {
            arq.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void replaceLinha(File f) {
//        File nf = new File("temporario.tmp");
//        FileWriter fw = null;
//        Scanner s = null;
//        try {
//            fw = new FileWriter(nf);
//            s = new Scanner(f);
//
//            while (s.hasNextLine()) {
//                String linha = s.nextLine();
//
//                linha = linha.replace(linhaAlterar, linhaAlterada);
//
//                try {
//                    fw.write(linha + System.getProperty("line.separator"));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fw.close();
//                s.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        f.delete();
//        nf.renameTo(f);
//    }
}




