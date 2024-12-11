import Execeptions.AlunoNaoEncontrado;
import Execeptions.NotFoundAlunos;
import Services.AlunoServices;
import Services.TeacherServices;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlunoServices alunoServices = new AlunoServices();
        TeacherServices teacherServices = new TeacherServices();
        Scanner sc = new Scanner(System.in );
        int options = 0;
        while(options != 7){
            System.out.println("\nGerenciamento do Curso Seno");
            System.out.println("[1] Gerenciar Alunos");
            System.out.println("[2] Gerenciar Professores");
            options = sc.nextInt();
            sc.nextLine();

            switch (options){
                case 1:
                    gerenciarAluno(sc, alunoServices);
                    break;
                case 2:
                    gerenciarProfessores(sc,teacherServices);
            }
        }

        sc.close();
    }

    public static void gerenciarAluno(Scanner sc, AlunoServices alunoServices){
        System.out.println("\nGerenciar Alunos");
        System.out.println("[1] Criar aluno");
        System.out.println("[2] Editar Aluno");
        System.out.println("[3] Deletar Aluno");
        System.out.println("[4] listar alunos");
        System.out.print("Escolha uma dessas opções ");
        int opcao = sc.nextInt();
        sc.nextLine();
        try {
            switch (opcao) {
                case 1:
                    System.out.print("nome do aluno: ");
                    String name = sc.nextLine();
                    System.out.print("CPF do aluno: ");
                    String cpf = sc.nextLine();
                    alunoServices.criar(name, cpf);
                    System.out.println("Aluno cadastrado com sucesso!!!");
                    break;
                case 2:
                    System.out.print("Cpf do aluno: ");
                    String cpfEditar = sc.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String novoNome = sc.nextLine();
                    alunoServices.alterar(cpfEditar,novoNome);
                    System.out.println("O aluno do cpf" + cpfEditar + "foi alterado com sucesso");
                    break;
                case 3:
                    System.out.print("CPF do aluno: ");
                    String cpfDelete = sc.nextLine();
                    alunoServices.deletar(cpfDelete);
                    break;
                case 4:
                    alunoServices.listarAlunos().forEach(System.out::println);
            }
        }catch (NullPointerException error ){
            System.out.println(error.getMessage());
        } catch (AlunoNaoEncontrado e) {
            throw new RuntimeException(e.getMessage());
        } catch (NotFoundAlunos e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void gerenciarProfessores(Scanner sc, TeacherServices teacherServices){
        System.out.println("\nGerenciar Professores");
        System.out.println("[1] Criar Professor");
        System.out.println("[2] Editar Professor");
        System.out.println("[3] Deletar Professor");
        System.out.println("[4] listar Professor");
        System.out.print("Escolha uma dessas opções ");
        int opcao = sc.nextInt();
        sc.nextLine();
        try {
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do professor: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite o cpf do professor: ");
                    String cpf = sc.nextLine();
                    teacherServices.criar(nome, cpf);
                    break;
                case 2:
                    System.out.print("Digite o cpf do professor que vai alterado");
                    String cpfAlterado = sc.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String newNome = sc.nextLine();
                    teacherServices.alterar(cpfAlterado, newNome);
                    break;
                case 4:
                    teacherServices.listarProfessores().forEach(System.out::println);
            }
        }catch (AlunoNaoEncontrado error){
            System.out.println(error.getMessage());
        }
    }
}
