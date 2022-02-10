

import org.apache.commons.io.output.FileWriterWithEncoding;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Turma turmaJava = new Turma("Java", null);
        Turma turmaBancoDeDados = new Turma("Banco de Dados", null);


        String[] nomesAlunosTurmaJava = {"Alexandre Martins",
                "Vitor Hugo Lima",
                "Esther Rodrigues",
                "Lavínia Cunha",
                "Natália Gomes",
                "Yago Ramos",
                "Letícia Cunha",
                "Srta. Ana Júlia Ramos",
                "Pietra Martins",
                "Thomas Peixoto",
                "Thales Farias"};

        String[] nomesAlunosTurmaBancoDeDados = {
                "Vitor Hugo Lima",
                "Esther Rodrigues",
                "Nathan Nascimento",
                "Lavínia Cunha",
                "Natália Gomes",
                "Dra. Lavínia Lopes",
                "Yago Ramos",
                "Letícia Cunha",
                "Luiz Miguel Azevedo",
                "Srta. Ana Júlia Ramos",
                "Thales Farias",
                "Dra. Alana Porto",
        };

        List<Aluno> alunosTurmaJava = new ArrayList<>();
        for (String s : nomesAlunosTurmaJava) {
            alunosTurmaJava.add(new Aluno(s));
        }
        turmaJava.setAlunos(alunosTurmaJava);

        List<Aluno> alunosTurmaBancoDeDados = new ArrayList<>();
        turmaBancoDeDados.setAlunos(alunosTurmaBancoDeDados);
        for (String s : nomesAlunosTurmaBancoDeDados) {
            alunosTurmaBancoDeDados.add(new Aluno(s));
        }


        SortedSet<Aluno> todosAlunos = new TreeSet<>();
        todosAlunos.addAll(turmaJava.getAlunos());
        todosAlunos.addAll(turmaBancoDeDados.getAlunos());

        imprimirTodosOsAlunos(todosAlunos);
        imprimirAlunosPorTurma(turmaJava);
        imprimirAlunosPorTurma(turmaBancoDeDados);

    }

    private static void imprimirAlunosPorTurma(Turma turma) {
        Collections.sort(turma.getAlunos());
        String linha = "\n";
        try (FileWriterWithEncoding writer = new FileWriterWithEncoding( turma.getNome() + ".txt", Charset.defaultCharset())) {

            writer.write("Turma: " + turma.getNome());
            writer.write(linha);

            writer.write("Quantidade de Alunos: " + turma.getAlunos().size());
            writer.write(linha);
            writer.write(linha);

            for (Aluno aluno : turma.getAlunos()
            ) {
                writer.write(aluno.getNome());
                writer.write(linha);


            }
        } catch (IOException e) {
            System.err.println("Não conseguiu gravar arquivo" + e.getMessage());
        }

    }


    private static void imprimirTodosOsAlunos(SortedSet<Aluno> alunos) {
       String linha = "\n";
        try (FileWriterWithEncoding writer = new FileWriterWithEncoding("listaalunos.txt", Charset.defaultCharset())) {

            writer.write("Todos os Alunos");
            writer.write(linha);
            writer.write("Quantidade de Alunos: " + alunos.size());
            writer.write(linha);
            writer.write(linha);

            for (Aluno aluno : alunos
            ) {
                writer.write(aluno.getNome());
                writer.write(linha);


            }
        } catch (IOException e) {
            System.err.println("Não conseguiu gravar arquivo" + e.getMessage());
        }

    }




}


