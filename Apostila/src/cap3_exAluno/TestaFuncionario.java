package cap3_exAluno;

public class TestaFuncionario {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario();
        funcionario1.cargo = "Diretor";
        funcionario1.salario = 20000.00;

        Funcionario funcionario2 = new Funcionario();
        funcionario2.cargo = "Analista de Qualidade";
        funcionario2.salario = 8000.00;

        imprimeInfoFunc(funcionario1.cargo, funcionario1.salario);
        imprimeInfoFunc(funcionario2.cargo, funcionario2.salario);

    }

    static void imprimeInfoFunc(String cargo, double salario){
        System.out.println("\nCargo: " + cargo + "\nSalário: "+ salario);
    }
}
