import lombok.AllArgsConstructor;
import lombok.Data;



@AllArgsConstructor
public @Data
class Aluno implements Comparable<Aluno> {
    private String nome;

    @Override
    public int compareTo(Aluno o) {
        return this.getNome().compareTo(o.nome);
    }
}
