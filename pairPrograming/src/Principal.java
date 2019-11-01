import javax.swing.*;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException {
        int escolhaMenu;

        do {
            escolhaMenu = Integer.parseInt(JOptionPane.showInputDialog(
                    null,
                    "Menu Principal\n" +
                            "1 - Time\n" +
                            "2 - Pessoa\n" +
                            "3 - Sair\n"));

            switch (escolhaMenu) {
                case(1):
                    crudTime();
                    break;
                case(2):
                    crudPessoa();
                    break;
                case(3):
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opcao invalida!\n" +
                                    "Digite uma das 3 opcoes.");
                    break;
            }
        } while (escolhaMenu != 3);

    }

    public static void crudTime() throws IOException {
        int escolhaSubMenu;
        do{
            escolhaSubMenu = mostraSubMenu();

            switch (escolhaSubMenu){
                case(1):
                    String nome = escolhaNome();
                    Time.adicionarTime(nome);
                    break;
                case(2):
                    break;
                case(3):
                    break;
                case(4):
                    String listaTimes = Time.leituraArquivo();
                    JOptionPane.showMessageDialog(null, listaTimes);
                    break;
                case(5):
                    break;

            }
        }while (escolhaSubMenu != 5);

    }

    public static void crudPessoa() throws IOException{
        int escolhaSubMenu;
        do{
            escolhaSubMenu = mostraSubMenu();

            switch (escolhaSubMenu){
                case(1):
                    String nome = escolhaNome();
                    String nomeTime = escolhaTime();

                    Pessoas.adicionarPessoa(nome, nomeTime);
                    break;
                case(2):
                    Pessoas.removerPessoa();
                    break;
                case(3):
                    break;
                case(4):
                    String listaPessoas = Pessoas.leituraArquivo();
                    JOptionPane.showMessageDialog(null, listaPessoas);
                    break;
                case(5):
                    break;

            }
        }while (escolhaSubMenu != 5);

    }

    public static int mostraSubMenu(){
        return Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "SubMenu:\n" +
                        "1 - Adicionar\n" +
                        "2 - Remover\n" +
                        "3 - Alterar\n" +
                        "4 - Listar\n" +
                        "5 - Voltar ao Menu Principal\n"));
    }

    public static String escolhaNome(){
        return JOptionPane.showInputDialog(
                null,
                "Digite o nome: ");
    }

    public static String escolhaTime(){
        return JOptionPane.showInputDialog(
                null,
                "Digite o time: ");

    }
}
