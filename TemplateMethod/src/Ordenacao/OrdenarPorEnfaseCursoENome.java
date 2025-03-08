package Ordenacao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import Model.OrdenacaoAlunos;
import Model.Aluno;

public class OrdenarPorEnfaseCursoENome extends OrdenacaoAlunos {
    @Override
    protected void ordenarLista(List<Aluno> alunos) {
        Collections.sort(alunos, Comparator.comparing(Aluno::getEnfase)
                .thenComparing(Aluno::getCurso)
                .thenComparing(Aluno::getNome));
    }
}
