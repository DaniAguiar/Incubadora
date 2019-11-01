package cap3_exAluno;

public class TestaTurma {
    public static void main(String[] args) {
        Turma turma1 = new Turma();
        turma1.periodo = "Matutino";
        turma1.serie = "Primeira";
        turma1.sigla = "Sigla X";
        turma1.tipoEnsino = "Fundamental";


        Turma turma2 = new Turma();
        turma2.periodo = "Noturno";
        turma2.serie = "Quinta";
        turma2.sigla = "Sigla y";
        turma2.tipoEnsino = "Medio";

        imprimeInfoTurma(turma1.periodo, turma1.serie, turma1.sigla, turma1.tipoEnsino);
        imprimeInfoTurma(turma2.periodo, turma2.serie, turma2.sigla, turma2.tipoEnsino);

    }

    static void imprimeInfoTurma(String periodo, String serie, String sigla, String tipoEnsino){
        System.out.println("\nPeriodo: " + periodo + "\nSérie: "+ serie + "\nSigla: " + sigla + "\nTipo de Ensino: " + tipoEnsino);
    }
}
