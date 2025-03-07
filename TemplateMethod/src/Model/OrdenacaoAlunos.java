package Model;

import java.util.List;

public abstract class OrdenacaoAlunos {

    //metodo template
    public final void ordenar(List<Aluno> alunos) {
        if (alunos == null || alunos.isEmpty()) {
            System.out.println("Lista de alunos vazia ou nula.");
            return;
        }
        ordenarLista(alunos);
        exibirLista(alunos);
    }

    //metodo abstrato que será implementado pelas subclasses
    protected abstract void ordenarLista(List<Aluno> alunos);

    //exibe a lista ordenada (comportamento comum)
    private void exibirLista(List<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
