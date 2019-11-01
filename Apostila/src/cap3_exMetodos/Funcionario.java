package cap3_exMetodos;

public class Funcionario {
    String nome;
    double salario;

    void aumentaSalario(double valor){
        this.salario += valor;


    }

    void consultarDadosFuncionario(){
        System.out.println("Nome do funcionario: "+this.nome+ "\n Salário: "+this.salario);
    }
}
