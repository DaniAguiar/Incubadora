package cap10_exClasseAbstrata;

abstract class Funcionarios {
    private int codigo;
    private String nome;
    private double bonificaçao;
    private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getBonificaçao() {
        return bonificaçao;
    }

    public void setBonificaçao(double bonificaçao) {
        this.bonificaçao = bonificaçao;
    }

    public abstract void imprimeBonificacao();
}
