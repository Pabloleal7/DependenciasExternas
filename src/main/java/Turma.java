import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;
@AllArgsConstructor
public @Data class  Turma {
    private String nome;
    private List<Aluno> Alunos;


}
