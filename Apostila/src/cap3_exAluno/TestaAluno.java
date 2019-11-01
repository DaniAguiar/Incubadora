package cap3_exAluno;

public class TestaAluno {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno();
        Turma t1 = new Turma();

        t1.periodo = "Matutino";
        t1.serie = "Primeira";
        t1.sigla = "Sigla X";
        t1.tipoEnsino = "Fundamental";

        aluno1.nome = "Yoda Noronha";
        aluno1.rg = "55.555.555-5";
        aluno1.dataNasc = "01/01/1994";

        aluno1.turma = t1;
        System.out.println(aluno1.turma.periodo);
        System.out.println(aluno1.turma.serie);
        System.out.println(aluno1.turma.sigla);
        System.out.println(aluno1.turma.tipoEnsino);

        Aluno aluno2 = new Aluno();
        aluno2.nome = "BrTT Gonçalves";
        aluno2.rg = "66.666.666-6";
        aluno2.dataNasc = "15/11/1990";

        imprimeInfoAluno(aluno1.nome, aluno1.rg, aluno1.dataNasc);
        imprimeInfoAluno(aluno2.nome, aluno2.rg, aluno2.dataNasc);

    }

    static void imprimeInfoAluno(String nome, String rg, String dataNasc){
        System.out.println("\nNome: " + nome + "\nRG: "+ rg + "\ndata Nascimento: " + dataNasc);
    }
}
