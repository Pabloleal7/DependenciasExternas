
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("" + turma.getNome() + ".txt"))) {

            writer.write("Turma: " + turma.getNome());
            writer.newLine();

            writer.write("Quantidade de Alunos: " + turma.getAlunos().size());
            writer.newLine();
            writer.newLine();

            for (Aluno aluno : turma.getAlunos()
            ) {
                writer.write(aluno.getNome());
                writer.newLine();


            }
        } catch (IOException e) {
            System.err.println("Não conseguiu gravar arquivo" + e.getMessage());
        }

    }


    private static void imprimirTodosOsAlunos(SortedSet<Aluno> alunos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("listaalunos.txt"))) {

            writer.write("Todos os Alunos");
            writer.newLine();
            writer.write("Quantidade de Alunos: " + alunos.size());
            writer.newLine();
            writer.newLine();

            for (Aluno aluno : alunos
            ) {
                writer.write(aluno.getNome());
                writer.newLine();


            }
        } catch (IOException e) {
            System.err.println("Não conseguiu gravar arquivo" + e.getMessage());
        }

    }


}



/*
    Projeto de avaliacao do Módulo de Dependencias externas
        Crie um projeto individual/grupo Utilizando os principais topicos apresentados ao longo dos módulos.

        Desejável:
        Aplicar principios da OO  ok
        Utilizar um gerenciador de pacotes ( Maven / Gradle) OK MAven
        Utilizar Lombok  OK
        Utilziar pelo menos 2 dependencias  ||| 1 dep Lombok falta 1
        Utuilziar pelo menos 2 estrutura de dados distintas ||| 1 list 2 sortedlist
        Gerar os arquivos de saida para cada ok
        Precisa ser inserida 2 funcionalidades. ok

        Imprimir cada turma e seus alunos ok
        Nome da turma ok
        total alunos ok
        nome dos alunos ok
        imprimir todos os alunos da escola ( sem duplicados, ja que existem alunos nas duas turmas) em ordem alfabetica
        -As impressões deverão ser geradas em um arquivo.txt ok

        Alunos de cada turma:

        Turma Java

        Projeto - Mod. Dependencias Externas
        Alexandre Martins
        Vitor Hugo Lima
        Esther Rodrigues
        Lavínia Cunha
        Natália Gomes
        Yago Ramos
        Letícia Cunha
        Srta. Ana Júlia Ramos
        Pietra Martins
        Thomas Peixoto
        Thales Farias
        Turma Banco de dados

        Vitor Hugo Lima
        Esther Rodrigues
        Nathan Nascimento
        Lavínia Cunha
        Natália Gomes
        Dra. Lavínia Lopes
        Yago Ramos
        Letícia Cunha
        Luiz Miguel Azevedo
        Srta. Ana Júlia Ramos
        Thales Farias
        Dra. Alana Porto
        Avaliação e Entrega.
        Entrega do link do repositorio, tendo o ultimo commit sendo no maximo o ultimo dia do modulo (09/02/2022)

        Cada projeto será avaliado e revisado e cada aluno sera respondido com um feedback sobre o trablaho.*/
