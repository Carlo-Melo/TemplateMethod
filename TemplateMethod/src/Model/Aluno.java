package Model;

public class Aluno {

    private String nome;
    private String sobrenome;
    private String situacao;
    private String curso;
    private String enfase;

    public Aluno(String nome, String sobrenome, String situacao, String curso, String enfase) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.situacao = situacao;
        this.curso = curso;
        this.enfase = enfase;
    }

    public String getNome() { 
        return nome; }

    public String getSobrenome() { 
        return sobrenome; }

    public String getSituacao() { 
        return situacao; }

    public String getCurso() { 
        return curso; }
        
    public String getEnfase() { 
        return enfase; }

    @Override
    public String toString() {
        return nome + " " + sobrenome + " | Curso: " + curso + " | Ênfase: " + enfase + " | Situação: " + situacao;
    }
}
