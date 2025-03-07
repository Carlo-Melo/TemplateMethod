package Ordenacao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import Model.OrdenacaoAlunos;
import Model.Aluno;

class OrdenarPorNome extends OrdenacaoAlunos {
    @Override
    protected void ordenarLista(List<Aluno> alunos) {
        Collections.sort(alunos, Comparator.comparing(Aluno::getNome));
    }
}