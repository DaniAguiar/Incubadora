package cap3_exBancario;

public class TestaFuncionario{
    public static void main(String[] args) {
        Funcionario f = new Funcionario(200.0);
        Impressora impressora = new Impressora();
        String opcao = "";

        f.nome = impressora.insereDados("Informe o nome do funcionario: ");

        do{
            opcao = impressora.insereDados(
                    "Realizar Operações:\n(1).Alterar nome\n(2).Alterar salário\n(3).Visualizar dados" +
                            "\nAperte Qualquer outra tecla para sair: ");

            switch (opcao){
                case "1": f.nome = impressora.insereDados(
                        "Informe o novo nome: ");
                    break;
                case "2": f.salario = (Double.parseDouble(impressora.insereDados(
                        "Informe o novo salário: ")));
                    break;
                case "3": f.mostrarDados();
                    break;
                default: opcao = "0";
                    break;
            }
        }while(opcao != "0");
    }
}
