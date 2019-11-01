package cap3_exBancario;

public class TestaConta{
    public static void main(String[] args) {
        String opcao = "0";
        ContasBanco c = new ContasBanco();
        Impressora impressora = new Impressora();

        c.numero = Integer.parseInt(impressora.insereDados("Insira o numero da conta a ser registrada: "));
        c.limite = Double.parseDouble(impressora.insereDados("Defina o limite desta conta: "));
        c.saldo = Double.parseDouble(impressora.insereDados("Informe o Saldo inicial desta conta: "));

        do{
            opcao = impressora.insereDados(
                    "Realizar Operações:\n(1).Depositar\n(2).Sacar\n(3).Imprimir Extrato" +
                              "\nAperte Qualquer outra tecla para sair: ");

            switch (opcao){
                case "1": c.depositar(Double.parseDouble(impressora.insereDados(
                        "Informe o Valor a ser depositado: ")));
                        break;
                case "2": c.sacar(Double.parseDouble(impressora.insereDados(
                        "Informe o Valor a ser sacado: ")));
                        break;
                case "3": c.imprimirExtrato();
                        break;
                default: opcao = "0";
                        break;
            }
        }while(opcao != "0");
        impressora.mostraDados("Nossa Agência agradece a preferência!");
    }

}
