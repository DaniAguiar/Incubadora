import javax.swing.*;
import java.io.*;

public class Time {

    //Gerar arquivo
    public static void gerarArquivo(String sBody) throws IOException {
        File root = new File("Arquivos");
        if (!root.exists()) {
            root.mkdirs();
        }

        File gpxfile = new File(root, "Times");
        StringBuilder times = new StringBuilder();

        if (gpxfile.exists()) {
            times.append(leituraArquivo());
            times.append(sBody);
            times.append("\n");
        }

        FileWriter writer = new FileWriter(gpxfile);

        writer.append(times);
        writer.flush();
        writer.close();
    }

    //Ler arquivo
    public static String leituraArquivo() throws IOException {
        File file = new File("Arquivos", "Times");
        StringBuilder text = new StringBuilder();


        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            text.append(line);
            text.append('\n');
        }
        br.close();

        return text.toString();
    }

    // CRUD
     public static void adicionarTime(String nome) throws IOException {
        if(nome.length()>3) {
            gerarArquivo(nome);
            JOptionPane.showMessageDialog(
                    null,
                    "Time adicionado!");
        }else{
            JOptionPane.showMessageDialog(null, "O nome deve " +
                    "conter mais que 3 caracteres");
        }
    }
    public static void removerTime() throws IOException {
        String linhaDelete = JOptionPane.showInputDialog("Informe o nome do Time a ser Removido: ");
        System.out.println("Time a ser deletado: " + linhaDelete);

        try {
            File folder = new File("Arquivos");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            File tempFile = new File(folder, "Times");
            StringBuilder st = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(tempFile));
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.trim().toLowerCase().contentEquals(linhaDelete.trim().toLowerCase())) {
                    st.append(line);
                    st.append("\n");
                    System.out.println(linhaDelete+ " foi deletado!");
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


}
