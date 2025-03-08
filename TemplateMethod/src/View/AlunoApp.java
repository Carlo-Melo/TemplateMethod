import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import Model.Aluno;
import Model.OrdenacaoAlunos;
import Ordenacao.OrdenarPorCursoENome;
import Ordenacao.OrdenarPorCursoEnfaseENome;
import Ordenacao.OrdenarPorEnfaseCursoENome;
import Ordenacao.OrdenarPorEnfaseENome;
import Ordenacao.OrdenarPorSobrenome;
import Ordenacao.OrdenarPorNome;
 

public class AlunoApp extends JFrame {

    private JComboBox<String> comboOrdenacao;
    private JTextArea textArea;
    private List<Aluno> alunos;

    public AlunoApp() {
        setTitle("Lista de Alunos - Ordenação");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Criando alunos
        alunos = new ArrayList<>();
        alunos.add(new Aluno("Ana", "Silva", "Ativo", "Engenharia de Software", "Desenvolvimento"));
        alunos.add(new Aluno("Bruno", "Souza", "Inativo", "Ciência da Computação", "Dados"));
        alunos.add(new Aluno("Carlos", "Oliveira", "Ativo", "Sistemas de Informação", "Segurança"));
        alunos.add(new Aluno("Daniela", "Pereira", "Ativo", "Engenharia de Software", "Desenvolvimento"));
        alunos.add(new Aluno("Eduardo", "Santos", "Inativo", "Ciência da Computação", "Dados"));

        // Painel de seleção
        JPanel panelTop = new JPanel();
        panelTop.add(new JLabel("Escolha a ordenação:"));
        
        comboOrdenacao = new JComboBox<>(new String[]{
                "Nome", "Sobrenome", "Situação e Nome",
                "Curso e Nome", "Ênfase e Nome",
                "Curso, Ênfase e Nome", "Ênfase, Curso e Nome"
        });
        panelTop.add(comboOrdenacao);
        
        JButton btnOrdenar = new JButton("Ordenar");
        panelTop.add(btnOrdenar);
        add(panelTop, BorderLayout.NORTH);

        // Área de texto para exibir a lista de alunos
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Botão de ação
        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarAlunos();
            }
        });

        atualizarLista();
        setVisible(true);
    }

    private void ordenarAlunos() {
        OrdenacaoAlunos ordenacao = null;
        int escolha = comboOrdenacao.getSelectedIndex() + 1;

        switch (escolha) {
            case 1: ordenacao = new OrdenarPorNome(); break;
            case 2: ordenacao = new OrdenarPorSobrenome(); break;
            case 4: ordenacao = new OrdenarPorCursoENome(); break;
            case 5: ordenacao = new OrdenarPorEnfaseENome(); break;
            case 6: ordenacao = new OrdenarPorCursoEnfaseENome(); break;
            case 7: ordenacao = new OrdenarPorEnfaseCursoENome(); break;
            default: return;
        }

        ordenacao.ordenar(alunos);
        atualizarLista();
    }

    private void atualizarLista() {
        textArea.setText("");
        for (Aluno aluno : alunos) {
            textArea.append(aluno + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AlunoApp());
    }
}
